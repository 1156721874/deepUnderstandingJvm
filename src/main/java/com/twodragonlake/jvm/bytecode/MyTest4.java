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

package com.twodragonlake.jvm.bytecode;

/**
 * Description.
 *
 * @author : CeaserWang
 * @version : 1.0
 * @since : 2018/9/8 12:10
 */

/**
 * 栈帧（stack frame）
 * 栈帧是一种用于帮助虚拟机执行方法调用与方法执行的数据结构。
 * 栈帧本身是一种数据结构，封装了方法的局部变量表，动态链接信息，方法的返回地址以及操作数栈等信息。
 * 符号引用 直接引用
 * 符号引用：A类引用了B类方法，那么A类边会有B类全限定名，这是符号引用
 * 直接引用：程序运行的时候，会把符号引用转换为直接引用，直接引用是对应的内存地址。
 */

/**
 * 1、invokeinterface:调用接口中的方法，实际上是在运行期决定的，决定到底调用实现该接口的那个对象的特定方法。4
 * 2、invokestatic : 调用静态方法
 * 3、invokespecial: 调用自己的私有方法，构造方法(<init>)以及父类的方法。
 * 4、invokevirtual: 调用虚方法，运行期动态查找的过程。
 * 5、invokedynamic: 动态调用方法。
 */

/**
 *静态解析的4种情形：
 * 1、静态方法
 * 2、父类方法
 * 3、构造方法
 * 4、私有方法
 * 以上4类方法称作非虚方法，他们是在类加载阶段就可以将符号引用转换为直接引用的。
 */
public class MyTest4 {
     public static void test(){
         System.out.println("test invoked");
     }

    public static void main(String[] args) {
        test();
    }
}
