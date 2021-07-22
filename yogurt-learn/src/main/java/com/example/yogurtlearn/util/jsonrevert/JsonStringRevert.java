package com.example.yogurtlearn.util.jsonrevert;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @description:
 * @author: old_yogurt
 * @date 2021/7/22 14:29
 */
public class JsonStringRevert {
    /**
     * @Description: 将对象转为Json格式
     */
    public static void toJsonString(){
        List<Person> listOfPersons = new ArrayList<Person>();
        listOfPersons.add(new Person(15, "Old Yogurt", new Date()));
        listOfPersons.add(new Person(20, "Old Yogurt1", new Date()));

        String s = JSON.toJSONString(listOfPersons);
        System.out.println("正常list对象格式: "+listOfPersons);
        System.out.println("转换为Json格式: "+s);
    }

    /**
     * @Description: BeanToArray 序列化功能 ,将bean 转为 数组
     */
    public static void beanToArray(){
        List<Person> listOfPersons = new ArrayList<Person>();
        listOfPersons.add(new Person(15, "Old Yogurt", new Date()));
        listOfPersons.add(new Person(20, "Old Yogurt1", new Date()));

        String jsonOutput= JSON.toJSONString(listOfPersons, SerializerFeature.BeanToArray);
        System.out.println("正常list对象格式: "+listOfPersons);
        System.out.println("转换为Json格式: "+jsonOutput);
    }

    /**
     * @Description: 通过 @JSONField注解 控制字段的排序，日期显示格式，序列化标记
     */
    public static void testJSONField(){
        List<Person2> listOfPersons = new ArrayList<Person2>();
        listOfPersons.add(new Person2(18, "Old","Old Yogurt",new Date()));
        listOfPersons.add(new Person2(20, "Old","Old Yogurt1",new Date()));

        String s = JSON.toJSONString(listOfPersons);
        System.out.println("正常list对象格式: "+listOfPersons);
        System.out.println("转换为Json格式: "+s);
    }


    /**
     * @Description: 将Json对象转为Json字符串
     */
    public static void jsonObjectToJsonString(){
        JSONArray array = new JSONArray();
        for (int i = 0; i < 2; i++) {
            JSONObject object = new JSONObject();
            object.put("AGE", 18);
            object.put("FULL NAME", "yogurt " + i);
            object.put("DATE OF BIRTH", "2021/07/2 14:52:00");
            array.add(object);
        }
        System.out.println(array.toJSONString());
    }


    public static void main(String[] args) {
        jsonObjectToJsonString();
    }
}
