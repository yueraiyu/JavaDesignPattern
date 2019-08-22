# 迭代器模式  
    Java 代码中有类似如下代码   
        for(int i =0; i < arr.length; i ++){  
            System.out.println(arr[i]);
        }  
        这类操作即循环操作, 主要针对同一类事物集合进行统一操作, 通过 i 的变化实现对整个集合  
    的遍历操作, 当然 Java 也提供了 foreach 操作, 不必明确声明迭代因子.  
        Java 的 Collection 接口通过 extends 继承了Iterable 接口, Collection 的实现如: ArrayList、  
    LinkedList、HashSet、TreeSet，以上类均提供的相应的迭代器实现. 不同类型返回不同的 Iterator   
    实现对集合的遍历操作. 只不过 Java 在 Iterator 的基础至少加入了 Iterable 接口.  
        [ArrayList UML](/ArrayList.jpg)     
---------------------------------------------------------------------------------------------------------------------

## 《图解设计模式》 例解
> 1. [UML图](/exam/bookshelf.jpg)
> 2. 说明
>>  Aggregate: 接口, 英译为聚集体, 可理解为集合的抽象层, 其中定义了 iterator() 方法, 用于返回指定集合类的  
                迭代器.  
>>  Iterator : 接口, 英译为迭代器, 定义类集合的遍历操作方法, 一般情况下集合的访问需要确认是否存在下一元素  
                以及返回当前元素值或对当前元素的具体操作, 其中定义了 hasNext() 、 next() 方法实现遍历操作.  
>>  BookShelf: 类, 实现了 Aggregate 接口, 返回一个 BookShelfIterator 迭代器. 
>>  BookShelfIterator: 类, 实现了 Iterator 接口, 实现了 hasNext()、 next() 方法.  
>>  以上为书中提供迭代器样例, 通过抽象读取书架书名模拟迭代操作.  

## 为什么要引入迭代器模式？
> 1. 将遍历与实现分离
> 2. 无论具体集合实现类，采用何种方式实现集合接口，只要保证迭代方式正确就可以不影响调用。

## 迭代器分析
> 1.使用场景  
>> (1) 具有相同属性的某一类集合的统一操作, 通过标准化迭代操作, 减少大量重复代码.
>> (2) 只对集合元素访问而不是操作改变等  

> 2.优点
>> (1) 通过集合接口、迭代器接口, 抽象定义了一系列集合操作以及集合的迭代操作, 使操作统一化标准化.  
>> (2) 接口的定义便于对集合的扩展, 不会导致代码乱象. 
>> (3) 迭代器可以与集合功能相独立，即一个集合可以有多个迭代器
>> (4) 迭代器可以有更丰富的功能 

> 3.缺点  
>> (1) 按照书中基础类继承结构, 如果需要对其它类支持迭代操作, 需要提供相应的集合类和迭代器类, 维护成本高,  
        可通过泛型支持来扩展类型的支持返回, 减少部分不必要的实现.                                     