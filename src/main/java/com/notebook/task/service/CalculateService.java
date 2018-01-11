package com.notebook.task.service;

import com.notebook.task.model.Notebook;
import com.notebook.task.model.Result;

public interface CalculateService {
    Result calculateSimilarWordsAndFrequency(Notebook notebook);
}
