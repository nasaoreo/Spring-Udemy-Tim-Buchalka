package academy.learningprogramming.config;

import academy.learningprogramming.GuessCount;
import academy.learningprogramming.MaxNumber;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GameConfig {
    // == fiedls ==
    private int maxNumber = 50;
    private int guessCount = 5;

    // == bean methods ==
    @Bean
    @MaxNumber
    public int maxNumber1() {
        return maxNumber;
    }

    @Bean
    @GuessCount
    public int guessCount2() {
        return guessCount;
    }
}
