package com.groovyapp.services.amqp

import grails.transaction.Transactional

@Transactional
class MessageConsumerService {

   // static exposes = ['jms']

   /* @Queue(name='mic1.queue')
    def interceptMessage1(msg) {
        println "The message in intercept1 is: $msg"

    }

    @Queue(name='mic1.queue')
    def interceptMessage2(msg) {
        println "The message in intercept2 is: $msg"

    }*/

    ///@Subscriber(topic = "mic.topic")
    def interceptMessage3(msg) {
        println "The message in intercept3 is: $msg"

    }

    //@Subscriber(topic = "mic.topic")
    def interceptMessage4(msg) {
        println "The message in intercept4 is: $msg"

    }

}
