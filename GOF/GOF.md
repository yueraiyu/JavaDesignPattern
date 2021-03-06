## 面向对象设计原则

* 依赖倒置原则（DIP）

  说明：高层模块与低层模块通过抽象来隔离依赖关系，淡化依赖；抽象是对一类或某些行为的高度说明，不依赖任何具体实现，二者应该是实现依赖抽象

  * `高层模块`(`稳当`)不应该依赖于`低层模块`(`变化`)，二者都应该依赖于`抽象`(`稳定`)
  * `抽象`(`稳当`)不应该依赖于`实现细节`(`变化`)，`实现细节`应该依赖于`抽象`(`稳定`)

* 开放封闭原则（OCP）

  说明：当面对需求变更，应当首先考虑添加扩展，而不是考虑修改。

  * 对`扩展`开放，对`更改`封闭
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

  * 使用封装来创建对象之间的分界层，让设计者可以在分界层一侧进行修改，而不会对另一侧产生不良的影响，从而实现层次间的松耦合

* 针对接口编程，而不是针对实现编程/面向接口设计/接口标准化

  * 不将变量类型声明为某个特定的具体类，而是声明为某个接口
  * 客户程序无需获知对象的具体类型，只需要知道对象所具有的接口
  * 减少系统中各部分的依赖关系，从而实现“高内聚、松耦合”的类型设计方案

## GOF模式分类

```
	在变化和稳定之间寻找隔离点。
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

```
	定义一个操作中的算法的骨架（`稳定`），而将一些步骤延迟（`变化`）到子类中；Template Method使得子类可以不改变（`复用`）一个算法的结构即可重定义（override重写）该算法的某些特定步骤；模版方法稳定中包含变化；适用于流程固定，但部分细节可能不同。
																																					---<<设计模式>> GOF
```

* UML
  
* 动机
  
    * 在软件构件过程中，对于某一项任务，它常常有`稳定`的整体操作结构，但各个子步骤却有很多`改变`的需求，或者由于固有原因（比如框架与应用之间的关系）而无法和任务的整体结构同时实现
  * 如何在确定`稳定操作`结构的前提下，来灵活应对各个子步骤的`变化`或者`晚期实现`需求？
  
* 代码实现
  
  * `非模式`
  
  ```java
  public class ClassA{
    public void oper1(){
      //...
    } 
  
    public void oper2(){
      //...
    }
  
    public void oper3(){
      //...
    }
  }
  
  public class ClassB{
    public void oper4(){
      //...
    }
  
    public void oper5(){
      //...
    }
  
    //重复操作流程
    public void oper(){
      ClassA classA = new ClassA();
      classA.oper1();
      classA.oper2();
      classA.oper3();
      oper4();
      oper5();
    }
  }
  
  public class ClassC{
    public void oper4(){
      //...
    }
  
    public void oper5(){
      //...
    }  
  
    //重复操作流程
    public void oper(){
      ClassA classA = new ClassA();
      classA.oper1();
      classA.oper2();
      classA.oper3();
      oper4();
      oper5();
    }
  }
  
  public class Client{
    public static void main(String args[]){
      ClassB classB = new ClassB();
      ClassC classC = new ClassC();
  
      classB.oper();
      classC.oper();
    }
  }
  ```
  
  * `模式-抽象类`
  
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
      //...
    }
  
    @Override
    public void oper2(){
      //...
    }
  
    @Override
    public void oper3(){
      //...
    }
  }
  
  //子类B
  public class ConcreteClassB extends AbstractClass{
    @Override
    public void oper1(){
      //...
    }
  
    @Override
    public void oper2(){
      //...
    }
  
    @Override
    public void oper3(){
      //...
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
  
  * `模式-接口`
  
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
      //...
    }
  
    @Override
    public void oper2(){
      //...
    }
  
    @Override
    public void oper3(){
      //...
    }
  }
  
  //实现类B
  public class ConcreteClassB implements AbstractInterface{
    @Override
    public void oper1(){
      //...
    }
  
    @Override
    public void oper2(){
      //...
    }
  
    @Override
    public void oper3(){
      //...
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
  
* 要点总结

  * Template Method 模式是一种非常`基础性`的设计模式，在面向对象系统中有着大量的应用。它用最简洁的机制（抽象函数的多态）为很多应用程序框架提供了灵活的扩展点，是代码复用的主要实现结构。
  * 除了可以灵活应对子步骤的变化外，“不要调用我，让我来调用你”的方向控制结构是Template Method的典型应用。
  * 在具体实现方面，被Template Method调用的抽象函数可以有具体实现，也可以没有任何实现，但一定要把它们设置为`protected`方法。

#### Strategy

```
  定义一系列`算法`,把他们一个个封装起来，并且使它们可互相替换（`变化`）。该模式使得算法可独立于使用它的客户程序（`稳定`）而变化（`扩展`，子类化）。
																																		 			---<<设计模式>> GOF
```

  * UML

  * 动机
  
    * 在软件构件过程中，某些对象使用的`算法`可能`多种多样`，经常改变，如果将这些算法都编码到对象中，将会使对象变得异常复杂；而且有时候支持不使用的算法也是一个性能负担。
      * 如何在运行时根据需要透明的更改对象的算法？将算法与对象本身节藕，从而避免上述问题？
    
  * 代码实现

    * `非模式`

    ```java
    public class ClassA{
      //根据不同策略做不同操作，当现有策略无法支持扩展时，需要添加新的策略类型及对应操作
      public void oper(int strategy){
        if (strategy == 0){
          //...
        }else if (strategy == 1){
          //...
        }else if (strategy == 2){
          //...
        }else if (strategy == 3){
          //...
        } //可能有无限变更...违背了开闭原则，开放扩展，封闭更改
    
        //...
      }
    }
    ```

    * `模式`

    ```java
    //实际持有策略的使用者
    public class Content{
      private Strategy strategy;
    
      public Content(Strategy strategy){
        this.strategy = strategy;
      }
    
      //变化的地方
      public void contentMethod(){
        strategy.oper();
      }
    }
    
    //策略接口，定义策略操作
    public interface Strategy{
      public void oper();
    }
    
    //策略A
    public class StrategyA implements Strategy{
      @Override
      public void oper(){
        //...
      }
    }
    
    //策略B
    public class StrategyB implements Strategy{
      @Override
      public void oper(){
        //...
      }
    }
    
    //调用 
    public class Client{
      public static void main(String args[]){
        Content contentA = new Content(new StrategyA());
        Content contentB = new Content(new StrategyB());
    
        contentA.contentMethod();
        contentA.contentMethod();
      }
    }
    ```

  * 要点总结
  
    * Strategy及其子类为组件提供了一系列`可重用的算法`，从而可以使得类型在运行时方便地根据需要在各个算法之间进行切换。
    * Strategy模式提供了用条件判断语句以外的另一种选择，`消除条件判断语句`，就是在解耦合。含有许多条件判断语句的代码通常都需要Strategy模式。
    * 如果Strategy对象没有实例变量，那么各个上下文可以共享同一个Strategy对象，从而节省对象开销。

  #### Observer/Event

```
	定义对象间的一种一对多（`变化`）的依赖关系，以便当一个对象的状态发生改变时，所有依赖于它的对象都能得到通知并自动更新。
  																																				---<<设计模式>> GOF
