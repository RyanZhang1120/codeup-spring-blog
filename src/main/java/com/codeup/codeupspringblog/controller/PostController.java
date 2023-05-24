package com.codeup.codeupspringblog.controller;

import com.codeup.codeupspringblog.models.Post;
import com.codeup.codeupspringblog.models.User;
import com.codeup.codeupspringblog.repositories.PostRepository;
import com.codeup.codeupspringblog.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class PostController {
    private PostRepository postDao;
    private UserRepository userRepository;
    @Autowired
    public void PostRepository(PostRepository postDao, UserRepository userRepository) {
        this.postDao = postDao;
        this.userRepository = userRepository;
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
    @GetMapping("/posts/{id}")
    public String showPost(@PathVariable Long id, Model model){
        Post post = postDao.findById(id).orElse(null);
        // If the post doesn't exist, redirect to a 404 page or similar
        if (post == null) {
            return "redirect:/404";
        }
        // Add the post to the model
        model.addAttribute("post", post);
        // Return the view
        return "posts/show";
    }
    @PostMapping("/posts")
    public String createPost(@ModelAttribute Post post) {
        // fetch a user from database
        // Here, I'm getting the first user. Change this according to your requirement.
        User user = userRepository.findById(1L).orElse(null);

        // check if user is not null and then set it to post
        if (user != null) {
            post.setUser(user);
        }
        postDao.save(post);
        return "redirect:/posts";
    }

}
