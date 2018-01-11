package com.notebook.task.model;

public class Notebook {
    private String notebook_entry;
    private String keyword;

    public Notebook() {
    }

    public Notebook(String notebook_entry, String keyword) {
        this.notebook_entry = notebook_entry;
        this.keyword = keyword;
    }

    public String getNotebook_entry() {
        return notebook_entry;
    }

    public void setNotebook_entry(String notebook_entry) {
        this.notebook_entry = notebook_entry;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }
}
