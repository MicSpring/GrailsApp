package com.groovyapp.services.databinding

import com.codahale.metrics.Meter
import com.codahale.metrics.MetricRegistry
import com.codahale.metrics.Timer
import grails.transaction.Transactional

/**
 * Created by user on 9/6/2016.
 */
@Transactional
class DataBindingService {

    MetricRegistry metricRegistry

    void bindData(){
        try {
            println "Service Bind Successful...."
        }catch(e){
            e.printStackTrace()
        }
    }



}

