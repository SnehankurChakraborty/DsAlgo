package com.dsalgo.java.features;

public class Singleton {

    private static Singleton INSTANCE = null;
    private Singleton(){}
    public static Singleton getInstance(){
        if(null == INSTANCE){
            synchronized (Singleton.class) {
                if(null == INSTANCE) {
                    INSTANCE = new Singleton();
                }
            }
        }
        return INSTANCE;
    }
}
