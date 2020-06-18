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
 * -verbose:gc 输出打印详细的GC日志
 * -Xms20M     堆空间最小值
 * -Xmx20M     堆空间最大值
 * -Xmn10M     堆空间新生代的大小
 * -XX:+PrintGCDetails  打印GC的详细的信息
 * -XX:SurvivorRatio=8  eden和survivor的比例是8:1
 *
 * @author : CeaserWang
 * @version : 1.0
 * @since : 2019/5/12 14:26
 */
public class MyTest1 {
    public static void main(String[] args) {
        int size = 1024 * 1024;
        byte[] myAlloc1 = new byte[3 * size];
        byte[] myAlloc2 = new byte[3 * size];
        byte[] myAlloc3 = new byte[4 * size];
        byte[] myAlloc4 = new byte[4 * size];
        System.out.println("hello world");
    }
}
