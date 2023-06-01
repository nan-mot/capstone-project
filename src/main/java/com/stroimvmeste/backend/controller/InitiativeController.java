package com.stroimvmeste.backend.controller;

import com.stroimvmeste.backend.dto.InitiativeFullDto;
import com.stroimvmeste.backend.dto.InitiativeLiteDto;
import com.stroimvmeste.backend.dto.UserLiteDto;
import com.stroimvmeste.backend.service.InitiativeService;
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

    @GetMapping("/create")
    public String createInitiativeView(Model model) {
        model.addAttribute("initiative", new InitiativeLiteDto());
        return "create-initiative";
    }
    @PostMapping
    public RedirectView createInitiative(@ModelAttribute("initiative") InitiativeLiteDto initiativeLiteDto, RedirectAttributes redirectAttributes) {
        final RedirectView redirectView = new RedirectView("/initiative/all", true);
        InitiativeLiteDto savedInitiative = initiativeService.addInitiative(initiativeLiteDto);
        redirectAttributes.addFlashAttribute("savedInitiative", savedInitiative);
        redirectAttributes.addFlashAttribute("addInitiativeSuccess", true);
        return redirectView;
    }
    @GetMapping("/all")
    public String viewInitiatives(Model model) {
        model.addAttribute("initiatives", initiativeService.getAllInitiatives());
        return "initiatives";
    }

    @GetMapping("/{initiativeTitle}")
    public String viewInitiative(Model model, @PathVariable String initiativeTitle) {
        Optional<InitiativeFullDto> optional = initiativeService.getInitiative(initiativeTitle);
        if (optional.isEmpty()) {
            model.addAttribute("entity", "Initiative");
            return "not-found";
        }
        model.addAttribute("initiative", optional.get());
        return "initiative";
    }

    @GetMapping("/{initiativeTitle}/participant/add")
    public String addParticipantView(Model model) {
        model.addAttribute("participant", new UserLiteDto());
        return "add-participant";
    }

    @PostMapping("/{initiativeTitle}/participant")
    public RedirectView addParticipant(@ModelAttribute("participant") UserLiteDto userLiteDto, @PathVariable String initiativeTitle) {
        initiativeService.addParticipant(initiativeTitle, userLiteDto.getUserName());
        return new RedirectView("/initiative/{initiativeTitle}", true);
    }


    @GetMapping("/{initiativeTitle}/experts")
    public String viewExperts(Model model, @PathVariable String initiativeTitle) {
        model.addAttribute("experts", initiativeService.generateListOfExperts(initiativeTitle));
        return "experts";
    }

}
