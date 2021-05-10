package com.hp.twopointer;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author caihaopeng
 * @date 16:06 2021/5/7
 **/
public class ReverseVowelsOfAString {
    public static String my(String s) {
        Character[] strs = {'a','e','i','o','u','A','E','I','O','U'};
        List<Character> list = Arrays.asList(strs);
        char[] chars = s.toCharArray();
        int left = 0;
        int right = chars.length - 1;

        while (left < right){
            if(list.contains(chars[left]) && list.contains(chars[right])){
                char t = chars[left];
                chars[left] = chars[right];
                chars[right] = t;
                String str = "1231231";


            }
            if (!list.contains(chars[left]) && list.contains(chars[right])){
                left++;
                continue;
            }
            if (!list.contains(chars[right]) && list.contains(chars[left])) {
                right--;
                continue;
            }

            left++;
            right--;
            }

        return String.valueOf(chars);

    }

    public static void main(String[] args) {
        String str = my("hello");
        System.out.println(str);
    }
}
