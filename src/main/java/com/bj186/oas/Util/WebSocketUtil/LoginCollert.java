package com.bj186.oas.Util.WebSocketUtil;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/")
public class LoginCollert {
    @RequestMapping("start.do")
    public String Login(){
        return "index";
    }
    @RequestMapping("/websocket/login")
    public ModelAndView login(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String username = request.getParameter("username");
        System.out.println(username+"登录");
        HttpSession session = request.getSession();
        session.setAttribute("SESSION_USERNAME", username);

        return new ModelAndView("WebSocket/massges");
    }

    @RequestMapping("send.do")
    public String send(HttpServletRequest request) {
        String username = request.getParameter("username");
        System.out.println(username);
        infoHandler().sendMessageToUser(username, new TextMessage("你好，测试！！！！"));
        return "shareMsg";
    }

    /**
     * 新建一个WebSocket消息处理类,用于推送系统消息
     * 在将这个发送消息的类放到Spring容器中去.
     * @return
     */
    @Bean
    private SpringWebSocketHander infoHandler() {
        return new SpringWebSocketHander();
    }

    @RequestMapping("/TextMsg.do")
    @ResponseBody
    public String TestSend(Massgs massgs,HttpServletRequest request){
        System.out.println(massgs.getUid());
        SpringWebSocketHander socketHander = infoHandler();
        WebSocketSession session = socketHander.getUsers().get(request.getSession(false).getAttribute("SESSION_USERNAME"));
        ObjectMapper mapper=new ObjectMapper();
        try {
            String json = mapper.writeValueAsString(massgs);
            socketHander.handleTextMessage(session,new TextMessage(json));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "成功!";
    }
}
