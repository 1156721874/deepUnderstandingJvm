package com.twodragonlake.jvm.classloader;

import java.util.HashMap;

public class MyTest15 {
    public static void main(String[] args) {
        String[] strings = new String[2];
        System.out.println(strings.getClass().getClassLoader());

        MyTest15[] myTest15s = new MyTest15[2];
        System.out.println(myTest15s.getClass().getClassLoader());

        int [] ints = new int[2];
        System.out.println(ints.getClass().getClassLoader());

        HashMap[] maps = new HashMap[2];
        System.out.println(maps.getClass().getClassLoader());
    }
}
