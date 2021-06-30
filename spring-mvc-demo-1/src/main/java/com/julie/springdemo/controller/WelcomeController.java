package com.julie.springdemo.controller;

import com.julie.service.demo.GenericWelcomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class WelcomeController {

    @Autowired
    private GenericWelcomeService welcomeService;

    //http://localhost:8080/spring-mvc-demo-1/
    @RequestMapping("/Welcome")
    public String doWelcome(Model model){

        //1. Retrieving the processed data
        //WelcomeService welcomeService = new WelcomeService();
        List<String> welcomeMessage = welcomeService.getWelcomeMessage("Julie");

        //2. Add data to the model
        model.addAttribute("myWelcomeMessage", welcomeMessage);

        //3. Return logical view name
        return "welcomeNew"; // /WEB-INF/views/welcomeNew.jsp
    }

}
