package com.TwinLine.Blogsite.Service;

import com.TwinLine.Blogsite.entity.User;
import com.TwinLine.Blogsite.payload.PostDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PostService{
    //create
    PostDto createPost(PostDto postDto,Integer userId, Integer categoryId);
    //update
    PostDto updatePost(PostDto postDto, Integer postId);
    //delete
    void deletePost(Integer postId);
    //get all posts
    List<PostDto> getAllPosts(Integer pageNumber, Integer pageSize);
    //get single post
    PostDto getPostById(Integer postId);
    //get all post by category
    List<PostDto> getPostByCategoryId(Integer categoryId);
    //get all post by user
    List<PostDto> getPostByUserId(Integer userId);
    //search post
    List<PostDto> searchPosts(String keyword);
    List<String> getTop5Words(User user);
}
