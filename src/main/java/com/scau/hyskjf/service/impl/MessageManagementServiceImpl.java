package com.scau.hyskjf.service.impl;

import com.scau.hyskjf.dao.MessageMapper;
import com.scau.hyskjf.pojo.Message;
import com.scau.hyskjf.service.MessageManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: kevin
 * @Date: 2018/8/14 15:05
 * @Version 1.0
 */

@Service
public class MessageManagementServiceImpl implements MessageManagementService {

    @Autowired
    private MessageMapper messageMapper;
    @Override
    public List<Message> findSendedMessage(int id) {
        return messageMapper.findSendedMessage(id);
    }

    @Override
    public List<Message> findReceivedMessage(int id) {
        return messageMapper.findReceivedMessahe(id);
    }

    @Override
    public List<Message> findUnlookMessage(int id) {
        return messageMapper.findUnlookMessage(id);
    }

    @Override
    public Message findMessageDetail(int id) {
        Message message = messageMapper.selectByPrimaryKey(id);
        if((message.getMestype() == 2 || message.getMestype() == 3) &&
           (message.getMesread() == null || message.getMesread() == false)){
            message.setMesread(true);
            messageMapper.updateByPrimaryKeySelective(message);
            return message;
        }else{
            return message;
        }
    }

    @Override
    public void sendMessage(Message message) {
        messageMapper.insert(message);
    }
}