```

* UML
  
* 动机

  * 在软件构件过程中，我们需要为某些对象建立一种“`通知依赖关系`”------一个对象（目标对象）的状态发生改变，所有的依赖对象（观察者对象）都将得到通知。如果这样的依赖关系过于紧密，将使软件不能很好地抵御变化。
  * 使用面向对象技术，可以将这种依赖关系弱化，并形成一种稳定的依赖关系。从而实现软件体系结构的松耦合。 
  
* 代码实现
  
    * `非模式`
    
    ```java
    public class MainClass{
      private FeildClass feild1;
    
      // 加吧 :-(
    
      // 再加呢？滚。。。
    
      // 由于高层类FeildClass高度依赖于低层类State，违背了依赖倒置原则，这里需要添加一层抽象来隔离FeildClass 与 State，将二者的依赖关系逆转过来；这里FeildClass可以抽象为观察者，State可以抽象为被观察者；FeildClass中不变的是对State的操作和监听，所以观察者中只需要包含特定的监听处理就好，具体怎么样交给子类吧；而State被观察者，可能存在多种不同的表现形式，所以操作也会有些许不同。
    
      // 对feild1进行一定操作，但是需求临时变更，需要中feild1中对某类状态做处理监听？怎么办？常用手段在feild1中添加状态并对状态监听
    
      // 需求又变了。。。假设再监听一个状态呢？
      public void oper(){
        feild1.oper();
        other.oper();
      }
    }
    
    public class FeildClass{
      // 该死需求变了，加吧
      private State state;
    
      // 需求又变了
      private OtherState otherState;
    
      public void oper(){
        // ...
    
        // 添加对新状态的相关操作吧
      }
    
      public void updateState(){
        // ... update state
      }
    
      public State getState(){
        return state;
      }
    }
    
    public class OtherState{
      // ...
    }
    
    public class State{
      // ...随便干什么啦
    }
  ```
  
    * `模式`
  
  ```java
  // 稳定部分 
  
  /**
     * 观察者
     */
  public interface Observer{
    public void update(Subject subject);
  }
  
  /**
     * 被观察对象
     */
  public class Subject{
    List<Observer> observers = new ArrayList<>();
  
    void attach(Observer observer){
      // ...
    }
  
    void detach(Observer observer){
      // ...
    }
  
    void notify(){
      for(Observer observer : observers){
        observer.update(this);
      }
    }
  }
  
  //变化部分
  
  /**
     * 实际观察者
     */
  public class ConcreteObserver implements Observer{
    public void update(Subject subject){
      state = subject.getState();
      // ... update state
    }
  }
  
  /**
     * 实际被观察对象
     */
  public class ConcreteSubject extends Subject{
    private Object state;
  
    public Object setState(Object state){
      this.state = state;
      notify();
    }
  
    public Object getState(){
      return state;
    }
  }
  
  public class Client{
    public static void main(String[] args){
      Subject subject = new ConcreteSubject();
      Observer observer = new ConcreteObserver();
      subject.attach(observer);
      subject.setState(new Object());
    }
  }
  ```
  
* 要点总结

  * 使用面向对象的抽象，Observer模式使得我们可以`独立地改变`目标与观察者，从而使二者之间的依赖关系达致松耦合。
  * 目标发送通知时，`无需指定观察者`，通知（可以携带通知信息作为参数）会自动传播。
  * 观察者自己决定是否需要订阅通知，目标对象对此一无所知。
  * Observer模式是基于事件的UI框架中非常常用的设计模式，也是MVC模式的一个重要组成部分。

### 单一职责

* 在软件组件的设计中，如果`责任划分`的不清晰，使用`继承`得到的结果往往是随着需求的变化，子类急剧膨胀，同时充斥着重复代码，这时候的关键是划清责任。
* 典型模式
    * Decorator
  * Bridge
#### Decorator

```
 		动态（`组合`）地给一个对象增加一些额外的职责。就增加功能而言，Decorator模式比生成子类（`继承`）更为灵活（消除重复代码&减少子类个数）。
																																					---<<设计模式>> GOF
```

  * UML
  
* 动机
  
  * 在某些情况下我们可能会“过度地使用继承来扩展对象的功能”，由于继承为类型引入的`静态特质`(永远不可能变)，使得这种扩展方式缺乏灵活性；并且随着子类的增多（扩展功能的增多），各种子类的组合（扩展功能的组合）会导致更多子类的膨胀。
  * 如何使“对象功能的扩展”能够根据需要来动态的实现？同时避免“扩展功能的增多”带来的子类膨胀问题？从而使得任何“功能扩展变化”所导致的影响降为最低？

* 代码实现

  * `非模式`

  ```java
  public class Stream {
    public abstract void read();
  }
  
  public class FileStream extends Stream {
    @override
    public void read(){
      //读取文件内容
    }
  }
  
  public class NetworkStream extends Stream {
    @override
    public void read(){
      //网络读取内容
    }
  }
  
  public class CryptoFileStream extends FileStream {
    @override
    public void read(){
      // ... 加密操作
      super.read();
    }
  }
  
  public class BufferedFileStream extends FileStream {
    @override
    public void read(){
      // ... 缓存操作
      super.read();
    }
  }
  
  public class CryptoBufferedFileStream extends FileStream {
    @override
    public void read(){
      // ... 加密并缓存操作
      super.read();
    }
  }
  
  public class CryptoNetworkStream extends NetworkStream {
    @override
    public void read(){
      // ... 加密操作
      super.read();
    }
  }
  
  public class BufferedNetworkStream extends NetworkStream {
    @override
    public void read(){
      // ... 缓存操作
      super.read();
    }
  }
  
  public class CryptoBufferedNetworkStream extends NetworkStream {
    @override
    public void read(){
      // ... 加密并缓存操作
      super.read();
    }
  }
  
  //大量子类继承父类病扩展新的功能，但是各个子类可能又有交叉相似的操作，继承较近的父类吧，其实它们也并没有很明显相似性，使用最开始的父类吧，导致大量重复的操作。违背了单一职责；组合。
  
  // 简单改一下
  
  // 继承自Stream是为了继承规范统一的操作，组合Stream是为了应对不同类型的组合操作
  public class CryptoStream extends Stream {
    private Stream stream; // = ...各种Stream
  
    public CryptoStream(Stream stream) {
      this.stream = stream;
    }
  
    @override
    public void read(){
      // ... 加密操作
      stream.read();
    }
  }
  
  //但是这样就会有很多子类都持有Stream，应该提一下
  public class DecoratorStream extends Stream {
    protected Stream stream;
  
    public DecoratorStream(Stream stream) {
      this.stream = stream;
    }
  
    @override
    public void read(){
      stream.read();
    }
  }
  
  //再改一下
  public class CryptoStream extends DecoratorStream {
    public CryptoStream(Stream stream) {
      super(stream);
    }
  
    @override
    public void read(){
      // ... 加密操作
      super.read();
    }
  }
  ```

  * `模式`

  ```java
  public abstract class Component{
    public abstract void operation();
  }
  
  public class ConcreteComponent extends Component {
    @Override
    public void operation(){
      // ...
    }
  }
  
  public class Decorator extends Component {
    protected Component component;
  
    public Decorator(Component component){
      this.component = component;
    }
  
    @Override
    public void operation(){
      // ...
    }
  }
  
  public ConcreateDecoratorA extends Decorator {
    public ConcreateDecoratorA(Component component){
      super(component);
    }
  
    @Override
    public void operation(){
      // ...
      super.operation();
    }
  }
  
  public ConcreateDecoratorB extends Decorator {
    public ConcreateDecoratorB(Component component){
      super(component);
    }
  
    @Override
    public void operation(){
      // ...
      super.operation();
    }
  }
  ```

* 要点总结

  * 通过采用`组合`而`非继承`的手法，Decorator模式实现了在`运行时动态扩展`对象功能的能力，而且可以根据需要扩展多个功能。避免了使用继承带来的“`灵活性差`”和“`多子类衍生`问题”。
  * Decorator类在`接口上`表现为`is-a` Component的`继承关系`，即Decorator类继承了Component类所具有的接口。但在`实现上`又表现为`has-a` Component的`组合关系`，即Decorator类又使用了另外一个Component类。
  * Decorator模式的目的并非解决“多子类衍生的多继承”问题，Decorator模式应用的要点在于解决“主体类在`多个方向`上的`扩展`功能”------是为“装饰”的含义。
#### Bridge

```
	将抽象部分（`业务功能`）与实现部分（`平台实现`）分离，使它们都可以独立的变化。
																																					---<<设计模式>> GOF
