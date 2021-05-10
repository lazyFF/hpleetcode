package com.hp.twopointer;

import java.util.Arrays;

/**
 * @author caihaopeng
 * @date 9:04 2021/5/7
 **/
public class TwoSum {
    public static int[] mySolution(int[] numbers, int target) {
        int[] result = new int[2];
        for (int i = 0; i < numbers.length;i++){
            for(int j = i + 1; j < numbers.length; j++ ){
                int sum = numbers[i] + numbers[j];
                if(sum == target){
                    result[0] = i + 1;
                    result[1] = j + 1;
                }
            }
        }
        return result;
    }

    public static int[] twoSum(int[] numbers, int target) {
        int low = 0, high = numbers.length - 1;
        while (low < high) {
            int sum = numbers[low] + numbers[high];
            if (sum == target) {
                return new int[]{low + 1, high + 1};
            } else if (sum < target) {
                ++low;
            } else {
                --high;
            }
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,3,4};
        int target = 6;
//        int[] result = mySolution(nums, target);
        int[] result = twoSum(nums, target);
        System.out.println(Arrays.toString(result));
    }
}
