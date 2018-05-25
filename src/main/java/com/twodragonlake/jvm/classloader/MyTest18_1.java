package com.twodragonlake.jvm.classloader;

public class MyTest18_1 {
    public static void main(String[] args) throws Exception {
        MyTest16 loader1 = new MyTest16("loader1");
        loader1.setPath("E:\\data\\classes\\");
        Class<?> clazz = loader1.loadClass("com.twodragonlake.jvm.classloader.MyTest");
        System.out.println("class : "+clazz.hashCode());
        System.out.println("class loader :" + clazz.getClassLoader());
    }
}