```


  * UML

  * 动机

    * 由于某些类型的`固有的实现逻辑`，使得它们具有`两个变化的维度`，乃至`多个维度的变化`。
    * 如何应对这种“多维度的变化”？如何利用面向对象技术来使得类型可以轻松地沿着两个乃至多个方向变化，而不引入额外的复杂度？
    
  * 代码实现
  
    * `非模式`
    
    ```java
    public abstract class Messager {
      public abstract void login();
      public abstract void sendMessage();
      public abstract void sendPicture();
    
      public abstract void playSound();
      public abstract void drawShape();
      public abstract void writeText();
      public abstract void connect();
    }
    
    public abstract class PCMessagerBase extends Messager{
      @Override
      public void playSound(){
        // ..
      }
    
      @Override
      public void drawShape(){
        // ..
      }
    
      @Override
      public void writeText(){
        // ..
      }
    
      @Override
      public void connect(){
        // ..
      }
    }
    
    public abstract class MobileMessagerBase extends Messager{
      @Override
      public void playSound(){
        // ..
      }
    
      @Override
      public void drawShape(){
        // ..
      }
    
      @Override
      public void writeText(){
        // ..
      }
    
      @Override
      public void connect(){
        // ..
      }
    }
    
    public PCMessagerLite extends PCMessagerBase{
      @Override
      public void login(){
        connect();
        // ...
      }
    
      @Override
      public void sendMessage(){
        writeText();
        // ...
      }
    
      @Override
      public void sendPicture(){
        drawShape();
        // ...
      }
    }
    
    public PCMessagerPerfact extends PCMessagerBase{
      @Override
      public void login(){
        playSound();
        // ...
        connect();
        // ...
      }
    
      @Override
      public void sendMessage(){
        playSound();
        // ...
        writeText();
        // ...
      }
    
      @Override
      public void sendPicture(){
        playSound();
        // ...
        drawShape();
        // ...
      }
    }
    
    public MobileMessagerLite extends MobileMessagerBase{
      @Override
      public void login(){
        connect();
        // ...
      }
    
      @Override
      public void sendMessage(){
        writeText();
        // ...
      }
    
      @Override
      public void sendPicture(){
        drawShape();
        // ...
      }
    }
    
    public MobileMessagerPerfact extends MobileMessagerBase{
      @Override
      public void login(){
        playSound();
        // ...
        connect();
        // ...
      }
    
      @Override
      public void sendMessage(){
        playSound();
        // ...
        writeText();
        // ...
      }
    
      @Override
      public void sendPicture(){
        playSound();
        // ...
        drawShape();
        // ...
      }
    }
    
    //扩展后子类数目庞大，该用组合重构一下，提炼两个类
    public MessagerLite {
      private Messager messager;
    
      // ... constractor
    
      @Override
      public void login(){
        messager.connect();
        // ...
      }
    
      @Override
      public void sendMessage(){
        messager.writeText();
        // ...
      }
    
      @Override
      public void sendPicture(){
        messager.drawShape();
        // ...
      }
    }
    
    public MessagerPerfact {
      private Messager messager;
    
      // ... constractor
    
      @Override
      public void login(){
        messager.playSound();
        // ...
        messager.connect();
        // ...
      }
    
      @Override
      public void sendMessage(){
        messager.playSound();
        // ...
        messager.writeText();
        // ...
      }
    
      @Override
      public void sendPicture(){
        messager.playSound();
        // ...
        messager.drawShape();
        // ...
      }
    }
    
    //紧接着，类层次结构非常接近Decorator模式，但*MessagerBase并不是普通类而是抽象类，只实现了部分方法，该抽象无法使用Decorator模式来进行扩展。
    //那么Messager中部分方法被实现部分未实现，可以拆分成两个类，让不同的类去实现
    public abstract class Messager {
      public abstract void login();
      public abstract void sendMessage();
      public abstract void sendPicture();
    }
    
    public abstract class MessagerImp {
      public abstract void playSound();
      public abstract void drawShape();
      public abstract void writeText();
      public abstract void connect();
    }
    
    public abstract class MobileMessagerBase extends MessagerImp {
      // ...
    }
    
    public MessagerLite extends Messager {
      private MessagerImp messagerImp;
      // ...
    }
    
    public MessagerPerfact extends Messager {
      private MessagerImp messagerImp;
      // ...
    }
    
    //针对MessagerLite、MessagerPerfact中都包含MessagerImp，需要再提到一个父类中
    
    public abstract class Messager {
      private MessagerImp messagerImp;
    
      public abstract void login();
      public abstract void sendMessage();
      public abstract void sendPicture();
    }
    
    public abstract class MessagerImp {
      public abstract void playSound();
      public abstract void drawShape();
      public abstract void writeText();
      public abstract void connect();
    }
    
    public abstract class MobileMessagerBase extends MessagerImp {
      // ...
    }
    
    public MessagerLite extends Messager {
      // ...
    }
    
    public MessagerPerfact extends Messager {
      // ...
    }
    ```
    
    * `模式`
    
    ```java
    // 平台层抽象
    public abstract class Abstraction {
      protected Implementor implementor;
    
      public Abstraction(Implementor implementor){
        this.implementor = implementor;
      }
    
      public abstract void operation();
    }
    
    // 业务层抽象
    public abstract class Implementor {
      public abstract void operationImp();
    }
    
    public class RefinedAbstraction extends Abstraction {
      public RefinedAbstraction(Implementor implementor){
        super(implementor);
      }
    
      public void operation(){
        // ...
        implementor.operationImp();
      }
    }
    
    public class ConcreteImplementorA extends Implementor {
      public void operationImp(){
        // ...
      }
    }
    
    public class ConcreteImplementorB extends Implementor {
      public void operationImp(){
        // ...
      }
    }
    ```
    
* 要点总结
  
  * Bridge模式使用“对象间的`组合`关系”解藕了`抽象`和`实现`之间固有的绑定关系，使得抽象和实现可以沿着各自的维度来变化。所谓抽象和实现沿着各自维度的变化，即“子类化”它们。
  * Bridge模式有时候类似于`多继承`方案，但是多继承方案往往违背`单一职责`原则（即一个类只有一个变化的原因），复用性比较差。Bridge模式是比多继承方案更好的解决方案。
  * Bridge模式的应用一般中“两个非常强的变化维度”，有时一个类有多于两个的变化维度，这是可以使用Bridge的扩展模式。

### 对象创建

* 通过“对象创建”模式绕开`new`，来避免对象创建（new）过程中所导致的`紧耦合`（`依赖具体类`），从而支持对象创建的稳定。它是接口抽象之后的第一步工作。
* 典型模式
  * Factory Method
  * Abstract Factory
  * Prototype
  * Builder


#### Factory Method

```
	定义一个用于`创建对象`的`接口`，让子类决定实例化哪一个类。Factory Method使得一个类的实例话延迟（目的：`解耦`，手段：`接口`函数）。
																																					---<<设计模式>> GOF
```

* UML
  
* 动机
  
  * 在软件系统中，经常面临着`创建对象`的工作；由于`需求的变化`，需要创建的对象的具体`类型经常变化`。
  * 如何应对这种变化？如何绕开常规的对象创建方法（new），提供一种“封装机制”来避免客户程序和这种“具体对象创建工作”的紧耦合？
  
* 代码实现

  * `非模式`

  ```java
  public class MainFormClass{
  
    public void oper(){
      FileSplitter splitter = new FileSplitter();
      splitter.oper();
  
      ImgSplitter imgSplitter = new ImgSplitter();
      imgSplitter.oper();
  
      // 大量同类型处理，创建大量类
    }
  }
  
  public class FileSplitter{
    public void oper(){
      // ...
    }
  }
  
  public class ImgSplitter{
    public void oper(){
      // ...
    }
  }
  
  //依赖于具体的类，当需求变更时，会大量依赖于new来创建新类，同时高层模型依赖低层具体模型也不好，需要添加抽象来隔离
  
  //加个抽象
  public abstract class Splitter {
    public abstract void oper();
  }
  
  public class FileSplitter extends Splitter {}
  public class ImgSplitter extends Splitter {}
  
  public class MainFormClass{
  
    public void oper(){
      Splitter splitter = new FileSplitter();
      splitter.oper();
  
      Splitter imgSplitter = new ImgSplitter();
      imgSplitter.oper();
  
      // 但创建时还是依赖于具体的类，还是依赖了具体类，怎么办？不用new还能咋办？有new就会依赖于具体类。用某个方法来return一个实例，达到运行时绑定，动态支持。
    }
  }
  
  //再改下
  public abstract class Splitter {
    public abstract void oper();
  }
  
  public class FileSplitter extends Splitter {}
  public class ImgSplitter extends Splitter {}
  
  public class SplitterFactory {
    public static Splitter createSplitter(){
      return new ImgSplitter();
    }
  }
  
  public class MainFormClass{
  
    public void oper(){
      Splitter imgSplitter = SplitterFactory.createSplitter();
      imgSplitter.oper();
  
      // 间接的new，但是如果其他的类呢，再创建一个方法来创建具体类。还是依赖具体类，工厂再提供一层抽象
    }
  }
  
  // 再改
  public interface SplitterFactory {
    public Splitter createSplitter();//多态new
  }
  
  //提供具体工厂
  public FileSplitterFactory implements SplitterFactory {
    @Override
    public Splitter createSplitter(){
      return new FileSplitter();
    }
  }
  
  public class MainFormClass{
    SplitterFactory factory;
  
    // 将类的内部强依赖，抛到了调用客户端，这样MainFormClass可以达到最大的灵活度
    public MainFormClass(SplitterFactory factory){
      this.factory = factory;
    }
  
    public void oper(){
      Splitter imgSplitter = factory.createSplitter();
      imgSplitter.oper();
    }
  }
  ```

  * `模式`

  ```java
  //稳定部分
  public abstract class Product {}
  
  public interface Creator {
    public Product factoryMethod();
  }
  
  //变化部分
  public class ConcreteProduct extends Product {}
  
  public class ConcreteCretor implements creator {
    @Override
    public Product factoryMethod(){
      return new ConcreteProduct();
    }
  }
  ```

* 要点总结

  * Factory Method模式用于`隔离类对象的使用者`和`具体类型`之间的耦合关系。面对一个经常变化的具体类型，紧耦合关系（new）会导致软件的脆弱。
  * Factory Method模式通过面向对象的手法，将所要创建的具体对象工作`延迟`到子类，从而实现一种`扩展`（而非更改）的策略，较好地解决了这种紧耦合关系。
  * Factory Method模式解决“单个对象”的需求变化。`缺点`在于要求`创建方法/参数`相同。

#### Abstract Factory

```
	提供一个`接口`，让该接口负责创建`一系列`“`相关`或者`相互依赖`的对象”，无需指定它们具体的类。
																																					---<<设计模式>> GOF
