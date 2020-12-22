package cn.tulingxueyuan.beans;

import java.util.Date;

public class PersonFactory {
    public Person createPersonFactory() {
        Child child = new Child();
        child.setName("二儿子");
        return child;
    }

    public static Date currentDate() {
        return new Date();
    }
}
