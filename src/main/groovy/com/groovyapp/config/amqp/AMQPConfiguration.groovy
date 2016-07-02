package com.groovyapp.config.amqp

import com.groovyapp.listener.amqp.AMQPMessageListener
import com.groovyapp.messageconverter.amqp.CustomMessageConverter
import com.groovyapp.messagevalidator.amqp.CustomMessageValidator
import com.groovyapp.util.amqp.AmqpUtil
import org.apache.activemq.ActiveMQConnectionFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.jms.annotation.EnableJms
import org.springframework.jms.annotation.JmsListenerConfigurer
import org.springframework.jms.config.DefaultJmsListenerContainerFactory
import org.springframework.jms.config.JmsListenerEndpointRegistrar
import org.springframework.jms.config.JmsListenerEndpointRegistry
import org.springframework.jms.listener.MessageListenerContainer
import org.springframework.jms.support.destination.DestinationResolver
import org.springframework.jms.support.destination.DynamicDestinationResolver
import org.springframework.messaging.handler.annotation.support.DefaultMessageHandlerMethodFactory
import org.springframework.messaging.handler.annotation.support.MessageHandlerMethodFactory

/**
 * Created by user on 6/21/2016.
 */
@Configuration
@EnableJms
public class AMQPConfiguration implements JmsListenerConfigurer {

    @Autowired
    ActiveMQConnectionFactory jmsConnectionFactory


    @Override
    void configureJmsListeners(JmsListenerEndpointRegistrar registrar) {

        println ("***** JMS Configured *****")

        registrar.setContainerFactory(jmsListenerContainerFactory())
        registrar.setMessageHandlerMethodFactory(messageHandlerMethodFactory()  )

        JmsListenerEndpointRegistry jmsListenerEndpointRegistry = registrar.getEndpointRegistry()
        jmsListenerEndpointRegistry?.getListenerContainers().each{ MessageListenerContainer messageListenerContainer ->
           println "****Details: ${messageListenerContainer?.destinationResolver}"

        }



    }

    @Bean
    public AmqpUtil amqpUtil() {
        def amqpUtil = new AmqpUtil()
        amqpUtil.connectionFactory = jmsConnectionFactory
        amqpUtil
    }

    @Bean
    public DestinationResolver destinationResolver() {
        return new DynamicDestinationResolver()
    }

    @Bean
    public AMQPMessageListener amqpMessageListener() {
        return new AMQPMessageListener()
    }

    @Bean
    public MessageHandlerMethodFactory  messageHandlerMethodFactory()
    {
        def messageHandlerMethodFactory = new DefaultMessageHandlerMethodFactory()
        messageHandlerMethodFactory.setMessageConverter(new CustomMessageConverter())
        messageHandlerMethodFactory.setValidator(new CustomMessageValidator())
        return messageHandlerMethodFactory
    }

    @Bean
    public DefaultJmsListenerContainerFactory jmsListenerContainerFactory() {
        DefaultJmsListenerContainerFactory factory =
                new DefaultJmsListenerContainerFactory();
        factory.setConnectionFactory(jmsConnectionFactory);
        //factory.setDestinationResolver(destinationResolver());
        factory.setConcurrency("3-10");
        return factory;
    }


}
