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
 * @since : 2018/10/4 19:51
 */

/**
 *现代JVM在执行Java代码的时候，通常都会将解释执行与编译执行二者结合起来进行。
 *
 * 所谓解释之行，就是通过解释器来读取字节码，遇到相应的指令就去执行该指令。
 * 所谓编译执行，就是通过即时编译器(just in time jit)将字节码转换为本地机器码执行，现代jvm会根据代码热点生成相应的本地机器码。
 *
 * 执行的方式有基于栈的和基于寄存器的执行方式：
 * 基于栈: 移植性好，java是基于栈的指令集，为了可移植性。由于栈是在内存里边出栈入栈，相比cpu寄存器，速度比较慢。
 * 完成相同的操作，基于栈的指令集要比基于寄存器的指令集所需要的指令数量要多。
 * 基于寄存器: 寄存器和硬件架构绑定在一块，因此移植性不ok，但是执行速度快。基于寄存器的指令集是在寄存器里边执行的，速度很快。
 * 虽然虚拟机可以采取一些优化手段，但总体来说，基于栈的指令集的执行速度要慢一些。
 *
 *
 */
public class MyTest8 {
    public int myCalulate(){
        int a =1;
        int b =2;
        int c =3;
        int d =4;

        int result = (a + b - c) * d;
        return result;
    }
}
