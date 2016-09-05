package com.groovyapp.util.model

import grails.validation.Validateable
import groovy.transform.ToString
import org.grails.databinding.BindUsing

/**
 * Created by user on 7/31/2016.
 */

@ToString
class WebDataBindingNestedCommand implements Validateable{
    String name
    List<String> dataNested

    /*@BindUsing({ obj, source ->
        println "Object is $obj"
        println "Object class:${obj.getClass()}"
        println "Source Properties: ${source.getPropertyNames()}"
        println "Source Class: ${source.getClass()}"
        "DemoName"
    })*/
    WebDataBindingNested2Command webDataBindingNested2Command
}
