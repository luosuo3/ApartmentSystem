package com.apartment.management.controller.admin;

import com.apartment.management.mapper.BookRoomMapper;
import com.apartment.management.model.BookRoom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class RoomManageController {
    @GetMapping("/roomManage")
    public String roomManage(Model model) {

        return "/admin/room_management";
    }
}
