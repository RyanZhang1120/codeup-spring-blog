package com.codeup.codeupspringblog.controller;
import com.codeup.codeupspringblog.models.Post;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostController {
    @GetMapping("/posts")
    @ResponseBody
    public String getPostsIndexPage() {
        return "This is the posts index page. All posts will be displayed here.";
    }

    @RequestMapping(path = "/posts/{id}", method = RequestMethod.GET)
    @ResponseBody
    public String indivPost(@PathVariable int id) {
        return "This is post " + id;
    }


    @GetMapping("/posts/create")
    @ResponseBody
    public String viewCreatePostForm() {
        return "This is the page for viewing the form to create a new post.";
    }

    @PostMapping("/posts/create")
    @ResponseBody
    public String createPost(@RequestBody Post post) {
        // Logic for creating a new post
        return String.format("A new post with title '%s' and content '%s' has been created.", post.getTitle(), post.getBody());
    }
}
