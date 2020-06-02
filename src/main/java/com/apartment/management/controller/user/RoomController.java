package com.apartment.management.controller.user;

import com.apartment.management.mapper.BookRoomMapper;
import com.apartment.management.mapper.RoomManageMapper;
import com.apartment.management.model.BookRoom;
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
public class RoomController {
    @Autowired
    BookRoomMapper bookRoomMapper;
    @Autowired
    RoomManageMapper roomManageMapper;
    @GetMapping("roombook")
    public String roomBook(Model model) {
        List<Integer> room_nums = roomManageMapper.findAllRoomNums();
        model.addAttribute("roomNums", room_nums);
        return "/user/room_book";
    }

    @PostMapping("/roombook")
    public String addRoomBook(@RequestParam(name = "username",required = false) String username, @RequestParam(name = "idCard",required = false)String idCard, HttpServletRequest request) throws ParseException {
        String room = request.getParameter("room");
        SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
        Date inTime = sd.parse(request.getParameter("inTime"));
        Date outTime = sd.parse(request.getParameter("outTime"));
        String deposit = request.getParameter("deposit");
        BookRoom bookRoom = new BookRoom();
        bookRoom.setUserName(username);
        bookRoom.setIdCard(idCard);
        bookRoom.setRoomNummber(Integer.parseInt(room));
        bookRoom.setInTime(inTime);
        bookRoom.setOutTime(outTime);

        bookRoom.setDeposit(Integer.parseInt(deposit));
        bookRoomMapper.insert(bookRoom);
        return "/user/room_book";
    }
}
