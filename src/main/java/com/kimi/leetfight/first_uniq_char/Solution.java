package com.kimi.leetfight.first_uniq_char;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created on 2021/2/17.
 * Copyright xKimi.inc
 *
 * @author Kimi
 */
public class Solution {

    public static char firstUniqChar(String s) {
        char c = ' ';
        char[] charArray = s.toCharArray();
        if (s.equals("") || charArray.length == 0) {
            return c;
        }
        LinkedHashMap<Character, Boolean> countMap = new LinkedHashMap<>();
        for (Character ch : charArray) {
            if (ch.compareTo('0') == 0){
                continue;
            }
            if (countMap.containsKey(ch)) {
                countMap.put(ch, false);
            } else {
                countMap.put(ch, true);
            }
        }
        for (Map.Entry<Character, Boolean> entry : countMap.entrySet()) {
            if (entry.getValue()) {
                c = entry.getKey();
                break;
            }
        }
        return c;
    }

    public static void main(String[] args) {
        String s = "loveleetcode";
        System.out.println(firstUniqChar(s));
    }
}
