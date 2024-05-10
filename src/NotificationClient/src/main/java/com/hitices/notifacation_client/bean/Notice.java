package com.hitices.notifacation_client.bean;

import com.hitices.notifacation_client.bean.message.Message;
import com.hitices.notifacation_client.bean.message.MessageType;
import lombok.*;

/**
 * @author Lei
 * @version 0.1
 * @date 2021/09/24
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Notice {
    private Message message;
    private String sourceId;
    private String targetId;
    private MessageType messageType;
}
