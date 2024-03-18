package com.fakestore.product.Product;

import com.fakestore.product.Category.CategoryModel;
import jakarta.persistence.*;
import lombok.Data;

@Entity(name = "product")
@Data
public class ProductModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String price;
    private String description;
    @ManyToOne
    private CategoryModel categoryModel;
    private String image;

}
