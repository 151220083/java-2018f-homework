对于代码中所有的生物，Creature是父类，子类分别是Huluwa，Oldman，Xiezi，Snake，Luoluo。这6个类构成Creature.java文件，父类为public类

还有8个排序文件，每个排序方式独自构成一个类，一个独立文件。在每个排序方式的构造文件中进行排序，同时将生物和棋盘类进行联系

棋盘类中包含main函数，其中棋盘类是17x11的棋盘，每个棋盘都是通过Creature父类访问子类，棋盘类的初始化函数定义了7个Huluwa类，10个小啰啰类，1个老爷爷类，一个蝎子精类，一个蛇精类。
确定老爷爷和蛇精在棋盘上的位置并保持变。

总共10个java文件，都在cre_define这个包之下运行

优点：基于面向对象的设计原则，程序的可扩展性、易读性、安全性得到提高。
          向上转型：简化了函数参数的种类，可以通过父类引用访问子类的详细信息

