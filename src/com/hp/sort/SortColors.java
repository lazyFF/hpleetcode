package com.hp.sort;

import java.util.HashMap;
import java.util.Map;

/**
 * @author caihaopeng
 * @date 2021.05.16
 */
public class SortColors {
    public static void mySortColors(int[] nums) {
        for (int i = 0; i < nums.length; i++){
            for (int j = i + 1; j < nums.length; j++){
                if(nums[i] > nums[j]){
                    int k = nums[i];
                    nums[i] = nums[j];
                    nums[j] = k;
                }
            }
        }

    }

    public static void sortColors(int[] nums) {
        //以元素1作为枢纽元，0放左边，2放右边
        int ZERO = -1; int ONE = 0; int TWO = nums.length;
        while (ONE < TWO){
            if(nums[ONE] == 0 ){
                swap(nums,++ZERO,ONE++);
            }else if(nums[ONE] == 2){
                swap(nums,ONE,--TWO);
            }else {
                ++ONE;
            }
        }

    }

    public static void swap(int[] nums,int left,int right){
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {0,0,0,1,1,2};
        mySortColors(nums);
    }
}
