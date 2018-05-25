package com.twodragonlake.jvm.classloader;

import javafx.scene.Parent;

class Parent2{
    static int a = 3;
    static {
        System.out.println("Parent2 static block");
    }
}

class Child2 extends Parent2{
    static int b = 4;
    static {
        System.out.println("Child2 static block");
    }
}

public class MyTest10 {
    static {
        System.out.println("MyTest10 static block");
    }

    public static void main(String[] args) {
        Parent2 parent;
        System.out.println("-----------------");
        parent = new Parent2();
        System.out.println("------------------");
        System.out.println(parent.a);
        System.out.println("------------------");
        System.out.println(Child2.b);
    }
}
