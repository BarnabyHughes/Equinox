package me.barnaby.horsecore.utils;

import java.util.HashMap;
import java.util.Map;

public class StringUtil {

    public static String capitalizeFirstLetters(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }

        String[] words = str.split("\\s+");
        StringBuilder result = new StringBuilder();

        for (String word : words) {
            if (!word.isEmpty()) {
                result.append(Character.toUpperCase(word.charAt(0))).append(word.toLowerCase().substring(1)).append(" ");
            }
        }

        // Remove trailing space
        result.deleteCharAt(result.length() - 1);

        return result.toString();
    }



    private static final Map<String, String> remap = new HashMap<>();
    public static void addRemapper(String s1, String s2) {
        remap.put(s1, s2);
    }
    public static String reformat(String name) {
        return remap.getOrDefault(name, name);
    }
}
