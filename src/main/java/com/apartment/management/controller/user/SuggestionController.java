package com.apartment.management.controller.user;

import com.apartment.management.mapper.MessageMapper;
import com.apartment.management.model.Message;
import com.apartment.management.model.MessageExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * @author 王峥
 * @date 2020/6/3 11:12 上午
 */
@Controller
public class SuggestionController {
    @Autowired
    MessageMapper messageMapper;
    @GetMapping("/suggestion")
    public String suggestion(Model model) {
        MessageExample messageExample = new MessageExample();
        messageExample.createCriteria().andUserNameIsNotNull();
        List<Message> messages = messageMapper.selectByExample(messageExample);
        model.addAttribute("messages", messages);
        return "user/suggestion";
    }
    @PostMapping("/addMessage")
    public String addMessage(Model model,HttpServletRequest request, @RequestParam(name = "title") String title, @RequestParam(name = "description")String destription) {
        String userName = request.getParameter("userName");
        Message message = new Message();
        message.setUserName(userName);
        message.setDescription(destription);
        message.setTitle(title);
        message.setUserType(0);
        messageMapper.insertSelective(message);
        MessageExample messageExample = new MessageExample();
        messageExample.createCriteria().andUserNameIsNotNull();
        List<Message> messages = messageMapper.selectByExample(messageExample);
        model.addAttribute("messages", messages);
        return "user/suggestion";
    }
}
