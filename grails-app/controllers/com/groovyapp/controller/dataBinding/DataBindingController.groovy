package com.groovyapp.controller.dataBinding

import com.groovyapp.domain.amqp.Message
import com.groovyapp.util.model.DemoModel
import com.groovyapp.jobs.*
import grails.plugin.dropwizard.metrics.meters.Metered
import grails.plugin.dropwizard.metrics.timers.Timed
import grails.rest.RestfulController
import grails.validation.Validateable
import grails.web.servlet.mvc.GrailsParameterMap
import grails.converters.*
import org.springframework.beans.factory.annotation.Autowired



class DataBindingController extends RestfulController<DemoModel>{

    static responseFormats = ['json']

    def dataBindingService

   DataBindingController() {
        super(DemoModel.class,true)
    }

    def index() {
        render "Controller in Action....."

    }

    def model(DemoModel demoModel)
    {
        println demoModel
        render 'ok'
    }

    def postModel(DemoModel demoModel)
    {
        println "params $params \n ${params.getClass()}"
        println demoModel
        render 'ok!!!'
    }

    def modelParam(String name, int age){
        println "Name: $name \n Age: $age"
        render 'ok!!!'
    }

    def postModelParam(String name, int age){
        println "Name(POST): $name \n Age(Post): $age"
        render 'ok!!!'
    }

    def postModelParamNCommand(String name, int age,DemoModel demoModel){
        println "Name(POST): $name \n Age(Post): $age \n DemoModel: $demoModel"
        //render view:"dataBinding"

        /**
         * render '<object>' to be used with Custom Object
         * Marshallers.
         *
         * For Custom Renderers use respond '<object>' as
         * respond method runs through the renderer registry
         * to inspect all the registered default/custom rederers (if any)
         * for the Mime Type in the Accept Header
         */

        // render demoModel/* as JSON*/
        respond demoModel
    }

    def modelParamNCommand(String name, int age,DemoModel demoModel) {
        println "Name(GET): $name \n Age(GET): $age  \n DemoModel: $demoModel"
        render 'ok!!!'
    }

    @Metered('Some Bind Data')
    @Timed('Some Bind Data Timed')
    def bindData(){
        dataBindingService.bindData()
        render "BinData Returned"
    }

    //This controller method Schedule a Job and trigger it
    def triggerJob(){
        try {
            //MetricsMonitoringJob.schedule(5000l, 6, [me: "Doing Good"])
            //MetricsMonitoringJob.triggerNow([me: "Doing Good", for: 6])
            render "Job has been Scheduled to Run......."
        }
        catch(e){
            e.printStackTrace()
        }
    }

    /** Log exception */
    private void logException(final Exception exception) {
        //log.error "Exception occurred. ${exception?.message}", exception
        exception.printStackTrace()
    }

}
