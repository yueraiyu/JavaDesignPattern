# 模版方法
        带有模版功能的的模式，组成模版的方法被定义（抽象方法）在父类中；方法的具体实现
    在子类中，父类定义调用流程，所以无论子类如何实现，流程都是统一的；即父类中定义处理
    流程的框架，子类中实现具体处理。
----------------------------------------------------------------------------

## UML图
>   ![TemplateMethod](https://github.com/yueraiyu/JavaDesignPattern/blob/master/src/com/yeay/design/templatemethod/template_method.jpg)

## 模版方法角色

> 1. AbstractClass 抽象类 : 负责实现模版方法，定义抽象发法 
> 2. ConcreteClass 具体类 : 实现抽象方法

## 优点

> 1. 抽离模版方法，避免重复代码，提高复用
> 2. 父类、子类协作
> 3. 父类与子类的一致性
> 4. 抽象类无法实例化，