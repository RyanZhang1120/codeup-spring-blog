package com.codeup.codeupspringblog.controller;

import com.codeup.codeupspringblog.models.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;

@Controller
public class PostController {
    @GetMapping("/posts")
    public String allPost(Model model) {
        ArrayList<Post> list = new ArrayList<>();
        list.add( new Post("Playstation", "Its the best!"));
        list.add( new Post("Tv Stand", "wow it works"));
        list.add( new Post("San Antonio Spurs", "Go Spurs Go"));
        list.add( new Post("Subways", "Eat Fresh"));
        list.add( new Post("Coffee", "Is my best Friend"));
        list.add( new Post("Spring Boot", "Is the best"));
        list.add( new Post("Pizza", "I am hungry now"));
        model.addAttribute("allPost", list);
        return "posts/index";
    }

    @GetMapping("/posts/{id}")
    public String showPost(@PathVariable int id, Model model) {
        Post individualPost = new Post("Playstation", "Its the best!");
        model.addAttribute("postId", id);
        model.addAttribute("post", individualPost);
        return "posts/show";
    }

}
