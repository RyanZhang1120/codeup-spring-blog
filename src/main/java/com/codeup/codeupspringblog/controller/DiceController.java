package com.codeup.codeupspringblog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.ui.Model;

@Controller
public class DiceController {
    @GetMapping("/roll-dice")
    public String rollDiceView() {
        return "dice";
    }

    @GetMapping("/roll-dice/{n}")
    public String rollDiceResults(@PathVariable int n, Model model) {
        int randomNumber = (int)Math.floor(Math.random() * 6 + 1);
        String results ="";

        if (n == randomNumber){
            results = "Winner Winner Chicken Dinner";
        }else {
            results = "You are Wrong, Loser!";
        }

        model.addAttribute("usersGuess", "You have chosen: " + n);
        model.addAttribute("randomNumber", "The Random Number: " +randomNumber);
        model.addAttribute("results", results);
        return "dice";
    }
}
