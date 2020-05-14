package com.apartment.management.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BuyGoodsController {
    @GetMapping("/buy_goods")
    public String buyGoods() {

        return "user/buy_goods";
    }
}
