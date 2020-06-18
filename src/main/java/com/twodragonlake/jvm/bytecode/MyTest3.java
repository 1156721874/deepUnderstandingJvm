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

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.util.concurrent.Executors;

/**
 * Description.
 *
 * @author : CeaserWang
 * @version : 1.0
 * @since : 2018/9/8 9:15
 */

/**
     * 对于java类中的每一个实例方法(非static方法)。其在编译后所生成的字节码当中，方法参数的数量总是
     * 会比源代码中方法参数的数量多一个（多了this），它位于方法的第一个参数位置处；这样，我们就可以在java
     * 的实例方法中使用this来去访问当前对象的属性以及其他方法。
     *
     * 这个操作是在编译期间完成的，既由javac编译器在编译的时候将对this的访问转化为对一个普通实例方法参数的访问；
     * 接下来在运行期间，由jvm在调用实例方法时，自动向实例方法传入该this参数，所以，在实例方法的局部变量表中，
     * 至少会有一个指向当前对象的局部变量。
 */

/**
 * java字节码对于异常的处理方式：
 * 1、统一采用异常表的方式对异常进行处理。
 * 2、在jdk1.4.2之前的版本中，并不是使用异常表的方式来对异常进行处理的，而是采用特定的指令方式。
 * 3、当异常处理在finally语句块时，线代的jvm采取的处理方式是将finally语句块的字节码拼接到每一个catch块后面，
 * 换句换说，程序中存在多少个catch块，就会在每一个catch块后面重复多少个finally语句块的字节码。
 */
public class MyTest3 {
    public void test() throws FileNotFoundException,IOException,NullPointerException{
        try {
            InputStream inputStream = new FileInputStream("test.text");
            ServerSocket serverSocket = new ServerSocket(6666);
            serverSocket.accept();
        } catch (FileNotFoundException e) {

        } catch (IOException e) {

        }catch (Exception ex){

        }finally {
            System.out.println("finally");
        }

    }
}
