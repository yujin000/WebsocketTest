package com.example.demo.dao;

import com.example.demo.dto.message_dto;
import com.example.demo.mapper.MessageMapper;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class message_dao {

    @Autowired
    MessageMapper messageMapper;


    public int insert(String msg) {
        System.out.println("dao 도착");
        return messageMapper.insert(msg);
    }
}
