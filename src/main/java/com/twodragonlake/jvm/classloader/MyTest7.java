package com.twodragonlake.jvm.classloader;

import java.util.concurrent.Executors;

public class MyTest7 {
    public static void main(String[] args) throws Exception{
        Class<?> str = Class.forName("java.lang.String");
        System.out.println(str.getClassLoader());

        Class<?> c = Class.forName("com.twodragonlake.jvm.classloader.C");
        System.out.println(c.getClassLoader());
    }
}

class C{

}
