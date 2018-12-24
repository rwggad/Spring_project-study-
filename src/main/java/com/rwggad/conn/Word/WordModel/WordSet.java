package com.rwggad.conn.Word.WordModel;

public class WordSet {
    private String insertUser;
    private String wordKey;
    private String wordValue;

    public WordSet() {

    }

    public WordSet(String wordKey, String wordValue, String insertUser) {
        this.insertUser = insertUser;
        this.wordKey = wordKey;
        this.wordValue = wordValue;
    }

    public String getInsertUser() {
        return insertUser;
    }

    public void setInsertUser(String insertUser) {
        this.insertUser = insertUser;
    }

    public String getWordKey() {
        return wordKey;
    }

    public void setWordKey(String wordKey) {
        this.wordKey = wordKey;
    }

    public String getWordValue() {
        return wordValue;
    }

    public void setWordValue(String wordValue) {
        this.wordValue = wordValue;
    }
}
