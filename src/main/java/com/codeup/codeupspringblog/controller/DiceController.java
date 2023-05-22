package com.codeup.codeupspringblog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.ui.Model;

@Controller
public class DiceController {
    private static final int NUMBER_OF_DICE = 5;
    @GetMapping("/roll-dice")
    public String rollDiceView() {
        return "dice";
    }

    @GetMapping("/roll-dice/{n}")
    public String rollDiceResults(@PathVariable int n, Model model) {
        int matchCount = 0;
        StringBuilder rolls = new StringBuilder();
        for (int i = 0; i < NUMBER_OF_DICE; i++) {
            int randomNumber = (int)Math.floor(Math.random() * 6 + 1);
            rolls.append(randomNumber).append(' ');
            if (n == randomNumber) {
                matchCount++;
            }
        }

        model.addAttribute("usersGuess", "You have chosen: " + n);
        model.addAttribute("randomNumber", "The Random Number: " +rolls);
        model.addAttribute("matchCount", "Number of matches: " + matchCount);
        return "dice";
    }
}
