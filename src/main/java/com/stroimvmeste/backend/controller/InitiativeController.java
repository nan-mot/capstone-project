package com.stroimvmeste.backend.controller;

import com.stroimvmeste.backend.dto.InitiativeLiteDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class InitiativeController {

    @GetMapping("/create")
    public String createInitiativeView(Model model) {
        model.addAttribute("initiative", new InitiativeLiteDto());
        return "create-initiative";
    }
}
