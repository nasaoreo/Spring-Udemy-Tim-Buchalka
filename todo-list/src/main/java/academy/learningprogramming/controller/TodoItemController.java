package academy.learningprogramming.controller;

import academy.learningprogramming.module.TodoData;
import academy.learningprogramming.service.TodoItemService;
import academy.learningprogramming.service.TodoItemServiceImpl;
import academy.learningprogramming.util.Mappings;
import academy.learningprogramming.util.ViewNames;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class TodoItemController {

    // == fields ==
    private final TodoItemService todoItemService;

    // == constructors ==
    @Autowired
    public TodoItemController(TodoItemServiceImpl todoItemService) {
        this.todoItemService = todoItemService;
    }

    // == model attributes ==
    @ModelAttribute
    public TodoData todoData() {
        return todoItemService.getData();
    }

    // == handler methos ==
    //http://localhost:8081/todo-list/items
    @GetMapping(Mappings.ITEMS)
    public String items() {
        return ViewNames.ITEM_LIST;
    }

}
