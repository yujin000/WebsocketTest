package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ChatMsgDTO {
    int msgSeq;
    int roomNum;
    String nick;

    String msg;

}

//    create table chat_msg (
//        msg_seq number primary key,
//        room_num number,
//        nick varchar2(50),
//    msg varchar2(1000)
//);
