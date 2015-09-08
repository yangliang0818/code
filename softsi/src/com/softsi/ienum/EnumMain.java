package com.softsi.ienum;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: caina
 * Date: 15-9-8
 * Time: 下午8:28
 * To change this template use File | Settings | File Templates.
 */
public class EnumMain {
    public static void main(String[] args) {
        Day.getInstance("sun").getName();
        Day.getInstance("FFFF").doSomeThing("默认情况");
        Day.getInstance("sun").doSomeThing("星期天");
        Day.getInstance("sun").getName();
        Day.getInstance("fri").doSomeThing("星期五");
        Day.getInstance("fri").getName();
        Day.getInstance("").doSomeThing("默认情况");
        Day.getInstance("sun").doSomeThing("我从星期天编程星期五了");
        Day.getInstance("sun").doSomeThing("我从星期天编程星期四了");
        Day.getInstance("sun").doSomeThing("我从星期天编程星期三了");
    }

    private static Map<String, Day> dayMap = new HashMap<String, Day>();

    enum Day {
        星期天("sun") {
            String name;

            @Override
            void doSomeThing(String name) {
                this.name = name;
                System.out.println(name);
                System.out.println("星期天在家休息");
            }

            public String getName() {
                System.out.println("name===" + name);
                return name;
            }
        }, 星期五("fri") {
            @Override
            void doSomeThing(String name) {
                System.out.println("红色星期五，收拾心情过周末");
            }
        }, 默认情况("其他情况") {
            @Override
            void doSomeThing(String name) {
            }
        };
        String code;

        Day(String code) {
            this.code = code;
            dayMap.put(code, this);
        }

        public String getName() {
            return "";
        }

        abstract void doSomeThing(String name);

        public static Day getInstance(String code) {
            return null == dayMap.get(code) ? 默认情况 : dayMap.get(code);
        }
    }
}
