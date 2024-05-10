package com.hitices.notifacationserver.service;

import com.hitices.notifacationserver.bean.Notice;

/**
 * @author Lei
 * @version 0.1
 * @date 2021/9/23
 */
public interface ForwardService {

    public void forwordOne(Notice notice);


    public void radioToClient(Notice notice);

    public void radioToServer(Notice notice);
}
