package com.groovyapp.util.model

import grails.validation.Validateable
import groovy.transform.ToString
import org.grails.databinding.BindUsing

/**
 * Created by user on 7/14/2016.
 */
@ToString
class DemoModel implements Validateable{


    String name;

    @BindUsing({obj, source ->
        println "Object is $obj"
        println "Object class:${obj.getClass()}"
        println "Source is ${source.getPropertyNames()}"
        println "Source Class: ${source.getClass()}"
        println "Age:= ${source.getPropertyValue("age")}"
        def ageOfModel = Integer.parseInt(source.getPropertyValue("age"))
        ageOfModel
    })
    int age;
    List<String> data
}
