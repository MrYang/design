package com.zz.design.creational.singleton;

public class DoubleCheck {

    private volatile static DoubleCheck instance;

    private DoubleCheck() {

    }

    public static DoubleCheck getInstance() {
        if (instance == null) {
            synchronized (DoubleCheck.class) {
                if (instance == null) {
                    instance = new DoubleCheck();
                }
            }
        }
        return instance;
    }
}

class InnerClass {
    private static class SingletonHolder {
        private static final InnerClass instance = new InnerClass();
    }

    private InnerClass() {
    }

    public static InnerClass getInstance() {
        return SingletonHolder.instance;
    }
}