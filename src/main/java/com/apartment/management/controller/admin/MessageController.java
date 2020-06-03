package com.apartment.management.controller.admin;

import com.apartment.management.mapper.MessageMapper;
import com.apartment.management.model.Message;
import com.apartment.management.model.MessageExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.util.List;

/**
 * @author 王峥
 * @date 2020/6/2 6:38 下午
 */
@Controller
@CrossOrigin
public class MessageController {
    @Autowired
    MessageMapper messageMapper;
    @GetMapping("/message_management")
    public String message() {
        return "admin/message";
    }

    @GetMapping("/admin/messages")
    @ResponseBody
    public List<Message> messages() {
        MessageExample messageExample = new MessageExample();
        messageExample.createCriteria().andUserNameIsNotNull();
        List<Message> messages = messageMapper.selectByExample(messageExample);
        return messages;
    }
    @PutMapping(value = "/admin/messageModefy",produces = "application/json")
    @ResponseBody
    public Message edit(@RequestBody Message message, HttpServletRequest request) {
        Message message1 = messageMapper.selectByPrimaryKey(message.getUserName());
        message1.setDescription(message.getDescription());
        messageMapper.updateByPrimaryKeySelective(message1);
        return message1;
    }
}
