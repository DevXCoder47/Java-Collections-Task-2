package com.nikijv.javacollectionsproject2.dictionary;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class Dictionary {
    private HashMap<String, ArrayList<String>> dictionary;
    public final Scanner scanner = new Scanner(System.in);
    public Dictionary() {
        dictionary = new HashMap<>();
        initializeDictionary();
    }
    public void printDictionary() {
        for(Map.Entry<String, ArrayList<String>> entry : dictionary.entrySet()) {
            System.out.print(entry.getKey() + ": ");
            for(String word : entry.getValue()) {
                System.out.print(word + " ");
            }
            System.out.println();
        }
    }
    private void initializeDictionary() {
        for(int i = 0; i < 2; i++){
            System.out.print("Enter word: ");
            String word = scanner.nextLine();
            System.out.print("Enter translations count: ");
            int count = scanner.nextInt();
            scanner.nextLine();
            ArrayList<String> translations = new ArrayList<>();
            for(int j = 0; j < count; j++){
                System.out.print("Enter translation: ");
                String translation = scanner.nextLine();
                translations.add(translation);
            }
            dictionary.put(word, translations);
            System.out.println();
        }
    }
}
