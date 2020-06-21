package com.game.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FinalController {

    @PostMapping("/final")
    public String finalpage(@RequestParam String sum, Model model) {

        model.addAttribute("sum", sum);

        return "final";
    }
}
