# 原型模式
            Java中通new ClassName()来实例化对象，这种情况必须指定类名；但可能出现不指定类名
    生成实例。
    
    可能出现不指明类名但情况：
    * 对象种类繁多，无法将它们整合到一个类中？
    * 难以根据类生成实例，由于生成实例过程复杂，无法通过类名实例？
    * 想解藕框架与生成的实例
    
    在Java中通过clone()方法生成实例副本。
----------------------------------------------------------------------------------
## UML图
>  ![Prototype](https://github.com/yueraiyu/JavaDesignPattern/blob/master/src/com/yeay/design/prototype/prototype.jpg)

## 原型模式中的角色

> 1. Prototype : 原型，负责定义用于复制现有实例生成新实例的方法
> 2. ConcretePrototype : 具体原型，实现用于复制现有实例生成新实例的方法
> 3. Client : 使用者，使用复制现有实例生成新实例的方法

## 为什么不用类名直接生成实例？

> 1. 对象种类繁多，无法将它们整合到一个类中？
> 2. 难以根据类生成实例，由于生成实例过程复杂，无法通过类名实例？
> 3. 想解藕框架与生成的实例