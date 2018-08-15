package com.scau.hyskjf.dao;

import com.scau.hyskjf.pojo.Message;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageMapper {
    int deleteByPrimaryKey(Integer mesid);

    int insert(Message record);

    int insertSelective(Message record);

    Message selectByPrimaryKey(Integer mesid);

    int updateByPrimaryKeySelective(Message record);

    int updateByPrimaryKeyWithBLOBs(Message record);

    int updateByPrimaryKey(Message record);

    List<Message> findSendedMessage(int messource);

    List<Message> findReceivedMessahe(int mesdestination);


    List<Message> findUnlookMessage(int mesdestination);
}