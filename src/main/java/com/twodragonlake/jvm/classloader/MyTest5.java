package com.twodragonlake.jvm.classloader;

import java.util.Random;

public class MyTest5 {
/*
详情：http://blog.csdn.net/wzq6578702/article/details/79382182
当一个接口初始化时并不要求其父接口完成了初始化
只有在真正用到父接口的时候（如引用接口中定义的常量时），才会初始化。
 */
    public static void main(String[] args) {
        //System.out.println(MyChild5.b);
        System.out.println(MyParent5_1.thread);
    }
}

class Grandapa{
    public static Thread thread = new Thread(){
        //代码块 当Thread的匿名类初始化的时候 代码块会被执行（每new一个类代码块都会执行一次）
        {
            System.out.println("Grandapa invoked!");
        }
    };
}

class MyParent5 extends  Grandapa{
    public static final int a =4;
    public static Thread thread = new Thread(){
        //代码块 当Thread的匿名类初始化的时候 代码块会被执行（每new一个类代码块都会执行一次）
        {
            System.out.println("MyParent5 invoked!");
        }
    };
}

class MyChild5 extends  MyParent5{
    public static   int b =  5;
}

interface  MyGrandpa5_1{
    public static Thread thread = new Thread(){
        {
            System.out.println("MyGrandpa5_1 invoked!");
        }
    };
}

interface  MyParent5_1 extends MyGrandpa5_1 {
    public static Thread thread = new Thread(){
        {
            System.out.println("MyParent5_1 invoked!");
        }
    };
}