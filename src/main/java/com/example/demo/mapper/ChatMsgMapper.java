package com.example.demo.mapper;

import com.example.demo.dto.ChatMsgDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ChatMsgMapper {
    int insert(ChatMsgDTO dto);
}
