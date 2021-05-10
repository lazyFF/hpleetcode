package com.hp.sort;

import java.util.Arrays;
/**
 * @author caihaopeng
 * @date 13:48 2021/5/10
 **/
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {5,6,98,9,45,1,2,43,454,45,56,67,8};
        int left = 0;
        int right = arr.length - 1;
        for (int i = left, j = i; i < right; j = ++i) {
            int ai = arr[i + 1];
            while (ai < arr[j]) {
                arr[j + 1] = arr[j];
                if (j-- == left) {
                    break;
                }
            }
            arr[j + 1] = ai;
        }
        System.out.println(Arrays.toString(arr));
    }
}
