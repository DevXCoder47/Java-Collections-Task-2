package com.nikijv.javacollectionsproject2.dictionary;
public class Word {
    public String word;
    public int popularity = 0;
    public Word(String word) {
        this.word = word;
    }
    public String toString(){
        return word;
    }
}
