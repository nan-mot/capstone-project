package com.stroimvmeste.backend.controller;

import com.stroimvmeste.backend.dto.InitiativeCreateDto;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;


@RestController
@RequestMapping("/api/news")
public class InitiativeController {


    @PostMapping("/create")
    public InitiativeCreateDto createInitiative(@RequestBody InitiativeCreateDto initiativeCreateDto) {
        System.out.println("CREATING PEACE OF NEWS:");
        System.out.println("TITLE: " + initiativeCreateDto.getTitle());
        System.out.println("DESCRIPTION: " + initiativeCreateDto.getDescription());
        return initiativeCreateDto;
    }

//    @GetMapping("/addProject")
//    public String addProjectView(Model model) {
//        model.addAttribute("project", new Project());
//        List<District> districts = districtService.getAllDistricts();
//        model.addAttribute("districts", districts);
//        return "add-project";
//    }
//
//    @PostMapping("/addProject")
//    public RedirectView addProject(@ModelAttribute("project") Project project, RedirectAttributes redirectAttributes) {
//        final RedirectView redirectView = new RedirectView("all", true);
//        Project savedProject = projectService.addProject(project);
//        redirectAttributes.addFlashAttribute("savedProject", savedProject);
//        redirectAttributes.addFlashAttribute("addProjectSuccess", true);
//        return redirectView;
//    }
}
