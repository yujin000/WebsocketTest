package com.example.demo.controller;

        import com.example.demo.service.ChatRoomService;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Controller;
        import org.springframework.ui.Model;
        import org.springframework.web.bind.annotation.RequestMapping;

        import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/chatRoom/")
public class ChatRoomController {

    @Autowired
    private HttpSession session;
    @Autowired
    ChatRoomService service;
    @RequestMapping("/join")
    public String join(int roomNum, Model model) {
        service.join(roomNum, session.getAttribute("nick").toString());
        model.addAttribute("roomNum", roomNum);
        return "index";
    }
}
