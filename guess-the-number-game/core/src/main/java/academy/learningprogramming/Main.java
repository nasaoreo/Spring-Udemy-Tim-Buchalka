package academy.learningprogramming;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        logger.info("Get The Number");

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

        //close context (container)
        context.close();

    }
}
