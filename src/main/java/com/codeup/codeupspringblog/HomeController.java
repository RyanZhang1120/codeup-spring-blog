package com.codeup.codeupspringblog;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {
        @GetMapping("/home")
        @ResponseBody
        public String hello() {
            return "This is the landing page!";
        }
}
