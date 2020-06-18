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

package com.twodragonlake.jvm.memory;

/**
 * 1.jcmd（从JDK1.7开始增加的命令）
 * 2.jcmd pid VM.flags：查看JVM的启动参数
 * 3.jcmd pid help ：列出当前正在运行的java进程可以进行的操作。
 * 4. jcmd pid help JFR.dump :查看具体命令的选项有哪些。
 * 5. jcmd pid PerfCounter.print: 查看jvm性能相关的参数。
 * 6. jcmd pid GC.class_histogram 查看系统中类的统计信息。
 * 7. jcmd pid Thread.print 查看线程的堆栈信息。
 * 8. jcmd pid GC.heap_dump 导出Heap dump文件。导出的文件可以通过jvisualvm查看
 * 9. jcmd pid VM.version 查看目标jvm进程的版本信息。
 * 10. jcmd pid VM.command_line:查看jvm启动命令行参数信息
 *
 * jstack 可以查看或者导出java应用程序中的堆栈信息。
 *
 * jmc： Java Mission control java任务控制
 * JFR： Java flight Recoder  java飞行记录器
 *
 * @author : CeaserWang
 * @version : 1.0
 * @since : 2019/4/30 11:16
 */
public class MyTest5 {
    public static void main(String[] args) {
        for (;;){
            System.out.println("hello world");
        }
    }
}
