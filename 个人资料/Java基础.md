# Java基础 #
## ==和eques、hashCode区别 ##
- ==在比较基本数据时比对的是值；在比较对象时，比较的是对象的地址。
- eques是Object类的方法，在未重写该方法时，会调用 == 方法。但大多数类都重写了该方法，比对对象是否相等
- hashCode获取一个hash值，（对象的内存地址基础上经过特定算法返回一个hash码）

## int和Integer的区别 ##
- int为java中的基本数据类型默认值为0
- Integer为int的封装类型默认值为null
- 为了对数字的重复利用，java会对int和Integer进行自动装箱和拆箱操作

        Integer x = new Integer(100);
        Integer y = new Integer(100);
        int z = 100;
        Integer q = 100;
        Integer w = 100;
		//    x==y  false  对象地址
		//    z==x   true  自动拆箱
		//    q==w   true  -128-127数值相等


## JVM内存划分 ##
- 程序计数器：可以看作当前线程所执行的字节码的指示器（字节码的地址）**线程私有**
- 栈（Java栈）：每当一个线程去执行方法时，就会创建一个栈帧，用于存储局部变量表、操作数栈，动态链接、每一个方法从被调用到执行完成的过程，都对应着一个栈帧从入栈到出栈的过程**线程私有**
- 本地方法栈：和栈差不多，为Native方法（Java调用非Java代码--JNI）服务**线程私有**
- 堆：几乎存放对象（并非所有对象都在堆中）GC工作的**多线程共享**
- 方法区：用于存储已被虚拟机加载的类信息、常量、静态变量、即时编译器编译后的代码等数据**多线程共享**

## String、StringBuffer、StringBuilder区别 ##
- String常量字符串，不可变，每次操作都会生成新的对象
- StringBuilder和StringBuffer类的对象被多次修改不会产生新对象
- StringBuffer线程安全，效率低
- StringBuilder线程不安全，效率高

## 接口和抽象类的理解、区别 ##
- 抽象类：可以理解为对象方法的抽象（同一类对象有同类的方法，但是其具体对象的方法实现不一样）--多态性体现
- 接口：抽象类的极端情况，多个对象公共行为的提取（能够被调用的方法）；为了把模块固化的契约，为了降低耦合度。

### 区别 ###
**接口**

- 描述事物的社会属性和行为的复用。
- 接口中可以又自己的成员变量--但是会被隐式的指定为public static final
- 接口只定义抽象方法
- 实现接口必须实现其所有方法

**抽象类**

- 描述事物的自然属性和行为的复用
- 被abstracta修饰的类为抽象类
- 含有抽象方法的类一定是抽象类，但是抽象类不一定含有抽象方法；且抽象方法必须是public或protected，否则不能被子类继承。默认为public。
- 抽象类中可以定义自己的成员变量和成员方法；

**抽象类意义**

抽象类更利于代码的维护和重用。抽象类是对一系列看上去不同，但本质上相同的具体概念的抽象

**接口的意义**

1. 统一访问：对同一个方法在不同对象内的不同实现可以实现统一管理
2. 多重实现：java不支持多重继承，但可以实现多个借口

  

## 内部类 ##
一个类定义在另一个类的内部，或方法内部被称为内部类

- 成员内部类：在一个类内，和变量同级
	1. 内部类可以随意访问外部类成员变量（如果外部类和内部类有相同名字的变量或方法时，默认调用的是内部类的，如需调用外部类可以<外部类>.this.<方法名|字段名>）
	2. 外部类访问内部类：必须创建外部类的对象，通过指向内部类的对象的引用来访问。




- 局部内部类：在一个方法或一个作用域内，局部内部类的访问仅限于方法内或者该作用域内。
	
		class Man{
    	public Man(){
         
    	}
     
    	public People getWoman(){
        class Woman extends People{   //局部内部类
            int age =0;
        }
        return new Woman();
    	}
		}

- 匿名内部类：唯一一种没有构造器的类，大部分匿名内部类用于接口回调

- 静态内部类：静态内部类是不需要依赖于外部类的

**为什么局部内部类和匿名内部类只能访问局部final变量？**

局部内部类和外部类处于同一级别，当局部内部类引用了外部类的局部变量，外部类被回收时，局部变量一同被回收。就会导致内部类对象访问了一个不存在的变量。方法中的局部变量实际上会复制为内部类的成员变量使用。

若变量是final时：

若是基本类型，其值是不能改变的，就保证了copy与原始的局部变量的值是一样的；

若是引用类型，其引用是不能改变的，保证了copy与原始的变量引用的是同一个对象。

## 进程、线程区别 ##


- 根本区别：进程是操作系统资源分配的基本单位，线程是处理器人物调度和处理的基本单位
- 资源开销：每个进程都有自己独立的代码和数据空间，线程有自己独立的方法栈（运行栈），同类的线程组成进程，同一个进程中的线程共享代码和数据空间
- 包含关系：一个进程包含多个线程，进程执行期间是多个线程同步进行
- 内存分配：同一进程内的线程共享本进程的地址空间和资源，而进程之间的地址空间和资源独立的
- 影响关系：当一个进程崩溃时，不会引起其他进程奔溃，在一个线程奔溃时会导致它所属的进程也奔溃
- 执行过程：每个独立的进程有程序运行的入口，顺序执行序列和程序出口，但线程不能独立执行，必须依赖进程，由应用程序提供多个线程的执行控制




