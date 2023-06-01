package com.stroimvmeste.backend.controller;

import com.stroimvmeste.backend.dto.DistrictDto;
import com.stroimvmeste.backend.service.DistrictService;
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
public class DistrictController {

    private final DistrictService districtService;

    @GetMapping("/createDistrict")
    public String createDistrictView(Model model) {
        model.addAttribute("district", new DistrictDto());
        return "create-district";
    }

    @PostMapping("/createDistrict")
    public RedirectView createDistrict(@ModelAttribute("district") DistrictDto districtDto, RedirectAttributes redirectAttributes) {
        final RedirectView redirectView = new RedirectView("allDistricts", true);
        DistrictDto savedDistrict = districtService.addDistrict(districtDto);
        redirectAttributes.addFlashAttribute("savedDistrict", savedDistrict);
        redirectAttributes.addFlashAttribute("addDistrictSuccess", true);
        return redirectView;
    }

    @GetMapping("/allDistricts")
    public String viewDistricts(Model model) {
        model.addAttribute("districts", districtService.getAllDistricts());
        return "districts";
    }


}
