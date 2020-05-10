package com.apartment.management.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LocationController {
    @GetMapping("/location")
    public String location() {

        return "/user/apartment_location";
    }
}
