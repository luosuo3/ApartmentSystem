package com.apartment.management.controller.login;

import com.apartment.management.mapper.UserMapper;
import com.apartment.management.model.BookRoomExample;
import com.apartment.management.model.User;
import com.apartment.management.model.UserExample;
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
        UserExample userExample = new UserExample();
        userExample.createCriteria().andUserNameEqualTo(username);
        List<User> users = userMapper.selectByExample(userExample);
        if (users.get(0).getType()==0) {
            if (users.get(0).getUserName().equals(username)||users.get(0).getPassword().equals(password)) {
                return "/user/room_book";
            } else {
                return "/index";
            }
        } else if (users.get(0).getType()==1) {
            if (users.get(0).getUserName().equals(username) || users.get(0).getPassword().equals(password)) {
                return "/admin/room_management";
            } else {
                return "/index";
            }
        }
        return "/index";
    }
}
