package com.example.yogurtlearn.util.stringrevert;

import java.util.Arrays;

/**
 * @description:
 *   String数组转为 int数组的两种方式
 * @author: old_yogurt
 * @date 2021/8/3 15:32
 */
public class StringRevert {
    public static void main(String[] args) {
        //假设我们有一个字符串数组：
        String[] strings = {"1", "2", "3"};

        //使用Lambda表达式（自Java 8起）：
        int[] array = Arrays.asList(strings).stream().mapToInt(Integer::parseInt).toArray();

        //另一种方式：
        int[] array1 = Arrays.stream(strings).mapToInt(Integer::parseInt).toArray();

    }
}
