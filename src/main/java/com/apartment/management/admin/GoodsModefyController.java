package com.apartment.management.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GoodsModefyController {
    @GetMapping("/goods_modefy.html")
    public String modefy(){
        return "admin/goods_modefy";
    }
}