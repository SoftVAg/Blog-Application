package com.TwinLine.Blogsite.Service;

import com.TwinLine.Blogsite.payload.CategoryDto;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface CategoryService {
    //create
    CategoryDto createCategory(CategoryDto categoryDto);

    // update
    CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId);

    // delete
    void deleteCategory(Integer categoryId);

    // get
    CategoryDto getCategoryById(Integer categoryId);

    //get all
    List<CategoryDto> getAllCategories();
}
