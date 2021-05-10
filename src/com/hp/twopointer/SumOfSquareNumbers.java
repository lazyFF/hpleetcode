package com.hp.twopointer;
/**
 * @author caihaopeng
 * @date 13:54 2021/5/7
 **/
public class SumOfSquareNumbers {
    public static boolean my(int c){
        long low = 0;
        long high = (long)Math.sqrt(c);
        while(low <= high){
            double sum = low * low + high * high;
            if(sum == c){
                return true;
            }else if(sum > c){
                high--;
            }else {
                low++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(my(5));
    }
}
