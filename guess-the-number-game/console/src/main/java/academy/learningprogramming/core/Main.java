package academy.learningprogramming.core;

import academy.learningprogramming.Game;
import academy.learningprogramming.MessageGenerator;
import academy.learningprogramming.NumberGenerator;
import academy.learningprogramming.config.AppConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        logger.info("Guess The Number Game");

        // create context (container)
        ConfigurableApplicationContext context
                = new AnnotationConfigApplicationContext(AppConfig.class);

        //get number generator bean from context
        NumberGenerator numberGenerator
                = context.getBean(NumberGenerator.class);

        //call method next() to get a random number
        int number = numberGenerator.next();

        //log generated number
        logger.info("number = {}", number);

        //get game bean from context (container)
        Game game = context.getBean(Game.class);

        //get message generator bean from context (container)
        MessageGenerator messageGenerator
                = context.getBean(MessageGenerator.class);

        //log main and result message
        logger.info("getMainMessage = {}", messageGenerator.getMainMessage());
        logger.info("getResultMessage = {}", messageGenerator.getResultMessage());

        //close context (container)
        context.close();

    }
}
