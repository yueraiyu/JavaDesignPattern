# 适配器模式/包装器模式
          生活中常常用到电源适配器，将不实用的电源转换为可用的电源。位于实际情况与需求之间，
      填补两者之间的差异；填补"现有程序"与"所需程序"之间的差异；起转换的作用，实际并不能为
      己所用，需要通过一定转换才能使用。
-----------------------------------------------------------------------------

## UML图
>   * [Adapter By Class](https://github.com/yueraiyu/JavaDesignPattern/blob/master/src/com/yeay/design/adapter/adapter_by_class.jpg)
>   * [Adapter By Entrust](https://github.com/yueraiyu/JavaDesignPattern/blob/master/src/com/yeay/design/adapter/adapter_by_entrust.jpg)

## 适配器分类

> 1. 类适配器模式: 使用继承的适配器
> 2. 对象适配器模式: 使用委托的适配器，委托即将某个方法中的实际处理交给其他实例的方法

## 适配器角色

> 1. Target(对象): 负责定义需要的方法，如：Print
> 2. Client(请求者): 使用Target定义的方法
> 3. Adaptee(被适配): 持有既定方法的角色，如：Banner
> 4. Adapter(适配): 模式主人公，使用Adaptee的方法来满足Target的需求，如：PrintBanner

## 什么时候使用？
> 1. 存在现有类，将现有类作为组件重复使用，适配器模式会对现有类进行适配，生成新类。
> 2. 版本升级与兼容
> 3. 功能接近的类

  
        