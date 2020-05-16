package com.apartment.management.controller.user;

import com.apartment.management.mapper.BookRoomMapper;
import com.apartment.management.model.BookRoom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;

@Controller
public class RoomController {
    @Autowired
    BookRoomMapper bookRoomMapper;
    @GetMapping("/roombook")
    public String roomBook() {

        return "/user/room_book";
    }

    @PostMapping("/roombook")
    public String addRoomBook(@RequestParam(name = "username",required = false) String username, @RequestParam(name = "idCard",required = false)String idCard, HttpServletRequest request) {
        String room = request.getParameter("room");
        SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String inTime = request.getParameter("inTime");
        String outTime = request.getParameter("outTime");
        String deposit = request.getParameter("deposit");
        BookRoom bookRoom = new BookRoom();
        bookRoom.setUser_name(username);
        bookRoom.setId_card(idCard);
        bookRoom.setRoom_nummber(Integer.parseInt(room));
        bookRoom.setIn_time(inTime);
        bookRoom.setOut_time(outTime);

        bookRoom.setDeposit(Integer.parseInt(deposit));
        bookRoomMapper.insert(bookRoom);
        return "/user/room_book";
    }
}
