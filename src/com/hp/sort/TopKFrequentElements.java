package com.hp.sort;

import java.util.*;

/**
 * @author caihaopeng
 * @date 14:46 2021/5/10
 **/
public class TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        List<Integer> frequentList = new ArrayList<>();
        Map<Integer,Integer> map = new HashMap<>();
        for(int num : nums){
            if(frequentList.contains(num)){
                map.put(num,map.get(num) + 1);
            }else{
               frequentList.add(num);
               map.put(num,1);
            }
        }

        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        List<Map.Entry<Integer, Integer>> entryList = new ArrayList<>(entries);


        return null;
    }
}
