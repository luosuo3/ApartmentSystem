package com.apartment.management.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RoomController {
    @GetMapping("/roombook")
    public String roomBook() {
        return "/user/room_book";
    }
}
