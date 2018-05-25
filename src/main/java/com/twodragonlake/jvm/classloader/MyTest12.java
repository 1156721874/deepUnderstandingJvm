package com.twodragonlake.jvm.classloader;

/*
http://blog.csdn.net/wzq6578702/article/details/79369460
 */
class CL{
    static {
        System.out.println("Class CL");
    }
}
/*
调用classLoader类的loadClass方法加载一个类，并不是对类的主动使用，不会导致类的初始化
 */
public class MyTest12 {
    public static void main(String[] args) throws Exception {
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        Class<?> cl = classLoader.loadClass("com.twodragonlake.jvm.classloader.CL");//不会触发类的初始化
        System.out.println(cl);
        System.out.println("-------------------------");
        cl = Class.forName("com.twodragonlake.jvm.classloader.CL");//使用了反射，这属于类初始化时机的反射时机。会触发类的初始化。
        System.out.println(cl);
    }
}
