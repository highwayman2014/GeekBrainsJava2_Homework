package homework_three;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        // Задание 1

        List<String> wordsArray = fillWordsArray();
        HashMap<String, Integer> uniqueWords = new HashMap<>();

        for (String word:wordsArray){
            if(uniqueWords.containsKey(word)){
                int count = uniqueWords.get(word);
                count++;
                uniqueWords.put(word, count);
            }else{
                uniqueWords.put(word, 1);
            }
        }

        for (Map.Entry entry : uniqueWords.entrySet()){
            System.out.println(entry.getKey() + ", встречается " + entry.getValue() + " раз");
        }

        // Задание 2

        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Иванов", "+7(999)999-99-99");
        phoneBook.add("Иванов", "+7(999)888-88-88");
        phoneBook.add("Петров", "+7(999)777-77-77");

        System.out.println(phoneBook.get("Иванов"));
        System.out.println(phoneBook.get("Петров"));
        System.out.println(phoneBook.get("Питер Паркер"));

    }

    public static List<String> fillWordsArray(){
        List<String> wordsArray = new ArrayList<>();
        wordsArray.add("one");
        wordsArray.add("two");
        wordsArray.add("three");
        wordsArray.add("four");
        wordsArray.add("five");
        wordsArray.add("four");
        wordsArray.add("one");
        wordsArray.add("six");
        wordsArray.add("seven");
        wordsArray.add("two");
        wordsArray.add("eight");
        wordsArray.add("nine");
        wordsArray.add("two");

        return wordsArray;
    }

}
