package academy.learningprogramming.controller;

import academy.learningprogramming.module.TodoData;
import academy.learningprogramming.util.Mappings;
import academy.learningprogramming.util.ViewNames;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class TodoItemController {

    // == model attributes ==
    @ModelAttribute
    public TodoData todoData() {
        return new TodoData();
    }

    // == handler methos ==
    //http://localhost:8081/todo-list/items
    @GetMapping(Mappings.ITEMS)
    public String items() {
        return ViewNames.ITEM_LIST;
    }

}
