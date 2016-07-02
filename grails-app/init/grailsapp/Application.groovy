package grailsapp

import com.groovyapp.util.amqp.CommonUtil
import grails.boot.GrailsApp
import grails.boot.config.GrailsAutoConfiguration
import grails.core.GrailsApplication
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan

@ComponentScan("com.groovyapp.config.amqp")
class Application extends GrailsAutoConfiguration {

    static void main(String[] args) {
        GrailsApp.run(Application, args)
    }

    Closure doWithSpring(){
        def beans = {
            commonUtil(CommonUtil)
        }

        beans
    }
}