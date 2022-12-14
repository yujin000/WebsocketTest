package com.example.demo.endpoint;

import javax.websocket.Session;

import com.example.demo.config.ApplicationContextProvider;
import com.example.demo.service.MessageService;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.springframework.stereotype.Service;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.server.ServerEndpoint;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Service
@ServerEndpoint("/chat")
public class endpoint {

    private MessageService service = ApplicationContextProvider.getApplicationContext().getBean(MessageService.class);
    //ApplicationContextProvider.getApplicationContext() -> 스프링 주소 / 디펜던시 룩업으로 꺼내온다

    private static Set<Session> clients = Collections.synchronizedSet(new HashSet<>());
    private Gson g = new Gson();

    @OnOpen
    public void onOpen(Session s) {
        System.out.println("open session : " + s.toString());
        if(!clients.contains(s)) {
            clients.add(s);
            System.out.println("session open : " + s);
        }else {
            System.out.println("이미 연결된 session 임!!!");
        }
    }

    @OnMessage
    public void onMessage(String msg, Session session) throws Exception{
        System.out.println("receive message : " + msg);

        JsonObject data = new JsonObject();
        data.addProperty("msg", msg);
        JsonArray arr = new JsonArray();
        arr.add(data);

        for(Session s : clients) {
            System.out.println("send data : " + msg);
            s.getBasicRemote().sendText(arr.toString());
            service.insert(msg);
        }

    }

    @OnClose
    public void onClose(Session s) {
        System.out.println("session close : " + s);
        clients.remove(s);
    }
}