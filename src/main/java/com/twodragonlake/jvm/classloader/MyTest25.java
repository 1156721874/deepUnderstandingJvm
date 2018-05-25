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

package com.twodragonlake.jvm.classloader;

/**
 * Description.
 *
 * @author : CeaserWang
 * @version : 1.0
 * @since : 2018/4/23 20:34
 */
public class MyTest25 implements  Runnable {

    private Thread thread;

    public MyTest25(){
        this.thread = new Thread(this);
        this.thread.run();
    }

    @Override
    public void run() {
        ClassLoader classLoader = this.thread.getContextClassLoader();
        this.thread.setContextClassLoader(classLoader);

        System.out.println(classLoader.getClass());//class sun.misc.Launcher$AppClassLoader

        System.out.println(classLoader.getParent().getClass());//class sun.misc.Launcher$ExtClassLoader
    }

    public static void main(String[] args) {
        new MyTest25();
    }
}
