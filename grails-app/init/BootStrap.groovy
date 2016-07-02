import grails.core.GrailsApplication

class BootStrap {

    def grailsApplication
    def init = { servletContext ->

        println "The grailsApplication is $grailsApplication"
        println "The Value1 is: ${grailsApplication.config.getProperty('dataSource.env')}"
        println "The Value2 is: ${grailsApplication.config.getProperty('sample.config')}"
        println "The Value3 is: ${grailsApplication.config.getProperty('sample.config2')}"
    }
    def destroy = {
    }
}
