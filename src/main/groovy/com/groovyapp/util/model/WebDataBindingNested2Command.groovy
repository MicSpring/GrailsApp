package com.groovyapp.util.model

import grails.validation.Validateable
import groovy.transform.ToString
import org.grails.databinding.BindUsing

/**
 * Created by user on 7/31/2016.
 */
@ToString
class WebDataBindingNested2Command implements Validateable{

    String name
    List<String> dataNested2
}
