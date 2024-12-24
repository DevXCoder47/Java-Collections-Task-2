package com.nikijv.javacollectionsproject2;
import com.nikijv.javacollectionsproject2.dictionary.Dictionary;
public class Main {
    public static void main(String[] args) {
        Dictionary dictionary = new Dictionary();
        dictionary.printDictionary();
        dictionary.scanner.close();
    }
}
