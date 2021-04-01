package homework_three;

import java.util.HashMap;

public class PhoneBook{

    private HashMap<String, String> values;

    public PhoneBook() {
        values = new HashMap<>();
    }

    public void add(String name, String phoneNumber){
        if(values.containsKey(name)){
            String currentPhoneNumber = values.get(name);
            values.put(name, currentPhoneNumber + "; " + phoneNumber);
        }else{
            values.put(name, phoneNumber);
        }
    }

    public String get(String name){
        if(values.containsKey(name)){
            return values.get(name);
        }else{
            return "Не найдено";
        }
    }
}
