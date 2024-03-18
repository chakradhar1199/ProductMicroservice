package com.fakestore.product.Product;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Iterator;
import java.util.List;

public interface ProductRepository extends JpaRepository<ProductModel, Long> {

    List<ProductModel> findByCategoryModel_Id(Long id);

    ProductModel findByTitle(String title);
}
