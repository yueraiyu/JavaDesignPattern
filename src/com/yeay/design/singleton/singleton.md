## UML图
>   ![Singleton](https://github.com/yueraiyu/JavaDesignPattern/blob/master/src/com/yeay/design/singleton/singleton.jpg)

## 单例模式
* 懒汉模式 单线程版
* 懒汉模式 多线程版
* 饿汉模式 静态成员，类加载，初始化一次，不保证哪些情况下会发生类加载
* 饿汉模式 静态成员，静态代码块初始化，利用类加载机制
* 静态内部类 利用类加载，只有在用的时候才会加载内部类，且初始化一次
* 枚举 枚举类型，编译器会编译程静态常量，线程安全，类型安全
* 双重校验 对类加锁且校验是否初始化，instance 添加 volatile