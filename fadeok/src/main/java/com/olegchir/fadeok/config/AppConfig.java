package com.olegchir.fadeok.config;

/**
 * Copyright (C) 2015 Oleg Chirukhin
 * Licensed under the Apache License 2.0,
 * see LICENSE-2.0.txt, LICENSE (it's a copy of LICENSE-2.0.txt) and NOTICE for additional information.
 * Precise date is 30.01.15, time is 5:54.
 */

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;


@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"com.olegchir"})
//@EnableAspectJAutoProxy(proxyTargetClass = true)
public class AppConfig extends WebMvcConfigurerAdapter {
//    @Bean
//    public UrlBasedViewResolver setupViewResolver() {
//        UrlBasedViewResolver resolver = new UrlBasedViewResolver();
//        resolver.setPrefix("/jsp/");
//        resolver.setSuffix(".jsp");
//        resolver.setViewClass(JstlView.class);
//        return resolver;
//    }

    @Bean
    public InternalResourceViewResolver internalResourceViewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/view/");
        resolver.setSuffix(".jsp");
        return resolver;
    }

    @Bean
    public TilesConfigurer tilesConfigurer() {
        TilesConfigurer tilesConfigurer = new TilesConfigurer();
        tilesConfigurer.setDefinitions("/layout/tiles.xml"); //, "/view/**/tiles.xml"
        tilesConfigurer.setCheckRefresh(true);
        return tilesConfigurer;
    }

    @Bean
    public TilesViewResolver tilesViewResolver() {
        TilesViewResolver tilesViewResolver = new TilesViewResolver();
        tilesViewResolver.setOrder(2);
        return tilesViewResolver;
    }


}