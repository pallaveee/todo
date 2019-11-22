package com.pallavi.todo.endpoints;

import com.pallavi.todo.model.TodoItem;
import com.pallavi.todo.repository.TodoRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class TodoEndpoint {

    private final TodoRepository todoRepository;

    public TodoEndpoint(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @GetMapping(value = "/api/todos")
    public Iterable<TodoItem> getTodos() {
        return todoRepository.findAll();
    }

    @PostMapping(value = "/api/todo")
    public TodoItem addItem(@RequestBody TodoItem todoItem){
        todoItem.setCreated(System.currentTimeMillis());
        return todoRepository.save(todoItem);
    }

    @PostMapping(value = "/api/todo/complete")
    public TodoItem completeItem(@RequestParam Long id) {
        Optional<TodoItem> optional = todoRepository.findById(id);
        if (optional.isPresent()) {
            TodoItem item = optional.get();
            item.setDone(true);
            return todoRepository.save(item);
        }

        return null;
    }

    @PostMapping(value = "/api/todo/uncomplete")
    public TodoItem uncompleteItem(@RequestParam Long id) {
        Optional<TodoItem> optional = todoRepository.findById(id);
        if (optional.isPresent()) {
            TodoItem item = optional.get();
            item.setDone(false);
            return todoRepository.save(item);
        }

        return null;
    }

    @PostMapping(value = "/api/todo/delete")
    public void deleteItem(@RequestParam long id){
        todoRepository.deleteById(id);
    }
}