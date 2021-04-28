package academy.learningprogramming.controller;

import academy.learningprogramming.service.DemoService;
import academy.learningprogramming.service.DemoServiceImp;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@Controller
public class DemoController {

    // == fields ==
    public final DemoService demoService;

    // == constructors ==
    @Autowired
    public DemoController(DemoServiceImp service) {
        this.demoService = service;
    }

    // == request methods

    // http://localhost:8081/todo-list/hello
    @ResponseBody
    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    // http://localhost:8081/todo-list/welcome
    @GetMapping("/welcome")
    public String welcome(Model model) {
        model.addAttribute("helloMessage", demoService.getHelloMessage("Nasaoreo"));
        log.info("model= {}", model);

        // prefix + name + suffix
        // /WEB-INF/view/welcome.jsp
        return "welcome";
    }

    // == model attributes ==
    @ModelAttribute("welcomeMessage")
    public String welcomeMessage() {
        log.info("service's welcomeMessage() called");
        return demoService.getWelcomeMessage();
    }
}
