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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class InitiativeController {

    private final InitiativeService initiativeService;

    @GetMapping("/createInitiative")
    public String createInitiativeView(Model model) {
        model.addAttribute("initiative", new InitiativeLiteDto());
        return "create-initiative";
    }
    @PostMapping("/createInitiative")
    public RedirectView createInitiative(@ModelAttribute("initiative") InitiativeLiteDto initiativeLiteDto, RedirectAttributes redirectAttributes) {
        final RedirectView redirectView = new RedirectView("allInitiatives", true);
        InitiativeLiteDto savedInitiative = initiativeService.addInitiative(initiativeLiteDto);
        redirectAttributes.addFlashAttribute("savedInitiative", savedInitiative);
        redirectAttributes.addFlashAttribute("addInitiativeSuccess", true);
        return redirectView;
    }
    @GetMapping("/allInitiatives")
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

    @GetMapping("/{initiativeTitle}/addParticipant")
    public String addParticipantView(Model model) {
        model.addAttribute("participant", new UserLiteDto());
        return "add-participant";
    }

    @PostMapping("/{initiativeTitle}/addParticipant")
    public RedirectView addParticipant(@ModelAttribute("participant") UserLiteDto userLiteDto, @PathVariable String initiativeTitle) {
        initiativeService.addParticipant(initiativeTitle, userLiteDto.getUserName());
        return new RedirectView("{initiativeTitle}", true);
    }


    @GetMapping("/{initiativeTitle}/experts")
    public String viewExperts(Model model, @PathVariable String initiativeTitle) {
        model.addAttribute("experts", initiativeService.generateListOfExperts(initiativeTitle));
        return "experts";
    }

}
