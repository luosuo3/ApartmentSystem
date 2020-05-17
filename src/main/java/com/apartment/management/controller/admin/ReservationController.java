package com.apartment.management.controller.admin;

import com.apartment.management.mapper.BookRoomMapper;
import com.apartment.management.model.BookRoom;
import com.apartment.management.model.BookRoomExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ReservationController {
    @Autowired
    BookRoomMapper bookRoomMapper;
    @GetMapping("/reservation_management")
    public String resetvation(Model model) {
        BookRoomExample bookRoomExample = new BookRoomExample();
         bookRoomExample.createCriteria().andIdCardIsNotNull();
        List<BookRoom> bookRooms = bookRoomMapper.selectByExample(bookRoomExample);
        model.addAttribute("bookRooms",bookRooms);
        return "/admin/reservation_management";
    }
}
