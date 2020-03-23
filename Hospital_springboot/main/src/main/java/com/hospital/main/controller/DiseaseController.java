package com.hospital.main.controller;

import com.hospital.main.bean.Disease;
import com.hospital.main.service.DiseaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DiseaseController {
    @Autowired
    DiseaseService diseaseService;
    @RequestMapping("disDetail/{a}")
    public String DisDetail(@PathVariable("a") long a, Model model){
        Disease diseaseById = diseaseService.getDiseaseById(a);
        model.addAttribute("disDetail",diseaseById);
        return "disDetail";
    }
}
