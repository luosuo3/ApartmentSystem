package com.apartment.management.controller.admin;

import com.apartment.management.mapper.BookRoomMapper;
import com.apartment.management.model.BookRoom;
import com.apartment.management.model.BookRoomExample;
import com.apartment.management.model.RoomManage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class ReservationController {
    private int resertId;
    @Autowired
    BookRoomMapper bookRoomMapper;
    @GetMapping("/reservation_management")
    public String resetvation(Model model) {
        BookRoomExample bookRoomExample =new BookRoomExample();
        bookRoomExample.createCriteria().andIdIsNotNull();
        List<BookRoom> bookRooms = bookRoomMapper.selectByExample(bookRoomExample);
        model.addAttribute("bookRooms",bookRooms);
        return "/admin/reservation_management";
    }
    @PostMapping("/getReserId")
    public String getManageId(HttpServletRequest request, Model model) {
        String id = request.getParameter("id");
        resertId = Integer.parseInt(id);
        BookRoom bookRoom = bookRoomMapper.selectByPrimaryKey(Integer.valueOf(id));
        model.addAttribute("bookroom", bookRoom);
        return "admin/reservation_modefy";
    }
}
