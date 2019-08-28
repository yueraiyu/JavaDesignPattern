## 策略模式
            整体的替换，程序中的不同算法实现.
-----------------------------------------------------------------------

## UML图
>   ![Strategy](https://github.com/yueraiyu/JavaDesignPattern/blob/master/src/com/yeay/design/strategy/strategy.jpg)

## 策略模式角色

>> 1. Strategy(策略)：负责定义实现策略所必须的接口。
>> 2. ConcreteStrategy(具体策略)：实现策略具体接口，具体的策略规则算法。
>> 3. Context(上下文)：使用策略，持有具体策略。

## 分析

>> 1. 将具体实现算法与具体方法分离，使用委托弱化关联，便于切换。
