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

package com.twodragonlake.jvm.gc;

/**
 * jvm参数：
 -verbose:gc
 -Xms20M
 -Xmx20M
 -Xmn10M
 -XX:+PrintGCDetails
 -XX:+PrintCommandLineFlags
 -XX:MaxTenuringThreshold=5 在可以自动调节对象晋升(promote)到老年代阈值的GC中，设置该阈值的最大值， 对象晋升到老年代的最大存活年龄
 这里是理想的情况下，当对象年龄达到6的时候，对象晋升到 老年代，但是jvm会根据当前新生代的情况可能在对象年龄到了2就会晋升到老年代
 jvm会有一个自动调节的机制。但是最大年龄不会超过5的，对象年龄大于5的肯定会被晋升到老年代，但是小于5也有可能会被提前晋升到老年代。
 该参数默认值是15，CMS中默认值是6，G1中默认值是15(在JJVM中，，该数值是由4个bit来表示的，所以最大值是1111，即15)

 -XX:+PrintTenuringDistribution 打印的作用，打印年龄为1的对象的是那些，对象年龄为2的是那些等信息的打印。

 经历过多次GC，存活的对象会在From Survivor和To Survivor之间来回存放，
 而这里面的一个前提是这两个空间有足够得到大小来存放这些数据，在GC算法中会计算每个对象年龄的大小，如果达到某个年龄后发现总大小
 已经大于Survivor（其中一个Survivor）空间的50%，这个时候就需要调整阈值，不能再继续等到默认的15次后才完成晋升，因为这样会导致Survivor空间不足，所以
 需要调整阈值，让这些存活对象尽快完成晋升。
 */
public class MyTest3 {
    public static void main(String[] args) {
        int size = 1024 * 1024;
        byte[] myAlloc1 = new byte[2 * size];
        byte[] myAlloc2 = new byte[2 * size];
        byte[] myAlloc3 = new byte[2 * size];
        byte[] myAlloc4 = new byte[2 * size];
        byte[] myAlloc5 = new byte[2 * size];
        byte[] myAlloc6 = new byte[2 * size];
        System.out.println("hello world");
    }
}
