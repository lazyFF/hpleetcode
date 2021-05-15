package com.hp.sort;

import java.util.*;

/**
 * @author caihaopeng
 * @date 9:14 2021/5/15
 **/
public class SortCharactersByFrequency {
    public static String myFrequencySort(String s) {
        char[] chars = s.toCharArray();
        Map<Character,Integer> frequencyCharMap = new HashMap<>(s.length());
        for (char c : chars){
            frequencyCharMap.put(c,frequencyCharMap.getOrDefault(c,0)+1);
        }

        List<Character>[] buckList = new ArrayList[chars.length + 1];

        Set<Map.Entry<Character, Integer>> entries = frequencyCharMap.entrySet();

        for(Map.Entry<Character,Integer> entry : entries){
            if(buckList[entry.getValue()] == null){
                buckList[entry.getValue()] = new ArrayList<>();
            }
            buckList[entry.getValue()].add(entry.getKey());
        }
        StringBuilder builder = new StringBuilder();

        for(int i = buckList.length - 1; i >= 0;i--){
            if(buckList[i] == null){
                continue;
            }
            for(Character c : buckList[i]){
                int num = i;
                while (num > 0){
                    builder.append(c);
                    num--;
                }
            }
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        String str = "baboon";
        System.out.println(myFrequencySort(str));
    }
}
