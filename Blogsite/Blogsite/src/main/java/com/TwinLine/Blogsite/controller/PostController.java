package com.TwinLine.Blogsite.controller;

import com.TwinLine.Blogsite.Service.PostService;
import com.TwinLine.Blogsite.payload.ApiResponse;
import com.TwinLine.Blogsite.payload.PostDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PostController {

    @Autowired
    private PostService postService;

    //create
    @PostMapping("/user/{userId}/category/{categoryId}/posts")
    public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto, @PathVariable Integer userId, @PathVariable Integer categoryId){
        PostDto createPost = this.postService.createPost(postDto, userId, categoryId);
        return new ResponseEntity<PostDto>(createPost, HttpStatus.CREATED);
    }
    //update
    @PutMapping("/posts/{postId}")
    public ResponseEntity<PostDto> updatePost(@RequestBody PostDto postDto, @PathVariable Integer postId){
        PostDto updatePost = this.postService.updatePost(postDto, postId);
        return new ResponseEntity<PostDto>(updatePost,HttpStatus.OK);
    }
    // get all post by category
    @GetMapping("/category/{categoryId}/posts")
    public ResponseEntity<List<PostDto>> getPostsByCategory(@PathVariable Integer categoryId){
        List<PostDto> posts = this.postService.getPostByCategoryId(categoryId);
        return new ResponseEntity<List<PostDto>>(posts,HttpStatus.OK);
    }

    //get by user
    @GetMapping("/user/{userId}/posts")
    public ResponseEntity<List<PostDto>> getPostsByUser(@PathVariable Integer userId){
        List<PostDto> posts = this.postService.getPostByUserId(userId);
        return new ResponseEntity<List<PostDto>>(posts,HttpStatus.OK);
    }

    // delete post
    @DeleteMapping("/posts/{postId}")
    public ApiResponse deletePost(@PathVariable Integer postId){
        this.postService.deletePost(postId);
        return new ApiResponse("Post is successfully deleted",true);
    }

    //get post by Id
    @GetMapping("/posts/{postId}")
    public ResponseEntity<PostDto> getPostById(@PathVariable Integer postId){
        PostDto postDto = this.postService.getPostById(postId);
        return new ResponseEntity<PostDto>(postDto,HttpStatus.OK);
    }

    // get all posts
    @GetMapping("/posts")
    public ResponseEntity<List<PostDto>> getAllPost(
        @RequestParam(value = "pageNumber", defaultValue = "0",required = false) Integer pageNumber,
        @RequestParam(value = "pageSize", defaultValue = "5",required = false) Integer pageSize
                ){
        List<PostDto> allPosts = this.postService.getAllPosts(pageNumber,pageSize);
        return new ResponseEntity<>(allPosts,HttpStatus.OK);
    }

    //search post
    @GetMapping("/posts/search/{keywords}")
    public ResponseEntity<List<PostDto>> searchPostByTitle(@PathVariable("keywords") String keyword){
        List<PostDto> result = this.postService.searchPosts(keyword);
        return new ResponseEntity<>(result,HttpStatus.OK);
    }
//    @GetMapping()
//    public ResponseEntity<List<String>> getTopWords(){
//        User user = getLoggedInUser(); // Get the logged-in user
//        List<String> topWords = postService.getTop5Words(user); // Pass user entity
//        return ResponseEntity.ok(topWords);
//    }

}


