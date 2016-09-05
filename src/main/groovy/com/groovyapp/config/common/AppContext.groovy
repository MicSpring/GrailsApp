package com.groovyapp.config.common

import com.groovyapp.util.model.NewModel
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

/**
 * Created by user on 7/26/2016.
 */
@Configuration
class AppContext {

    @Bean
    public NewModel newModel2() {
        def newModel = new NewModel()
        newModel
    }
}
