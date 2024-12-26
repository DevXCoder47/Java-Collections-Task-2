package com.nikijv.javacollectionsproject2.dictionary;
import java.util.*;
public class Dictionary {
    public final Scanner scanner = new Scanner(System.in);
    private HashMap<Word, ArrayList<String>> dictionary;
    private final Random randomizer = new Random();
    private static final String DEFAULT = "(non-defined)";
    public Dictionary() {
        dictionary = new HashMap<>();
        initializeDictionary();
//        autoInitializeDictionary();
    }
    public void addWord(){
        String word = setWord();
        dictionary.put(new Word(word), new ArrayList<>(Collections.singletonList(DEFAULT)));
    }
    public void editWord(){
        String word = setWord();
        for(Word item : dictionary.keySet()){
            if(word.equals(item.word)){
                ArrayList<String> translations = dictionary.remove(item);
                System.out.print("Enter new word: ");
                word = scanner.nextLine();
                dictionary.put(new Word(word), translations);
                return;
            }
        }
        System.out.println("Word not found\n");
    }
    public void deleteWord(){
        String word = setWord();
        for(Word item : dictionary.keySet()){
            if(word.equals(item.word)){
                dictionary.remove(item);
                return;
            }
        }
        System.out.println("Word not found\n");
    }
    public void addTranslation(){
        String word = setWord();
        for(Word item : dictionary.keySet()){
            if(word.equals(item.word)){
                if(Objects.equals(dictionary.get(item), Collections.singletonList(DEFAULT))) {
                    ArrayList<String> translations = setTranslations();
                    dictionary.put(item, translations);
                }
                else
                    System.out.println("Word already has translation\n");
                return;
            }
        }
        System.out.println("Word not found\n");
    }
    public void editTranslation(){
        String word = setWord();
        for(Word item : dictionary.keySet()){
            if(word.equals(item.word)){
                ArrayList<String> translations = setTranslations();
                dictionary.put(item, translations);
                return;
            }
        }
        System.out.println("Word not found\n");
    }
    public void deleteTranslation(){
        String word = setWord();
        for(Word item : dictionary.keySet()){
            if(word.equals(item.word)){
                dictionary.put(item, new ArrayList<>(Collections.singletonList(DEFAULT)));
                return;
            }
        }
        System.out.println("Word not found\n");
    }
    public void printDictionary() {
        for(Map.Entry<Word, ArrayList<String>> entry : dictionary.entrySet()) {
            System.out.print(entry.getKey() + ": ");
            for(String word : entry.getValue()) {
                System.out.print(word + " ");
            }
            System.out.println();
        }
    }
    public void showWord(String value){
        for(Word item : dictionary.keySet()) {
            if(item.word.equals(value)) {
                System.out.print(item + ": ");
                for(String translation : dictionary.get(item)) {
                    System.out.print(translation + " ");
                }
                System.out.println();
                item.popularity++;
                return;
            }
        }
        System.out.println("No such word found");
    }
    public void imitateWordSearch(){
        Word[] words = dictionary.keySet().toArray(new Word[0]);
        for(int i = 0; i < 100; i++) {
            int index = randomizer.nextInt(words.length);
            showWord(words[index].word);
        }
    }
    public void showTop(boolean popular){
        Word[] words = dictionary.keySet().toArray(new Word[0]);
        ArrayList<Word> top = new ArrayList<>(
                Arrays.stream(words)
                        .filter(word -> word.popularity > 0)
                        .toList()
        );
        top.sort((w1, w2) -> Integer.compare(w1.popularity, w2.popularity));
        if(popular)
            Collections.reverse(top);
        if(top.size() > 10)
            top.subList(10, top.size()).clear();
        for(Word item : top) {
            System.out.println(item + ": popularity - " + item.popularity);
        }
    }
    private void initializeDictionary() {
        for(int i = 0; i < 3; i++){
            String word = setWord();
            ArrayList<String> translations = setTranslations();
            dictionary.put(new Word(word), translations);
            System.out.println();
        }
    }
    private void autoInitializeDictionary() {
        dictionary.put(new Word("W1"), new ArrayList<>(Arrays.asList("T1", "T2", "T3", "T4")));
        dictionary.put(new Word("W2"), new ArrayList<>(Arrays.asList("T21", "T22", "T23")));
        dictionary.put(new Word("W3"), new ArrayList<>(Arrays.asList("T31", "T32", "T33")));
        dictionary.put(new Word("W4"), new ArrayList<>(Collections.singletonList("T41")));
        dictionary.put(new Word("W5"), new ArrayList<>(Arrays.asList("T51", "T52")));
        dictionary.put(new Word("W6"), new ArrayList<>(Arrays.asList("T1", "T2", "T3", "T4")));
        dictionary.put(new Word("W7"), new ArrayList<>(Arrays.asList("T21", "T22", "T23")));
        dictionary.put(new Word("W8"), new ArrayList<>(Arrays.asList("T31", "T32", "T33")));
        dictionary.put(new Word("W9"), new ArrayList<>(Collections.singletonList("T41")));
        dictionary.put(new Word("W10"), new ArrayList<>(Arrays.asList("T51", "T52")));
        dictionary.put(new Word("W11"), new ArrayList<>(Arrays.asList("T1", "T2", "T3", "T4")));
        dictionary.put(new Word("W12"), new ArrayList<>(Arrays.asList("T21", "T22", "T23")));
        dictionary.put(new Word("W13"), new ArrayList<>(Arrays.asList("T31", "T32", "T33")));
        dictionary.put(new Word("W14"), new ArrayList<>(Collections.singletonList("T41")));
        dictionary.put(new Word("W15"), new ArrayList<>(Arrays.asList("T51", "T52")));
    }
    private String setWord(){
        System.out.print("Enter word: ");
        return scanner.nextLine();
    }
    private ArrayList<String> setTranslations(){
        System.out.print("Enter translations count: ");
        int count = scanner.nextInt();
        scanner.nextLine();
        ArrayList<String> translations = new ArrayList<>();
        for(int j = 0; j < count; j++){
            System.out.print("Enter translation: ");
            String translation = scanner.nextLine();
            translations.add(translation);
        }
        return translations;
    }
}
