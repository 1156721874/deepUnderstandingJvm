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

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * Description.
 *
 * @author : CeaserWang
 * @version : 1.0
 * @since : 2018/10/5 10:29
 */
public class Client {
    public static void main(String[] args) {
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles","true");
        RealSubJect realSubJect = new RealSubJect();
        InvocationHandler invocationHandler = new DynamicSubject(realSubJect);
        SubJect subJect = (SubJect) Proxy.newProxyInstance(realSubJect.getClass().getClassLoader(),realSubJect.getClass().getInterfaces(),invocationHandler);
        subJect.request();
        System.out.println(subJect.getClass());
        System.out.println(subJect.getClass().getSuperclass());
    }
}
