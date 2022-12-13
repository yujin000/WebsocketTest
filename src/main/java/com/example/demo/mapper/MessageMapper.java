package com.example.demo.mapper;

import com.example.demo.dto.message_dto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MessageMapper {
    int insert(String msg);
}
