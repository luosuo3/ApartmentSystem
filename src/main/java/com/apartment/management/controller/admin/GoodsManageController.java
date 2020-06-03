package com.apartment.management.controller.admin;

import com.apartment.management.mapper.GoodManageMapper;

import com.apartment.management.model.GoodManage;
import com.apartment.management.model.GoodManageExample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.util.List;

@Controller
public class GoodsManageController {
    private int goodId;
    @Autowired
    GoodManageMapper goodManageMapper;

    @GetMapping("/goodsManage")
    public String goodsManage(Model model) {
        GoodManageExample goodManageExample = new GoodManageExample();
        goodManageExample.createCriteria().andGoodsIdIsNotNull();
        List<GoodManage> goodManages = goodManageMapper.selectByExample(goodManageExample);
        model.addAttribute("goodManages",goodManages);
        return "/admin/goods_management";
    }

    @PostMapping("/banGood")
    public String banGood(Model model, HttpServletRequest request){

        String id = request.getParameter("id");
        Integer id1 = Integer.valueOf(id);
        GoodManage goodManage = goodManageMapper.selectByPrimaryKey(id1);
        //选择禁用，则把数量改为0
        goodManage.setGoodsNumber(0);
        goodManageMapper.updateByPrimaryKey(goodManage);

        GoodManageExample goodManageExample=new GoodManageExample();
        goodManageExample.createCriteria().andGoodsIdIsNotNull();
        List<GoodManage>goodManages= goodManageMapper.selectByExample(goodManageExample);
        model.addAttribute("goodManages",goodManages);
        return "/admin/goods_management";
    }

    @PostMapping("/getGoodId")
    public String getGoodId(HttpServletRequest request, Model model){
        String id = request.getParameter("goodNum");
        goodId = Integer.parseInt(id);
        GoodManage goodManage=goodManageMapper.selectByPrimaryKey(Integer.valueOf(id));
        model.addAttribute("goodManage",goodManage);
        return "admin/goods_modefy";
    }

    @PostMapping("/modefyGood")
    public String modefyGood(HttpServletRequest request, Model model,
                             @RequestParam(name = "goodsNums")int goodsNums,
                             @RequestParam(name = "goodsName")String goodsName,
                             @RequestParam(name = "goodsPrice")float goodsPrice,
                             @RequestParam(name = "goodsNumber")int goodsNumber)throws ParseException {
        GoodManage goodManage = new GoodManage();
        goodManage.setGoodsId(goodId);
        goodManage.setGoodsNums(goodsNums);
        goodManage.setGoodsName(goodsName);
        goodManage.setGoodsPrice(goodsPrice);
        goodManage.setGoodsNumber(goodsNumber);

        goodManageMapper.updateByPrimaryKey(goodManage);
        GoodManageExample goodManageExample=new GoodManageExample();
        goodManageExample.createCriteria().andGoodsIdIsNotNull();
        List<GoodManage>goodManages= goodManageMapper.selectByExample(goodManageExample);
        model.addAttribute("goodManages",goodManages);
        return "/admin/goods_management";
    }
    @PostMapping("/delectGood")
    public String delectGood(HttpServletRequest request,Model model){
        String id = request.getParameter("id");
        goodManageMapper.deleteByPrimaryKey(Integer.valueOf(id));

        GoodManageExample goodManageExample=new GoodManageExample();
        goodManageExample.createCriteria().andGoodsIdIsNotNull();
        List<GoodManage>goodManages= goodManageMapper.selectByExample(goodManageExample);
        model.addAttribute("goodManages",goodManages);
        return "admin/goods_management";
    }
    @PostMapping("/addGood")
    public String addGood(HttpServletRequest request,Model model,
                          @RequestParam(name = "goodsNums")int goodsNums,
                          @RequestParam(name = "goodsName")String goodsName,
                          @RequestParam(name = "goodsPrice")float goodsPrice,
                          @RequestParam(name = "goodsNumber")int goodsNumber){
//        String goodsName = request.getParameter("goodsName");
//        goodId = Integer.parseInt(goodsName);

        GoodManage goodManage = new GoodManage();
        goodManage.setGoodsId(goodId);
        goodManage.setGoodsNums(goodsNums);
        goodManage.setGoodsName(goodsName);
        goodManage.setGoodsPrice(goodsPrice);
        goodManage.setGoodsNumber(goodsNumber);
        goodManageMapper.insertSelective(goodManage);

        GoodManageExample goodManageExample=new GoodManageExample();
        goodManageExample.createCriteria().andGoodsIdIsNotNull();
        List<GoodManage>goodManages= goodManageMapper.selectByExample(goodManageExample);
        model.addAttribute("goodManages",goodManages);
        return "admin/goods_management";
    }
}
