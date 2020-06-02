package com.apartment.management.controller.admin;

import com.apartment.management.mapper.BookRoomMapper;
import com.apartment.management.mapper.RoomManageMapper;
import com.apartment.management.model.BookRoom;
import com.apartment.management.model.BookRoomExample;
import com.apartment.management.model.RoomManage;
import com.apartment.management.model.RoomManageExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class ReservationController {
    private int resertId;
    @Autowired
    BookRoomMapper bookRoomMapper;
    @Autowired
    RoomManageMapper roomManageMapper;

    @GetMapping("/reservation_management")
    public String resetvation(Model model) {
        BookRoomExample bookRoomExample = new BookRoomExample();
        bookRoomExample.createCriteria().andIdIsNotNull();
        List<BookRoom> bookRooms = bookRoomMapper.selectByExample(bookRoomExample);
        model.addAttribute("bookRooms", bookRooms);
        return "/admin/reservation_management";
    }

    @PostMapping("/getReserId")
    public String getReserId(HttpServletRequest request, Model model) {
        String id = request.getParameter("id");
        resertId = Integer.parseInt(id);
        BookRoom bookRoom = bookRoomMapper.selectByPrimaryKey(Integer.valueOf(id));
        model.addAttribute("bookRoom", bookRoom);
        return "admin/reservation_modefy";
    }

    @PostMapping("/modefyReser")
    public String modefyReser(HttpServletRequest request, Model model,
                              @RequestParam(value = "userName") String userName,
                              @RequestParam(name = "idCard") String idCard,
                              @RequestParam(name = "roomNummber") int roomNummber,
                              @RequestParam(name = "inTime") String inTime,
                              @RequestParam(name = "outTime") String outTime) throws ParseException {
        String deposit = request.getParameter("deposit");
        BookRoom bookRoom = new BookRoom();
        bookRoom.setId(resertId);
        bookRoom.setUserName(userName);
        bookRoom.setIdCard(idCard);
        bookRoom.setRoomNummber(roomNummber);
        //        日期格式化
        SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
        Date inTime1 = sd.parse(inTime);
        bookRoom.setInTime(inTime1);
        Date outTime1 = sd.parse(outTime);
        bookRoom.setOutTime(outTime1);
        bookRoom.setDeposit(Integer.valueOf(deposit));

        bookRoomMapper.updateByPrimaryKey(bookRoom);
        BookRoomExample bookRoomExample = new BookRoomExample();
        bookRoomExample.createCriteria().andIdIsNotNull();
        List<BookRoom> bookRooms = bookRoomMapper.selectByExample(bookRoomExample);
        model.addAttribute("bookRooms", bookRooms);
        return "/admin/reservation_management";
    }

    @PostMapping("/delectReser")
    public String delectReser(HttpServletRequest request, Model model) {
        String id = request.getParameter("id");
        bookRoomMapper.deleteByPrimaryKey(Integer.valueOf(id));

        BookRoomExample bookRoomExample = new BookRoomExample();
        bookRoomExample.createCriteria().andIdIsNotNull();
        List<BookRoom> bookRooms = bookRoomMapper.selectByExample(bookRoomExample);
        model.addAttribute("bookRooms", bookRooms);
        return "admin/reservation_management";
    }

    @PostMapping("/define")
    public  String define(HttpServletRequest request,Model model) {
        int id = Integer.parseInt(request.getParameter("id"));
        BookRoom bookRoom = bookRoomMapper.selectByPrimaryKey(id);
        RoomManageExample roomManageExample = new RoomManageExample();
        roomManageExample.createCriteria().andRoomNumsEqualTo(bookRoom.getRoomNummber());
        List<RoomManage> roomManages = roomManageMapper.selectByExample(roomManageExample);
        RoomManage roomManage = roomManages.get(0);
        roomManage.setUsername(bookRoom.getUserName());
        roomManage.setStatus(1);
        roomManage.setInTime(bookRoom.getInTime());
        roomManage.setOutTime(bookRoom.getOutTime());
        roomManage.setRoomNums(bookRoom.getRoomNummber());
        roomManage.setCheckIn(1);
        RoomManageExample roomManageExample1 = new RoomManageExample();
        roomManageExample.createCriteria().andRoomNumsEqualTo(bookRoom.getRoomNummber());
        roomManageMapper.updateByPrimaryKey(roomManage);
        bookRoomMapper.deleteByPrimaryKey(id);

        BookRoomExample bookRoomExample = new BookRoomExample();
        bookRoomExample.createCriteria().andIdIsNotNull();
        List<BookRoom> bookRooms = bookRoomMapper.selectByExample(bookRoomExample);
        model.addAttribute("bookRooms", bookRooms);
        return "/admin/reservation_management";
    }

}
