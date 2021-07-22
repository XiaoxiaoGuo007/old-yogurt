package com.example.yogurtlearn.util.jsonrevert;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

/**
 * @Author: old_yogurt
 * @Description:
 * @Param:
 * @return:
 */
public class Person {

    /** JSONField注解 属性参数的作用
     public @interface JSONField {
        // 配置序列化和反序列化的顺序，1.1.42版本之后才支持
        int ordinal() default 0;
        // 指定字段的名称
        String name() default "";
        // 指定字段的格式，对日期格式有用
        String format() default "";
        // 是否序列化
        boolean serialize() default true;
        // 是否反序列化
        boolean deserialize() default true;
    }*/
    @JSONField(name = "AGE")
    private int age;
 
    @JSONField(name = "FULL NAME")
    private String fullName;
 
    @JSONField(name = "DATE OF BIRTH")
    private Date dateOfBirth;
 
    public Person(int age, String fullName, Date dateOfBirth) {
        super();
        this.age = age;
        this.fullName= fullName;
        this.dateOfBirth = dateOfBirth;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", fullName='" + fullName + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                '}';
    }
}