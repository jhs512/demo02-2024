package com.ll.demo02;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/todos")
public class TodoController {
    private long todosLastId;
    private List<Todo> todos;

    public TodoController() {
        todos = new ArrayList<>();
    }

    @GetMapping("")
    public List<Todo> getTodos() {
        return todos;
    }

    @GetMapping("/add")
    public Todo add(
            String body
    ) {
        Todo todo = Todo
                .builder()
                .id(++todosLastId)
                .body(body)
                .build();

        todos.add(todo);

        return todo;
    }
}
