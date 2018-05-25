package com.twodragonlake.jvm.classloader;

import sun.misc.Launcher;

/*
本文件介绍：
https://blog.csdn.net/wzq6578702/article/details/79835695
 */
/**
 * 在运行期，一个Java类是由该类的完全限定名(binary name，二进制名)和用于加载该类的定义类加载器(defining loader)所共同决定的。
 * 如果同样的名字（即相同的完全限定名）的类是由两个不同的加载器所加载的，那么这些类就是不同的，即便.class文件的字节码完全一样，并且从相同的位置加载亦是如此。
 */
/*
在Oracle的Hotspot实现中，系统属性sun.boot.calss.path如果 修改错了，则运行会出错，提示如下错误信息：
Error occurred during initialization of VM
java/lang/NoClassDefFoundError: java/lang/Object
 */
/*
内建与jvm中的启动类加载器会加载Java.lang.ClassLoader以及其他的Java平台类，
当jvm启动时，一块特殊的机器码会运行，他会加载扩展类加载器以及系统类加载器，
这块特殊的机器码叫做启动类加载器 (Bootstrap)

启动类加载器并不是Java类，而其他的加载器则都是Java类，
启动类加载器是特定于平台的机器指令，他负责开启整个加载过程。

所有类加载器（除了启动类加载器）都被实现为Java类，不过，总归要有一个组件来加载第一个Java类加载器，
从而让整个加载过程能够顺利进行下去，加载第一个纯Java类加载器就是启动类加载器的职责。

启动类加载器还会负责加载供JRE正常运行所需要的基本组件。这包括java.util与java.lang包中的类等等。
 */
public class MyTest23 {
    public static void main(String[] args) {
        System.out.println(System.getProperty("sun.boot.class.path"));
        System.out.println("-------------------------------------------");
        System.out.println(System.getProperty("java.ext.dirs"));
        System.out.println("-------------------------------------------");
        System.out.println(System.getProperty("java.class.path"));

        System.out.println(ClassLoader.class.getClassLoader());
        //扩展类加载器和应用类加载器都是由启动类加载器加载的。
        System.out.println(Launcher.class.getClassLoader());

        System.out.println(ClassLoader.getSystemClassLoader());
        System.out.println(System.getProperty("java.system.class.loader"));//java.system.class.loader
        System.out.println(MyTest23.class.getClassLoader());
        System.out.println(MyTest16.class.getClassLoader());

    }
}
