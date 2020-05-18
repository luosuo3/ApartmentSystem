package com.apartment.management.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class RoomModefyController {
    @GetMapping("/room_modefy.html")
    public String modefy(HttpServletRequest request) {
        String roomNum = request.getParameter("roomNum");
        System.out.println(roomNum);
        return "admin/room_modefy";
    }
}
