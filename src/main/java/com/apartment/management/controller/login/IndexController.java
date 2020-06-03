package com.apartment.management.controller.login;

import com.apartment.management.mapper.RoomManageMapper;
import com.apartment.management.mapper.UserMapper;
import com.apartment.management.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class IndexController {
    @Autowired
    RoomManageMapper roomManageMapper;
    @Autowired
    UserMapper userMapper;
    @GetMapping("/index")
    public String index() {
        return "index";
    }

    @PostMapping("/login")
    public String login(@RequestParam(name = "username",required = false)  String username, @RequestParam(name = "password",required = false) String password, Model model, HttpServletRequest request){

        UserExample userExample = new UserExample();
        userExample.createCriteria().andUserNameEqualTo(username);
        List<User> users = userMapper.selectByExample(userExample);
        request.getSession().setAttribute("user",users.get(0));
        if (users.get(0).getType()==0) {
            if (users.get(0).getUserName().equals(username) && users.get(0).getPassword().equals(password)) {
                List<Integer> room_nums = roomManageMapper.findAllRoomNums();
                model.addAttribute("roomNums", room_nums);
                return "/user/room_book";
            } else {
                request.getSession().setAttribute("error","密码错误重新输入!");
                return "/index";
            }
        } else if (users.get(0).getType()==1) {

            if (users.get(0).getUserName().equals(username) && users.get(0).getPassword().equals(password)) {
                RoomManageExample roomManageExample = new RoomManageExample();
                roomManageExample.createCriteria().andIdIsNotNull();
                List<RoomManage> roomManages = roomManageMapper.selectByExample(roomManageExample);
                model.addAttribute("roomManages",roomManages);
                return "/admin/room_management";
            } else {
                 request.getSession().setAttribute("error","密码错误重新输入!");
                return "/index";
            }
        }
        request.getSession().setAttribute("error","密码错误重新输入!");
        return "/index";
    }
    @RequestMapping("/logout")
    public String logout(HttpSession session){
        // 清除Session
        session.invalidate();
        // 重定向到登录页面的跳转方法
        return "redirect:index";
    }
    @GetMapping("/registered")
    public String registered () {
        return "/registered";
    }
    @PostMapping("/addUser")
    public String addUser (HttpServletRequest request,HttpSession session,Model model,@RequestParam(name = "userName") String userName,@RequestParam(name = "passWord")String passWord) {
        User user = new User();
        user.setUserName(userName);
        user.setPassword(passWord);
        user.setType(0);
        userMapper.insert(user);
        return "/index";
    }

}
