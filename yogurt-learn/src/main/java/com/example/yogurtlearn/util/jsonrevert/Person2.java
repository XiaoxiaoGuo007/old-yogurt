package com.example.yogurtlearn.util.jsonrevert;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

/**
 * @description:
 * @author: old_yogurt
 * @date 2021/7/22 14:39
 */
public class Person2 {
    @JSONField(name="AGE", serialize=false)
    private int age;

    @JSONField(name="LAST NAME", ordinal = 2)
    private String lastName;

    @JSONField(name="FIRST NAME", ordinal = 1)
    private String firstName;

    @JSONField(name="DATE OF BIRTH", format="dd/MM/yyyy", ordinal = 3)
    private Date dateOfBirth;

    public Person2(int age, String lastName, String firstName, Date dateOfBirth) {
        this.age = age;
        this.lastName = lastName;
        this.firstName = firstName;
        this.dateOfBirth = dateOfBirth;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public String toString() {
        return "Person2{" +
                "age=" + age +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                '}';
    }
}
