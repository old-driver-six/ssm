package com.bj186.oas.WebSoket;

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
 * 这里有个注意点,我们用了Spring提供的拦截器,也就相当于将请求路径交给了DispatchServlet去管理了
 * 所以前端访问路径就不能用传统的WebSocket的访问路径是不一样的.
 *      需要参照web.xml里面的DispatchServlet的访问路径配置写后缀. 比如我设置的是.do,就必须将.do后缀加上
 *      前端路径访问是,如果项目配置的名称,需加上名称.
 */
public class WebsoketConfig extends WebMvcConfigurerAdapter implements WebSocketConfigurer {
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        System.out.println("执行registerWebSocketHandlers方法!");
        registry.addHandler(webSocketHandler(),"/websocket/socketServer.do").addInterceptors(new SpringWebSocketHanderInterceptor());
        registry.addHandler(webSocketHandler(), "/sockjs/socketServer.do").addInterceptors(new SpringWebSocketHanderInterceptor()).withSockJS();
    }
    @Bean
    public TextWebSocketHandler webSocketHandler(){
        return new SpringWebSocketHander();
    }

}
