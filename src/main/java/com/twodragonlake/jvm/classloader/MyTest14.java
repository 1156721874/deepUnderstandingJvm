package com.twodragonlake.jvm.classloader;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;

public class MyTest14 {
    public static void main(String[] args) throws IOException {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        String resourceName = "com/twodragonlake/jvm/classloader/MyTest13.class";
        Enumeration<URL> urls =  classLoader.getResources(resourceName);
        while(urls.hasMoreElements()){
            System.out.println(urls.nextElement());
        }

        System.out.println("----------------");

        Class<?> clazz = String.class;
        System.out.println(clazz.getClassLoader());//由根类加载器加载 因为系统类加载器的加载目录包含rt目录
        System.out.println("----------------");
        clazz = MyTest14.class;
        System.out.println(clazz.getClassLoader());   //自定义的类有系统类加载器加载

    }
}
