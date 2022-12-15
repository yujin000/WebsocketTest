package com.example.demo.service;

import com.example.demo.dao.ChatUserDAO;
import com.example.demo.dto.ChatUserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChatUserService {
    @Autowired
    private ChatUserDAO dao;

    public boolean isExist(ChatUserDTO dto) {
        if (dao.isExist(dto.getNick())==1) {
            return true;
        } else {
            return false;
        }
    }
}
