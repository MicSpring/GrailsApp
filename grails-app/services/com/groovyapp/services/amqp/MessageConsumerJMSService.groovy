package com.groovyapp.services.amqp

import grails.transaction.Transactional

import javax.jms.Message
import javax.jms.MessageListener

@Transactional
class MessageConsumerJMSService implements MessageListener{


    /*void onMessageService(String msg) {
        println "The Message is -> $msg"
    }*/

    @Override
    void onMessage(Message message) {
        println "The Message is -> ${message.text}"
    }
}
