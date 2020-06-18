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

import java.lang.ref.SoftReference;
import java.util.Date;

/**
 * Description.
 *
 * @author : CeaserWang
 * @version : 1.0
 * @since : 2020/3/8 21:57
 */
public class MyTest1 {
    public static void main(String[] args) {
        Date date=  new Date();
        SoftReference<Date> softReference = new SoftReference(date);
        Date date1 = softReference.get();
        if(null != date1){
            System.out.println("hello");
        }else{
            System.out.println("world");
        }
        System.out.println("=========");
        softReference.clear();
        Date date2 = softReference.get();
        System.out.println(date2);
    }
}
