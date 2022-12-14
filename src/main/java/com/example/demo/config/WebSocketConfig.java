package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;
import javax.websocket.server.ServerEndpointConfig.Configurator;


@Configuration
//@Configuration + @Bean
// 외부라이브러 또는 내장 클래스를 bean으로 등록하고자 할 경우 사용.
// 1개 이상의 @Bean을 제공하는 클래스의 경우 반드시 @Configuraton을 명시
public class WebSocketConfig extends Configurator {

    //@ServerEndpoint 어노테이션이 달린 클래스들은 WebSocket이 생성될 때마다
    //인스턴스가 생성되고 JWA에 의해 관리되기 때문에 스프링의  @Autowired가 설정된 멤버들이
    // 정상적으로 최기화 되지 않습니다. 이때 이를 연결해 주고 초기화해 주는 클래스가 필요
    @Bean
    public ServerEndpointExporter serverEndpointExporter() {
        return new ServerEndpointExporter();
    }
}
