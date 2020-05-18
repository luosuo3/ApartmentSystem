package com.apartment.management.controller.admin;

import com.apartment.management.mapper.BookRoomMapper;
import com.apartment.management.mapper.RoomManageMapper;
import com.apartment.management.model.BookRoom;
import com.apartment.management.model.RoomManage;
import com.apartment.management.model.RoomManageExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class RoomManageController {
    @Autowired
    RoomManageMapper roomManageMapper;
    @GetMapping("/roomManage")
    public String roomManage(Model model) {
        RoomManageExample roomManageExample = new RoomManageExample();
        roomManageExample.createCriteria().andIdIsNotNull();
        List<RoomManage> roomManages = roomManageMapper.selectByExample(roomManageExample);
        model.addAttribute("roomManages",roomManages);
        return "/admin/room_management";
    }

    @PostMapping("/banRoom")
    public String banRoom(Model model, HttpServletRequest request) {
        String id = request.getParameter("id");
        Integer id1 = Integer.valueOf(id);
        RoomManage roomManage = roomManageMapper.selectByPrimaryKey(id1);
        if (roomManage.getStatus()==0) {
            roomManage.setStatus(1);
        } else {
            roomManage.setStatus(0);
        }
        roomManageMapper.updateByPrimaryKey(roomManage);
        RoomManageExample roomManageExample = new RoomManageExample();
        roomManageExample.createCriteria().andIdIsNotNull();
        List<RoomManage> roomManages = roomManageMapper.selectByExample(roomManageExample);
        model.addAttribute("roomManages",roomManages);
        return "/admin/room_management";
    }
}
