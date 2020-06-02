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
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class RoomManageController {
    private int roomId;
    @Autowired
    RoomManageMapper roomManageMapper;

    @GetMapping("/roomManage")
    public String roomManage(Model model) {
        RoomManageExample roomManageExample = new RoomManageExample();
        roomManageExample.createCriteria().andIdIsNotNull();
        List<RoomManage> roomManages = roomManageMapper.selectByExample(roomManageExample);
     model.addAttribute("roomManages", roomManages);
        return "/admin/room_management";
    }

    @PostMapping("/banRoom")
    public String banRoom(Model model, HttpServletRequest request) {
        String id = request.getParameter("id");
        Integer id1 = Integer.valueOf(id);
        RoomManage roomManage = roomManageMapper.selectByPrimaryKey(id1);
        if (roomManage.getStatus() == 0) {
            roomManage.setStatus(1);
        } else {
            roomManage.setStatus(0);
        }
        roomManageMapper.updateByPrimaryKey(roomManage);
        RoomManageExample roomManageExample = new RoomManageExample();
        roomManageExample.createCriteria().andIdIsNotNull();
        List<RoomManage> roomManages = roomManageMapper.selectByExample(roomManageExample);
        model.addAttribute("roomManages", roomManages);
        return "/admin/room_management";
    }

    @PostMapping("/getManageId")
    public String getManageId(HttpServletRequest request, Model model) {
        String id = request.getParameter("id");
        roomId = Integer.parseInt(id);
        RoomManage roomManage = roomManageMapper.selectByPrimaryKey(Integer.valueOf(id));
        model.addAttribute("roomManage", roomManage);
        return "admin/room_modefy";
    }

    @PostMapping("/modefyRoom")
    public String modefyRoom(HttpServletRequest request,Model model,
                             @RequestParam(name = "roomNums" )int roomNums,
                             @RequestParam(name = "username")String username,
                             @RequestParam(name = "inTime")String inTime,
                             @RequestParam(name = "outTime")String outTime) throws ParseException {
        String checkIn = request.getParameter("checkIn");
        String status = request.getParameter("status");
        RoomManage roomManage = new RoomManage();
        roomManage.setId(roomId);
        roomManage.setRoomNums(roomNums);
        roomManage.setUsername(username);
        roomManage.setCheckIn(Integer.valueOf(checkIn));
        roomManage.setStatus(Integer.valueOf(status));
//        日期格式化
        SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
        Date inTime1 = sd.parse(inTime);
        roomManage.setInTime(inTime1);
        Date outTime1=sd.parse(outTime);
        roomManage.setOutTime(outTime1);
        roomManageMapper.updateByPrimaryKey(roomManage);
        RoomManageExample roomManageExample = new RoomManageExample();
        roomManageExample.createCriteria().andIdIsNotNull();
        List<RoomManage> roomManages = roomManageMapper.selectByExample(roomManageExample);
        model.addAttribute("roomManages", roomManages);
        return "/admin/room_management";
    }
    @PostMapping("/delectRoom")
    public String delectRoom(HttpServletRequest request, Model model) {
        String id = request.getParameter("id");
        roomManageMapper.deleteByPrimaryKey(Integer.valueOf(id));

        RoomManageExample roomManageExample = new RoomManageExample();
        roomManageExample.createCriteria().andIdIsNotNull();
        List<RoomManage> roomManages = roomManageMapper.selectByExample(roomManageExample);
        model.addAttribute("roomManages", roomManages);
        return "admin/room_management";
    }

}
