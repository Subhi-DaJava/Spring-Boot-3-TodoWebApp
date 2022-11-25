package com.uyghur.springboot.webapp.exception;

public class TodoNotFoundException extends Exception {

	public TodoNotFoundException(String message) {
        super(message);
    }
}
