package com.example.demo.dto;

import com.example.demo.mapper.MessageMapper;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class message_dto {
    private int seq;
    private String msg;
}