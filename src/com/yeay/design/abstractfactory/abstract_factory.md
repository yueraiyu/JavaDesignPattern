# 抽象工厂
            工厂是将零件组装的地方，而抽象工厂呢？抽象指什么？工厂指生成具体产品的地方！那么抽象工厂呢？生成抽象产品？
        抽象工厂就是将抽象零件组装成抽象产品；在面向对象中，抽象意指不关注具体如何实现，而仅关注接口；通过抽象类/接口
        定义方法，具体细节交由具体实现的类。与工厂方法的区别呢？
------------------------------------------------------------------------------------------------------

## UML图
>   ![AbstractFactory](https://github.com/yueraiyu/JavaDesignPattern/blob/master/src/com/yeay/design/abstractfactory/abstract_factory.jpg)  
   

## 抽象工厂角色

>>  1. AbstractProduct(抽象产品) : 定义 AbstractFactory角色所生产的抽象零件和产品的接口。
>>  2. AbstractFactory(抽象工厂) : 定义用于生成抽象产品的接口。
>>  3. Client(委托者) : 调用AbstractFactory、AbstractProduct。
>>  4. ConcreteProduct(具体产品) : 实现AbstractProduct定义的接口。
>>  5. ConcreteFactory(具体工厂) : 实现AbstractFactory定义的接口。

## 抽象工厂优点

>> 1. 易于子类扩展，问题定位

## 抽象工厂缺点

>> 1. 当添加新的组件时，需要定义抽象类，并且抽象工厂即相应子类工厂、实际组件都要修改。

## Java中生成实例当方法

>> 1. new
>> 2. clone
>> 3. newInstance

