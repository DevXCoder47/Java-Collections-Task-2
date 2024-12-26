package com.nikijv.javacollectionsproject2;
import com.nikijv.javacollectionsproject2.dictionary.Dictionary;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Dictionary dictionary = new Dictionary();
        while(true) {
            System.out.println("""
                    
                    Choose an action: \
                    
                    1. View word\
                    
                    2. Add word \
                    
                    3. Edit word\
                    
                    4. Delete word\
                    
                    5. Add translation\
                    
                    6. Edit translation\
                    
                    7. Delete translation\
                    
                    8. Show top 10 popular words\
                    
                    9. Show top 10 unpopular words\

                    10. Exit""");
            int choice = dictionary.scanner.nextInt();
            dictionary.scanner.nextLine();
            switch(choice) {
                case 1: dictionary.showWord(getWord(dictionary.scanner)); break;
                case 2: dictionary.addWord(); break;
                case 3: dictionary.editWord(); break;
                case 4: dictionary.deleteWord(); break;
                case 5: dictionary.addTranslation(); break;
                case 6: dictionary.editTranslation(); break;
                case 7: dictionary.deleteTranslation(); break;
                case 8: dictionary.showTop(true); break;
                case 9: dictionary.showTop(false); break;
                case 10: break;
                default: System.out.println("Invalid choice\n");
            }
            if(choice == 10)
                break;
        }
        dictionary.scanner.close();
    }
    public static String getWord(Scanner scanner){
        System.out.print("Enter a word: ");
        return scanner.nextLine();
    }
}
