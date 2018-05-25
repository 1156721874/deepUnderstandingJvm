/*
 * Copyright (C) 2018 The TwoDragonLake Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.twodragonlake.jvm.classloader;

import java.sql.Driver;
import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * Description.
 *
 * @author : CeaserWang
 * @version : 1.0
 * @since : 2018/4/23 20:57
 */
public class MyTest26 {
    /*
    线程类上下文加载器的一般使用模式(获取-使用-还原)
    ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
    try{
        Thread.currnetThread().setContextClassLoader(targetTccl);
        myMethod();
    }finally{
        Thread.currentThread().setContextClassLoader(classLoader);
    }
    myMethod里面则调用了Thread.currentThread().getContextClassLoader(),获取当前线程的上下文加载器
    做某些事情。
    如果一个类由类加载器A加载，那么这个类的依赖类也是由相同的类加载器加载的（如果该依赖类之前没有被加载过的话）
    ContextClassLoader的作用就是为了破坏java的类加载委托机制。

    当高层提供统一的接口让底层去实现，同时又要在高层加载（或实例化）底层的类时，就必须要通过线程上下文类加载器
    来帮助高层的ClassLoader找到并加载该类。
     */

    public static void main(String[] args) {
        //Thread.currentThread().setContextClassLoader(MyTest26.class.getClassLoader().getParent());
        ServiceLoader<Driver> serviceLoader = ServiceLoader.load(Driver.class);
        Iterator<Driver> iterator = serviceLoader.iterator();

        while(iterator.hasNext()){
            Driver driver =  iterator.next();
            System.out.println("driver: "+driver.getClass() + "loader: "+ driver.getClass().getClassLoader() );
        }

        System.out.println("当前线程上下文类加载器: " + Thread.currentThread().getContextClassLoader());

        System.out.println("ServiceLoader的类加载器: "+ServiceLoader.class.getClassLoader());

    }
}
