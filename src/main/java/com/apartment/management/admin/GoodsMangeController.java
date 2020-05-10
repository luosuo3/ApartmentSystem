package com.apartment.management.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GoodsMangeController {
    @GetMapping("/goodsMange")
    public String goodsMange() {

        return "/admin/goods_management";
    }
}
