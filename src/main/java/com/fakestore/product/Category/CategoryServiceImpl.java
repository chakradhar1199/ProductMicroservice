package com.fakestore.product.Category;

import com.fakestore.product.Exception.CategoryNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CatrgoryService{
    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }
    @Override
    public CategoryModel createCategory(CategoryModel categoryModel) {
        Optional<CategoryModel> model = Optional.ofNullable(categoryRepository.findByName(categoryModel.getName()));
        if(model.isPresent()){
            throw new CategoryNotFoundException("Category with name "+categoryModel.getName()+" already exists");
        }
        return categoryRepository.save(categoryModel);
    }

    @Override
    public CategoryModel updateCategory(CategoryModel categoryModel) {
        Optional<CategoryModel> model = categoryRepository.findById(categoryModel.getId());
        if(model.isPresent()){
            model.get().setName(categoryModel.getName());
            model.get().setDescription(categoryModel.getDescription());
            return categoryRepository.save(model.get());
        }
        else{
            throw new CategoryNotFoundException("Category with id "+categoryModel.getId()+" not found");
        }
    }

    @Override
    public void deleteCategory(Long id) {
        Optional<CategoryModel> model = categoryRepository.findById(id);
        if(model.isPresent()) {
            categoryRepository.delete(model.get());
        }
        else{
            throw new CategoryNotFoundException("Category with id "+id+" not found");
        }

    }

    @Override
    public CategoryModel getCategory(Long id) {
        Optional<CategoryModel> model = categoryRepository.findById(id);
        if(model.isPresent()){
            return model.get();
        }
        throw new CategoryNotFoundException("Category with id "+id+" not found");
    }

    @Override
    public List<CategoryModel> getAllCategories() {
        List<CategoryModel> categoryModels = categoryRepository.findAll();
        System.out.println(categoryModels);
        return categoryModels;
    }
}