```

- UML

* 动机

  - 在软件系统中，经常面临着“`一系列`相互依赖的对象”的创建工作；同时，由于需求的变化，往往存在更多系列对象的创建工作。
  - 如何应对这种变化？如何绕开常规的对象创建方法（new），提供一种“封装机制”来避免客户程序和这种“`多系列`具体对象创建工作”的紧耦合？

* 代码实现

  - `非模式`

  ```java
  public class MainClass {
    public static void mian(String[] args){
      Product1Factory product1Factory = new Product1Factory();
      Product1 product1 = product1Factory.create();
  
      Product2Factory product2Factory = new Product2Factory();
      Product2 product2 = product2Factory.create();
  
      Product3Factory product3Factory = new Product3Factory();
      Product3 product3 = product3Factory.create();
    }
  }
  
  //面对具有相关性的多个类型的对象创造，会有大量的工厂类，可不可以用一个工厂来生成不同的类，生产一组相关性组件
  ```

  - `模式`

  ```java
  public abstract Product1 {}
  public abstract Product2 {}
  
  public interface Creator {
    public Product1 createProduct1();
    public Product2 createProduct2();
  }
  
  public ConcreteProduct1 extends Product1 {}
  public ConcreteProduct2 extends Product2 {}
  
  public ConcreteCreator implements Creator {
    @Override
    public Product1 createProduct1(){
      return new ConcreteProduct1();
    }
  
    @Override
    public Product2 createProduct2(){
      return new ConcreteProduct2();
    }
  }
  ```
- 要点总结
  
    - 如果没有应对“`多系列`对象构件”的需求变化，则没有必要使用Abstract Factory模式，这时候使用简单的工厂完全可以。
    - “系列对象”指的是在某一`特定系列`下的对象之间有相互`依赖`、或`作用`的关系。不同系列的对象之间不能相互依赖。
  - Abstract Factory模式主要在于应对“`新系列`”的需求变动。其缺点在于难以应对“新对象”的需求变动。
  
#### Prototype

```
  使用`原型实例`指定创建对象的种类，然后通过`拷贝`这些原型来创建新的对象。
  																																				---<<设计模式>> GOF
```

  - UML

  - 动机

    - 在软件系统中，经常面临着“某些`结构复杂`的对象”的创建工作；由于需求的`变化`，这些对象经常面临着剧烈的变化，但是它们却拥有比较`稳定一致的接口`。
    - 如何应对这种变化？如何想“客户程序（使用这些对象的程序）”隔离出“这些易变对象”，从而使得“依赖这些易变对象的客户程序”不随着需求改变而改变？
  
  - 代码实现
  
    - `非模式`
    
    ```java
    public abstract class Splitter {
      public abstract void oper();
    }
    
    public interface SplitterFactory {
      public Splitter createSplitter();//多态new
    }
    
    // 合并二者
    public abstract class Splitter {
      public abstract void oper();
    
      public abstract Splitter clone();//生成自己的副本实例
    }
    
    public BinarySplitter extends Splitter {
      @Override
      public void oper(){
        // ...
      }
    
      @Override
      public abstract Splitter clone(){
        // clone
      }
    }
    
    // 将工厂方法中产品和工厂合并
    ```
  
    - `模式`
    
    ```java
    public interface Prototype extends Cloneable {
      public Prototype clone();
    }
    
    public ConcretePrototype1 extends Prototype {
      @Override
      public Prototype clone(){
        // ... clone 深度
      }
    }
    
    public ConcretePrototype2 extends Prototype {
      @Override
      public Prototype clone(){
        // ... clone 深度
      }
    }
    
    public class Client {
      public void oper(){
        // ... Prototype clone
      }
    }
    
    //这样能干嘛？什么时候用？也工厂方法有啥区别？某些复杂结构类的初始化创建比较复杂，通过深度clone会比工厂方法更方便。深度clone即复制对象的值而非引用
    ```
    
- 要点总结
  
    - Prototype模式同样用于隔离类对象的`使用者`和`具体类型`（易变类）之间的耦合关系，它同样要求这些“`易变类`”拥有“`稳定的接口`”。
    - Prototype模式对于“如何创建易变类的实体对象”采用“原型克隆”的方法来做，它使得我们可以非常灵活的动态创建“拥有某些稳定接口”的新对象------所需工作仅仅是注册一个新类的对象（即原型），然后在任何需要的地方clone。
  - Prototype模式中的clone方法可以利用某些框架中的序列化来实现深拷贝。
  
#### Builder

```
	将一个复杂对象的`构建`与其`表示`相分离，使得同样的构建过程（稳定）可以创建不同的表示（变化）。
  																																				---<<设计模式>> GOF
```

- UML
  
- 动机
  
    - 在软件系统中，有时候面临着“一个`复杂对象`”的创建工作，其通常由各个部分的`子对象`用一定的`算法`构成；由于需求的变化，这个复杂对象的`各个部分`经常面临着剧烈的`变化`，但是将它们`组合在一起的算法`却相对`稳定`。（模版方法）
    - 如何应对这种变化？如何提供一种“封装机制”来隔离出“复杂对象的各个部分”的变化，从而保存系统中的“稳定构建算法”不随着需求改变而改变？
    
- 代码实现

  - `非模式`

  ```java
  public abstract class House {
    public void House() { //构造器中定义构建过程，子类初始化是会自动调用相应的方法，但这里构造太繁琐麻烦了
      buildPart1();
  
      for(int i = 0; i < 4; i ++){
        buildPart2();
      }
  
      buildPart3();
      buildPart4();
      buildPart5();
    }
  
    public abstract void buildPart1();
    public abstract void buildPart2();
    public abstract void buildPart3();
    public abstract void buildPart4();
    public abstract void buildPart5();
  }
  
  // 单一职责
  public abstract class House{}
  
  public abstract class HouseBuilder{
    public final House build(){
      buildPart1();
  
      for(int i = 0; i < 4; i ++){
        buildPart2();
      }
  
      buildPart3();
      buildPart4();
      buildPart5();
    }
  
    public abstract void buildPart1();
    public abstract void buildPart2();
    public abstract void buildPart3();
    public abstract void buildPart4();
    public abstract void buildPart5();
  }
  
  //每种类型的构造都需要继承HouseBuilder，但这样过度依赖于具体Builder，抽象具体的构建类
  public class HouseDirector {
    private HouseBuilder builder;
  
    public HouseDirector(HouseBuilder builder){ //通过构造器传入不同的Builder实现动态绑定
      this.builder = builder;
    }
  
    public House build(){
      builder.buildPart1();
  
      for(int i = 0; i < 4; i ++){
        builder.buildPart2();
      }
  
      builder.buildPart3();
      builder.buildPart4();
      builder.buildPart5();
    }
  }
  
  public abstract class HouseBuilder{
    public abstract void buildPart1();
    public abstract void buildPart2();
    public abstract void buildPart3();
    public abstract void buildPart4();
    public abstract void buildPart5();
  }
  ```

  - `模式`

  ```java
  public class Product{}
  
  public class Director {
    private Builder builder;
  
    public Director(Builder builder){
      this.builder = builder;
    }
  
    public Product build(){
      builder.build1();
      builder.build2();
      builder.build3();
      return builder.getResult();
    }
  }
  
  public interface Builder {
    public void build1();
    public void build2();
    public void build3();
    public Product getResult();
  }
  
  public class ContreteBuilder implements Builder {
    private Product product;
  
    public void build1(){
      // ...
    }
  
    public void build2(){
      // ...
    }
  
    public void build3(){
      // ...
    }
  
    public Product getResult(){
      // ... return a result by build*
      return product;
    }
  }
  ```

- 要点总结

  - Builder模式主要用于“`分步骤`构建一个复杂的对象”。在这其中“分步骤”是一个`稳定`的算法，而复杂对象的`各个部分`则`经常变化`。
  - 变化点在哪里，封装哪里------Builder模式主要在于应对“复杂对象各个部分”的频繁需求变动。其缺点在于难以应对“分步骤构建算法”的需求变动。
  - 在Builder模式中，要注意不同语言中构造器内调用抽象函数的差别。
### 对象性能

  - 面向对象很好地解决了“`抽象`”的问题，但是必不可免地要付出一定的代价。对于通常情况来讲，面向对象的成本大都可以忽略不计。但是某些情况，面向对象所带来的成本必须谨慎处理。
  - 典型模式
      - Singleton
    - Flyweight

  #### Singleton

```
	保证一个类仅有一个实例，并提供一个该实例的全局访问点。
   																																				---<<设计模式>> GOF
```

- UML
  
- 动机
  
    - 在软件系统中，经常有这样一些特殊的类，必须保证它们中系统中只存在`一个实例`，才能确保它们的`逻辑正确性`、以及`良好的效率`。
    - 如何`绕开`常规的`构造器`，提供一种机制来保证一个类只有一个实例？
    - 这应该是类设计者的责任，而不是使用者的责任。
    
- 代码实现

  - `非模式`

  ```java
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
   * 双重校验，但由于内存读写reorder不安全，指令重排序
   * 指令序列：并不一定会按照编写顺序执行
   */
  class Singleton7{
    private static volatile Singleton7 singleton;
  
    private Singleton7(){}
  
    public static Singleton7 getInstance(){
      if (singleton == null){
        synchronized (Singleton7.class){
          if (singleton == null){
            singleton = new Singleton7();//加载类、校验类、分配内存、初始化静态成员、初始化标准模式值、调用构造器、返回引用地址，cpu中这些顺序可能重排序，可能分配内存后就返回内存地址，但对象并未初始化，并不能使用，这里需要编译器优化，java中volatitle关键字就有效的保证了不重排序优化
            return singleton;
          }
        }
      }
      return singleton;
    }
  }
  
  // 构造私有化，避免一些线程安全问题，利用锁、类加载机制
  ```

  - `模式`

  ```java
  public class Singleton {
    private Singleton instance;
  
    private Singleton(){}
  
    public static getInstance(){
      if(instance == null){
        instance = new Singleton();
      }
      return instance;
    }
  }
  ```
  
- 要点总结

    - Singleton模式中的实例构造器可以设置为protected以允许子类派生。
    - Singleton模式一般不要支持开背构造函数和clone，因为这有可能导致多个对象实例，与Singleton模式的初衷违背。
    - 如何实现多线程安全？注意对双检查锁的正确实现。
#### Flyweight

```
	运用共享技术有效地支持大量细粒度的对象。 
																																					---<<设计模式>> GOF
