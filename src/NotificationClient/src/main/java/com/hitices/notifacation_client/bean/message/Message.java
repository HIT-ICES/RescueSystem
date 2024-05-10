package com.hitices.notifacation_client.bean.message;

import lombok.*;

import java.util.Date;

/**
 * @author Lei
 * @version 0.1
 * @date 2021/9/21
 * 表示一个基本的消息类型，主要描述的是消息本地
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Message {

    /**
     * 消息内容
     */
    private String messageInfo;

    /**
     * 消息状态
     */
    private int messageState;

    /**
     * 日期
     */
    private String messageTime;

}
