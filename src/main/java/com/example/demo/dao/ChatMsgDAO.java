package com.example.demo.dao;

import com.example.demo.dto.ChatMsgDTO;
import com.example.demo.mapper.ChatMsgMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ChatMsgDAO {

    @Autowired
    private ChatMsgMapper chatMsgMapper;



    public int insert(ChatMsgDTO dto) {
        return chatMsgMapper.insert(dto);
    }
}
