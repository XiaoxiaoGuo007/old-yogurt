package com.example.yogurtlearn.algorithm.other;

import java.util.HashSet;

/**
 * @description:
 * @author: old_yogurt
 * @date 2021/7/23 16:21
 */
public class _1_取随机数 {
    /**
     * 随机指定范围内N个不重复的数
     * 利用HashSet的特征，只能存放不同的值
     * @param min 指定范围最小值
     * @param max 指定范围最大值
     * @param surplus 因为有重复的，还需要几个  n-set.size()
     * @param n 随机数个数
     * @param set 随机数结果集
     */
    public static void randomSet(int min, int max, int surplus,int n, HashSet set) {
        if (n > (max - min + 1) || max < min) {
            return;
        }
        for (int i = 0; i < surplus; i++) {
            // 调用Math.random()方法
            int num = (int) (Math.random() * (max - min)) + min;
            set.add(num);// 将不同的数存入HashSet中
        }
        int setSize = set.size();
        // 如果存入的数小于指定生成的个数，则调用递归再生成剩余个数的随机数，如此循环，直到达到指定大小
        if (setSize < n) {
            randomSet(min, max, n - setSize,n, set);// 递归
        }
    }
}
