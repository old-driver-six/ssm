package com.bj186.oas.Util.WebSocketUtil;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

/**
 * 消息处理类,里面维护了一个map集合,存放用户的标识和所创建的WebSocketSession绑定在一起,
 */
public class SpringWebSocketHander extends TextWebSocketHandler {
    //存储WebSoket和用户ID的map
    private static final List<Massgs> news=new ArrayList<>();   //存放离线消息的集合

    private static final Map<String, WebSocketSession> users;
    public Map<String, WebSocketSession> getUsers(){
        return users;
    }
    private static Logger logger = Logger.getLogger(SpringWebSocketHander.class);
    //用户标识,对应监听器的Key
    private static final String USER_ID="SESSION_USERNAME";
    static {
        users=new Hashtable<>();
    }
    /**
     * 连接成功,会触发页面上面的onopen方法
     */
    public void afterConnectionEstablished(WebSocketSession socketSession){
        logger.info("当前用户连接数!"+users.size());
        String userId=(String) socketSession.getAttributes().get(USER_ID);
        users.put(userId,socketSession);
        System.out.println("当前线上用户数量:"+users.size());
        for (Massgs massgs : news) {
            WebSocketSession session = users.get(massgs.getUid());
            if(session!=null){

                sendMessageToUser(massgs.getUid(),new TextMessage(massgs.getMsg()));

                news.remove(massgs);
            }
        }
    }
    public void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus){
        String userId=(String)session.getAttributes().get(USER_ID);
        System.out.println("用户:"+userId+"已退出!");
        users.remove(userId);
        System.out.println("剩余在线用户: "+users.size());
    }

    /**
     * Js调用WebSoket send方法的时候,会调用该方法
     * @param session
     * @param message
     */
    @Override
    public void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        super.handleTextMessage(session,message);

        ObjectMapper mapper=new ObjectMapper();
        Massgs massgs = mapper.readValue(message.getPayload(), Massgs.class);
        System.out.println("服务端收到消息:"+message);
        if(!"".equals(massgs.getUid())){     //判断当前用户是否在线,如果不在线就将消息缓存在消息集合中

            if(massgs.getUid().equals("TOUSERS")){      //判断是否是群发消息,如果不是群发消息,就是单发消息
                sendMessageToUsers(new TextMessage(massgs.getMsg()));
            }else {
                try {
                    sendMessageToUser(massgs.getUid(),new TextMessage(massgs.getMsg()));
                }catch (NullPointerException e){        //抛出异常说明,这个用户的session没有在线,所有直接放到缓存中去
                    news.add(massgs);
                }

            }
        }
    }

    /**
     * 发生异常时关闭用户连接,删除用户数据
     * @param session
     * @param throwable
     * @throws IOException
     */
    public void handleTransportError(WebSocketSession session, Throwable throwable) throws IOException {
        if(session.isOpen()){
            session.close();
        }
        System.out.println("传输异常,关闭webSocket连接");
        String userId=(String) session.getAttributes().get(USER_ID);
        users.remove(userId);       //从当前用户map中删除用户信息
    }
    public boolean supportsPartialMessages(){
        return false;
    }
    /**
     * 给某个用户发送消息
     * @param userID 用户传递的id值
     * @param message 用户要发送的消息
     */
    public void sendMessageToUser(String userID, TextMessage message){
        if(users.get(userID).isOpen()) {
            try {
                users.get(userID).sendMessage(message);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 给所有的用户发送消息
     * @param message
     */
    public void sendMessageToUsers(TextMessage message){
        for (String id : users.keySet()) {
            try {
                if(users.get(id).isOpen()){
                    users.get(id).sendMessage(message);
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

}
