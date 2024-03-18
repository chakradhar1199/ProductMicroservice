package com.fakestore.product.Category;

import jakarta.persistence.*;
import lombok.Data;

@Entity(name = "category")
@Data
public class CategoryModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
}
