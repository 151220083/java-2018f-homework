#README
##��������
```
package calabashworld//��«������Ļ�����������Field��������Cell����/������Thing
package creatures//��«��������������abstract��Creature���̳���Creature�ľ���������
package formation//�󷨣�abstract��Formation���̳���Formation�ľ�������
package groups//����Ⱥ��abstract��Groups���̳���Groups�ľ����«��Ⱥ�������Ⱥ��
package output//���������������
package picture//����2dͼ�񣺶���ͼƬ��ͼƬ���Ų�ƴ�ӡ����Ʊ��������ƽ�ɫ
```
##�������
###composition
`Field.java`
```
public class Field{
    ...
    final Cell[][][] cells;
    cells(...){...}
    ...
}
```
###�̳�:
`Thing <- Creature <- CalabashMan/Spirit/Snake/Oldman`
���븴�á�is-a��ϵ������ʾ�����ڲ�ͬ�����й��Եĵط�������ͬ����������԰������򣩡�
###��̬:
`CalabashMan.printme()/Spirit.printme()/Snake.printme()/Oldman.printme()`
`zhen.sort()`
`Snake.cheer()/Oldman.cheer()`
��ͬ����ʵ���в�ͬ��Ϊ������̳���ͬһ�������Ĳ�֮ͬ�����в��컯�Ĵ����ڶ�һ�鸸������ָ��ͬ������д���ʱ����Ҫ�ֿ����Ǿ������ĸ����ࡣ
###��װ:
Groups.sort() 
`Groups.java`
```
public abstract class Groups implements Group{
    ...
    public void sort(){
    formation.sortTeam(creatures);
    }
    ...
}
```
Groups�����˰���վ�ӵľ���ʵ�֣���������Ⱥ��������ֻ��Ҫ����sort()�����Ϳ��ԡ��޷�ֱ�Ӳ���Groups�еĳ�Ա��Ҳ�����˽�Groups�еĳ�Ա��
###association:
`Groups.java`
```
class Groups{
    ...
    Formation formation;
    ...
}
```
###aggregation:
`Thing.java`
```
class Thing{
    ...
    Position position = new Position();
    ...
    }
```
###delegating:
`Groups.java`
`sort();`
###�ӿ�:
`Printable` `Sortable` `Cheerable`
�涨������Ľӿڣ�����Ҫʵ��print(Field field);ͬ�๦������ͬ�ӿڣ����������Ϊ����翴����ͳһ�ġ�
###srp:
	Thingֻ��������
	
	�������������дһ�����ʱ��ֻ��Ҫ����һ�����ܣ�����Ҫ�����޹ص����ݡ�
###ocp:
	Printʵ���������������implements Printableʵ����һ�����
	
	��ʱ����ͨ��implements Printableʵ���Լ���Ҫ����������Ҳ���Ҫ�ı����д�����ʵ�֣�ʵ���µ��������ʱֻ��Ҫ�����µ����⣬����Ҫ�����Ƿ���ƻ��Ѿ�ʵ�ֵĹ��ܡ�
###lsp:
	Spiritʵ�������滻����Thing��λ��
	
	�ڶԺܶ಻ͬ��Thing���в���ʱ������Ҫ����������������Thing��ֻ��עThing������ʲô�����ˡ�
###dip:
	Groups�е�formation�����Ӧ������abstract�࣬��ͬ���󷨴�Formation�̳С�
	
	Groupsֻ��Ҫ֪���Լ���һ��formation��ʵ����formation������Ľӿڣ���ôgroups�Ϳ���ʹ������ӿڽ������򣬲���Ҫ֪���������ĸ��󷨡�Groups�;��������֮�䲢�����໥Ӱ�졣