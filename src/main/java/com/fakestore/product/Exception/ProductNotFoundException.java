package com.fakestore.product.Exception;

public class ProductNotFoundException extends RuntimeException{
    public ProductNotFoundException(String s) {
        super(s);
    }
}
