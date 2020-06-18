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

import java.util.*;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Description.
 *
 * @author : CeaserWang
 * @version : 1.0
 * @since : 2018/7/31 22:57
 */
public class Test {
    public static void main(String[] args) {
        //A();
    }

    private static void A() {
        List<String> chars = new ArrayList<>();
        for (int i = 'a'; i < 'z'; i++) {
            chars.add(i+"");
        }
        for (int i = 'A'; i < 'Z'; i++) {
            chars.add(i+"");
        }
        for (int i = 0; i <= 9; i++) {
            chars.add(i+"");
        }
        String[] ochars =new  String[chars.size()];
        for (int i = 0; i < ochars.length; i++) {
            ochars[i] = chars.get(i);
        }
        System.out.println(Arrays.asList(ochars));
        Map<String, String> map = new LinkedHashMap(10,0.75f,true);

        for (int i = 0; i < ochars.length; i++) {
            if(!map.containsKey(ochars[i])){
                map.put(ochars[i],ochars[i]);
            }
        }
        map.entrySet().forEach(item -> {
            System.out.println(item.getKey()+":"+item.getValue());
        });
    }
}
