package com.groovyapp.config.common

import org.springframework.web.WebApplicationInitializer
import org.springframework.web.context.ContextLoaderListener
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext

import javax.servlet.ServletContext
import javax.servlet.ServletException

/**
 * Created by user on 7/26/2016.
 */
class GrailsAppWebInitializer /*implements WebApplicationInitializer*/  {

    //@Override
    void onStartup(ServletContext servletContext) throws ServletException {

        AnnotationConfigWebApplicationContext rootContext =
                new AnnotationConfigWebApplicationContext();
        rootContext.register(AppContext.class);

        // Manage the lifecycle of the root application context
        servletContext.addListener(new ContextLoaderListener(rootContext));

    }
}
