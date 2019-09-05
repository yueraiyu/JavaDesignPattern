## 面向对象设计原则

* 依赖倒置原则（DIP）

  说明：高层模块与低层模块通过抽象来隔离依赖关系，淡化依赖；抽象是对一类或某些行为的高度说明，不依赖任何具体实现，二者应该是实现依赖抽象

  * `高层模块`(`稳当`)不应该依赖于`低层模块`(`变化`)，二者都应该依赖于`抽象`(`稳定`)
  * `抽象`(`稳当`)不应该依赖于`实现细节`(`变化`)，`实现细节`应该依赖于`抽象`(`稳定`)

* 开放封闭原则（OCP）

  说明：当面对需求变更，应当首先考虑添加扩展，而不是考虑修改。

  * 对`扩展`开发，对`更改`封闭
  * 类模块应该是`可扩展`的，但是`不可修改`

* 单一职责原则（SRP）

  说明：当类的职责(`方法`)过多时，会导致类表现出不稳定臃肿的现象，当扩展子类时容易导致职责不明确。

  * 一个类应该仅有`一个`引起它`变化`的原因
  * 变化的方向隐含着类的责任

* Liskov替换原则（LSP）

  说明：多态

  * 子类必须能够替换它们的基类(IS-A)
  * 继承表达类型抽象

* 接口隔离原则（ISP）

  说明：不必要的方法就没必要暴露给客户程序(使用者)

  * 不应该强迫客户程序依赖它们不用的方法
  * 接口应该小而完备

* 优先使用对象组合，而不是类继承

  说明：继承与组合，is-a or has-a，继承上父类通常对于子类而言是没有绝对的隐私的，而子类也极大依赖于父类，父类或者子类的改变都将严重影响现有结构；而组合对于拥有者只关系调用接口是否可用即可，即使改变也完全可以是当方面的。

  * 类继承通常为“白箱复用”，对象组合通常为“黑箱复用”
  * 继承在某种程度上破坏了封装性，子类父类耦合度高
  * 对象组合之要求被组合的对象具有良好定义的接口，耦合度低

* 封装变化点

  说明：

  * 使用封装来创建对象之间的分界层，让设计者可以在分界层一侧进行修改，而不会对另一侧产生不良的影响，从而实现层次间的松耦合

* 针对接口编程，而不是针对实现编程/面向接口设计/接口标准化

  * 不将变量类型声明为某个特定的具体类，而是声明为某个接口
  * 客户程序无需获知对象的具体类型，只需要知道对象所具有的接口
  * 减少系统中各部分的依赖关系，从而实现“高内聚、松耦合”的类型设计方案

## GOF模式分类

```markdown
在变化和稳定之间寻找隔离点
```

* 目的分类

  * `创建型`：将对象的部分`创建工作延迟`到子类或者其他对象，从而应对需求变化为`对象创建具体类型`的实现引来的冲击
  * `结构型`：通过`类继承`或者`对象组合`获得更灵活的`结构`，从而应对需求变化为`对象结构`带来的冲击
  * `行为型`：通过`类继承`或者`对象组合`来划分类于对象间的`职责`，从而应对需求变化为`多个交互对象`带来的冲击

* 范围分类/实现手段

  * 类模式/继承：处理`类与子类`的`静态关系`
  * 对象模式/组合：处理`对象间`的`动态关系`

