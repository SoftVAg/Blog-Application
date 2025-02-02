package com.TwinLine.Blogsite.controller;

import com.TwinLine.Blogsite.Service.CategoryService;
import com.TwinLine.Blogsite.payload.ApiResponse;
import com.TwinLine.Blogsite.payload.CategoryDto;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @PostMapping("/")
    public ResponseEntity<CategoryDto> createCategory(@Valid @RequestBody CategoryDto categoryDto) {
        CategoryDto createCategory=this.categoryService.createCategory(categoryDto);
        return new ResponseEntity<CategoryDto> (createCategory, HttpStatus.CREATED);
    }

    @PutMapping("/{catId}")
    public ResponseEntity<CategoryDto> updateCategory(@Valid @RequestBody CategoryDto categoryDto, @PathVariable Integer catId) {
        CategoryDto updatedCategory=this.categoryService.updateCategory(categoryDto, catId);
        return new ResponseEntity<CategoryDto>(updatedCategory, HttpStatus.OK);
    }

    //Delete by Id
    @DeleteMapping("/{catId}")
    public ResponseEntity<ApiResponse> deleteCategory (@PathVariable Integer catId) {
        this.categoryService.deleteCategory (catId);
        return new ResponseEntity<ApiResponse> (new ApiResponse ( "category is deleted succesfully !!", true), HttpStatus.OK);
    }

    //getById
    @GetMapping("/{catId}")
    public ResponseEntity<CategoryDto> getCategory (@PathVariable Integer catId) {
        CategoryDto categoryDto = this.categoryService.getCategoryById(catId);
        return new ResponseEntity<CategoryDto> (categoryDto, HttpStatus.OK);
    }

    //get all
    @GetMapping("/")
    public ResponseEntity<List<CategoryDto>> getCategories(){
        List<CategoryDto> categories = this.categoryService.getAllCategories();
        return ResponseEntity.ok(categories);
    }
}
