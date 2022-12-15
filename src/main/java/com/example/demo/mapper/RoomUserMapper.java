package com.example.demo.mapper;

import com.example.demo.dto.ChatRoomDTO;
import com.example.demo.dto.RoomUserDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

@Mapper
public interface RoomUserMapper {
    int isExist(Map <String, String> param);
    int insert(Map <String, String> param);
}
