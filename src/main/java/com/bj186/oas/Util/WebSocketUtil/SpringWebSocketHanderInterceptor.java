package com.bj186.oas.Util.WebSocketUtil;

import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.support.HttpSessionHandshakeInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * webSocket拦截器
 */
public class SpringWebSocketHanderInterceptor extends HttpSessionHandshakeInterceptor {
    @Override
    public boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler, Map<String, Object> attributes) throws Exception {
        if(request instanceof HttpServletRequest){
            HttpSession session = ((HttpServletRequest) request).getSession(false);     //获取Session
            if(session!=null){
                String session_username = (String)session.getAttribute("SESSION_USERNAME"); //获取出Session里面存放的用户信息
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
