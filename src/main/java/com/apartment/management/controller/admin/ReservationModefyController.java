package com.apartment.management.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ReservationModefyController {
    @GetMapping("/reservation_modefy.html")
    public String modefy() {
        return "admin/reservation_modefy";
    }
}
