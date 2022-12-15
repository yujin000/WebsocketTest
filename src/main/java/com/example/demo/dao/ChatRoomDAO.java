package com.example.demo.dao;

import com.example.demo.mapper.ChatRoomMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ChatRoomDAO {

    @Autowired
    private ChatRoomMapper chatRoomMapper;

    public int insert(int roomNum) {
        System.out.println("채팅방 인원증가");
        return chatRoomMapper.update(roomNum);
    }
}
