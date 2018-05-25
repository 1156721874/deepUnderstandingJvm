package com.twodragonlake.jvm.classloader;

public class MySample {
    public MySample(){
        System.out.println("MySample is loaded by : "+this.getClass().getClassLoader());
        new MyCat();
        System.out.println("form MySample :"+MyCat.class);
    }
}
