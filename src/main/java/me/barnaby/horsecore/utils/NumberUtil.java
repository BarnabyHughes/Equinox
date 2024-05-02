package me.barnaby.horsecore.utils;

import java.util.LinkedHashMap;
import java.util.Map;

public class NumberUtil {
    private static final Map<Integer, String> romanNumeralsMap = new LinkedHashMap<>();

    static {
        romanNumeralsMap.put(1000, "M");
        romanNumeralsMap.put(900, "CM");
        romanNumeralsMap.put(500, "D");
        romanNumeralsMap.put(400, "CD");
        romanNumeralsMap.put(100, "C");
        romanNumeralsMap.put(90, "XC");
        romanNumeralsMap.put(50, "L");
        romanNumeralsMap.put(40, "XL");
        romanNumeralsMap.put(10, "X");
        romanNumeralsMap.put(9, "IX");
        romanNumeralsMap.put(5, "V");
        romanNumeralsMap.put(4, "IV");
        romanNumeralsMap.put(1, "I");
    }

    public static String intToRoman(int num) {
        StringBuilder roman = new StringBuilder();
        for (Map.Entry<Integer, String> entry : romanNumeralsMap.entrySet()) {
            int value = entry.getKey();
            while (num >= value) {
                roman.append(entry.getValue());
                num -= value;
            }
        }
        return roman.toString();
    }
}
