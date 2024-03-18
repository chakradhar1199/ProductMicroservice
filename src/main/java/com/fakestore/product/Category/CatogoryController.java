package com.fakestore.product.Category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/category")
public class CatogoryController {

    private final CatrgoryService catrgoryService;

    @Autowired
    public CatogoryController(CatrgoryService catrgoryService) {
        this.catrgoryService = catrgoryService;
    }

    //get all products
    @GetMapping("/all")
    public List<CategoryModel> getAllCategories(){
        System.out.println("get all categories");
        return  catrgoryService.getAllCategories();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryModel> getCategory(@PathVariable Long id){
        return ResponseEntity.ok().body(catrgoryService.getCategory(id));
    }

    @PostMapping("/add")
    public ResponseEntity<CategoryModel> addCategory(@RequestBody CategoryModel categoryModel){
        return ResponseEntity.ok().body(catrgoryService.createCategory(categoryModel));
    }

    @PutMapping("/update")
    public ResponseEntity<CategoryModel> updateCategory(@RequestBody CategoryModel categoryModel){
        return ResponseEntity.ok().body(catrgoryService.updateCategory(categoryModel));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteCategory(@PathVariable Long id){
        catrgoryService.deleteCategory(id);
        return ResponseEntity.ok().build();
    }

}
