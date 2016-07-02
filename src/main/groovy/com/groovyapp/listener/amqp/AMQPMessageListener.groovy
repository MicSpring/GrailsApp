package com.groovyapp.listener.amqp

import com.groovyapp.util.amqp.CustomMessageObject
import org.springframework.jms.annotation.JmsListener
import org.springframework.validation.annotation.Validated

import javax.jms.Message
import javax.validation.Valid


/**
 * Created by user on 6/22/2016.
 */
class AMQPMessageListener {

    @JmsListener(destination = "mic2.queue", containerFactory = "jmsListenerContainerFactory")
    public void processOrder(@Valid  CustomMessageObject data) {
        println "\n\nMessage Data is:- $data"
    }
}
