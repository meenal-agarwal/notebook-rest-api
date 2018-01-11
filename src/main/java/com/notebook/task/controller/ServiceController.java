package com.notebook.task.controller;

import com.notebook.task.model.Notebook;
import com.notebook.task.model.Result;
import com.notebook.task.service.CalculateServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ServiceController {

    private static final Logger logger = LoggerFactory.getLogger(ServiceController.class);

    @Autowired
    private CalculateServiceImpl CalculateService;

    @PostMapping(value = "/calculate")
    public String calculateSimilarWordsAndFrequency(Model model, @ModelAttribute Notebook notebook) {
        logger.info("Request Received");
        Result result = CalculateService.calculateSimilarWordsAndFrequency(notebook);
        model.addAttribute("result", result);
        return "result";
    }


    @GetMapping(value = "/")
    public String greetingForm(Model model) {
        logger.info("Initializing Notebook Model");
        model.addAttribute("notebook", new Notebook());
        return "index";
    }
}
