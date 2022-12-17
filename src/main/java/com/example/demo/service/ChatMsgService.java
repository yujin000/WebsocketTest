package com.example.demo.service;

import com.example.demo.dao.ChatMsgDAO;
import com.example.demo.dto.ChatMsgDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChatMsgService {

    @Autowired
    private ChatMsgDAO dao;

    public int insert(ChatMsgDTO dto) {
        return dao.insert(dto);
    }
}
