package com.groovyapp.messagevalidator.amqp

import org.springframework.validation.Errors
import org.springframework.validation.Validator

/**
 * Created by user on 6/22/2016.
 */
class CustomMessageValidator implements Validator{

    @Override
    boolean supports(Class<?> clazz) {
        println "#### clazz in Custom Message Validator : $clazz"
        return true
    }

    @Override
    void validate(Object target, Errors errors) {
        println "#####target in Custom Message Validator: $target"
        /**
         * @see
         * @param errors when populated the message is not
         * passed to registered Listener
         */
        //errors.reject("No Right Message")
    }
}
