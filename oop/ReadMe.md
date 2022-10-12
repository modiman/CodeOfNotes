# 封装继承多态

假设要抽象表示这个世界，以生物为例

每个生物都应该有一些基本属性（成员变量）、有一些行为能力（成员方法）

首先是人

```java
public class People{
    //一些基本属性
    private String type;
    private String name;
    private boolean famale;
    private int age;
    private People father;

    //构造器 
    public People(){

    }

    //行为
    public void run(){
        System.out.println("run");
    }
    public void speak(){
        System.out.println("speak");
    }
    public void write(){
        System.out.println("write");
    }

}
```

cat

```java
public class Cat {
     //一些基本属性
     private String type;
     private String name;
     private boolean famale;
     private int age;
     private Cat father;
   //构造器 
    public Cat(){

    }

    //行为
    public void run(){
        System.out.println("run");
    }
    public void speak(){
        System.out.println("speak");
    }
}
```

发现一些规律：

* 很多类是有一些公共属性的，如name、type、famale,那么每次都在类中写出这些是否冗余？**解决方案**：继承，定义一个模板类，把那些公共属性集中起来，子类只要继承这个类就自动继承了他的成员变量

**抽象一个生物类**

```java
public class Creature {
    private String type;
    private String name;
    boolean famale;
    private int age;
    
}

```

有时候不仅仅公共属性需要继承，方法也需要继承。

问题在于方法不同于属性，方法涉及到了一系列具体逻辑的处理。可每个继承的子类实现同一件事情未必使用相同的方式（世界的参差）。比如run方法，人用两条腿，猫用四条腿。在这种情况下，父类可以不直接实现run方法，而是只定义一个方法名，告诉继承他的子类他应该有这个行为，具体怎么做自己决定。

于是抽象方法和抽象类出现了

* 抽象方法指只有方法名**没有也不能有**方法体的方法
* 抽象类指有抽象方法存在的类

```java
public abstract class Creature {
    private String type;
    private String name;
    boolean famale;
    private int age; 
    
    public abstract void run();
    public abstract void eat();
}

```

**新的问题，java只能单继承**

​          思考一个问题，有一个父类A，两个子类C和D分别继承了A并各自重写了A的a方法，那么如果D同时继承B和C将不知道该去继承谁的a方法，为了避免这种菱形继承的问题，java只允许单继承。

​        菱形继承好像对上面的抽象类并不会产生影响，因为抽象类只有方法名，没有方法体。

可是由于java只能单继承，思考以下情景

* 一个类想要继承多个类的方法
* 只需要继承方法不用属性

于是**接口**应运而生了

接口更是像是一个专门描述行为的数据结构，描述一个类想要成为这个类必须具有哪些行为。

抽象类表示is a,接口表示like a

定义一个Livable接口

```java
public interface Livable {
    public void run();
    public void speak();
}
```

这种通过不同方式实现接口中的方法的操作就叫做**多态**。

接口的出现促进了面向接口编程的发展，更好的践行了**开闭原则**（即对拓展开放，对修改关闭）

