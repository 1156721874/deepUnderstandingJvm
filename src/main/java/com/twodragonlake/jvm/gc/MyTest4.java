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
 -verbose:gc
 -Xmx200M
 -Xmn50M
 -XX:TargetSurvivorRatio=60 表示Survivor空间存活的对象超过60%的时候，就会重新计算阈值 MaxTenuringThreshold
 -XX:+PrintTenuringDistribution
 -XX:+PrintGCDetails
 -XX:+PrintGCDateStamps 打印GC的时间戳
 -XX:+UseConcMarkSweepGC 老年代使用CMS收集器
 -XX:+UseParNewGC 新生代使用Paralle new GC
 -XX:MaxTenuringThreshold=3  阈值设置为3，理想情况对象超过三代就会晋升到老年代
 * @author : CeaserWang
 * @version : 1.0
 * @since : 2019/5/18 17:43
 */
public class MyTest4 {
    public static void main(String[] args) throws InterruptedException {
        byte [] byte_1 = new byte[1024 * 1024];
        byte [] byte_2 = new byte[1024 * 1024];
        myGc();
        Thread.sleep(1000);
        System.out.println("111111------------------------------------------------------------");
        myGc();
        Thread.sleep(1000);
        System.out.println("222222------------------------------------------------------------");
        myGc();
        Thread.sleep(1000);
        System.out.println("333333------------------------------------------------------------");
        myGc();
        Thread.sleep(1000);
        System.out.println("444444------------------------------------------------------------");

        byte [] byte_3 = new byte[1024 * 1024];
        byte [] byte_4 = new byte[1024 * 1024];
        byte [] byte_5 = new byte[1024 * 1024];

        myGc();
        Thread.sleep(1000);
        System.out.println("555555------------------------------------------------------------");

        myGc();
        Thread.sleep(1000);
        System.out.println("666666------------------------------------------------------------");
        System.out.println("hello world");
    }
    private static void myGc(){
        for(int i= 0;i <= 40;i++){
            byte [] byteArray = new byte[ 1024 * 1024];
        }
    }
}
