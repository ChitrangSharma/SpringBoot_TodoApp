package com.geek24.todo_app.service;

import com.geek24.todo_app.entity.Todo;
import com.geek24.todo_app.repository.TodoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {
    private final TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    // Save
    public Todo save(Todo todo){
        return todoRepository.save(todo);
    }

    // Get all
    public List<Todo> getAll(){
        return todoRepository.findAll();
    }

    // Get by id
    public Todo findById(Long id){
        return todoRepository.findById(id).orElse(null);
    }

    // Delete by id
    public void delete(Long id){
        todoRepository.deleteById(id);
    }
}
