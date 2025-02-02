package com.TwinLine.Blogsite.Repo;

import com.TwinLine.Blogsite.entity.Categories;
import com.TwinLine.Blogsite.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import com.TwinLine.Blogsite.entity.User;
import java.util.List;


public interface PostRepo extends JpaRepository<Post,Integer> {
       List<Post> findByUser(User user);
       List<Post> findByTitleContaining(String title);
       List<Post> findByCategories(Categories category);
}
