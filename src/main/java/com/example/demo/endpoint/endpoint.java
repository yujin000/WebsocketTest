package com.example.demo.endpoint;

import javax.websocket.Session;

import com.example.demo.config.ApplicationContextProvider;
import com.example.demo.dto.ChatMsgDTO;
import com.example.demo.dto.ChatRoomDTO;
import com.example.demo.service.ChatMsgService;
import com.google.gson.Gson;
import org.springframework.stereotype.Service;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.util.*;

@Service
@ServerEndpoint("/chat/{roomNum}")
public class endpoint {

    private ChatMsgService service = ApplicationContextProvider.getApplicationContext().getBean(ChatMsgService.class);
    //ApplicationContextProvider.getApplicationContext() -> 스프링 주소 / 디펜던시 룩업으로 꺼내온다

    //private static Set<Session> clients = Collections.synchronizedSet(new HashSet<>());
    private static Map<Integer, Set<Session>> sessions = Collections.synchronizedMap(new HashMap<>());
    private Gson g = new Gson();

    @OnOpen
    public void onOpen(@PathParam("roomNum") int roomNum, Session s) {
        System.out.println("open session : " + s.toString());
        System.out.println("roomNum : " + roomNum);

        if(!sessions.containsKey(roomNum)) {
            sessions.put(roomNum, new HashSet<>());
        }
        if (!sessions.get(roomNum).contains(s)) {
            sessions.get(roomNum).add(s);
            System.out.println("session open : " + s);
        }else {
            System.out.println("이미 연결된 session 임!!!");
        }
    }

    @OnMessage
    public void onMessage(String json, Session session) throws Exception{
        Gson g = new Gson();
        System.out.println("receive json : " + json);

        ChatMsgDTO chatMsgDto = g.fromJson(json, ChatMsgDTO.class);

//        JsonObject data = new JsonObject();
//        data.addProperty("msg", msg);
//        JsonArray arr = new JsonArray();
//        arr.add(data);

        for(Session s : sessions.get(chatMsgDto.getRoomNum())) {
            System.out.println("send data : " + chatMsgDto.getMsg());
            s.getBasicRemote().sendText(chatMsgDto.getNick() + " : " + chatMsgDto.getMsg());
        }

        service.insert(chatMsgDto);

    }

    @OnClose
    public void onClose(@PathParam("roomNum") int roomNum, Session s) {
        System.out.println("session close : " + s);
        sessions.get(roomNum).remove(s);
    }
}