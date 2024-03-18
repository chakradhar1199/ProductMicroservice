package com.fakestore.product.Exception;

public class CategoryNotFoundException extends RuntimeException {
    public CategoryNotFoundException(String categoryNotFound) {
        super(categoryNotFound);
    }
}
