package com.apartment.management.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author 王峥
 * @date 2020/6/2 6:38 下午
 */
@Controller
public class MessageController {
    @GetMapping("/message_management")
    public String message() {
        return "admin/message";
    }
}
