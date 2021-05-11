package com.hp.sort;

import java.util.*;

/**
 * @author caihaopeng
 * @date 14:46 2021/5/10
 **/
public class TopKFrequentElements {
    public static int[] topKFrequent(int[] nums, int k) {
        List<Integer> frequentList = new ArrayList<>();
        Map<Integer,Integer> map = new HashMap<>();
        for(int num : nums){
//            if(frequentList.contains(num)){
//                map.put(num,map.get(num) + 1);
//            }else{
//                frequentList.add(num);
//                map.put(num,1);
//            }
            map.put(num,map.getOrDefault(num,0)+1);
        }

        List<Map.Entry<Integer, Integer>> entryList = new ArrayList<>(map.entrySet());
        for(int i = 0;i < entryList.size() - 1 ; i++){
            for(int j = 0; j < entryList.size() - i - 1; j++){
                if(entryList.get(j).getValue() > entryList.get(j + 1).getValue()){
                    Map.Entry<Integer,Integer> entry = entryList.get(j+1);
                    entryList.set(j+1,entryList.get(j));
                    entryList.set(j,entry);
                }
            }
        }

        int[] arr = new int[k];
        for(int i = entryList.size() - k,j = 0;i < entryList.size();i++){
            arr[j] = entryList.get(i).getKey();
            j++;
        }

        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {1,1,1,2,2,3,3,3,3};
        int k = 2;
        System.out.println(Arrays.toString(topKFrequent(arr, k)));
    }
}
