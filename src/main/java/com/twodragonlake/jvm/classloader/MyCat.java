package com.twodragonlake.jvm.classloader;

public class MyCat {
    public MyCat(){
        System.out.println("MyCat is loaded by : "+this.getClass().getClassLoader());
       // System.out.println("from MyCat : "+MySample.class);
    }
}
