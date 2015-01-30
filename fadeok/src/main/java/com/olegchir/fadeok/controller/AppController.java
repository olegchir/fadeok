package com.olegchir.fadeok.controller;

/**
 * Copyright (C) 2015 Oleg Chirukhin
 * Licensed under the Apache License 2.0,
 * see LICENSE-2.0.txt, LICENSE (it's a copy of LICENSE-2.0.txt) and NOTICE for additional information.
 * Precise date is 30.01.15, time is 5:57.
 */

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

@Controller
public class AppController {
//    @ResponseBody
//    @RequestMapping(value = "/welcome", method = RequestMethod.GET)
//    public ModelAndView welcome() {
//        String message = "<p>Hello Fadeok!</p>";
//        return new ModelAndView("welcome", "message", message);
//    }

//    @ResponseBody
//    @RequestMapping(value = "/", method = RequestMethod.GET)
//    public ModelAndView index(Locale locale, Model model) {
//        return new ModelAndView("index");
//    }

    @RequestMapping(value = {"/", "/home"}, method = RequestMethod.GET)
    public String home(Locale locale, Model model) {

        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

        String formattedDate = dateFormat.format(date);

        model.addAttribute("serverTime", formattedDate );

        return "home";
    }
}
