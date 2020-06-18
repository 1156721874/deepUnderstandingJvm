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
 -Xms20M
 -Xmx20M
 -Xmn10M
 -XX:+PrintGCDetails
 -XX:SurvivorRatio=8
 -XX:+UseConcMarkSweepGC
 * @author : CeaserWang
 * @version : 1.0
 * @since : 2019/5/25 13:33
 */
public class MyTest5 {
    public static void main(String[] args) {
        int size = 1024 * 1024;
        byte[] myAlloc1 = new byte[5 * size];
        System.out.println("111111");
        byte[] myAlloc2 = new byte[5 * size];
        System.out.println("22222");
        byte[] myAlloc3 = new byte[2 * size];
        System.out.println("333333");
        byte[] myAlloc4 = new byte[3 * size];
        System.out.println("444444");

    }
}
