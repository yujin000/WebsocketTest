package com.example.demo.dao;

import com.example.demo.mapper.MessageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MessageDAO {

    @Autowired
    private MessageMapper messageMapper;


    public int insert(String msg) {
        System.out.println("dao 도착");
        return messageMapper.insert(msg);
    }
}
