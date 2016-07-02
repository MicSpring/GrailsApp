package com.groovyapp.messageconverter.amqp

import org.springframework.messaging.Message
import org.springframework.messaging.MessageHeaders
import org.springframework.messaging.converter.MessageConverter

import javax.jms.JMSException
import javax.jms.ObjectMessage
import javax.jms.Session

/**
 * Created by user on 6/22/2016.
 */
class CustomMessageConverter implements MessageConverter {
    @Override
    Message<?> toMessage(Object payload,
                         MessageHeaders headers) {
        println "******payload----> $payload \n *******headers------: $headers"
        return null
    }

    @Override
    Object fromMessage(Message<?> message,
                       Class<?> targetClass) {
        println "******* Message: $message \n ********* targetClass: $targetClass"
        def instance = targetClass.newInstance()
        instance.msg = message.getPayload()
        println "******* Instance: $instance"
        return instance
    }
}
