package com.notebook.task.service;

import com.notebook.task.exception.KeywordNotFoundException;
import com.notebook.task.exception.NotebookEntryNotFoundException;
import com.notebook.task.model.Notebook;
import com.notebook.task.model.Result;
import org.apache.commons.text.similarity.LevenshteinDistance;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class CalculateServiceImpl implements CalculateService {

    @Override
    public Result calculateSimilarWordsAndFrequency(Notebook notebook) {

        if(notebook.getNotebook_entry() == null || notebook.getNotebook_entry().trim().isEmpty()){
            throw new NotebookEntryNotFoundException("Notbook entry not available");
        }
        if(notebook.getKeyword() ==null || notebook.getKeyword().trim().isEmpty()){
            throw new KeywordNotFoundException("Keyword not found");
        }

        String notebook_entry = notebook.getNotebook_entry();
        String keyword = notebook.getKeyword();
        int frequency = 0;

        Set<String> similarWordsList = new HashSet<>();

            if(notebook_entry != null){
            String words[] = notebook_entry.trim().split("\\s+");
            for(String word : words){
                if(word.equals(keyword)){
                    frequency++;
                } else if (calculateLevenshteinDistance(keyword,word) == 1){
                    similarWordsList.add(word);
                }
            }
        }
        return new Result(keyword,frequency,similarWordsList);
    }

    private int calculateLevenshteinDistance(String word1, String word2){
        LevenshteinDistance distance = new LevenshteinDistance();
        return distance.apply(word1,word2);
    }
}