```

  - UML

  - 动机

    - 在软件系统采用纯粹对象方案的问题在于大量`细粒度的对象`会很快充斥在系统中，从而带来很高的运行时代价------主要指`内存需求`方案的代价。
    - 如何在避免大量细粒度对象问题的同时，让外部客户程序仍然能够透明的使用面向对象的方式来进行操作？
    - 比如字符串的使用，常常占用大量内存；字符串大多使用共享技术；

  - 代码实现

    - `非模式`

    ```java
    //字体
    public class Font{}
    
    public class FontFactory {
      Map<String, Font> fontPool = new HashMap<>();
    
      public Font getFont(String key){
        if(flyweights.containsKey(key)){
          return flyweights.get(key);
        }else{
          // new flyweight
          // flyweights.put(key, flyweight)
          // return flyweight
        }
      }
    }
    ```

    - `模式`

    ```java
    public abstract class Flyweight{
      public abstract void oper();
    }
    
    public class FlyweightFactory {
      Map<Ojbect, Flyweight> flyweights = new HashMap<>();
    
      public void getFlyweight(Object key){
        if(flyweights.containsKey(key)){
          return flyweights.get(key);
        }else{
          // new flyweight
          // flyweights.put(key, flyweight)
          // return flyweight
        }
      }
    }
    
    public class ConcreteFlyweight extends Flyweight {
      @Override
      public void oper(){
        // ...
      }
    }
    
    public class UnsharedConcreteFlyweight extends Flyweight {
      @Override
      public void oper(){
        // ...
      }
    }
    ```

  - 要点总结
  
    - 面向对象很好地解决了抽象性的问题，但是作为一个运行在机器中的程序实体，我们需要考虑对象的代价问题。Flyweight主要解决面向对象的代价问题，一般不触及面向对象的抽象问题。
    - Flyweight采用对象`共享`的做法来降低系统中对象的个数，从而降低细粒度对象给系统带来的内存压力。在具体实现方面，要注意对象状态的处理。
    - 对象的数量太大从而导致对象内存开销加大------什么样的数量才算大？这需要我们仔细的根据具体应用情况进行评估，而不能凭空臆断。

  ### 接口隔离

  - 在`组件`构建过程中，某些`接口之间直接的依赖`常常会带来很多问题、甚至根本无法实现。采用添加一层`间接`(稳定)接口，来隔离本来互相紧密关联的接口是一种常见的解决方案。
  - 典型模式
    - Facade
    - Proxy
    - Mediate
    - Adapter

  #### Facade

```
	为子系统中的一组接口提供一个一致（`稳定`）的界面，Facade模式定义了一个`高层接口`，这个接口使得这一子系统更加容易使用（复用）。
																																					---<<设计模式>> GOF
```

  - UML
  
  - 动机
  
    - `组件的客户`和`组件中各种复杂的子系统`有了过多的`耦合`，随着外部客户程序和各子系统的演化，这种过多的耦合面临很多变化的挑战。
    - 如何简化外部客户程序和系统间的交互接口？如何将外部客户程序的演化和内部子系统的变化之间的依赖相互解藕？
  
  - 代码实现
  
    - `非模式`
    
    ```java
    
    ```
  
    - `模式`
    
    ```java
    
    ```
  
  - 要点总结

      - 从客户程序的角度来看，Facade模式简化了整个组件系统的接口，对于组件内部与外部客户程序来说，达到了一种“解耦”的效果------内部子系统的任何变化不会影响到Facade接口的变化。
      - Facade设计模式更注重从`架构`的层次去看整个系统，而不是单个类的层次。Facade很多时候更是一种架构设计模式。
      - FAcade设计模式并`非`一个`集装箱`，可以任意的放进任何多个对象。Facade模式中组件的内部应该是“相互`耦合关系`比较大的一系列组件”，而不是简单的功能集合。
      - 对外松耦合，对内高内聚。

#### Proxy

```
	为其他对象提供一种代理以控制（`隔离`，使用接口）对这个对象的访问。
																																					---<<设计模式>> GOF
```

- UML

- 动机

  - 在面向对象系统中，有些对象由于某种原因（比如对象创建的开销很大，或者某些操作需要安全控制，或者需要进程外的访问等），直接访问会给使用者、或者系统结构带来很多麻烦。
  - 如何在不失去`透明操作`对象的同时来`管理/控制`这些对象特有的复杂性？增加一层`间接层`是软件开发中常见的解决模式。

- 代码实现

  - `非模式`

  ```java
  public abstract class Subject{
    public abstract void request();
  }
  
  public RealSubject extends Subject{
    @Override
    public void request(){
      // ...
    }
  }
  
  public Client {
    private Subject subject;
  
    public Client(Subject subject){
      this.subject = subject;
    }
  
    public void do(){
      // ...
      subject.request();
      // ...
    }
  }
  ```

  - `模式`

  ```java
  public abstract class Subject{
    public abstract void request();
  }
  
  public class Proxy extends Subject{
    private Subject subject;
  
    public Proxy(Subject subject){
      this.subject = subject;
    }
  
    @Override
    public void request(){
      subject.request();
    }
  }
  
  public RealSubject extends Subject{
    @Override
    public void request(){
      // ... 对realSubject的间接访问
    }
  }
  ```

- 要点总结

  - “增加一层`间接层`”是软件系统中对很多复杂问题的一种常见解决方法。在面向对象系统中，直接使用某些对象会带来很多问题，作为间接层的proxy对象便是解决这一问题的常用手段。
  - 具体proxy设计模式的`实现方法`、`实现粒度`都相差很大，有些可能对单个对象做细粒度的控制，如copy-on-write技术，有些可能对组件模式提供抽象代理层，在架构层次对对象做proxy。
  - proxy并不一定要求保持接口完整的一致性，只要能够实现间接控制，有时候损及一些透明性是可以接受的。

#### Adapter

```
	将一个类的接口转换成客户希望的另一个接口。Adapter模式使得原本由于接口`不兼容`而不能一起工作的那些类可以一起工作。
																																					---<<设计模式>> GOF
```

- UML

- 动机

  - 在软件系统中，由于应用环境的变化，常常需要将“一些现存的对象”放在新的环境应用中，但是新环境要求的接口是这些现存对象所不满足的。
  - 如何应对这种“迁移的变化”？如何既能利用现有对象的良好表现，同时又能满足新的应用环境所要求的接口？

- 代码实现

  - `非模式`

  ```java
  // 目标接口
  public abstract class Target{
    public abstract void process();
  }
  
  //遗留接口
  public abstract class Adaptee{
    public abstract void foo();
  }
  
  // 怎么把遗留接口适用于新接口，而不改变遗留接口，添加中间/间接层匹配
  ```

  - `模式-组合`

  ```java
  public abstract class Target{
    public abstract void request();
  }
  
  public class Adaptee{
    public void specificRequest(){
      // ...
    }
  }
  
  //组合实现 更灵活
  public class Adapter extends Target{
    private Adaptee adaptee;
  
    public Adapter(Adaptee adaptee){
      this.adaptee = adaptee;
    }
  
    @Override
    public void request(){
      adaptee.specificRequest();
    }
  }
  ```

  - `模式-继承`

  ```java
  public interface Target{
    public void request();
  }
  
  public class Adaptee{
    public void specificRequest(){
      // ...
    }
  }
  
  //继承实现	过度依赖父类，不灵活
  public class Adapter extends Adaptee implements Target{
    @Override
    public void request(){
      super.specificRequest();
    }
  }
  ```

- 要点总结

  - Adapter模式主要应用于“希望复用一些现存的类，但是接口又与复用环境要求不一致”，中遗留代码复用、类库迁移等方面非常有用。
  - GOF 23 定义了两种Adapter模式等实现结构：对象适配器和类适配器。但类适配器采用“多继承”但实现方式，一般不推荐使用。对象适配器采用“对象组合”的方式，更符合松耦合精神。
  - Adapter模式可以实现的非常靓货，不必拘泥于GOF 23中定义的两种结构。例如，完全可以将Adapter模式中“现存对象”作为新的接口方法参数，来达到适配的目的。

#### Mediate

```
	用一个`中介对象`来`封装`（封装变化）一系列的`对象交互`。中介者使得对象不需要`显式`的相互引用（编译时依赖->运行时依赖），从而使其耦合松散（管理变化），而且可以独立的改变他们之间的交互。
																																					---<<设计模式>> GOF
