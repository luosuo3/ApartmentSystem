package com.apartment.management.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RoomModefyController {
    @GetMapping("/room_modefy.html")
    public String modefy() {
        return "admin/room_modefy";
    }
}
