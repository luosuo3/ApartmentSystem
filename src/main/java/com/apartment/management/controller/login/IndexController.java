package com.apartment.management.controller.login;

import com.apartment.management.mapper.UserMapper;
import com.apartment.management.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class IndexController {
    @Autowired
    UserMapper userMapper;
    @GetMapping("/index")
    public String index() {
        return "index";
    }

    @PostMapping("/login")
    public String login(@RequestParam(name = "username",required = false)  String username,@RequestParam(name = "password",required = false) String password ){
        User user = userMapper.selectUser(username);
        if (user.getType()==0) {
            if (user.getUser_name().equals(username)||user.getPassword().equals(password)) {
                return "/user/room_book";
            } else {
                return "/index";
            }
        } else if (user.getType()==1) {
            if (user.getUser_name().equals(username) || user.getPassword().equals(password)) {
                return "/admin/room_management";
            } else {
                return "/index";
            }
        }
        return "/index";
    }
}
