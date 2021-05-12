package academy.learningprogramming.service;

import academy.learningprogramming.Game;
import academy.learningprogramming.MessageGenerator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Slf4j
@Service
public class GameServiceImpl implements GameService{
    // == fields ==
    public final Game game;
    public final MessageGenerator messageGenerator;

    // == contructors ==
    @Autowired
    public GameServiceImpl(Game game, MessageGenerator messageGenerator)
    {
        this.game = game;
        this.messageGenerator = messageGenerator;
    }

    // == init ==
    @PostConstruct
    public void init(){
        log.info("main message : {}", getMainMessage());
        log.info("the number that we have to guess : {}", game.getNumber());
    }

    // == public methods ==
    @Override
    public boolean isGameOver() {
        return game.isGameWon() || game.isGameLost();
    }

    @Override
    public String getMainMessage() {
        return messageGenerator.getMainMessage();
    }

    @Override
    public String getResultMessage() {
        return messageGenerator.getResultMessage();
    }

    @Override
    public void checkGuess(int guess) {
        game.setGuess(guess);
        game.check();
    }

    @Override
    public void reset() {
        game.reset();
    }
}
