package com.fakestore.product.Category;
import java.util.List;
import java.util.Optional;

public interface CatrgoryService {
    CategoryModel createCategory(CategoryModel categoryModel);
    CategoryModel updateCategory(CategoryModel categoryModel);

    void deleteCategory(Long id);

    CategoryModel getCategory(Long categoryId);

    List<CategoryModel> getAllCategories();
}
