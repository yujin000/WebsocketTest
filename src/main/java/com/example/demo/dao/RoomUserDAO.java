package com.example.demo.dao;

import com.example.demo.mapper.RoomUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public class RoomUserDAO {

    @Autowired
    private RoomUserMapper roomUserMapper;

    public int isExist(Map<String, String> param) {
        return roomUserMapper.isExist(param);
    }

    public int insert(Map <String, String> param) {
        return roomUserMapper.insert(param);
    }

}
