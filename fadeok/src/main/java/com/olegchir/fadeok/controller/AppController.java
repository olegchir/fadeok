package com.olegchir.fadeok.controller;

/**
 * Copyright (C) 2015 Oleg Chirukhin
 * Licensed under the Apache License 2.0,
 * see LICENSE-2.0.txt, LICENSE (it's a copy of LICENSE-2.0.txt) and NOTICE for additional information.
 * Precise date is 30.01.15, time is 5:57.
 */

import com.googlecode.genericdao.search.Search;
import com.googlecode.genericdao.search.jpa.JPASearchProcessor;
import com.olegchir.fadeok.dao.FadeokTaskDao;
import com.olegchir.fadeok.dao.FadeokTaskDaoImpl;
import com.olegchir.fadeok.dao.FadeokUserDao;
import com.olegchir.fadeok.model.FadeokTask;
import com.olegchir.fadeok.model.FadeokUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Transactional;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@Controller
public class AppController {

    public static final String QUERY_ALL_TABLES = "SELECT * FROM INFORMATION_SCHEMA.TABLES";

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

    @Transactional
    @RequestMapping(value = {"/users"}, method = RequestMethod.GET)
    public String users(Locale locale, Model model) {

        Search search = new Search();
        List<FadeokUser> users = fadeokUserDao.search(search);
        model.addAttribute("users",users);

        model.addAttribute("user", new FadeokUser());

        return "users";
    }

    @Transactional
    @RequestMapping("/remove/{id}")
    public String removePerson(@PathVariable("id") long id){
        fadeokUserDao.removeById(id);
        return "redirect:/users";
    }
    @Transactional
    @RequestMapping("/edit/{id}")
    public String editPerson(@PathVariable("id") long id, Model model){
        FadeokUser user = fadeokUserDao.find(id);
        model.addAttribute("user", user);

        Search search = new Search();
        List<FadeokUser> users = fadeokUserDao.search(search);
        model.addAttribute("users", users);

        return "users";
    }

    @Transactional
    @RequestMapping(value= "/users/add", method = RequestMethod.POST)
    public String addUser(@ModelAttribute("user") FadeokUser p, BindingResult result){
        fadeokUserDao.save(p);
        return "redirect:/users";
    }


    @Resource
    public FadeokTaskDao fadeokTaskDao;
    @Resource
    public FadeokUserDao fadeokUserDao;


}
