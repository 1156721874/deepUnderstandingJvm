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

package com.twodragonlake.jvm.lock;

/**
 * 当我们使用synchronized关键字来修饰同步代码块时，本质上在字节码层面上是通过monitorenter
 * 与monitorexit指令来实现同步的，当进入monitorenter指令后，线程将会持有monitor对象，
 * 当退出monitorexit后，线程将会释放掉该monitor对象，在线程整个执行过程中，他会始终持有monitor对象的，
 * 这样就确保了共享资源的同步访问。
 *
 * monitor对象到底是什么？
 *
 * 当我们使用new关键字创建一个java对象时，底层的jvm会自动为该创建的对象创建一个所谓的object header，并且
 * 将该object header附加到该对象上，java中的每个对象在创建后，都会拥有一个与之相关联的monitor对象，
 * 这也是为什么我们synchronized关键字修饰同步代码块时，我们使用什么对象（如Object，string，Date）都可以的原因所在。
 *
 * Object Header里面包含了很多信息，如monitor信息，锁相关的信息等。
 *
 *  对于同步方法的字节码来说，在反编译的字节码中并没有出现monitor与monitor相关的指令，
 *  而是出现了一个ACC_SYNCHRONIZED标记。
 *
 *  本质上，jvm使用ACC_SYNCHRONIZED访问标记来判断某个方法是否是一个同步方法。
 *
 *  当方法调用时，调用指令会先检查该方法是否拥有ACC_SYNCHRONIZED访问标记，如果发现了该标记，那么执行的线程
 *  将会首先持有monitor对象，接下来再去执行方法；在该方法运行期间，其他任何线程都将无法获取到monitor对象，
 *  当方法执行完毕后，线程会释放掉所有持有的monitor对象。
 *
 *  那么线程所持有的的monitor对象又是什么呢？
 *  1、如果被synchronized修饰的方法是普通实例方法，那么monitor对象就是当前被调用方法所在的那个对象。
 *  2、如果被synchronized修饰的方法是静态方法，那么monitor对象就是当前类所对应的class对象。
 *
 */
public class MyTest1 {
    private Object object = new Object();

    public void myMethod(){
        synchronized (object){
            System.out.println("hello world");
        }
    }

    public synchronized void method2(){
        System.out.println("hello world");
    }
}
