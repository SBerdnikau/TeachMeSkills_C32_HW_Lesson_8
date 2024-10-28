package com.teachmeskills.lesson_8.task3;

import com.teachmeskills.lesson_8.task3.fruit.Apple;

import java.lang.reflect.Field;

public class ApplicationRunner {
    public static void main(String[] args) {
       try {
           Apple apple = new Apple();
           Field field = apple.getClass().getDeclaredField("color");
           field.setAccessible(true);
           System.out.println("Current color apple: " +  field.get(apple));
           field.set(apple, "Red");
           System.out.println("After change color apple: " +  field.get(apple));
       }catch (NoSuchFieldException | IllegalAccessException e) {
           System.out.println(e.getMessage());
       }
    }
}