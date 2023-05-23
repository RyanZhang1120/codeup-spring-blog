package com.codeup.codeupspringblog.controller;

import com.codeup.codeupspringblog.models.Post;
import com.codeup.codeupspringblog.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import com.codeup.codeupspringblog.repositories.PostRepository;

import java.util.ArrayList;

@Controller
public class PostController {
    private PostRepository postDao;
    @Autowired
    public PostController(PostRepository postDao){
        this.postDao = postDao;
    }
    @GetMapping("/posts")
    public String allPost(Model model) {
        model.addAttribute("allPost", postDao.findAll());
        return "posts/index";
    }
    @GetMapping("/posts/create")
    public String showCreateForm(Model model) {
        model.addAttribute("post", new Post());
        return "posts/create";
    }
    @PostMapping("/posts")
    public String createPost(@ModelAttribute Post post) {
        postDao.save(post);
        return "redirect:/posts";
    }

}
