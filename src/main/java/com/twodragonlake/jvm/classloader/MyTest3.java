package com.twodragonlake.jvm.classloader;

import java.util.UUID;

public class MyTest3 {
    /*
    当一个常量的值并非编译期可以确定的，那么其值就不会被放到调用类的常量池中，
    这时的程序运行时，会导致主动使用这个常量所在的类，显然会导致这个类被初始化
     */
    public static void main(String[] args) {
        System.out.println(MyParent3.str);
        /*
        Myparnet3 static bloack
        04d27b8c-5480-497d-83cc-8b924e5889a5
         */
    }
}

class MyParent3{
    public static final String str =UUID.randomUUID().toString();
    static{
        System.out.println("Myparnet3 static bloack");
    }
}
