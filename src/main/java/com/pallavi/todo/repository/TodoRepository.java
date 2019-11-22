package com.pallavi.todo.repository;

import com.pallavi.todo.model.TodoItem;
import org.springframework.data.repository.CrudRepository;

public interface TodoRepository extends CrudRepository<TodoItem, Long> {

}