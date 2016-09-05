package com.groovyapp.util.model

import grails.validation.Validateable
import groovy.transform.ToString
import org.grails.databinding.BindUsing

/**
 * Created by user on 7/31/2016.
 */
@ToString
class WebDataBindingCommand implements Validateable{

    String name
    int     age
    List<String> data


/*    @BindUsing({ obj, source ->
        println "Object is $obj"
        println "Object class:${obj.getClass()}"
        println "Source Properties: ${source.getPropertyNames()}"
        println "Source Class: ${source.getClass()}"
        def nestedName = (source.getPropertyValue("webDataBindingNestedCommand"))
        def nestedModel = new WebDataBindingNestedCommand(name:nestedName)
        nestedModel
    })*/
    WebDataBindingNestedCommand webDataBindingNestedCommand
}
