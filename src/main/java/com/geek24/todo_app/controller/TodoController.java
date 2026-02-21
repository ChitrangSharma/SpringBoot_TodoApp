package com.geek24.todo_app.controller;

import com.geek24.todo_app.entity.Todo;
import com.geek24.todo_app.service.TodoService;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
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
//    @PostMapping
//    public Todo createTodo(@RequestBody Todo todo){
//        return todoService.save(todo);
//    }

    //Rarely used - .create()
//    @PostMapping
//    public ResponseEntity<Todo> createTodo(@RequestBody Todo todo){
//        Todo savedTodo = todoService.save(todo);
//        URI location = URI.create("/api/todos/" + savedTodo.getId());
//        return ResponseEntity
//                .created(location)
//                .body(savedTodo);
//
//    }

    @PostMapping
    public ResponseEntity<Todo> createTodo(@RequestBody Todo todo){
        Todo savedTodo = todoService.save(todo);
        return ResponseEntity.status(201).body(savedTodo);
    }

    //Get all todos
//    @GetMapping
//    public List<Todo> getAllTodos(){
//        return todoService.getAll();
//    }

    @GetMapping
    public ResponseEntity<List<Todo>> getAllTodos(){
        return ResponseEntity.ok(todoService.getAll());
    }

    //Get_todo by id

//    @GetMapping("/{id}")
//    public Todo getTodoById(@PathVariable Long id){
//        return todoService.findById(id);
//    }

//    @GetMapping("/{id}")
//    public ResponseEntity<Todo> getTodoById(@PathVariable Long id){
////        return todoService.findById(id);
//        Todo todo = todoService.findById(id);
//
//        if(todo == null){
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//        return new ResponseEntity<>(todo, HttpStatus.OK);
//    }

    @GetMapping("/{id}")
    public ResponseEntity<Todo> getTodoById(@PathVariable Long id){
        return ResponseEntity.ok(todoService.findById(id));
    }


    //Delete_todo
//    @DeleteMapping("/{id}")
//    public void deleteTodos(@PathVariable Long id){
//        todoService.delete(id);
//    }

//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteTodos(@PathVariable Long id){
//        todoService.delete(id);
//        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTodos(@PathVariable Long id){
        todoService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
