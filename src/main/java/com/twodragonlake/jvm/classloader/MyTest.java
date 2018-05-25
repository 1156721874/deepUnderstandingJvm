package com.twodragonlake.jvm.classloader;

public class MyTest {
/*
对于静态字段来说，只有直接定义该字段的类才会被初始化
当一个类初始化时，要求其父类全部都已经初始化完毕了
-XX:+TraceClassLoading 用于追踪类的加载信息并打印出来
-XX:+<option> 表示开启option选项
-XX:-<option> 表示关闭option选项
-XX:<option>=<value>,表示将option的选项的值设置为value
 */
    public static void main(String[] args) {
        //直接使用父类的变量 ，子类不会初始化，虽有用了子类的标识符
        System.out.println(MyChild.str);
        /*
        MyParent1 static block
        hello world
         */

        //直接调用子类的变量 会首先初始化父类，然后再初始化子类
       // System.out.println(MyChild.str2);
        /*
        MyParent1 static block
        MyChild static bloack
        welcome
         */
    }

}

class MyParent1{
    public static String str  = "hello world";
    static{
        System.out.println("MyParent1 static block");
    }
}

class MyChild extends  MyParent1{
    public static String str2 = "welcome";
    static{
        System.out.println("MyChild static bloack");
    }
}
