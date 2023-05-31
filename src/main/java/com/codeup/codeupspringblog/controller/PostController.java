package com.codeup.codeupspringblog.controller;

import com.codeup.codeupspringblog.models.Post;
import com.codeup.codeupspringblog.models.User;
import com.codeup.codeupspringblog.repositories.PostRepository;
import com.codeup.codeupspringblog.repositories.UserRepository;
import com.codeup.codeupspringblog.service.EmailService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;



@Controller
public class PostController {
    private PostRepository postDao;
    private UserRepository userDao;
    private EmailService emailService;
    @Autowired
    public void PostRepository(PostRepository postDao, UserRepository userDao, EmailService emailService) {
        this.postDao = postDao;
        this.userDao = userDao;
        this.emailService = emailService;
    }

    @GetMapping("/posts")
    public String allPost(Model model) {
        model.addAttribute("allPost", postDao.findAll());
        return "posts/index";
    }
    @GetMapping("/posts/create")
    public String showCreateForm(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        // Check if a user is logged in
        if (auth instanceof AnonymousAuthenticationToken) {
            return "redirect:/login";
        }

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
    public String createPost(@Valid @ModelAttribute Post post, Errors validation, Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        // Get the authenticated user name
        String username = auth.getName();

        // Retrieve the User from the UserRepository using the authenticated username
        User user = userDao.findByUsername(username);
        if (user == null) {
            throw new IllegalArgumentException("Invalid user name: " + username);
        }
        if (validation.hasErrors()) {
            model.addAttribute("errors", validation);
            model.addAttribute("post", post);
            return "posts/create"; // return to the form page if there is an error
        }
        // Assign the user to the post
        post.setUser(user);

        // Save the post with the associated user
        postDao.save(post);

        return "redirect:/posts";
    }
    @GetMapping("/posts/{id}/edit")
    public String showEditForm(@PathVariable Long id, Model model) {
        Post post = postDao.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid post Id:" + id));
        model.addAttribute("post", post);
        return "posts/edit";
    }
    @PostMapping("/posts/{id}")
    public String updatePost(@PathVariable Long id, @ModelAttribute Post post) {
        // Retrieve the first user
        User user = userDao.findById(1L)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id: 1"));

        // Assign the user to the post
        post.setUser(user);
        postDao.save(post);
        return "redirect:/posts/" + id;
    }
}
