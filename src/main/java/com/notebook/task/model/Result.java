package com.notebook.task.model;

import java.util.Set;

public class Result {

    private String keyword;
    private int frequency;
    private Set<String> similarWords;

    public Result(String keyword, int frequency, Set<String> similarWords) {
        this.keyword = keyword;
        this.frequency = frequency;
        this.similarWords = similarWords;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    public Set<String> getSimilarWords() {
        return similarWords;
    }

    public void setSimilarWords(Set<String> similarWords) {
        this.similarWords = similarWords;
    }
}
