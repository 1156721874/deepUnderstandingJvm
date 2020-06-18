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
 * @since : 2018/9/15 10:06
 */

/**
 * invokevirtual 运行期执行的时候首先：
 * 找到操作数栈顶的第一个元素它所指向对象的实际类型，在这个类型里边，然后查找和常量里边Fruit的方法描述符和方法名称都一致的
 * 方法，如果在这个类型下，常量池里边找到了就会返回实际对象方法的直接引用。
 *
 *如果找不到，就会按照继承体系由下往上(Apple-->Fruit-->Object)查找，查找匹配的方式就是
 * 上面描述的方式，一直找到位为止。如果一直找不到就会抛出异常。
 *
 *比较方法重载（overload）和方法重写（overwrite），我们可以得出这样的结论：
 * 方法重载是静态的，是编译器行为；方法重写是动态的，是运行期行为。
 *
 */
public class MyTest6 {
    public static void main(String[] args) {
        Fruit apple = new Apple();
        Fruit orange = new Orange();
        apple.test();
        orange.test();

        apple = new Orange();
        apple.test();
    }
}

class Fruit{
    public void test(){
        System.out.println("fruit");
    }
}

class Apple extends  Fruit{
    @Override
    public void test() {
        System.out.println("apple");
    }
}

class Orange extends Fruit{
    @Override
    public void test() {
        System.out.println("orange");
    }
}
