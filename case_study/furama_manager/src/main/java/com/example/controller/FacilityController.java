package com.example.controller;

import com.example.dto.FacilityDto;
import com.example.model.Facility;
import com.example.service.FacilityService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/facility")
public class FacilityController {
    @Autowired
    private FacilityService facilityService;
    @GetMapping("list")
    public String showList(@PageableDefault(value = 5) Pageable pageable, Model model){
        model.addAttribute("list",facilityService.findAll(pageable));
        return "facility/list";
    }
    @GetMapping("create")
    public String showCreate(Model model){
        model.addAttribute("facility",new FacilityDto());
        model.addAttribute("facilityTypeList",facilityService.findFacilityType());
        model.addAttribute("rentTypeList",facilityService.findRentType());
        return "facility/create";
    }
    @PostMapping("create")
    public String save(@ModelAttribute Facility facility){
        Facility facility1 = new Facility();
        BeanUtils.copyProperties(facility,facility1);
        facilityService.save(facility1);
        return "redirect:/facility/list";
    }
    @GetMapping("edit/{id}")
    public String showEdit(@PathVariable int id, Model model){
        FacilityDto facilityDto = new FacilityDto();
        Facility facility = facilityService.findById(id);
        BeanUtils.copyProperties(facility,facilityDto);
        model.addAttribute("facility",facilityDto);
        model.addAttribute("facilityTypeList",facilityService.findFacilityType());
        model.addAttribute("rentTypeList",facilityService.findRentType());
        return "facility/edit";
    }
    @PostMapping ("edit")
    public String edit(@ModelAttribute("facility") FacilityDto facilityDto,Model model){
        Facility facility = new Facility();
        BeanUtils.copyProperties(facilityDto,facility);
        facilityService.save(facility);
        return "redirect:/facility/list";
    }
    @PostMapping("delete")
    public String remove(@RequestParam int id){
        facilityService.remove(id);
        return"redirect:/facility/list";
    }
}
