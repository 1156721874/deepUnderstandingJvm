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

package com.twodragonlake.jvm.g1;

/**
 -verbose:gc
 -Xms10m
 -Xmx10m
 -XX:+UseG1GC
 -XX:+PrintGCDetails
 -XX:+PrintGCDateStamps
 -XX:MaxGCPauseMillis=200m
 *
 * @author : CeaserWang
 * @version : 1.0
 * @since : 2019/7/21 9:49
 */
public class MyTest {
    public static void main(String[] args) {
        int size = 1024 * 1024;
        byte[] myAlloc1 = new byte[size];
        byte[] myAlloc2 = new byte[size];
        byte[] myAlloc3 = new byte[size];
        byte[] myAlloc4 = new byte[size];
        System.out.println("hello world");
    }
}
