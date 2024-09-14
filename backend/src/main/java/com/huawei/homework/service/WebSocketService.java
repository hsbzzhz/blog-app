package com.huawei.homework.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Component;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import java.io.IOException;
import java.util.concurrent.CopyOnWriteArraySet;

@Component
public class WebSocketService {
    //与某个客户端的连接会话，需要通过它来给客户端发送数据
    private Session session;

    private static final Logger LOGGER = LoggerFactory.getLogger(WebSocketService.class);

    //concurrent包的线程安全Set，用来存放每个客户端对应的WebSocket对象。
    private static CopyOnWriteArraySet<WebSocketService> webSocketSet=new CopyOnWriteArraySet<>();

    /**
     *  建立连接成功
     * @param session
     */
    @OnOpen
    public void onOpen(Session session){
        this.session=session;
        webSocketSet.add(this);
        LOGGER.info("【websocket消息】 有新的连接，总数{}",webSocketSet.size());
    }

    /**
     * 连接关闭
     */
    @OnClose
    public void onClose(){
        this.session=session;
        webSocketSet.remove(this);
        LOGGER.info("【websocket消息】 连接断开，总数{}",webSocketSet.size());
    }

    /**
     * 接收客户端消息
     * @param message
     */
    @OnMessage
    public void onMessage(String message){
        LOGGER.info("【websocket消息】 收到客户端发来的消息：{}",message);
    }

    /**
     * 广播发送消息
     * @param message
     */
    public void sendAllMessage(String message){
        LOGGER.info("【websocket消息】 发送消息：{}",message);
        for (WebSocketService webSocket:webSocketSet){
            try {
                webSocket.session.getBasicRemote().sendText(message);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
