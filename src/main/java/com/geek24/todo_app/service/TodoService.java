package com.geek24.todo_app.service;

import com.geek24.todo_app.entity.Todo;
import com.geek24.todo_app.exception.ResourceNotFoundException;
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
        return todoRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Todo not found with id: " + id)
        );

    }

    //Update_Todo
    public Todo updateTodo(Long id, Todo updatedTodo){
        Todo existingTodo = todoRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Todo not found with id: " + id));
        existingTodo.setTitle(updatedTodo.getTitle());
        existingTodo.setDescription(updatedTodo.getDescription());
        existingTodo.setCompleted(updatedTodo.getCompleted());
        return todoRepository.save(existingTodo);
    }

    // Patch update
    public Todo patch(Long id, Todo updatedFields) {
        Todo existingTodo = todoRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Todo not found with id: "+id));

        if (updatedFields.getTitle() != null) {
            existingTodo.setTitle(updatedFields.getTitle());
        }

        if (updatedFields.getDescription() != null) {
            existingTodo.setDescription(updatedFields.getDescription());
        }

        // For boolean, use Boolean instead of primitive boolean
        if (updatedFields.getCompleted() != null) {
            existingTodo.setCompleted(updatedFields.getCompleted());
        }

        return todoRepository.save(existingTodo);
    }

    // Delete by id
    public void delete(Long id){
        todoRepository.deleteById(id);
    }
}
