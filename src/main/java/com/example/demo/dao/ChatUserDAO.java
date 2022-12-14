package com.example.demo.dao;

import com.example.demo.mapper.ChatUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ChatUserDAO {

    @Autowired
    ChatUserMapper chatUserMapper;

    public int isExist(String nick) {
        System.out.println("유저식별 : " + nick);
        return chatUserMapper.isExist(nick);
    }
}
