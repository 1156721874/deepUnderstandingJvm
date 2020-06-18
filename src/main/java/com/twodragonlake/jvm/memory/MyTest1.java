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

package com.twodragonlake.jvm.memory;

/*
JVM内存区域分了如下几个区域：
# 虚拟机栈(Stack Frame)
在执行一个方法的时候，会有一个栈帧，用来存储，方法里边的操作数的出栈入栈，当java文件编译完成的时候，max_stack(栈最大的深度),max_local(最大局部变量表有多少个元素)等都是确定的。

# 程序计数器(Program Counter)
记录方法执行的位置，线程切换回来之后继续从这个位置执行。

# 本地方法栈
主要执行本地方法，native 方法

# 堆(Heap)
所有进程共享的。
我们子啊操作对象的时候，是使用引用的方式去操作对象的，引用放在栈帧里边，对象放在堆里边。
那么引用指向的对象在对里边存储有一下2种方式：
## 都是指针
栈指向堆里边的那块区域分成2部分，每一部分都是存储的一个指针。一个指针指向实际的对象数据，另一个指向
元数据区的class数据。
## 一半是对象数据，一半类型指针
栈指向堆里边的那块区域分成2部分，一部分直接就是存储的对象数据。另一部分是一个指针，指向元数据区的类，也就是class数据。

oracle的hospot用的是一半是对象数据，一半数类型指针这种方式。
为什么采用这种方式？
在堆里边很对对象都会因为垃圾收集算法，对象地址也伴随着移动，这种对象的移动是很频繁的，如果用第一种方式
每次对象的移动，对象的地址就会发生变化，那么指向它的指针也要跟着变化，这样是很繁琐的，而第二种栈里边指向的区域，第一部分就是直接是对象的数据，而第二部分是class的数据，class的数据一般不会发生变化。这样就相对于第一种方式减少了指针地址变化的次数。


# 方法区(Method area)
存储元信息，class对象，常量等
永久代(Permanent Genaration)和方法区不是完全等价的，jdk1.8开始彻底去掉了永久代，jdk8使用元空间(meta space)

# 运行时的常量池
是方法区的一部分，存放常量

# 直接内存
不是jvm管理的内存区域，DirectBuffer申请的，这部分内存是os管理。

### 关于java对象创建的过程：

new 关键字创建对象的三个步骤：

- 在堆内存中创建出对象的实例。
- 为对象的实例成员变量赋初值。
- 将对象的引用返回。

#### 指针碰撞
在堆里边，内存分为2部分，一部分是被占用的，另一部分是未占用的，他们各自都是连续的，我们在未被占用的区域创建对象后，指针就会向下移动，
这就是指针碰撞(前提是堆空间通过一个指针进行分割，一侧是已经被占用的空间，另一侧是未被占用的空间)

#### 空闲列表
堆内存里边的空间不是连续的，占用和未被占用的空间都掺杂在一起，这个时候虚拟机会维护一个空闲区域的列表，记录空闲区域的地址以及他的容量，以及那些空间是已经使用的，
然后给对象分配内存的时候会从维护的列表里边找一个能容纳对象的一个区域把对象放进去，这就是空闲链表(前提是堆内存空间中已被使用与未被使用的空间交叉在一起的，这是，虚拟机
就需要通过一个列表记录那些空间是可以使用的，那些空间是已经被使用的，接下来找出可以容纳下新创建对象的且未被使用的空间，在此空间存放该对象，同时还要
修改该列表上的记录)


#### 对象在内存中的布局：
1 . 对象头
2. 实例数据(即我们在一个类中所声明的各项信息)
3. 对齐填充(可选)

#### 引用访问对象的方式：
1. 使用句柄的方式。
2. 使用直接指针的方式。
 */


import java.util.ArrayList;
import java.util.List;

public class MyTest1 {
    //-Xms5m -Xmx5m -XX:+HeapDumpOnOutOfMemoryError
    public static void main(String[] args) {
        List<MyTest1> list = new ArrayList<>();
        for(;;){
            list.add(new MyTest1());
            System.gc();
        }
    }

}

/**
 * java.lang.OutOfMemoryError: GC overhead limit exceeded
 * Dumping heap to java_pid6640.hprof ...
 * Heap dump file created [8974002 bytes in 0.029 secs]
 * Exception in thread "main" java.lang.OutOfMemoryError: GC overhead limit exceeded
 * 	at com.twodragonlake.jvm.memory.MyTest1.main(MyTest1.java:94)
 */
