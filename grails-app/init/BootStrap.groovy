import com.groovyapp.util.model.NewModel
import grails.core.GrailsApplication
import grails.spring.BeanBuilder

class BootStrap {

    BeanBuilder beanBuilder = new BeanBuilder()


    def grailsApplication
    def init = { servletContext ->

        beanBuilder.beans{
                newModel(NewModel)
        }


        beanBuilder.registerBeans(grailsApplication.mainContext)
        println "The grailsApplication is $grailsApplication"
        println "The Value1 is: ${grailsApplication.config.getProperty('dataSource.env')}"
        println "The Value2 is: ${grailsApplication.config.getProperty('sample.config')}"
        println "The Value3 is: ${grailsApplication.config.getProperty('sample.config2')}"
        println "The Value4 is: ${grailsApplication.config.getProperty('sample.env')}"
        println "The Value5 is: ${grailsApplication.mainContext.getBean('commonUtil')}"
        println "The Value6 is: ${grailsApplication.mainContext.getBean('newModel')}"
        println "The Value7 is: ${grailsApplication.config.getProperty('sample.devconfig')}"

        /*def parContextBeans = grailsApplication.parentContext.getBeanDefinitionNames()
        for(String beanName:parContextBeans)
            print "${beanName} ,"

        println()
       10.times {
           100.times {
               print "*"
           }
           println()
       }
        println()

        println "ParentContextClass: ${grailsApplication.parentContext.getClass()}"
        */

        def mainContextBeans = grailsApplication.mainContext
        println "MainContextClass: ${mainContextBeans.getClass()}"
        println "MainContextClass Parent: ${mainContextBeans.getParent().getClass()}"


       /* for(String beanName:mainContextBeans.getBeanDefinitionNames())
            print "${beanName} ,"*/

    }
    def destroy = {
    }
}
