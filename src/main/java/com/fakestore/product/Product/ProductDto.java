package com.fakestore.product.Product;

import com.fakestore.product.Category.CategoryModel;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
public class ProductDto {
    private Long id;
    private String title;
    private String price;
    private String description;
    private Long categoryModelId;
    private String image;
}
