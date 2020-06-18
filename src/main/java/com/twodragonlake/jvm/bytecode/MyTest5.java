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

/**
 * Description.
 *
 * @author : CeaserWang
 * @version : 1.0
 * @since : 2018/9/15 9:19
 */

/**
 * 方法的静态分派:
 *  GrandPa g1 = new Father();
 *  以上代码，g1的静态类型是Gandpa，而g1的实际类型（真正指向的类型）是Father。
 *  我们可以得出这样的结论：变量的静态类型是不会发生变化的，而变量的实际类型则是可以发生变化的（多态的一种体现），实际类型是在运行期方可确定。
 *
 */
public class MyTest5 {
    //方法的重载是一种静态的行为，在编译期就可以完全确定。
    public void test(GrandPa grandPa){
        System.out.println("grandpa");
    }

    public void test(Father father){
        System.out.println("father");
    }

    public void test(Son son){
        System.out.println("son");
    }

    public static void main(String[] args) {
        GrandPa grandPa1 = new Father();
        GrandPa grandPa2 = new Son();
        MyTest5 myTest5 = new MyTest5();
        myTest5.test(grandPa1);
        myTest5.test(grandPa2);
    }

}


class GrandPa{

}

class Father extends GrandPa{

}

class Son extends Father{

}