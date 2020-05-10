package com.apartment.management.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ReservationController {
    @GetMapping("/reservation_management")
    public String resetvation() {
        return "/admin/reservation_management";
    }
}