* 封装角度分类

  * 组件协作
    * Template Method
    * Strategy
    * Observer/Event
  * 对象性能
    * Singleton
    * Flyweight
  * 数据结构
    * Composite
    * Iterator
    * Chain of Resposibility
  * 单一职责
    * Decorator
    * Bridge
  * 接口隔离
    * Facade
    * Proxy
    * Mediate
    * Adapter
  * 行为变化
    * Command
    * Vistor
  * 对象创建
    * Factory Method
    * Abstract Factory
    * Prototype
    * Builder
  * 状态变化
    * Memento
    * State
  * 领域
    * Interpreter

  ## 设计模式方法讨论(重构获得模式)

  * 书籍推荐：《重构---改善既有代码的设计》、《重构与模式》
  * 面向对象设计模式是“好的面向对象设计”，所谓“好的面向对象设计”指是那些可以满足“`应对变化，提高复用`”
  * 现代软件设计的特征是“需求的频繁变化”。设计模式的要点是“寻找`变化点`，然后在变化点处应用设计模式，从而更好地应对需求的变化”，“什么时候、什么地点应用设计模式”比“理解设计模式结构本身”更为重要
  * 设计模式的应用不宜先入为主，一上来就使用设计模式是对设计模式最大的误用。没有一步到位的设计模式。敏捷软件开发实践提倡“Refactoring to Patterns”是目前普遍公认的最好的使用设计模式的方法。

  ## 重构关键技巧

  * 静态	=>	动态
  * 早绑定	=>	晚绑定
  * 继承	=>	组合
  * 编译时依赖	=>	运行时依赖
  * 紧耦合	=>	松耦合

  ## 模式详解

  ### 组件协作

  * 现代软件专业分工之后的第一个结果是“`框架`与`应用程序`的划分”，“组件协作”模式通过`晚期绑定`，来实现框架与应用程序间的`松耦合`，是二者之间协作时常用的模式。
  * 典型模式
    * Template Method
    * Strategy
    * Observer/Event

  #### Template Method

  ```markdown
  定义一个操作中的算法的骨架（`稳定`），而将一些步骤延迟（`变化`）到子类中；Template Method使得子类可以不改变（`复用`）一个算法的结构即可重定义（override重写）该算法的某些特定步骤；模版方法稳定中包含变化；适用于流程固定，但部分细节可能不同。
  ```

  * UML

    ```PlantUML
    @startuml
    abstract AbstractClass{
    + void templementMethod()
    + abstract void menthod1()
    + abstract void menthod2()
    }
    note left of AbstractClass 
    void templementMethod(){
    menthod1();
    menthod2();
    }
    end note
    AbstractClass <|-- ConcreteClassA
    class ConcreteClassA{
    + void menthod1()
    + void menthod2()
    }
    
    AbstractClass <|-- ConcreteClassB
    class ConcreteClassB{
    + void menthod1()
    + void menthod2()
    }
    @enduml
    ```

  * 在软件构件过程中，对于某一项任务，它常常有`稳定`的整体操作结构，但各个子步骤却有很多`改变`的需求，或者由于固有原因（比如框架与应用之间的关系）而无法和任务的整体结构同时实现

  * 如何在确定`稳定操作`结构的前提下，来灵活应对各个子步骤的`变化`或者`晚期实现`需求？

    * `传统操作`

    ```java
    public abstract class AbstractClass{
      	public abstract void oper1();
    		public abstract void oper2();
    		public abstract void oper3();
    }
    
    //子类A
    public class ConcreteClassA extends AbstractClass{
      	@Override
      	public void oper1(){
          ...
        }
      
      	@Override
    		public void oper2(){
          ...
        }
      
      	@Override
    		public void oper3(){
          ...
        }
      
      	public void oper(){
          oper1();
    			oper2();
    			oper3();
        }
    }
    
    //子类B
    public class ConcreteClassB extends AbstractClass{
      	@Override
      	public void oper1(){
          ...
        }
      
      	@Override
    		public void oper2(){
          ...
        }
      
      	@Override
    		public void oper3(){
          ...
        }
      
      	public void oper(){
          oper1();
    			oper2();
    			oper3();
        }
    }
    
    
    ```

    

    * `抽象类实现`

    ```java
    //抽象类 主要定义抽象方法及模版方法
    public abstract class AbstractClass{
      	//模版方法，定义为final，避免子类覆写篡改流程
    		public final void oper(){
    			oper1();
    			oper2();
    			oper3();
    		}
    		
      	//子类需要实现,定义具体操作
    		public abstract void oper1();
    		public abstract void oper2();
    		public abstract void oper3();
    }
    
    //子类A
    public class ConcreteClassA extends AbstractClass{
      	@Override
      	public void oper1(){
          ...
        }
      
      	@Override
    		public void oper2(){
          ...
        }
      
      	@Override
    		public void oper3(){
          ...
        }
    }
    
    //子类B
    public class ConcreteClassB extends AbstractClass{
      	@Override
      	public void oper1(){
          ...
        }
      
      	@Override
    		public void oper2(){
          ...
        }
      
      	@Override
    		public void oper3(){
          ...
        }
    }
    
    //调用
    public class Client{
      public static void main(String args[]){
        	AbstractClass concreteA = new ConcreteClassA();
        	AbstractClass concreteB = new ConcreteClassB();
        
        	concreteA.oper();
        	concreteB.oper();
      }
    }
    ```

    * `接口实现`

    ```java
    //接口 主要定义抽象方法及模版方法
    public interface AbstractInterface{
      	//模版方法，java 8 可以在接口定义default方法，但是实现类可以覆盖，不安全
    		default void oper(){
    			oper1();
    			oper2();
    			oper3();
    		}
    		
      	//具体实现类需要实现,定义具体操作
    		public void oper1();
    		public void oper2();
    		public void oper3();
    }
    
    //实现类A
    public class ConcreteClassA implements AbstractInterface{
      	@Override
      	public void oper1(){
          ...
        }
      
      	@Override
    		public void oper2(){
          ...
        }
      
      	@Override
    		public void oper3(){
          ...
        }
    }
    
    //实现类B
    public class ConcreteClassB implements AbstractInterface{
      	@Override
      	public void oper1(){
          ...
        }
      
      	@Override
    		public void oper2(){
          ...
        }
      
      	@Override
    		public void oper3(){
          ...
        }
    }
    
    //调用	
    public class Client{
      public static void main(String args[]){
        	AbstractInterface concreteA = new ConcreteClassA();
        	AbstractInterface concreteB = new ConcreteClassB();
        
        	concreteA.oper();
        	concreteB.oper();
      }
    }
    ```