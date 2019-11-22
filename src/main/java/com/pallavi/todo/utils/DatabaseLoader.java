package com.pallavi.todo.utils;

import com.pallavi.todo.model.TodoItem;
import com.pallavi.todo.repository.TodoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseLoader implements CommandLineRunner {

    private final TodoRepository todoRepository;

    public DatabaseLoader(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        todoRepository.save(TodoItem.builder()
                .created(0)
                .isDone(false)
                .text("I should clean the bathroom")
                .userName("Pallavike")
                .build());

        todoRepository.save(TodoItem.builder()
                .created(1000000000)
                .isDone(true)
                .text("Tomorrow I should wipe my butt")
                .userName("Hayot")
                .build());
    }
}
