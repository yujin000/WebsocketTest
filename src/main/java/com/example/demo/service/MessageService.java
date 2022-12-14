package com.example.demo.service;
import com.example.demo.dao.MessageDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageService {

    @Autowired
    private MessageDAO dao;

    public int insert(String msg) {
        return dao.insert(msg);
    }
}
