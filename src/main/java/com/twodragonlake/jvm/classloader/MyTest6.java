package com.twodragonlake.jvm.classloader;

/*
解释见：
http://blog.csdn.net/wzq6578702/article/details/79382182
 */
public class MyTest6 {
    public static void main(String[] args) {
        Singleton singleton = Singleton.getInstance();
        System.out.println(Singleton.counter1);
        System.out.println(Singleton.counter2);
    }
}

class Singleton{
    public static int counter1;
    private static Singleton singleton = new Singleton();
    private Singleton(){
        counter1++;
        counter2++;
    }
    public static int counter2=0;
    public static Singleton getInstance(){
        return singleton;
    }
}
