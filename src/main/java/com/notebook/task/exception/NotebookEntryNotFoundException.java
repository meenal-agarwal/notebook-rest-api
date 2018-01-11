package com.notebook.task.exception;

public class NotebookEntryNotFoundException extends RuntimeException {

    public NotebookEntryNotFoundException(String message) {
        super(message);
    }
}
