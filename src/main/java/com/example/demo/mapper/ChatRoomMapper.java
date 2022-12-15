package com.example.demo.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ChatRoomMapper {
    int update(int roomNum);


}
