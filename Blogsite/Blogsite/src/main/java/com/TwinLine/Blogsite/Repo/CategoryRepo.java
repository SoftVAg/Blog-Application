package com.TwinLine.Blogsite.Repo;

import com.TwinLine.Blogsite.entity.Categories;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository<Categories,Integer> {

}
