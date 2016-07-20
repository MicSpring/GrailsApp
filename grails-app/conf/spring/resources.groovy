import com.groovyapp.messageconverter.amqp.CustomMessageConverter2
import com.groovyapp.util.renderer.DemoModelRenderer
import org.apache.activemq.ActiveMQConnectionFactory
import org.springframework.jms.connection.JmsTransactionManager
import org.springframework.jms.core.JmsTemplate
import org.springframework.jms.listener.DefaultMessageListenerContainer
import org.springframework.jms.listener.adapter.MessageListenerAdapter

// Place your Spring DSL code here



beans = {
    jmsConnectionFactory(ActiveMQConnectionFactory) {
        brokerURL = 'tcp://localhost:61616'
    }

    customMessageConverter2(CustomMessageConverter2)

    jmsTemplate(JmsTemplate) {
        connectionFactory = jmsConnectionFactory
        messageConverter = customMessageConverter2
    }
    messageListener(MessageListenerAdapter, ref("messageDelegateService")) {
        defaultListenerMethod = "receive"
    }

    messageListenerTopic(MessageListenerAdapter, ref("messageConsumerService")) {
        defaultListenerMethod = "interceptMessage3"
    }

    jmsContainerQueue(DefaultMessageListenerContainer) {
        connectionFactory = jmsConnectionFactory
        destinationName = "mic1.queue"
        messageListener = messageListener//ref("messageConsumerJMSService")
        transactionManager = transactionManager
        //autoStartup = false
    }

    /*jmsContainerTopic(DefaultMessageListenerContainer) {
        connectionFactory = jmsConnectionFactory
        destinationName = "mic.topic"
        messageListener = messageListener//ref("messageConsumerJMSService")
        transactionManager = transactionManager
        //autoStartup = false
    }

    jmsContainerTopic2(DefaultMessageListenerContainer) {
        connectionFactory = jmsConnectionFactory
        destinationName = "mic.topic"
        messageListener = messageListenerTopic//ref("messageConsumerJMSService")
        transactionManager = transactionManager
        //autoStartup = false
    }*/

    transactionManager(JmsTransactionManager, ref("jmsConnectionFactory")){
    }

    demoModelRenderer(DemoModelRenderer)

}
