package grailsapp

import com.groovyapp.config.common.GrailsAppWebInitializer
import com.groovyapp.util.amqp.CommonUtil
import com.groovyapp.util.model.NewModel
import grails.boot.GrailsApp
import grails.boot.config.GrailsAutoConfiguration
import grails.core.GrailsApplication
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.config.YamlMapFactoryBean
import org.springframework.beans.factory.config.YamlPropertiesFactoryBean
import org.springframework.context.EnvironmentAware
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.ImportResource
import org.springframework.core.env.ConfigurableEnvironment
import org.springframework.core.env.Environment
import org.springframework.core.env.MapPropertySource
import org.springframework.core.env.MutablePropertySources
import org.springframework.core.io.ClassPathResource


@ComponentScan("com.groovyapp.config.amqp")
class Application extends GrailsAutoConfiguration implements EnvironmentAware {

    static void main(String[] args) {
        /* new GrailsApp(Application)
                 .initializers(new GrailsAppWebInitializer())
                 .run(args);*/

        GrailsApp.run(Application, args)
    }


    Closure doWithSpring() {
        def beans = {
            commonUtil(CommonUtil)
        }

        beans
    }

    @Override
    void setEnvironment(Environment environment) {
        println "The environment is ${environment.getClass()}"

        YamlMapFactoryBean yaml = new YamlMapFactoryBean();
        yaml.setResources(new ClassPathResource("config/application-devconfig.yml"));
        MutablePropertySources mutablePropertySources = ((ConfigurableEnvironment)environment).getPropertySources();
        MapPropertySource mapPropertySource = new MapPropertySource("yamlProperties",yaml.getObject())
        mutablePropertySources.addLast(mapPropertySource)

        println "Doneeeee....."
    }
}