package com.groovyapp.services.metrics

import com.codahale.metrics.Meter
import com.codahale.metrics.MetricRegistry
import com.codahale.metrics.Timer
import org.springframework.jmx.export.annotation.ManagedAttribute
import org.springframework.jmx.export.annotation.ManagedResource

/**
 * Created by user on 9/10/2016.
 */

@ManagedResource
class MetricsService {

    int params


    MetricRegistry metricRegistry

    void fetchMetrics(){
        println "MetricRegistry: $metricRegistry"
        Meter meter = metricRegistry.meter("Some Bind Data")
        Timer timer = metricRegistry.timer('Some Bind Data Timed')
        def rate = meter.oneMinuteRate
        Timer.Context context =  timer.time()
        println "The rate is: $rate and timer is ${timer.count} " /*+
                "\n Time Taken:${context.stop()}"
*/
    }

    @ManagedAttribute
    int getParams() {
        return params
    }

    @ManagedAttribute
    void setParams(int params) {
        this.params = params
    }
}
