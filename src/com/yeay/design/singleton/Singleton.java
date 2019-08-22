package com.yeay.design.singleton;

/**
 * 单例模式
 */
public class Singleton {
    public static void main(String[] args) throws InterruptedException {
        Runnable r = () -> {
            Singleton1 singleton = Singleton1.getInstance();
//            Singleton2 singleton = Singleton2.getInstance();
            System.out.println("current = " + Thread.currentThread().getName() +
                    ", singleton = " + singleton);
        };

        for (int i = 0; i < 100000; i ++) {
            Thread t = new Thread(r);
            t.start();
//            Thread.sleep(1);
        }
    }
}

/**
 * 懒汉模式
 * 懒加载
 * 单线程适用，多线程条件下
 */
class Singleton1{
    private static Singleton1 singleton;

    private Singleton1(){}

    public static Singleton1 getInstance(){
        if (singleton == null){
            singleton = new Singleton1();
            return singleton;
        }

        return singleton;
    }
}

/**
 * 懒汉模式
 * 懒加载
 * 多线程适用，线程安全，效率低
 */
class Singleton2{
    private static Singleton2 singleton;

    private Singleton2(){}

    public synchronized static Singleton2 getInstance(){
        if (singleton == null){
            singleton = new Singleton2();
            return singleton;
        }

        return singleton;
    }
}

/**
 * 饿汉模式
 *
 * 利用类加载初始化顺序
 */
class Singleton3{
    private static Singleton3 singleton = new Singleton3();

    private Singleton3(){}

    public static Singleton3 getInstance(){return singleton;}
}

/**
 * 饿汉模式 变种
 *
 * 利用类加载初始化顺序
 */
class Singleton4{
    private static Singleton4 singleton;

    static {
        singleton = new Singleton4();
    }

    private Singleton4(){}

    public static Singleton4 getInstance(){return singleton;}
}

/**
 * 静态内部类，延迟加载
 */
class Singleton5{
    private static class SingletonHelper{
        private static final Singleton5 INSTANCE = new Singleton5();
    }

    public static Singleton5 getInstance(){return SingletonHelper.INSTANCE;}
}

/**
 * 枚举
 */
enum Singleton6{
    INSTANCE;
}

/**
 * 双重校验
 */
class Singleton7{
    private static volatile Singleton7 singleton;

    private Singleton7(){}

    public static Singleton7 getInstance(){
        if (singleton == null){
            synchronized (Singleton7.class){
                if (singleton == null){
                    singleton = new Singleton7();
                    return singleton;
                }
            }
        }
        return singleton;
    }
}