```

- UML

- 动机

  - 在软件构建过程中，经常会出现`多个对象`互相`关联交互`的情况，对象之间常常会维持一种复杂的应用关系，如果遇到一些需求的更改，这种直接的应用关系将面临不断的变化。
  - 在这种情况下，我们可以使用一个“中介对象”来`管理对象间的关联关系`，避免相互交互的对象之间的紧耦合引用关系，从而更好的抵御变化。
  - 调用通知规范？

- 代码实现

  - `非模式`

  ```java
  
  ```

  - `模式`

  ```java
  
  ```

- 要点总结

  - 将多个对象间复杂的关联关系解耦，Mediator模式将多个对象间的控制逻辑进行集中管理，变“多个对象交互关联”为“多个对象和一个中介者关联”，简化了系统的维护，抵御了可能的变化。
  
- 随着控制逻辑的复杂化，Mediator具体对象的实现可能相当复杂，这时候可以对Mediator对象进行分解处理。
  - Facade模式是解耦系统间（单向）的对象关联关系；Mediator模式是解耦系统内各个对象间（双向）的关联关系。
  
  ### 状态变化

  - 在`组件构建`过程中，某些`对象的状态`经常面临变化，如何对这些变化进行有效的管理？同时又维持高层模块的稳定？“状态变化”模式为这一问题提供了一种解决方案。
  
- 典型模式
    - State
    - Memento

#### State

```
  	允许一个对象在其内部状态改变时改变它的行为。从而使对象看起来似乎修改了其行为。
  																																			---<<设计模式>> GOF
```

  - UML
  
  - 动机
  
    - 在软件构建过程中，某些对象的`状态`如果改变，其`行为`也会随之而发生变化，比如文档处于只读状态，其支持的行为和读写状态支持的行为就可能完全不同。
    - 如何在运行时根据对象的状态来透明地更改对象的行为？而不会为对象操作和状态转化之间应如紧耦合？
  
  - 代码实现
  
    - `非模式`
  ```java
    enum NetworkState {
      Network_Open;
      Network_Close;
      Network_Connect;
    }
    //这里的枚举会不会添加新的状态？开闭原则
    
    public class NetworkProcessor {
      private NetworkState state;
    
      public void oper1(){
        if(state == Network_Open){
          // ...
          state = Network_Close;
        }else if(state == Network_Close){
          // ...
          state = Network_Connect;
        }else if(state == Network_Connect){
          // ...
          state = Network_Open;
        }
      }
    
      public void oper1(){
        if(state == Network_Open){
          // ...
          state = Network_Connect;
        }else if(state == Network_Close){
          // ...
          state = Network_Open;
        }else if(state == Network_Connect){
          // ...
          state = Network_Close;
        }
      }
    }
    
    //如果状态发生改变，则行为也会发生改变；有点像策略模式；但和策略又有些不同，策略提供指定算法操作，而状态的变更引起的操作怎么处理？针对每种状态提供对对应的操作，这样就扩展开放修改封闭了。
    public abstract class NetworkState{ 
      protected NetworkState nextState;
    
      public NetworkState(NetworkState nextState){
        this.nextState = nextState;
      }
    
      public abstract void oper1();
      public abstract void oper2();
      public abstract void oper2();
    }
    
    public class OpenState extends NetworkState{
      private static NetworkState state;
    
      private OpenState(){
      }
    
      public static NetworkState getInstance(){
        if(state == null){
          state = new OpenState();
        }
        return state;
      }
    
      @Override
      public void oper1(){
        nextState = CloseState.getInstance();
      }
    
      @Override
      public void oper2(){
        nextState = ConnectState.getInstance();
      }
    
      @Override
      public void oper3(){
        nextState = OpenState.getInstance();
      }
    }
    
    public class CloseState extends NetworkState{
      private static NetworkState state;
    
      private CloseState(){
      }
    
      public static NetworkState getInstance(){
        if(state == null){
          state = new CloseState();
        }
        return state;
      }
    
      @Override
      public void oper1(){
        nextState = CloseState.getInstance();
      }
    
      @Override
      public void oper2(){
        nextState = ConnectState.getInstance();
      }
    
      @Override
      public void oper3(){
        nextState = OpenState.getInstance();
      }
    }
    
    public class ConnectState extends NetworkState{
      private static NetworkState state;
    
      private ConnectState(){
      }
    
      public static NetworkState getInstance(){
        if(state == null){
          state = new ConnectState();
        }
        return state;
      }
    
      @Override
      public void oper1(){
        nextState = CloseState.getInstance();
      }
    
      @Override
      public void oper2(){
        nextState = ConnectState.getInstance();
      }
    
      @Override
      public void oper3(){
        nextState = OpenState.getInstance();
      }
    }
    
    public class NetworkProcess{
      private NetworkState state;
    
      public NetworkProcess(NetworkState state){
        this.state = state;
      }
    
      public void oper1(){
        state.oper1();
        state = state.nextState;
      }
    
      public void oper2(){
        state.oper2();
        state = state.nextState;
      }
    
      public void oper3(){
        state.oper3();
        state = state.nextState;
      }
    } 
    ```
    
  - `模式`
    ```java
  public class Context{
      private State state;
    
      public Context(State state){
        this.state = state;
      }
    
      public void request(){
        state.handle();
      }
    }
    
    public abstract class State{
      public abstract void handle();
    }
    
    public class ConcreteStateA extends State{
      public void handle(){
        // ...
      }
    }
    
    public class ConcreteStateB extends State{
      public void handle(){
        // ...
      }
    }
    ```
    
  - 要点总结
  
    - State模式将所有与一个特定状态相关的行为都放入一个State的子类对象中，在对象状态切换时，切换相应的对象；但同时维持State的接口，这样实现了具体操作与状态转换间的解耦。
    - 为不同的状态引入不同的对象使得状态转换变得更加明确，而且可以保证不会出现状态不一致的情况，因为转换是原子性的-----即要么彻底转换过来，要么不转换。
    - 如果State对象没有实例变量，那么各个上下文可以共享同一个State对象，从而节省对象开销。

  #### Memento

```
  	在不破坏`封装性`的前提下，捕获一个对象的`内部状态`，并在该对象之外保持这个状态。这样以后就可以将该对象恢复到原先保存的状态。
  																																			---<<设计模式>> GOF
```

  - UML
  
  - 动机
  
    - 在软件构建过程中，某些对象的`状态`在转换过程中，可能由于某种需要，要求程序能够`回溯`到对象之前处于某个点时到状态。如果使用一些公有接口来让其他对象得到对象的状态，便会暴露对象的细节实现。
    - 如何实现对像状态的良好保持与恢复？但同时不会因此而破坏对象本身的封装性。
  
  - 代码实现
  
    - `非模式`
  ```java
    
    ```
    
  - `模式`
    ```java
  public class Memento{
      private String state;
    
      public Memento(String state){
        this.state = state;
      }
    
      public String getState{return state;}
    
      public void setState(String s){state = s;}
    }
    
    public class Originator{
      private String state;
    
      public Originator(){}
    
      public Memento createMemento(){
        Memento m = new Memento(state);
        return m;
      }
    
      public void setMemento(Memento m){
        state = m.getState();
      }
    
      public void updateState(String state){
        this.state = state;
      }
    }
    
    public class Client{
      public static void main(String[] args){
        Originator originator = new Originator();
        //存储备忘录
        Memento memento = originator.createMemento();
        //更新状态
        originator.updateState();
        //恢复
        originator.setMemento(memento)
      } 
    }
    ```
    
  - 要点总结
  
    - 备忘录（Memento）存储原发器（Originator）对象的内部状态，在需要时恢复原发器状态。
    - Memento模式的核心是信息隐藏，即Originator需要向外界隐藏信息，保持其封装性。但同时又需要将状态保持到外界（Memento）。
    - 由于现代语言运行时（如C#、Java等）都具有相当的对象序列化支持，因此往往采用效率较高、又较容易正确实现的序列化方案来实现Memento模式。

  ### 数据结构

  - 常常有一些组件在内部具有特定的`数据结构`，如果让客户程序依赖这些特定的数据结构，将极大地破坏组件的复用。这时候，将这些特定数据结构封装在内部，在外部提供统一的接口，来实现与特定数据结构无关的访问，是一种行之有效的解决方案。
  - 典型模式
    - Composite
    - Iterator
    - Chain of Resposibility

  #### Composite

```
	将对象组合成`树形结构`以表示“部分-整体”的层次结构。Composite使得用户对单个对象和组合对象的使用具有`一致性`（稳定）。
																																					---<<设计模式>> GOF
