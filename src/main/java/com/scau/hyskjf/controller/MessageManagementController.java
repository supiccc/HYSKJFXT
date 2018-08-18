package com.scau.hyskjf.controller;

//站内消息管理控制器


import com.scau.hyskjf.pojo.Admin;
import com.scau.hyskjf.pojo.Message;
import com.scau.hyskjf.service.MessageManagementService;
import com.scau.hyskjf.util.json.ResponseCode;
import com.scau.hyskjf.util.json.ResponseJSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SessionAttributes("user")
@RestController
@RequestMapping("/messageManegement")
public class MessageManagementController {

    @Autowired
    private MessageManagementService messageManagementService;
    //查看已发送消息
    @RequestMapping("/sended")
    public ResponseJSON browseSendedMessages(@ModelAttribute("user")Admin admin){
        List<Message> messageList = messageManagementService.findSendedMessage(admin.getAdminid());
        return new ResponseJSON(ResponseCode.SUCCESS,messageList);
    }


    //查看已接收消息
    @RequestMapping("/received")
    public ResponseJSON browseReceivedMessages(@ModelAttribute("user")Admin admin){
        List<Message> messages = messageManagementService.findReceivedMessage(admin.getAdminid());
        return new ResponseJSON(ResponseCode.SUCCESS,messages);
    }


    //查看未浏览消息
    @RequestMapping("/unlook")
    public ResponseJSON browseUntreatedMessages(@ModelAttribute("user")Admin admin){
        List<Message> messages = messageManagementService.findUnlookMessage(admin.getAdminid());
        return new ResponseJSON(ResponseCode.SUCCESS,messages);
    }

    @RequestMapping("/messagedetail/{id}")
    //查看消息详情
    public ResponseJSON browseMessageDetail(@PathVariable int id){
        Message message = messageManagementService.findMessageDetail(id);
        return new ResponseJSON(ResponseCode.SUCCESS,message);
    }


    //发送消息
    @RequestMapping("/sendMessage")
    public ResponseJSON sendMessage(Message message){
        messageManagementService.sendMessage(message);
        return new ResponseJSON(ResponseCode.SUCCESS);
    }


    //回复消息
    @RequestMapping("/replyMessage")
    public ResponseJSON replyMessage(Message message){
        messageManagementService.sendMessage(message);
        return new ResponseJSON(ResponseCode.SUCCESS);
    }
}
