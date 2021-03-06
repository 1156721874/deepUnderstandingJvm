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

/**
 * Description.
 *
 * @author : CeaserWang
 * @version : 1.0
 * @since : 2018/4/15 16:19
 */
/*
当前类加载器(Current ClassLoader)
每个类都会使用自己的类加载器(即加载自身的类加载器) 来去加载其他类(指的是所依赖的类)
如果ClassX引用了ClassY，那么ClassX的类加载器就会加载ClassY（前提是ClassY尚未被加载）

线程上下文加载器（Context  ClassLoader）
线程上下文类加载器是从jdk1.2开始引入的，类Thread中的getContextCLassLoader()与setContextClassLoader(ClassLoader classloader)
分别用来获取和设置上下文类加载器

如果没有通过与setContextClassLoader(ClassLoader classloader)进行设置的话，线程将继承其父线程的上下文类加载器。
Java应用运行时的初始线程的上下文加载器是系统类加载器，在线程中运行的代码可以通过该类加载器来加载类与资源

前言：
我们在使用jdbc的时候，不同的数据库的驱动都是由每个厂商自己去实现，开发者在使用的时候，只需要把驱动jar包
放到当前path下边就可以了，这些驱动是由系统类加载器加载，而java.sql下边的一些Class在使用的时候不可避免的
要去使用厂商自定义的实现的逻辑，但是这些java.sql下的类的加载器是由启动类加载器完成的加载，由于父加载器(启动类加载器)加载的类无法访问子加载器（系统类加载器或者应用类加载器）
加载的类，所以就无法在有些java.sql的类去访问具体的厂商实现，这个是双亲委托模型尴尬的一个局面。


线程上下文加载器的重要性：
SPI (Service Provider Interface)
父ClassLoader可以使用当前线程Thread.currentThread().getContextClassLoader()所指定的classloader加载的类。
这就改变了父ClassLoader不能使用子ClassLoader或是其他没有直接父子关系的CLassLoader加载的类的情况，即改变了
双亲委托模型。

线程上下文加载器就是当前线程的Current ClassLoader
在双亲委托模型下，类加载器由下至上的，即下层的类加载器会委托上层进行加载。但是对于SPI来说，有些接口是java
核心库所提供的，而java核心库是由启动类加载器来加载的，而这些接口的实现来自于不同的jar包（厂商提供），java
的启动类加载器是不会加载其他来源的jar包，这样传统的双亲委托模型就无法满足SPI的要求，而通过给当前线程设置上下文加载器
就可以设置上下文类加载器来实现对于接口实现类的加载。

 */
public class MyTest24 {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getContextClassLoader());
        System.out.println(Thread.class.getClassLoader());
    }
}