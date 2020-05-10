package com.apartment.management.login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class IndexController {
    @GetMapping("/index")
    public String index() {
        return "index";
    }

    @PostMapping("/login")
    public String login(@RequestParam(name = "username",required = false)  String username,@RequestParam(name = "password",required = false) String password ){
        if (username.equals("user")&&password.equals("user")) {
            return "/user/room_book";
        } else if (username.equals("admin")&&password.equals("admin")) {
            return "/admin/room_management";
        }
        return "index";
    }
}
