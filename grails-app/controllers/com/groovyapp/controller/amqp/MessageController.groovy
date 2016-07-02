package com.groovyapp.controller.amqp

import com.groovyapp.domain.amqp.Message
import org.springframework.jms.core.JmsTemplate

class MessageController {
    static scaffold = Message

    JmsTemplate jmsTemplate
    //def jmsService


    def index() {
        println "Welcome to Index"
    }

    def sendMessage() {
       // println "The JMS Template is: $jmsTemplate and service $jmsService"
        println "The JMS Template is: $jmsTemplate"
        //jmsTemplate.s
        //jmsService.send(queue:"mic1.queue","First Message")

        //jmsService.send(topic:"mic.topic","Broadcast Message")


        jmsTemplate.convertAndSend "mic1.queue","FirstMessage With Template"
        jmsTemplate.convertAndSend "mic2.queue","FirstMessage With Template For Annotated Listener"
        //jmsTemplate.convertAndSend "mic.topic","FirstMessage With Topic"

        render(view:"message")

    }
}
