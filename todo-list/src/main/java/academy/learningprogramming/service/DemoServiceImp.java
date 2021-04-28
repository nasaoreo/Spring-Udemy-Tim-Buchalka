package academy.learningprogramming.service;

import org.springframework.stereotype.Service;

@Service
public class DemoServiceImp implements DemoService {
    @Override
    public String getHelloMessage(String user) {
        return "Hello " + user;
    }

    @Override
    public String getWelcomeMessage() {
        return "Welcome to this Demo application.";
    }
}
