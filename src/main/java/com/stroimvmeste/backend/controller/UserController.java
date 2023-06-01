package com.stroimvmeste.backend.controller;

import com.stroimvmeste.backend.dto.ExpertDto;
import com.stroimvmeste.backend.dto.UserLiteDto;
import com.stroimvmeste.backend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/createUser")
    public String createUserView(Model model) {
        model.addAttribute("user", new UserLiteDto());
        return "create-user";
    }

    @PostMapping("/createUser")
    public RedirectView createUser(@ModelAttribute("user") UserLiteDto userLiteDto, RedirectAttributes redirectAttributes) {
        final RedirectView redirectView = new RedirectView("allUsers", true);
        UserLiteDto savedUser = userService.addUser(userLiteDto);
        redirectAttributes.addFlashAttribute("savedUser", savedUser);
        redirectAttributes.addFlashAttribute("addUserSuccess", true);
        return redirectView;
    }

    @GetMapping("/createExpert")
    public String createExpertView(Model model) {
        model.addAttribute("expert", new ExpertDto());
        return "create-expert";
    }

    @PostMapping("/createExpert")
    public RedirectView createExpert(@ModelAttribute("expert") ExpertDto expertDto, RedirectAttributes redirectAttributes) {
        final RedirectView redirectView = new RedirectView("allUsers", true);
        ExpertDto savedExpert = userService.addExpert(expertDto);
        redirectAttributes.addFlashAttribute("savedExpert", savedExpert);
        redirectAttributes.addFlashAttribute("addExpertSuccess", true);
        return redirectView;
    }

    @GetMapping("/allUsers")
    public String viewUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "users";
    }

}
