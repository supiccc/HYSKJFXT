package com.scau.hyskjf.service;

import com.scau.hyskjf.pojo.Message;

import java.util.List;

/**
 * @Author: kevin
 * @Date: 2018/8/14 15:07
 * @Version 1.0
 */
public interface MessageManagementService {
    List<Message> findSendedMessage(int id);

    List<Message> findReceivedMessage(int id);

    List<Message> findUnlookMessage(int id);

    Message findMessageDetail(int id);

    void sendMessage(Message message);
}
