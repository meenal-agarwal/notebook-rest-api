package com.notebook.task.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ExceptionHandler({KeywordNotFoundException.class, NotebookEntryNotFoundException.class})

    public ModelAndView handleBaseException(RuntimeException exception) {
        ModelAndView mav = new ModelAndView();
        logger.error(exception.getMessage(), exception);
        mav.addObject("exception", exception);
        mav.setViewName("error");
        return mav;
    }
}
