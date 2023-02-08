package com.example.todo_spring_rest.exception;

public class DataDuplicateException extends RuntimeException {

    public DataDuplicateException(String message) {
        super(message);
    }
}
