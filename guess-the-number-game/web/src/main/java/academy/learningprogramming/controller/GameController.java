package academy.learningprogramming.controller;

import academy.learningprogramming.service.GameService;
import academy.learningprogramming.util.AttributeNames;
import academy.learningprogramming.util.GameMapping;
import academy.learningprogramming.util.ViewNames;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Slf4j
@Controller
public class GameController {

    // == fields ==
    private final GameService gameService;

    // == constructors ==
    @Autowired
    public GameController(GameService gameService){
        this.gameService = gameService;
    }

    // == request methods ==
    @GetMapping(GameMapping.PLAY)
    public String play(Model model){
        model.addAttribute(AttributeNames.MAIN_MESSAGE, gameService.getMainMessage());
        model.addAttribute(AttributeNames.RESULT_MESSAGE, gameService.getResultMessage());

        log.info("model = {}", model);

        if(gameService.isGameOver())
        {
            return ViewNames.GAME_OVER;
        }

        return ViewNames.PLAY;
    }

    @PostMapping(GameMapping.PLAY)
    public String processMessage(@RequestParam int guess)
    {
        log.info("guess = {}", guess);

        gameService.checkGuess(guess);

        return GameMapping.REDIRECT_PLAY;
    }

    @GetMapping(GameMapping.RESTART)
    public String restart(Model model){
        gameService.reset();
        return GameMapping.REDIRECT_PLAY;
    }
}
