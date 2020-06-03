package com.apartment.management.controller.login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

/**
 * @author 王峥
 * @date 2020/6/3 10:57 上午
 */
@Controller
public class ErrorController {
    @GetMapping("/error")
    public String error(HttpSession session) {
        session.invalidate();
        return "error";
    }
}
