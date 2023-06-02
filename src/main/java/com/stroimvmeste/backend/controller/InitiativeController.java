package com.stroimvmeste.backend.controller;

import com.stroimvmeste.backend.dto.InitiativeByIdDto;
import com.stroimvmeste.backend.dto.InitiativeFullDto;
import com.stroimvmeste.backend.service.DistrictService;
import com.stroimvmeste.backend.service.InitiativeService;
import com.stroimvmeste.backend.service.SpecializationService;
import com.stroimvmeste.backend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Optional;

@Controller
@RequestMapping("/initiative")
@RequiredArgsConstructor
public class InitiativeController {

    private final InitiativeService initiativeService;

    private final DistrictService districtService;

    private final SpecializationService specializationService;

    private final UserService userService;

    @GetMapping("/create")
    public String createInitiativeView(Model model) {
        model.addAttribute("initiative", new InitiativeByIdDto());
        model.addAttribute("districts", districtService.getAllDistricts());
        model.addAttribute("specializations", specializationService.getAllSpecializations());
        return "create-initiative";
    }
    @PostMapping
    public RedirectView createInitiative(@ModelAttribute("initiative") InitiativeByIdDto initiativeLiteDto, RedirectAttributes redirectAttributes) {
        final RedirectView redirectView = new RedirectView("/initiative/all", true);
        InitiativeByIdDto savedInitiative = initiativeService.addInitiative(initiativeLiteDto);
        redirectAttributes.addFlashAttribute("savedInitiative", savedInitiative);
        redirectAttributes.addFlashAttribute("addInitiativeSuccess", true);
        return redirectView;
    }
    @GetMapping("/all")
    public String viewInitiatives(Model model) {
        model.addAttribute("initiatives", initiativeService.getAllInitiatives());
        return "initiatives";
    }

    @GetMapping("/{initiativeId}")
    public String viewInitiative(Model model, @PathVariable Long initiativeId) {
        Optional<InitiativeFullDto> optional = initiativeService.getInitiative(initiativeId);
        if (optional.isEmpty()) {
            model.addAttribute("entity", "Initiative");
            return "not-found";
        }
        model.addAttribute("initiative", optional.get());
        return "initiative";
    }

    @GetMapping("/participant/add/{initiativeId}")
    public String addParticipantView(Model model, @PathVariable Long initiativeId) {
        Optional<InitiativeFullDto> optional = initiativeService.getInitiative(initiativeId);
        if (optional.isEmpty()) {
            model.addAttribute("entity", "Initiative");
            return "not-found";
        }
        model.addAttribute("initiative", optional.get());
        model.addAttribute("users", userService.getAllUsers());
        return "add-participant";
    }

    @PostMapping("/{initiativeId}/participant")
    public RedirectView addParticipant(@ModelAttribute("participantId") Long participantId, @PathVariable Long initiativeId) {
        initiativeService.addParticipant(initiativeId, participantId);
        return new RedirectView("/initiative/" + initiativeId, true);
    }


    @GetMapping("/experts/{initiativeId}")
    public String viewExperts(Model model, @PathVariable Long initiativeId) {
        model.addAttribute("experts", initiativeService.generateListOfExperts(initiativeId));
        return "experts";
    }

    @GetMapping("/update/{initiativeId}")
    public String updateInitiativeView(Model model, @PathVariable Long initiativeId) {
        model.addAttribute("initiative", initiativeService.getInitiative(initiativeId));
        model.addAttribute("districts", districtService.getAllDistricts());
        model.addAttribute("specializations", specializationService.getAllSpecializations());
        return "update-initiative";
    }

    @PostMapping("/update")
    public RedirectView updateInitiative(@ModelAttribute("initiative") InitiativeByIdDto initiativeLiteDto, RedirectAttributes redirectAttributes) {
        final RedirectView redirectView = new RedirectView("/initiative/all", true);
        InitiativeByIdDto updatedInitiative = initiativeService.updateInitiative(initiativeLiteDto);
        redirectAttributes.addFlashAttribute("updatedInitiative", updatedInitiative);
        redirectAttributes.addFlashAttribute("updatedInitiativeSuccess", true);
        return redirectView;
    }

    @GetMapping("/delete/{initiativeId}")
    public RedirectView deleteInitiative(@PathVariable Long initiativeId) {
        initiativeService.deleteInitiative(initiativeId);
        final RedirectView redirectDeleteView = new RedirectView("/initiative/all", true);
        return redirectDeleteView;
    }

}
