package com.apartment.management.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RoomManageController {
    @GetMapping("/roomManage")
    public String roomManage() {
        return "/admin/room_management";
    }
}
