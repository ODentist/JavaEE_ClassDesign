package com.qf.cdtuvirus.controller;


import com.qf.cdtuvirus.service.ProvinceofchinaService;
import com.qf.cdtuvirus.service.VisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * 实现页面跳转
 */
@Controller
public class IndexController {
    @Autowired
    private VisitService visitService;
    @Autowired
    private ProvinceofchinaService provinceofchinaService;
    @RequestMapping("data")
    public String toIndex(Model model) {
        //加载网站的阅读数量
        Integer count_ip = visitService.count();
//        model.addAttribute("count_ip", count_ip);
        //加载疫情的实时数据
        Map<String, Integer> epidamic_data = provinceofchinaService.queryEpidemiceDate();
        Map<String, Integer> heal = provinceofchinaService.queryEpidemiceDate();
        Map<String, Integer> dead = provinceofchinaService.queryEpidemiceDate();
        model.addAttribute("count_ip",count_ip);
        model.addAttribute("epidamic_data",epidamic_data);
        model.addAttribute("confirm",heal);
        model.addAttribute("confirm",dead);

        return "data";
    }

}
