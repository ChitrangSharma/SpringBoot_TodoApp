package com.geek24.todo_app.exception;

public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException(String message){
        super(message);
    }
    /**
     * Spring automatically handles unchecked exceptions.
     * **/
}
