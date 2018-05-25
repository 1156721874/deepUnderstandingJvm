package com.twodragonlake.jvm.classloader;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class MyTest16 extends  ClassLoader {

    private String classLoaderName;
    private final String fileExtension = ".class";
    private String path;


    public MyTest16(ClassLoader classLoader){
        super(classLoader);
    }

    public void setPath(String path) {
        this.path = path;
    }

    public MyTest16(String classLoaderName){
        super();//使用系统类加载器作为当前类的父类委托加载器
        this.classLoaderName = classLoaderName;
    }

    public MyTest16(ClassLoader classLoader,String classLoaderName){
        super(classLoader);//使用自定义的类加载器作为当前类的父类委托加载器
        this.classLoaderName = classLoaderName;
    }

    private byte[] loadClassData(String name ){
        InputStream inputStream = null;
        ByteArrayOutputStream baos = null;
        byte [] bytes = null;

        try{
            //this.classLoaderName = this.classLoaderName.replace(".","\\");
            name = name.replace(".","\\");
            inputStream = new FileInputStream(new File(this.path + name + this.fileExtension));
            baos = new ByteArrayOutputStream();
            int ch = 0;
            while (-1 !=(ch = inputStream.read())){
                baos.write(ch);
            }
            bytes = baos.toByteArray();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try{
                inputStream.close();
                baos.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return bytes;
    }

    @Override
    /*
    loadClass会调用子类的findClass方法
     */
    protected Class<?> findClass(String className) throws ClassNotFoundException {
        System.out.println("findClass invoked "+className);
        System.out.println(" this.classLoaderName : "+ this.classLoaderName);
        byte [] data = loadClassData(className);//中间调用子类的findClass方法
        return defineClass(className,data,0,data.length);
    }

    public static void main(String[] args) throws Exception {
        MyTest16 myClassLoader = new MyTest16("myClassLoader");
        myClassLoader.setPath("E:\\data\\classes\\");
        Class<?> clazz = myClassLoader.loadClass("com.twodragonlake.jvm.classloader.MyTest");
        System.out.println("class :"+clazz.hashCode());
        Object object = clazz.newInstance();
        System.out.println(object);
        System.out.println("-----------------------------------------");

        myClassLoader= null;
        clazz = null;
        object = null;
        System.gc();

        Thread.sleep(10000);

        myClassLoader = new MyTest16("myClassLoader3");
        myClassLoader.setPath("E:\\data\\classes\\");
        clazz = myClassLoader.loadClass("com.twodragonlake.jvm.classloader.MyTest");
        System.out.println("class :"+clazz.hashCode());
        object = clazz.newInstance();
        System.out.println(object);
        System.out.println("-----------------------------------------");

     /*   MyTest16 myClassLoader1 = new MyTest16(myClassLoader,"myClassLoader1");
        myClassLoader1.setPath("E:\\data\\classes\\");
        Class<?> clazza = myClassLoader1.loadClass("com.twodragonlake.jvm.classloader.MyTest");
        System.out.println("class :"+clazza.hashCode());
        Object objecta = clazza.newInstance();
        System.out.println(objecta);

        System.out.println("---------------------------------------------");

        MyTest16 myClassLoader2 = new MyTest16(myClassLoader1,"myClassLoader2");
        myClassLoader2.setPath("E:\\data\\classes\\");
        Class<?> clazz2 = myClassLoader2.loadClass("com.twodragonlake.jvm.classloader.MyTest");
        System.out.println("class :"+clazz2.hashCode());
        Object object2 = clazz2.newInstance();
        System.out.println(object2);*/
    }
}
