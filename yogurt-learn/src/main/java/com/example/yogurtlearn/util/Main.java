package com.example.yogurtlearn.util;

import java.util.Arrays;
import java.util.List;

public class Main{
    public static void main(String[] argv){
        List persons = Arrays.asList(new Person("Joe"), new Person("Jim"), new Person("John"));
        persons.forEach(p ->System.out.println(p));
    }
}


class Person {
    private String firstName;

    private String lastName;

    private int age;

    public Person(String firstName) {
        this.firstName = firstName;

    }

    public Person(String firstName, int age) {
        this.firstName = firstName;

        this.age = age;

    }

    public String getFirstName() {
        return firstName;

    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;

    }

    public String getLastName() {
        return lastName;

    }

    public void setLastName(String lastName) {
        this.lastName = lastName;

    }

    public int getAge() {
        return age;

    }

    public void setAge(int age) {
        this.age = age;

    }

    @Override

    public String toString() {
        return "Person [firstName=" + firstName + ", lastName=" + lastName

                + ", age=" + age + "]";

    }

}