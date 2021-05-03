package academy.learningprogramming.service;

import academy.learningprogramming.module.TodoData;
import academy.learningprogramming.module.TodoItem;

public interface TodoItemService {
    void addItem(TodoItem toAdd);

    void removeItem(int id);

    TodoItem getItem(int id);

    void updateItem(TodoItem toUpdate);

    TodoData getData();
}
