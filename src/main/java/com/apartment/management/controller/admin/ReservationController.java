package com.apartment.management.controller.admin;

import com.apartment.management.mapper.BookRoomMapper;
import com.apartment.management.model.BookRoom;
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
        List<BookRoom> bookRooms = bookRoomMapper.selectAllBookRoom();
        model.addAttribute("bookrooms",bookRooms);
        return "/admin/reservation_management";
    }
}
