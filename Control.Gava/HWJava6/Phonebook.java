package HWJava6;

import java.util.*;

public class Phonebook {
    public static void main(String[] args) {
        // HashMap
        Map<String, List<String>> phoneBook = new HashMap<>();
        // phoneBook
        addContact(phoneBook, "nickname_1", generatePhoneNumber());
        addContact(phoneBook, "nickname_2", generatePhoneNumber());
        addContact(phoneBook, "nickname_2", generatePhoneNumber());
        addContact(phoneBook, "nickname_1", generatePhoneNumber());
        addContact(phoneBook, "nickname_2", generatePhoneNumber());

        printPhoneBook(phoneBook);
    }
    private static void addContact(Map<String, List<String>> phoneBook, String name, String phoneNumber) {
        
        if (phoneBook.containsKey(name)) {
            List<String> phoneNumbers = phoneBook.get(name);
            phoneNumbers.add(phoneNumber);
        } else {
        
            List<String> phoneNumbers = new ArrayList<>();
            phoneNumbers.add(phoneNumber);
            phoneBook.put(name, phoneNumbers);
        }
    }

    //Генератор номеров

    private static String generatePhoneNumber() {
        Random random = new Random();
        return "+7(" +
                String.format("%03d", random.nextInt(1000))+ ") " +
                String.format("%03d", random.nextInt(1000)) + "-" +
                String.format("%02d", random.nextInt(100)) + "-" +
                String.format("%02d", random.nextInt(100)) ;
    }

    //Вывод телефонной книги
    private static void printPhoneBook(Map<String, List<String>> phoneBook) {
        // сортировка
        List<Map.Entry<String, List<String>>> sortedEntries = new ArrayList<>(phoneBook.entrySet());
        sortedEntries.sort(Comparator.comparingInt(entry -> entry.getValue().size()));

        // print new string
        for (int i = sortedEntries.size() - 1; i >= 0; i--) {
            Map.Entry<String, List<String>> entry = sortedEntries.get(i);
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}

