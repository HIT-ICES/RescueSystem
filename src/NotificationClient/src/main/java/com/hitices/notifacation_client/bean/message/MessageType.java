package com.hitices.notifacation_client.bean.message;

/**
 * @author Lei
 * @version 0.1
 * @date 2021/9/22
 * 表示通知的类型
 */
public enum MessageType {
    /**
     * 客户端向服务端发送的请求
     */
    CLIENT_TO_SERVER(0),

    /**
     * 客户端向客户端发送的请求
     */
    CLIENT_TO_CLIENT(1),

    /**
     * 服务端向客户端发送的请求
     */
    SERVER_TO_CLIENT(2),

    /**
     * 某一个客户端的广播消息
     */
    CLIENT_RADIO_CLIENT(3),

    /**
     * 客户端向所有的server发送的广播消息
     */
    CLIENT_RADIO_SERVER(4),

    /**
     * 来自服务端的广播消息
     */
    SERVER_RADIO_SERVER(5),

    SERVER_RADIO_CLIENT(6);


    /**
     *
     */

    private int code;

    MessageType(int code){
        this.code = code;
    }
    public int getCode(){
        return code;
    }


    public static MessageType getTypeByCode(int code){
        MessageType[] messageType = MessageType.values();
        for(MessageType message : messageType){
            if(message.getCode() == code){
                return message;
            }
        }
        return messageType[0];
    }
}
