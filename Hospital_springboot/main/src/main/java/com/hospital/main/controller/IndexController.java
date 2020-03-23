package com.hospital.main.controller;

import com.hospital.main.bean.DisCategory;
import com.hospital.main.bean.Disease;
import com.hospital.main.bean.Doctor;
import com.hospital.main.service.DisCategoryService;
import com.hospital.main.service.DiseaseService;
import com.hospital.main.service.DoctorService;
import com.hospital.main.serviceImpl.DiseaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class IndexController {
    //主页上功能
    //0.疾病分类
    @Autowired
    private DisCategoryService disCategoryService;
    //1.推荐医生
    @Autowired
    private DoctorService doctorService;
    //2.疾病检索
    //3.登录，注册
    //4.文章
    //5.随机10种病
    @Autowired
    private DiseaseService diseaseService;
    @RequestMapping("/")
    public String index(Model model){
        List<Disease> randomDisease = diseaseService.getRandomDisease();
        List<DisCategory> allDisCategory = disCategoryService.getAllDisCategory();
        List<Doctor> randomDoctor = doctorService.getRandomDoctor();
        model.addAttribute("randomdis",randomDisease);
        model.addAttribute("disclists",allDisCategory);
        model.addAttribute("randomdoc",randomDoctor);
        return "index";
    }
}