```

  - UML
  
  - 动机
  
    - 在软件某些情况下，`客户代码`过多地依赖于对象`容器`复杂的`内部实现结构`，对象容器内部实现结构（而非抽象接口）的变化将引起客户代码的频繁变化，带来了代码的维护性、扩展性等弊端。 
    - 如何将“客户代码与复杂的对象容器结构”解耦？让对象容器自己来实现自身的复杂结构，从而使得客户代码就像处理简单对象一样来处理复杂的对象容器？
  
  - 代码实现
  
    - `非模式`
  ```java
    
    ```
    
  - `模式`
    ```java
  public abstract class Component{
      public Component(){}
    
      public abstract void process();
  }
  
  public class Composite extends Component{
    private String name;
  
    private List<Component> elements;
  
    public Composite(String name){
      this.name = name;
    }
  
    public void add(Component element){
      elements.add(element);
    }
  
    public void remove(Component element){
      elements.remove(element);
    }
  
    @Override
    public void process(){
      for(Component e : elements){
        e.process(); // 多态调用   
      }
    }
  }
  
  public class Leaf extends Component{
    private String name;
  
    public Leaf(String s){
      this.name = s;
    }
  
    @Override
    public void process(){
      // ... any
    }
  }
  ```
  
  - 要点总结

      - Composite模式采用树形结构来实现普遍存在的对象容器，从而将“`一对多`”的关系转化为“`一对一`”的关系，使得客户代码可以一致的（复用）处理对象和对象容器，无需关心处理的是单个的对象，还是组合的对象容器。
      - 将“客户代码与复杂的对象容器结构”解耦是Composite的核心思想，解耦之后，客户代码将与纯粹的抽象接口------而非对象容器的内部实现结构------发生依赖，从而更能“应对变化”。
      - Composite模式在具体实现中，可以让父对象中的字对象反向追溯；如果父对象有频繁的遍历需求，可使用缓存技巧来改善效率。

  #### Iterator

```
	提供一种方法`顺序访问`一个`聚合对象`中的各个元素，而又`不暴露`（稳定/隔离变化）该对象的内部表示。
																																					---<<设计模式>> GOF
```

  - UML
  
  - 动机
  
    - 在软件构建过程中，`集合对象`内部结构常常发生变化各异。但对于这些集合对象，我们希望在不暴露其内部结构的同时，可以让外部客户代码透明的访问其中包含的元素。同时这种“透明遍历”也为“同一种算法在多种集合对象上进行操作“提供了可能。
    - 使用面向对象技术将这种遍历机制抽象为”迭代器对象”为“应对变化中的集合对象”提供了一种优雅的方式。
  
  - 代码实现
  
    - `非模式`
  ```java
    
    ```
    
  - `模式`
    ```java
  public interface Iterator<T>{
      public T first();
      public T next();
      public boolean isDone();
    public T currentItem();
  }
  
  public interface Aggregate<T>{
    public Iterator<T> createIterator();
  }
  
  public class ConcreteAggregate<T> implements Aggregate{
    // ?
  
    public Iterator<T> createIterator(){
      return new ConcreteIterator(this);
    }
  }
  
  public class ConcreteIterator<T> implements Iterator{
    private Aggregate<T> collections;
  
    public ConcreteIterator(Aggregate<T> collections){
      this.collections = collections;
    }
  
    // ...
  }
  
  //面向对象的多态调用，性能消耗大；迭代方向单一；
  ```
  
  - 要点总结

      - 迭代抽象：访问一个聚合对象的内容而无需暴露它的内部表示。
      - 迭代多态：为遍历不同的集合结构题狗一个统一的接口，从而支持同样的算法在不同的集合结构上进行操作。
      - 迭代器的健壮性考虑：遍历的同时更改迭代器所在的集合结构，会导致问题。

  #### Chain of Resposibility

```
	使`多个对象`都`有机会`处理请求，从而避免请求的发送者和接受者之间的耦合关系。将这些`对象连成一条链`，并沿着这条链`传递请求`，直到有一个对象处理它为止。
																																					---<<设计模式>> GOF
