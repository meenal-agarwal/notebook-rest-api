package com.notebook.task.service;

import com.notebook.task.exception.KeywordNotFoundException;
import com.notebook.task.exception.NotebookEntryNotFoundException;
import com.notebook.task.model.Notebook;
import com.notebook.task.model.Result;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CalculateServiceImplTest {

    @Autowired
    private CalculateService calculateService;

    @Test(expected = NotebookEntryNotFoundException.class)
    public void testNotebookEntryNotFound() {
        Notebook notebook = new Notebook("", "word");
        calculateService.calculateSimilarWordsAndFrequency(notebook);
    }

    @Test(expected = KeywordNotFoundException.class)
    public void testKeyWordNotFond() {
        Notebook notebook = new Notebook("Word Words Wor word", "");
        calculateService.calculateSimilarWordsAndFrequency(notebook);
    }


    @Test
    public void testEmptySimilarWords() {
        Notebook notebook = new Notebook("word Words Wor word", "word");
        Result result = calculateService.calculateSimilarWordsAndFrequency(notebook);
        assertEquals(result.getFrequency(), 2);
        assertTrue(result.getSimilarWords().isEmpty());
    }

    @Test
    public void testZeroFrequency() {
        Notebook notebook = new Notebook("Word Words Wor word", "words");
        Result result = calculateService.calculateSimilarWordsAndFrequency(notebook);
        assertEquals(result.getFrequency(), 0);
        Set<String> expectedSimilarWords = new HashSet<>();
        expectedSimilarWords.add("Words");
        expectedSimilarWords.add("word");
        assertEquals(result.getSimilarWords(), expectedSimilarWords);
    }

    @Test
    public void testAllSample1() {
        Notebook notebook = new Notebook("Word Words Wor word", "Word");
        Result result = calculateService.calculateSimilarWordsAndFrequency(notebook);
        assertEquals(result.getFrequency(), 1);
        Set<String> expectedSimilarWords = new HashSet<>();
        expectedSimilarWords.add("Words");
        expectedSimilarWords.add("word");
        expectedSimilarWords.add("Wor");
        assertEquals(result.getSimilarWords(), expectedSimilarWords);
    }

    @Test
    public void setTestAllSample2() {
        Notebook notebook = new Notebook("Word Word Word word", "Word");
        Result result = calculateService.calculateSimilarWordsAndFrequency(notebook);
        assertEquals(result.getFrequency(), 3);
        Set<String> expectedSimilarWords = new HashSet<>();
        expectedSimilarWords.add("word");
        assertEquals(result.getSimilarWords(), expectedSimilarWords);
    }

}