package com.bj186.oas.Util.WebSocketUtil;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import org.springframework.web.socket.handler.TextWebSocketHandler;

@Configuration
@EnableWebMvc
@EnableWebSocket
/**
 * 创建WebSocket连接点:
 */
public class WebsoketConfig extends WebMvcConfigurerAdapter implements WebSocketConfigurer {
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(webSocketHandler(),"/websocket/socketServer.do").addInterceptors(new SpringWebSocketHanderInterceptor());
        registry.addHandler(webSocketHandler(), "/sockjs/socketServer.do").addInterceptors(new SpringWebSocketHanderInterceptor()).withSockJS();

    }
    @Bean
    public TextWebSocketHandler webSocketHandler(){
        return new SpringWebSocketHander();
    }

}
