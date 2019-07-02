package com.bj186.oas.WebSoket;

import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.support.HttpSessionHandshakeInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * webSocket拦截器
 */
public class SpringWebSocketHanderInterceptor extends HttpSessionHandshakeInterceptor {
    /**
     * 拦截WebSoket握手前取出session里面放的用户信息,
     *      WebSocket貌似就是用的Session来通信的
     * 如果不用Session的话,这样的话就需要记录客户端电脑的ip地址了,
     * @param request
     * @param response
     * @param wsHandler
     * @param attributes
     * @return
     * @throws Exception
     */
    @Override
    public boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler, Map<String, Object> attributes) throws Exception {
        if(request instanceof ServerHttpRequest){
            HttpSession session = ((ServletServerHttpRequest) request).getServletRequest().getSession();     //获取Session
            if(session!=null){
                String session_username = (String)session.getAttribute("SESSION_USERNAME"); //获取出Session里面存放的用户信息
                System.out.println("获取存在cookie里面的信息!"+session_username);
                if(session_username==null){ //如果session为空,则说明不是用户发送的消息
                    session_username="sandao";
                }
                attributes.put("WEBSOCKET_USERNAME",session_username);      //将用户消息放到webSocket维护的连接map中去.
            }
        }
        return super.beforeHandshake(request,response,wsHandler,attributes);
    }

    @Override
    public void afterHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler, Exception ex) {
        super.afterHandshake(request, response, wsHandler, ex);
    }
}
