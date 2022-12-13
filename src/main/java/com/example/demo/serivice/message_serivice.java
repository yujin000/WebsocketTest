package com.example.demo.serivice;

import com.example.demo.dao.message_dao;
import com.example.demo.dto.message_dto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class message_serivice {

    @Autowired
    private message_dao dao;

    public int insert(String msg) {
        return dao.insert(msg);
    }
}
