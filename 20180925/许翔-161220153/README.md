# Java程序设计 第3次作业

###### 161220153 许翔

> 作业要求：以文字说明所写代码中用到哪些面向对象的概念、机制、设计理念等，并阐述这样做的好处

1. 

涉及到葫芦娃、老爷爷、蛇精、蝎子精、小喽啰等多种生物体，因此很自然地使用**继承**，有一个“生物体”父类，以及不同生物体的子类。父类有着一些共通的属性，例如名称、所在位置横纵坐标以及一些共同的方法。不过这些属性和方法都源于第2次作业，在这一次作业中目前还没有使用。

使用**继承**，可以让一些具有共同特点的类型在拥有相同的数据成员和成员函数的同时，还可以定义自己特有的数据成员和成员函数。这样，一方面，它们的共通部分只需要编写一次代码，节省了开发时间和维护成本；另一方面，允许他们定义新的成员，保证了不同类型的特点可以体现。

```java
public class Creature {
  protected String name; //共通属性
  protected int positionX;
  protected int positionY;
  ...
  public void changePosition(int x, int y){ ... } //共通方法
}

class CalabashBros extends Creature{
  private int number; //葫芦娃特有的属性，比如它们具有颜色、他们具有一个顺序关系
  private String color;
  ...
}

class GrandFather extends Creature{ ... } //其他生物体同理
```

不同的阵型，我是通过不同函数来实现的。基于现有的这种继承关系，我可以很方便地将阵型函数的调用接口的其中一个参数类型设为Creature类，这样不管是葫芦娃，还是蝎子精小喽啰，都可以通过同样的函数来实现阵型的排列。例如：

```java
public boolean HeYi(Creature creature[], int leadX, int leadY, String direction){ ... }
```

对于葫芦娃，就可以直接排列阵型：

```java
CalabashBros[] calabashBros = { new CalabashBros(0), ... , new CalabashBros(6), };
formation.ChangShe(calabashBros, 8, 10, "Left");
```

对于蝎子精小喽啰，由于蝎子精和小喽啰本身不属于同一类型，但是类型的父类都是Creature类，因此可以在组合后排列阵型：

```java
Scorpion scorpion = new Scorpion();
Underling[] underling = { new Underling(0), ... , new Underling(6),  };
Creature[] badGuys = new Creature[underling.length+1];
badGuys[0] = scorpion;
System.arraycopy(underling, 0, badGuys, 1, underling.length);
formation.HeYi(badGuys, 11, 10, "Right");
```

2. 

我们要在最后输出整个二维空间，每种生物体应该输出不同的符号代表自身，但是“输出”这个方法是共通的，因此用到了**多态**。在“生物体”基类中定义了一个print方法，而不同生物体的子类override这一方法，来输出自身的符号。

使用**多态**，可以统一相近类型（即具有相同父类的子类）的方法调用的接口，且不影响体现子类自身的特殊性。

3. 

在整个面向对象的程序设计的过程中，都贯穿着**数据抽象**这一思想。

在我的实现中，Coordinator担任“造物主”这一角色，具有整个程序的main函数。阵型是在二维空间上实现的，因此我将代表二维空间的Map类作为了阵型的Formation类的成员变量。造物主可以通过调用阵型类提供的不同函数（即不同阵型），传递不同参数（即安排不同的生物体、阵型所在位置）来达到排布阵型的效果。

Map类本身“管理”着一个二维空间，用一个私有成员二维数组来实现，数组的类型是Creature，当某一个位置有生物体时，二维数组的对应位置就会存储该生物体的引用，可以理解为指向了这个生物体，否则就存储一个NULL。Map类还提供放置生物、移除生物、打印二维空间的方法接口。



一些思考：

1. 在对不同生物体进行抽象时，面临了一个选择。如果葫芦娃这个类型继承于生物体，那么葫芦娃就无法用枚举类型来实现，因为Java不支持多继承，而ENUM本身是通过继承来实现的。如果葫芦娃使用枚举类型，他就无法继承于生物体这一类型，那么其他的像老爷爷、蝎子精这些角色是单独成类型还是继承自生物体类型，也面临一个选择。最终，我选择了放弃枚举类型而将所有角色都继承于生物体这一父类，来保持整体的统一，并便于阵型函数调用的实现。

2. 在对“阵型”进行抽象的时候，也面临了一个选择，是把不同阵型都抽象成不同的类型，还是只是为不同阵型提供不同的方法函数。我目前采取的是后者的实现方法，我暂时没能比较出两种实现哪个更好。


