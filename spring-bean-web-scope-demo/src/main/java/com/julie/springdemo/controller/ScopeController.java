package com.julie.springdemo.controller;

import com.julie.springdemo.service.RandomizerRequestScope;
import com.julie.springdemo.service.RandomizerSessionScope;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;

@Controller
public class ScopeController {

    @Autowired
    private RandomizerRequestScope randomizerRequestScope;

    @Autowired
    private RandomizerSessionScope randomizerSessionScope;

    @RequestMapping("/Welcome")
    public void getRandom(HttpServletResponse response) throws Exception{
        response.getWriter().println("************ request scope ************ <br>");
        response.getWriter().println("Old Number : " + randomizerRequestScope.getRandomNumber() + "<br>");
        randomizerRequestScope.generateRandomNumber();
        response.getWriter().println("New Number : " + randomizerRequestScope.getRandomNumber() + "<br>");
        response.getWriter().println("Object reference : " + randomizerRequestScope + "<br>");

        response.getWriter().println("************ session scope ************ <br>");
        response.getWriter().println("Old Number : " + randomizerSessionScope.getRandomNumber() + "<br>");
        randomizerSessionScope.generateRandomNumber();
        response.getWriter().println("New Number : " + randomizerSessionScope.getRandomNumber() + "<br>");
        response.getWriter().println("Object reference : " + randomizerSessionScope + "<br>");
    }
}
