import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        String arr[] = {
                "ночь", "улица", "фонарь", "аптека",
                "бессмысленый", "тусклый", "свет", "живи",
                "еще", "хоть", "четверть", "век",
                "все", "исход", "нет", "умирать",
                "начинать", "сначала", "повторять", "все",
                "ночь", "рябь", "канал", "аптека",
                "улица", "фонарь"
        };

        ArrayList<String> list = StringtoList(arr);
        HashMap<String, Integer> map = quantityWord(arr);


        Phonebook phonebook = new Phonebook();
        phonebook.add("Ivanov", "ivanov-phone-1", "ivanov-mail-1");
        phonebook.add("Petrov", "petrov-phone-1", "petrov-mail-1");
        phonebook.add("Ivanov", "ivanov-phone-2", "ivanov-mail-2");

        System.out.println("e-mail Ivanov: " + phonebook.getMails("Ivanov"));
        System.out.println("e-mail Petrov: " + phonebook.getMails("Petrov"));
        System.out.println("phone Ivanov: " + phonebook.getPhones("Ivanov"));
        System.out.println("phone Petrov: " + phonebook.getPhones("Petrov"));
    }

    private static ArrayList<String> StringtoList(String[] arr) {
        ArrayList<String> list = new ArrayList<>(Arrays.asList(arr));
        for (int i = 0; i < list.size(); i++) {
            String currentWord = list.get(i);
            for (int j = i + 1; j < list.size(); j++) {
                if (currentWord.equals(list.get(j))) list.remove(j);
            }
        }
        return list;
    }

    private static HashMap<String, Integer> quantityWord(String[] arr) {
        int count = 1;
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) map.put(arr[i], count + 1);
            else map.put(arr[i], count);

        }

        return map;
    }

}