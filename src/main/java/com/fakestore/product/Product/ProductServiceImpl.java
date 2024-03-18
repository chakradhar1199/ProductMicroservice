package com.fakestore.product.Product;

import com.fakestore.product.Category.CategoryModel;
import com.fakestore.product.Category.CategoryRepository;
import com.fakestore.product.Exception.ProductNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService{
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public ProductModel createProduct(ProductDto productModel) {
       Optional<CategoryModel> categoryModel = categoryRepository.findById(productModel.getCategoryModelId());
       Optional<ProductModel> productModelOptional = Optional.ofNullable(productRepository.findByTitle(productModel.getTitle()));
         if(productModelOptional.isPresent()){
              throw new ProductNotFoundException("Product with title "+productModel.getTitle()+" already exists");
         }
       if(categoryModel.isPresent()){
           ProductModel product = new ProductModel();
           product.setTitle(productModel.getTitle());
              product.setDescription(productModel.getDescription());
                product.setPrice(productModel.getPrice());
                product.setCategoryModel(categoryModel.get());
                product.setImage(productModel.getImage());
                return productRepository.save(product);
       }
       else{
           throw new ProductNotFoundException("Category with id "+productModel.getCategoryModelId()+" not found");
       }
    }
    @Override
    public ProductModel updateProduct(ProductDto productDto) {
        Optional<CategoryModel> categoryModel = categoryRepository.findById(productDto.getCategoryModelId());
        if(!categoryModel.isPresent()){
            throw new ProductNotFoundException("Category with id "+productDto.getCategoryModelId()+" not found");
        }
        Optional<ProductModel> productModelOptional = productRepository.findById(productDto.getId());
        if(productModelOptional.isPresent()){
            ProductModel productModel = productModelOptional.get();
            productModel.setTitle(productDto.getTitle());
            productModel.setDescription(productDto.getDescription());
            productModel.setPrice(productDto.getPrice());
            productModel.setImage(productDto.getImage());
            productModel.setCategoryModel(categoryModel.get());
            return productRepository.save(productModel);
        }
        else{
            throw new ProductNotFoundException("Product with id "+productDto.getId()+" not found");
        }
    }
    public void deleteProduct(Long id) {
        ProductModel productModel = productRepository
                .findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Product with id " + id + " not found"));
        productRepository.delete(productModel);
    }
    public ProductModel getProduct(Long productId) {
        return productRepository
                .findById(productId)
                .orElseThrow(() -> new ProductNotFoundException("Product with id " + productId + " not found"));
    }

    public List<ProductModel> getAllProducts() {
        return productRepository.findAll();
    }
    public List<ProductModel> getProductByCategory(Long categoryId) {
        return productRepository.findByCategoryModel_Id(categoryId);
    }
}
