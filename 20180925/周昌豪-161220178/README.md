 # �����«�ޱ��3 #
 ***
   ###### ʵ��������Ӫ�����ͱ任 ######

***
## ����
������«�� үү �߾� Сආ� Ы�Ӿ�
```
class Creature
{ 
	String name;  
	Position pos;
  	void OutPutInfo()
  	...
}
```
 Creature��ΪCalabashBrother, Monster��Ļ���
```
class Monster extends Creature { ... }
class CalabashBrother extends Creature { ... }

```
***
## Team��
```
abstract class CreatureTeam
{
	protected Creature[] list;
	protected Creature cheerleader;
	
	protected abstract void GetRandomList();
	public abstract void SetRandomFormation(Field field);
}
```
�����г�Ա�������ߺͻ�ȡ����б�������͵ķ���
��ΪCalabashBrotherTeam �� MonsterTeam �Ļ���
```
class MonsterTeam extends CreatureTeam { ... }
class CalabashBrotherTeam extends CreatureTeam { ... }
```

***
## ����
�����������ޣ�ʹ��ö��������
```
enum  FormationTye
{
	ChangSe(Pos(0, 0), Pos(1, 0), Pos(2, 0), Pos(3, 0), Pos(4, 0), Pos(5, 0), Pos(6, 0)),
	HeYi(Pos(0, 0), Pos(1, 1), Pos(2, 2), Pos(3, 3), Pos(4, 2), Pos(5, 1), Pos(6, 0))��
	
	private Position list[];
	...
}
```
- �ɹ�������λ����Ϣ������list
- �������Ϣֻ��¼�˸�����list[0]�����λ�ã��ɸ���list[0]�ľ���λ�øı�����λ��

```
	public static Position[] GetRandomFormation()
	{
		int random = (int)(Math.random()* FormationType.values().length);
		return FormationType.values()[random].GetList(); //�������λ���б�
	}
```

***
## Field
```
public class Tile
{	
	private Creature CreatureStandOn;
	private boolean IsEmpty;

 	boolean Set (Creature src) { ... };
 	boolean Clear() { ... };
 	void Print() { ... };
 	...
 }
 ```
 Tile����һ�������վ��λ�� 
 ```
 class Field
 {
 	private Tile[][] plant;
 	public boolean Set (Creature creature, int x, int y);
 	public boolean AllClear();
 	...
 }
```
Field�����һ��Tile�Ķ�ά������Ϊս�����а��������յȷ���
***
![���������ͼƬ����](https://github.com/foreveryounth/java-2018f-homework/blob/master/20180925/%E5%91%A8%E6%98%8C%E8%B1%AA-161220178/img-floder/%E7%BB%93%E6%9E%84%E8%AF%B4%E6%98%8E.png)                                                                                                                                     
***
