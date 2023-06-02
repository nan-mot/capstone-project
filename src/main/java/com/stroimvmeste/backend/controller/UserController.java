package com.stroimvmeste.backend.controller;

import com.stroimvmeste.backend.dto.ExpertByIdDto;
import com.stroimvmeste.backend.dto.UserDistrictIdDto;
import com.stroimvmeste.backend.service.DistrictService;
import com.stroimvmeste.backend.service.SpecializationService;
import com.stroimvmeste.backend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final DistrictService districtService;
    private final SpecializationService specializationService;


    @GetMapping("/create")
    public String createUserView(Model model) {
        model.addAttribute("user", new UserDistrictIdDto());
        model.addAttribute("districts", districtService.getAllDistricts());
        return "create-user";
    }

    @PostMapping
    public RedirectView createUser(@ModelAttribute("user") UserDistrictIdDto userLiteDto, RedirectAttributes redirectAttributes) {
        final RedirectView redirectView = new RedirectView("/user/all", true);
        UserDistrictIdDto savedUser = userService.addUser(userLiteDto);
        redirectAttributes.addFlashAttribute("savedUser", savedUser);
        redirectAttributes.addFlashAttribute("addUserSuccess", true);
        return redirectView;
    }

    @GetMapping("/expert/create")
    public String createExpertView(Model model) {
        model.addAttribute("expert", new ExpertByIdDto());
        model.addAttribute("districts", districtService.getAllDistricts());
        model.addAttribute("specializations", specializationService.getAllSpecializations());
        return "create-expert";
    }

    @PostMapping("/expert")
    public RedirectView createExpert(@ModelAttribute("expert") ExpertByIdDto expertDto, RedirectAttributes redirectAttributes) {
        final RedirectView redirectView = new RedirectView("/user/all", true);
        ExpertByIdDto savedExpert = userService.addExpert(expertDto);
        redirectAttributes.addFlashAttribute("savedExpert", savedExpert);
        redirectAttributes.addFlashAttribute("addExpertSuccess", true);
        return redirectView;
    }

    @GetMapping("/all")
    public String viewUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "users";
    }

}
