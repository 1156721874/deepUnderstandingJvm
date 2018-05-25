package com.twodragonlake.jvm.classloader;

class Parent{
    static int x = 3;
    static{
        System.out.println("Parent static block");
    }
}

class Child extends  Parent{
    static int b = 4;
    static {
        System.out.println("Child static block");
    }
}

public class MyTest9 {
    static {
        System.out.println("MyTest9 static block");
    }
    public static void main(String[] args) {
        System.out.println(Child.b);
    }
}
