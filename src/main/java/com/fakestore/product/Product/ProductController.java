package com.fakestore.product.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/product")
public class ProductController {
    //create Product
    //update Product
    //delete Product
    //get all products
    //get product by id
    //get product by category
    //get product by name

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/add")
    public ResponseEntity<ProductModel> addProduct(@RequestBody ProductDto ProductDto){
        return ResponseEntity.ok().body(productService.createProduct(ProductDto));
    }

    @PostMapping("/update")
    public ResponseEntity<ProductModel> updateProduct(@RequestBody ProductDto productDto){
        return ResponseEntity.ok().body(productService.updateProduct(productDto));
    }
    @GetMapping("/all")
    public ResponseEntity<List<ProductModel>> getAllProducts(){
        return ResponseEntity.ok().body(productService.getAllProducts());
    }
    @GetMapping("/{id}")
    public ResponseEntity<ProductModel> getProduct(@PathVariable Long id){
        return ResponseEntity.ok().body(productService.getProduct(id));
    }
    //get by category
    @GetMapping("/category/{id}")
    public ResponseEntity<List<ProductModel>> getProductByCategory(@PathVariable Long id){
        return ResponseEntity.ok().body(productService.getProductByCategory(id));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteProduct(@PathVariable Long id){
        productService.deleteProduct(id);
        return ResponseEntity.ok().build();
    }
}
