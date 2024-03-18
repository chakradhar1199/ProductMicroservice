package com.fakestore.product.Product;

import java.util.List;

public interface ProductService {
    ProductModel createProduct(ProductDto productDto);
    ProductModel updateProduct(ProductDto productDto);

    void deleteProduct(Long id);

    ProductModel getProduct(Long productId);

    List<ProductModel> getAllProducts();
    List<ProductModel> getProductByCategory(Long categoryId);
}
