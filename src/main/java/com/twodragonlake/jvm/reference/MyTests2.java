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

package com.twodragonlake.jvm.reference;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.util.Date;

/**
 * ReferenceQueue引用队列的设计目的是在于让我们能够知道或者是识别出垃圾收集器所执行的动作.
 *
 * @author : CeaserWang
 * @version : 1.0
 * @since : 2020/3/9 21:15
 */
public class MyTests2 {
    public static void main(String[] args) {
        Date date=  new Date();
        ReferenceQueue<Date> referenceQueue = new ReferenceQueue<>();
        SoftReference<Date> softReference = new SoftReference(date,referenceQueue);
        date = null;
        System.gc();
        System.out.println(softReference.get());

    }
}
