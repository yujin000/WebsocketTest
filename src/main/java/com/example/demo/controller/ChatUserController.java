package com.example.demo.controller;

import com.example.demo.dto.ChatUserDTO;
import com.example.demo.service.ChatUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/chatUser/")
public class ChatUserController {

    @Autowired
    HttpSession session;
    @Autowired
    ChatUserService service;
    @RequestMapping("login")
    public String login(ChatUserDTO dto, Model model) {
        if (service.isExist(dto)) {
            session.setAttribute("nick", dto.getNick());
            return "mypage";
        } else {
            return "home";
        }
    }


}
