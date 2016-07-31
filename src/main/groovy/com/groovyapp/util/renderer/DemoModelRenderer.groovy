package com.groovyapp.util.renderer

import com.groovyapp.domain.amqp.Message
import com.groovyapp.util.model.DemoModel
import grails.rest.render.AbstractRenderer
import grails.rest.render.RenderContext
import grails.web.mime.MimeType
import groovy.json.StreamingJsonBuilder

/**
 * Created by user on 7/20/2016.
 */
class DemoModelRenderer extends AbstractRenderer<DemoModel> {

    DemoModelRenderer() {
        super(DemoModel, new MimeType('application/json'))
        println " ======= In DemoModelRenderer () Creation ======="
    }
    @Override
    void render(DemoModel object, RenderContext context) {
        println "DemoModelRenderer In RENDER ${context.getClass()}"
        try {
            context.contentType = MimeType.JSON.name
            //context.writer.write()
            def json = new StreamingJsonBuilder(context.writer)
            println "Creating JSON......"
            json.ok {
                n1 "okkk1"
            }
        }
        catch(e){
            e.printStackTrace()
        }
    }
}
