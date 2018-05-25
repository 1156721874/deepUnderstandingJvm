package com.twodragonlake.jvm.classloader;

class FinalTest{
    public static  int x = 3;
    static{
        System.out.println("FinalTest");
    }
}

public class MyTest8 {
    public static void main(String[] args) {
        System.out.println(FinalTest.x);
    }
}
