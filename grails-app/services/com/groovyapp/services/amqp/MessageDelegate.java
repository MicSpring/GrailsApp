package com.groovyapp.services.amqp;

import javax.jms.Message;
import javax.jms.TextMessage;

/**
 * Created by user on 6/19/2016.
 */
public interface MessageDelegate {

    //void handleMessage(String message);
    void receive(Object message);

}
