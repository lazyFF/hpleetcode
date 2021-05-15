package com.hp.sort;

import java.util.*;

/**
 * 347. 前 K 个高频元素
 * @author caihaopeng
 * @date 14:46 2021/5/10
 **/
public class TopKFrequentElements {
    public static int[] myTopKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int num : nums){
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
    //桶排序
    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> frequentMap = new HashMap<>();
        for(int num : nums){
            frequentMap.put(num,frequentMap.getOrDefault(num,0)+1);
        }
        //桶排序，新建桶集合
        List<Integer>[] buckList = new ArrayList[nums.length + 1];
        Set<Map.Entry<Integer, Integer>> entries = frequentMap.entrySet();
        //元素出现的个数作为下标放入桶数组中
        for(Map.Entry<Integer,Integer> entry : entries){
            if(buckList[entry.getValue()] == null){
                buckList[entry.getValue()] = new ArrayList<>();
            }
            buckList[entry.getValue()].add(entry.getKey());
        }
        //从后遍历，获取前K个元素就是出现频率最高的K个数
        List<Integer> topK = new ArrayList<>();
        for(int i = buckList.length -1;i >= 0 && topK.size() < k; i-- ){
            if(buckList[i] == null){
                continue;
            }
            if(buckList[i].size() <= (k - topK.size())){
                topK.addAll(buckList[i]);
            }else{
                topK.addAll(buckList[i].subList(0,k- topK.size()));
            }
        }

        int[] res = new int[k];
        for(int i = 0; i< topK.size(); i++){
            res[i] = topK.get(i);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] num = {1,1,1,2,2,3};
        int k = 2;
//        int[] answer = myTopKFrequent(num, k);
        int[] answer = topKFrequent(num, k);
        System.out.println(Arrays.toString(answer));

    }
}
