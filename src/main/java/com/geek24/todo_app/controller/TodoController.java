package com.geek24.todo_app.controller;

import com.geek24.todo_app.entity.Todo;
import com.geek24.todo_app.service.TodoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@Controller
//@ResponseBody
@RequestMapping("/api/todos")
public class TodoController {
    private final TodoService todoService;

    TodoController(TodoService todoService){
        this.todoService=todoService;
    }

    //Create_Todo
    @PostMapping
    public Todo createTodo(@RequestBody Todo todo){
        System.out.println("TITLE = " + todo.getTitle());
        System.out.println("Description = "+todo.getDescription());
        return todoService.save(todo);
    }

    //Get all todos
    @GetMapping
    public List<Todo> getAllTodos(){
        return todoService.getAll();
    }

    //Get_todo by id
    @GetMapping("/{id}")
    public Todo getTodoById(@PathVariable Long id){
        return todoService.findById(id);
    }

    //Delete_todo
    @DeleteMapping("/{id}")
    public void deleteTodos(@PathVariable Long id){
        todoService.delete(id);
    }

}
