package com.hp.greedy;

import java.util.Arrays;

/**
 * 饼干分发
 * @author chp
 * @date 2021.5.20
 */
public class AssignCookies {

    public static int findContentChildren(int[] g, int[] s) {
        //先将数组排序，然后从小的需求开始满足
        Arrays.sort(g);
        Arrays.sort(s);

        int gi = 0;
        int sj = 0;

        while(gi < g.length && sj < s.length){
            if(g[gi] <= s[sj]){
                gi++;
//                sj++;
//                continue;
            }
            sj++;
        }
        return gi;
    }

    public static void main(String[] args) {
        int[] g = {10,9,7,8};
        int[] s = {5,6,7,8};
        System.out.println(findContentChildren(g,s));

    }
}
