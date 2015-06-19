package com.olegchir.fadeok.init;
/**
 * Copyright (C) 2015 Oleg Chirukhin
 * Licensed under the Apache License 2.0,
 * see LICENSE-2.0.txt, LICENSE (it's a copy of LICENSE-2.0.txt) and NOTICE for additional information.
 */

import org.apache.tiles.extras.complete.CompleteAutoloadTilesListener;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.*;
import java.util.EnumSet;

/**
 * Created by olegchir on 25.12.14.
 *
 * Servlet 3.0 initialization INSTEAD of web.xml, WebApplicationInitializer is a part of spring-web
 */
public class AppInitializer implements WebApplicationInitializer {

    private static final String CONFIG_LOCATION = "com.olegchir.fadeok.config";

    public void onStartup(ServletContext servletContext) throws ServletException {
        System.out.println("Initializing Application for " + servletContext.getServerInfo());

        //Create webapp context
        AnnotationConfigWebApplicationContext applicationContext = new AnnotationConfigWebApplicationContext();
        applicationContext.setConfigLocation(CONFIG_LOCATION);

        servletContext.addListener(new ContextLoaderListener(applicationContext));
//        servletContext.addListener(new CompleteAutoloadTilesListener());

        // Add the servlet mapping manually and make it initialize automatically
        DispatcherServlet dispatcherServlet = new DispatcherServlet(applicationContext);
        ServletRegistration.Dynamic servlet = servletContext.addServlet("mvc-dispatcher", dispatcherServlet);

        servlet.addMapping("/");
        servlet.setAsyncSupported(true);
        servlet.setLoadOnStartup(1);
    }
}