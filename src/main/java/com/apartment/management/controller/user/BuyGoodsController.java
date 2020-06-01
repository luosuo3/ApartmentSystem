package com.apartment.management.controller.user;

import com.apartment.management.mapper.GoodManageMapper;
import com.apartment.management.model.GoodManage;
import com.apartment.management.model.GoodManageExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class BuyGoodsController {
    @Autowired
    GoodManageMapper goodManageMapper;
    @GetMapping("/buy_goods")
    public String buyGoods(Model model) {
        GoodManageExample goodManageExample = new GoodManageExample();
        goodManageExample.createCriteria().andGoodsIdIsNotNull();
        List<GoodManage> goodManages = goodManageMapper.selectByExample(goodManageExample);
        model.addAttribute("goodManages", goodManages);
        return "user/buy_goods";
    }
    @PostMapping ("/buyGood")
    public String buyGood(Model model, HttpServletRequest request) {
        String id = request.getParameter("id");
        int number = Integer.valueOf(request.getParameter("number"));
        GoodManage goodManage = goodManageMapper.selectByPrimaryKey(Integer.valueOf(id));
        goodManage.setGoodsNumber(goodManage.getGoodsNumber()-number);
        goodManageMapper.updateByPrimaryKey(goodManage);
        GoodManageExample goodManageExample = new GoodManageExample();
        goodManageExample.createCriteria().andGoodsIdIsNotNull();
        List<GoodManage> goodManages = goodManageMapper.selectByExample(goodManageExample);
        model.addAttribute("goodManages", goodManages);
        return "user/buy_goods";
    }
}
