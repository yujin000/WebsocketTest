package com.example.demo.service;

import com.example.demo.dao.ChatRoomDAO;
import com.example.demo.dao.RoomUserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ChatRoomService {

    @Autowired
    private ChatRoomDAO chatRoomDao;
    @Autowired
    private RoomUserDAO roomUserDao;

    public void join(int roomNum, String nick) {

        Map <String, String> param = new HashMap<>();
        param.put("roomNum", String.valueOf(roomNum));
        param.put("nick", nick);
        if (roomUserDao.isExist(param)==0) {
            chatRoomDao.insert(roomNum);
            roomUserDao.insert(param);
        }
    }


}
