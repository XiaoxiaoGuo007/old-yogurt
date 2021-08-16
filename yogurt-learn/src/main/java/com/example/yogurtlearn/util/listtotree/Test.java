package com.example.yogurtlearn.util.listtotree;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.LinkedList;
import java.util.List;

/**
 * @description:
 * @author: old_yogurt
 * @date 2021/8/10 19:00
 */
public class Test {
    public static void testToTree(){
        TreeVo parent1 = new TreeVo();
        parent1.setId(1);
        parent1.setName("1");

        TreeVo parent2 = new TreeVo();
        parent2.setId(2);
        parent2.setName("2");

        TreeVo parent3 = new TreeVo();
        parent3.setId(3);
        parent3.setName("3");

        List<TreeVo> result = new LinkedList<>();
        result.add(parent1);
        result.add(parent2);
        result.add(parent3);


        TreeVo parent11 = new TreeVo();
        parent11.setId(11);
        parent11.setName("1-1");

        TreeVo parent111 = new TreeVo();
        parent111.setId(111);
        parent111.setName("1-2");
        List<TreeVo> parent1111 = new LinkedList<>();
        parent1111.add(parent11);
        parent1111.add(parent111);

        System.out.println(parent1111);

        result.get(0).setList(parent1111);

        JSONArray array = JSONObject.parseArray(String.valueOf(result));

        System.out.println(result);
        System.out.println(array);
    }

    public static void main(String[] args) {
        testToTree();
    }
}
