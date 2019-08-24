# 创造者模式
            组装复杂实例，对于大型复杂组件，无法一次构造，需要先构造个组成部件，再进行组装；
            
-------------------------------------------------------------------------------

## UML图
>   ![Builder](https://github.com/yueraiyu/JavaDesignPattern/blob/master/src/com/yeay/design/builder/builder.jpg)  
            
## 创造者模式角色

>   1. Builder(建造者) : 定义生成实例的接口
>   2. ConcreteBuilder(实际建造者) : 负责实现Builder中定义的接口
>   3. Director(监工) : 负责使用Builder中的接口生成实例，并不依赖于实际建造者，只是调用Builder中的接口(对象多态)

## 类设计的可替换性

>   1. 不知道实际调用者，也并不重，通过接口、抽象类将实际操作转递到实际实现类
>   2. 即多态性