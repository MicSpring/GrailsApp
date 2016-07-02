package com.groovyapp.services.amqp

import com.groovyapp.util.amqp.CommonUtil
import grails.transaction.Transactional
import org.springframework.beans.factory.annotation.Autowired

import javax.jms.Message
import javax.jms.TextMessage

@Transactional
class MessageDelegateService implements MessageDelegate {

    @Autowired
    CommonUtil commonUtil;

   /* @Override
    void handleMessage(String message) {
        println "The Message in Adapter is:- $message"
    }*/

    def serviceMethod() {

    }

    @Override
    void receive(Object message) {

        println "CommonUtil: $commonUtil"
        println "The Message in Adapter(Receive) is:- $message"
    }
}
