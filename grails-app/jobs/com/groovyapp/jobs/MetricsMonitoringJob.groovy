package com.groovyapp.jobs

import org.quartz.JobExecutionContext

class MetricsMonitoringJob {

    def metricsService

    static triggers = {
        //It will be fired from DataBindingController
        simple repeatInterval: 5000l // execute job once in 5 seconds
    }

    def execute(/*JobExecutionContext context*/) {
        // execute job
        println "Job Executed.... "/*for: ${context.mergedJobDataMap()}*/
        metricsService.fetchMetrics()
    }
}