```

  - UML
  
  - 动机
  
    - 在软件构建过程中，`一个请求`可能被`多个对象`处理，但是`每个请求`在`运行时`只能有`一个接受者`，如果显示指定，将必不可少地带来请求发送者与接受者的紧耦合。
    - 如何使请求的发送者不需要指定具体的接受者？让请求的接受者自己者运行时决定来处理请求，从而使两者解耦。
  
  - 代码实现
  
    - `非模式`
  ```java
    enum RequestType{
      REQ_HANDLER1;
      REQ_HANDLER2;
    REQ_HANDLER3;
    }
  
    public class Request{
      private String desc;
    
    private RequestType req;
  
    public Request(String desc, RequestType req){
      this.desc = desc;
      this.req = req;
    }
  
    public RequestType getReq(){return req;}
  
    public String getDesc(){return desc;}
  }
  
  public abstract class ChainHandler{
    private ChainHandler nextChain;
  
    public ChainHandler(){}
  
    public void setRequestToNextHandler(Request req){
      if(nextChain != null){
        nextChain.handle(req);
      }
    }
  
    public abstract boolean canHandleRequest(Request req);
    public abstract void processRequest(Request req);
  
    public void setNextChain(ChainHandler next){
      nextChain = next;
    }
  
    public void handle(Request req){
      if(canHandleRequest(req)){
        processRequest(req);
      }else{
        setRequestToNextHandler(req);
      }
    }
  }
  
  public class Handler1 extends ChainHandler{
    @Override
    public boolean canHandleRequest(Request req){
      // ...
    }
    @Override
    public void processRequest(Request req){
      // ...
    }
  }
  
  public class Handler2 extends ChainHandler{
    @Override
    public boolean canHandleRequest(Request req){
      // ...
    }
    @Override
    public void processRequest(Request req){
      // ...
    }
  }
  
  public class Client{
    public static void main(String[] args){
      Handler1 h1 = new Handler1();
      Handler2 h2 = new Handler2();
      Handler1 h3 = new Handler1();
  
      h1.setNextChain(h2);
      h2.setNextChain(h3);
  
      REquest req = new Request("process task ...", RequestType.REQ_HANDLER#);
      h1.handle(req);
    }
  }
  ```
  
  - `模式`
  ```java
  public abstract Handler{
    private Handler next;
  
    public abstract void handleRequest();
  }
  
  public ConcreteHandler1 extends handler{
    @Override
    public void handleRequest(){
      // ....
    }
  }
  
  public ConcreteHandler2 extends handler{
    @Override
    public void handleRequest(){
      // ....
    }
  }
  ```
  
  - 要点总结

      - Chain of Responsibility模式的应用场合在于“一个请求可能有多个接受者，但是最后真正的接受者只有一个”，这时候请求发送者与接受者的耦合有可能出现“变化脆弱”的症状，职责链的目的就是将二者解耦，从而更好地应对变化。
      - 应用了Chain of Responsibility模式后，对象的`职责分派`将更具灵活性。我们可以在`运行时动态`添加/修改请求的处理职责。
      - 如果请求传递到职责链的末尾仍得不到处理，应该有一个合理的缺省机制。这也是每个接受对象的责任，而不是发出请求的对象的责任。

  ### 行为变化

  - 在组件的构建过程中，组件`行为的变化`经常导致组件本身剧烈的变化。“行为变化”模式将组件的行为和组件本身进行解耦，从而支持组件行为的变化，实现两者之间的松耦合。
  - 典型模式
    - Command
    - Vistor

  #### Command

```
	将一个请求（行为）`封装为一个对象`，从而使你可用不同的请求对客户进行参数化；对请求排队或记录请求日志，以及支持可撤销对操作。  
																																					---<<设计模式>> GOF
```

  - UML
  
  - 动机
  
    - 在软件构建过程中，“行为请求者”与“行为实现者“通常呈现一种”紧耦合“。但在某些场合---比如需要对行为进行“记录、撤销/重（undo/redo）、事务”等处理，这种无法抵御变化的紧耦合是不合适的。
    - 在这种情况下，如何将“行为请求者”与“行为实现者”解耦？将一组行为抽象为对象，可以实现二者之间的松耦合。
  
  - 代码实现
  
    - `非模式`
  ```java
    public abstract class Command{
      public abstract void execute();
    }
  
    //行为对象
  public class ConcreteCommdand1 extends Command{
      private String arg;
    
      public ConcreteCommdand1(String arg){this.arg = arg;}
  
    @Override
    public void execute(){
      // ...
      System.out.println("process 1");
    }
  }
  
  public class ConcreteCommdand2 extends Command{
    private String arg;
  
    public ConcreteCommdand2(String arg){this.arg = arg;}
  
    @Override
    public void execute(){
      // ...
      System.out.println("process 2");
    }
  }
  ```
  
  - `模式`
  ```java
  
  ```
  
  - 要点总结

      - Command模式的根本目的在于将“行为请求者”与“行为实现者”解耦，在面向对象语言中，常见的实现手段是“将行为抽象为对象”。
      - 实现Command接口的具体命令对象ConcreteCommand有时候根据需要可能会保存一些额外的状态信息。通过使用Composite模式，可以将多个“命令”封装为一个“复合命令”MacroCommand。
      - Command模式与C++中的函数对象有些类似。但两者定义行为接口的规范有所区别；Command以面向对象中的“接口-实现”来定义行为接口规范，更严格，但有性能损失；C++函数对象以函数签名来定义行为接口规范，更灵活，性能更高。

  #### Vistor

```
	表示一个作用于某个对象结构中的各元素的操作。使得可以中不改变（稳定）个元素的类的前提下定义（扩展）作用于这些元素的新操作（变化）。  
																																					---<<设计模式>> GOF
```

  - UML
  
  - 动机
  
    - 在软件构建过程中，由于`需求`的`改变`，某些`类层次`结构中常常需要`增加新的行为`（方法），如果直接在`基类`中做这样的`更改`，将会给`子类`带来很`繁重`的`变更负担`，甚至破坏原有设计。
    - 如何在不更改类层次结构的前提下，在运行时根据需要透明地为类层次结构上的各个类动态添加新的操作，从而避免上述问题？
  
  - 代码实现
  
    - `非模式`
  ```java
    public abstract class Element{
      public Element(){}
    
    public abstract void func1();
    
  }
    
    public class ElementA extends Element{
      @Override
    public void func1(){
      // ...
    }
  }
  
  public class ElementB extends Element{
    @Override
    public void func1(){
      // ...
    }
  }
  
  //如果需求变更，基类添加新行为，所有子类都要新增新行为的支持；开闭原则
  ```
  
  - `模式`
  ```java
  public abstract class Visitor{
    public Visitor(){}
  
    public abstract visitElementA(ElementA element);
    public abstract visitElementB(ElementB element);
  }
  
  public abstract class Element{
    public Element(){}
    //通过组合剥离变化
    public abstract void accept(Visitor visitor); // 第一次多态辨析
  }
  
  public class ElementA extends Element{
    @Override
    public void accept(Visitor visitor){
      // ...
      visitor.visitElementA(this);
    }
  }
  
  public class ElementB extends Element{
    @Override
    public void accept(Visitor visitor){
      // ...
      visitor.visitElementB(this);// 第二次多态辨析
    }
  }
  
  // 新需求来了
  public class Visitor1 extends Visitor{
    @Override
    public visitElementA(ElementA element){
      // ...
    }
  
    @Override
    public visitElementB(ElementB element){
      // ...
    }
  }
  
  public class Visitor2 extends Visitor{
    @Override
    public visitElementA(ElementA element){
      // ...
    }
  
    @Override
    public visitElementB(ElementB element){
      // ...
    }
  }
  
  public class Client{
    public static void main(String[] args){
      Visitor2 visitor = new Visitor2();
      ElementB element = new ElementB();
      element.accept(visitor);// double dispatch
  
      // first: accept; second: visitor.visitElement*()
    }
  }
  //Visitor稳定的前提，必须保证Element子类个数确定！但实际环境无法满足，如果Element添加子类，则Visitor基类及所有子类都要修改，还是违反了开闭原则！特别容易打破！
  ```
  
  - 要点总结

      - Visitor模式通过所谓的双重分发（double dispatch）来实现在不更改（不添加新的操作-编译时）Element类层次结构的前提下，在运行时透明地为类层次结构上的各个类动态添加新的操作（支持变化）。
      - 所谓的双重分发即Visitor模式中间包括类两个多态分发（注意其中的多态机制）：第一个为accept方法的多态辨析；第二个位visitElementX方法的多态辨析。
      - Visitor模式的最大缺点在于扩展类层次结构（增添新的Element子类），会导致Visitor类的改变。因此Visitor模式适用于“Element类层次结构稳定，而其中的操作却经常面临频繁改动“。

  ### 领域

  - 在特定领域中，某些`变化`虽然`频繁`，但可以`抽象`为某种`规则`。这时候，结合`特定领域`，将问题抽象为`语法规则`，从而给出该领域下的一般性解决方案。
  - 典型模式
    - Interpreter

  #### Interpreter

```
	给定一个语言，定义它的文法的一种表示，并定义一种解释器，这个解释器使用该表示来解释语言中的句子。
																																					---<<设计模式>> GOF
```

  - UML
  
  - 动机
  
    - 在软件构建过程中，如果某一特定领域的问题比较复杂，类似的`结构`不断`重复`出现，如果使用普通的编程方式来实现将面临非常频繁的变化。
    - 在这种情况下，将特定领域的问题表达为某种语法规则下的句子，然后构建一个解释器来解释这样的句子，从而达到解决问题的目的。
  
  - 代码实现
  
    - `非模式`
  ```java
    abstract class Expression{
      public Expression(){}
    
    public abstract int interpreter(Map<Character, Integer> var);
    }
  
    //变量表达式
    class VarExpression extends Expression{
      private char key;
  
    public VarExpression(char key){
      this.key = key;
    }
  
    @Override
    public int interpreter(Map<Character, Integer> var){
      return var.get(key);
    }
  }
  
  //符号表达式
  abstract class SymbolExpression extends Expression{
    protected Expression left;
    protected Expression right;
  
    public SymbolExpression(Expression left, Expression right){
      this.left = left;
      this.right = right;
    }
  }
  
  //加法运算
  class AddExpression extends SymbolExpression{
    public AddExpression(Expression left, Expression right){
      super(left, right);
    }
  
    @Override
    public int interpreter(Map<Character, Integer> var){
      return left.interpreter(var) + right.interpreter(var);
    }
  }
  
  //减法运算
  class SubExpression extends SymbolExpression{
    public SubExpression(Expression left, Expression right){
      super(left, right);
    }
  
    @Override
    public int interpreter(Map<Character, Integer> var){
      return left.interpreter(var) - right.interpreter(var);
    }
  }
  
  class ExpressionAnalyse{
    public static Expression analyse(String expStr){
      Stack<Expression> expStack = new Stack();
  
      Expression left = null;
      Expression right = null;
  
      for(int i = 0; i < expStr.length(); i ++){
        char[] exps = expStr.toCharArray();
        switch(exps[i]){
          case '+' :
            left = expStack.peek();
            right = new VarExpression(exps[++i]);
            expStack.push(new AddExpression(left, right));
            break;
          case '-' :
            left = expStack.peek();
            right = new VarExpression(exps[++i]);
            expStack.push(new SubExpression(left, right));
            break;
          default:
            expStack.push(new VarExpression(exps[i]));
        }
      }
  
      Expression expression = expStack.peek();
      return expression;
    }
  }
  
  public class Client{
    public static void main(String[] args){
      String expStr = "a+b-c+d";
      Map<Character, Integer> var = new HashMap();
      var.put('a', 5);
      var.put('b', 2);
      var.put('c', 1);
      var.put('d', 8);
  
      Expression expression = ExpressionAnalyse.analyse(expStr);
      int result = expression.interpreter(var);
      System.out.println(result);
    }
  }
  ```
  
  - `模式`
  ```java
  public class Context{}
  
  public abstract class AbstractExpression{
    public abstract interpret(Context context);
  }
  
  //终端表达式
  public class TerminalExpression extends AbstractExpression{
    @Override
    public interpret(Context context){
      // ...
    }
  }
  
  
  //非终端表达式
  public class NonterminalExpression extends AbstractExpression{
    @Override
    public interpret(Context context){
      // ...
    }
  }
  
  public class Client{
    public static void main(String[] args){
      Context context = new Context();
      AbstractExpression expression = new TerminalExpression();
      expression.interpret(context);
  
      expression = new NonterminalExpression();
      expression.interpret(context);
  
    }
  }
  ```
  
  - 要点总结

      - Interpreter模式的`应用场合`是Interpreter模式应用中的难点，只有满足“`业务规则频繁变化`，且类似的`结构不断重复`出现，并且`容易抽象为语法规则`的问题“才适合使用Interpreter模式。
      - 使用Interpreter模式来表示`文法规则`，从而可以使用面向对像技巧来方便的“扩展”文法。
      - Interpreter模式比较适合简单的文法表示，对于复杂的文法表示，Interpreter模式会产生比较大的类层次结构，需要求助于语法分析生成器这样的标准工具。

  ## 模式总结

* 一个目标：管理`变化`，提高`复用`！
* 两个手段：
  * 分解：寻找不同
  * 抽象：抽象思维，类型/接口
* 八大原则：
  * 依赖倒置原则（DIP）
  * 开放封闭原则（OCP）
  * 单一职责原则（SRP）
  * Liskov替换原则（LSP）
  * 接口隔离原则（ISP）
  * 对象组合优于类继承
  * 封装变化点
  * 面向接口编程
* 重构技法
  * 静态 => 动态
  * 早绑定 => 晚绑定
  * 继承 => 组合
  * 编译时依赖 => 运行时依赖
  * 紧耦合 => 松耦合
* 所有模式：继承 >> 组合 >> 多态组合（松耦合基础）
* 关注变化点和稳定点
* 什么时候不用模式？
  * 代码可读性很差时
  * 需求理解很浅时
  * 变化没有显现时
  * 不是系统的关键依赖点
  * 项目没有复用价值时
  * 项目将要发布时
* 经验
  * 不要为模式而模式
  * 关注抽象类&接口
  * 理清变化点&稳定点
  * 审视依赖关系
  * 要有Framework&Application的区隔思维
  * 良好的设计时演化的结果
* 设计模式成长之路
  * “手中无剑，心中无剑”：见模式而不知
  * “手中有剑，心中无剑”：可以识别模式，作为应用开发人员使用模式
  * “手中有剑，心中有剑“：作为框架开发人员为应用设计某些模式
  * “手中无剑，心中有剑”：忘掉模式，只有原则

  