package com.stroimvmeste.backend.controller;

import com.stroimvmeste.backend.dto.SpecializationDto;
import com.stroimvmeste.backend.service.SpecializationService;
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
@RequestMapping("/specialization")
@RequiredArgsConstructor
public class SpecializationController {

    private final SpecializationService specializationService;

    @GetMapping("/create")
    public String createSpecializationView(Model model) {
        model.addAttribute("specialization", new SpecializationDto());
        return "create-specialization";
    }

    @PostMapping
    public RedirectView createSpecialization(@ModelAttribute("specialization") SpecializationDto specializationDto, RedirectAttributes redirectAttributes) {
        final RedirectView redirectView = new RedirectView("/specialization/all", true);
        SpecializationDto savedSpecialization = specializationService.addSpecialization(specializationDto);
        redirectAttributes.addFlashAttribute("savedSpecialization", savedSpecialization);
        redirectAttributes.addFlashAttribute("addSpecializationSuccess", true);
        return redirectView;
    }

    @GetMapping("/all")
    public String viewSpecializations(Model model) {
        model.addAttribute("specializations", specializationService.getAllSpecializations());
        return "specializations";
    }
}
