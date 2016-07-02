package com.groovyapp.messageconverter.amqp

import com.groovyapp.util.amqp.CustomMessageObject
import org.springframework.jms.support.converter.MessageConversionException
import org.springframework.jms.support.converter.MessageConverter

import javax.jms.Destination
import javax.jms.JMSException
import javax.jms.Message
import javax.jms.Session
import javax.jms.TextMessage

/**
 * Created by user on 6/24/2016.
 */
class CustomMessageConverter2 implements MessageConverter {
    @Override
    Message toMessage(Object object, Session session) throws JMSException, MessageConversionException {
        println "toMessage Object: $object"
        String str = (String)object
        def message = session.createTextMessage()
        message.setText(str)
        return message
    }

    @Override
    Object fromMessage(Message message) throws JMSException, MessageConversionException {
        println "fromMessage message: $message"
        def msg = (TextMessage)message
        def customMessageObject = new CustomMessageObject(msg:msg.getText())
        return customMessageObject
    }
}
