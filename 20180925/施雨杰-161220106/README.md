#��ҵ:�����«�ޱ�̡�����Ӫ����
##�������
������ҵҪ�󣬽���ƵĶ�����·�Ϊ�������������
ͬʱ�������Formation������Sort�ȷ������������ṩһϵ�пɽ��еĹ���

**1.Creature**
��«�ޣ�үү���߾���Ы�Ӿ���ආ�����������ڴ���
```
public class Creature {
    protected String name; //���������
    private int locationX;
    private int locationY; //������ս��������
    public Creature();
    public Creature(String creatureName);
    public void tellMyName(); 
    public boolean gotoPlace(Ground space, int X, int Y);  //�����ƶ�����������ָ�����ص�һ�����괦
    public void leavePlace(Ground space); //�����뿪�������뿪ָ��������
}
```

**2.Unit**
���������еĵ�Ԫ���ǹ������صĻ�����Ԫ����Ground(����)�ṩ������Ĳ���
```
public class Unit {
    private Creature onGroundCreature;  //�˵�Ԫ�ϵ�����
    public Unit();
    public boolean isEmpty();  
    public void Come(Creature creature);  //ԭ�Ӳ���:���롣��������뵥Ԫ�У���ʾ�������ƶ�����
    public void Leave();                  //ԭ�Ӳ���:�뿪��������Ӵ˵�Ԫ�Ƴ�����ʾ�������뿪
    public void showCreature();           //ԭ�Ӳ���:��ʾ����ӡ�˵�Ԫ�����������
}
```

**3.Ground**
λ��ս���е������࣬���ڿ���������վ���Ĺ�������
�����ص�ÿ����Ԫ�����ڴ����У��Դ˱�֤���ط��ʵ���ȷ�ԣ�����ͨ����������ؽ���һϵ�н���
```
public class Ground {
    private Unit[][] space;  //һ��Unit�Ķ�ά���飬�����صľ��������ʽ
    private int bound;       //space�Ĵ�С�������صķ�Χ��С
    public Ground(int N);    //ͨ������Nȷ�����صľ����С�������ݴ˲�����������ʵ��
    public boolean isEmpty(int X, int Y);  //����Ӧ���ص�Ԫ��λ���Ƿ�Ϊ�գ��Ƕ����ز����ı���
    public boolean testBound(int X, int Y);//����Ӧ���ص�Ԫ�Ƿ���ڣ��������Ƿ�Խ�磬�Ƕ����ز����ı���
    public void gotoUnit(int X, int Y, Creature creature); //ͨ���˺������ö�ӦUnit��ԭ�Ӳ�����������
    public void leaveUnit(int X, int Y);   //ͨ���˺������ö�ӦUnit��ԭ�Ӳ��������뿪
    public int showBound();  //�������صľ����С
    public void showCreature(int X, int Y);//ͨ���˺������ö�ӦUnit��ԭ�Ӳ���������ʾ�����ϵ�����
}

```

**4.Sort**
һ�������࣬�ṩһϵ��Ϊ��«������ķ���
```
public class Sort {
    protected HuluWa[] brothers;  //��������ĺ�«������
    public  Sort();
    public Sort(HuluWa[] brothers);
    public void sort();           //������ʵ�ֵĲ�ͬ������
}
```

**5.Formation**
�洢�������г�������������Ҫ��λ����Ϣ��Ϊ�����ṩ����ķ���
```
public class Formation {
    private FormationType type;  //һ�����͵�ö�����ͣ�������������������г�����������
    private int direction;       //�������͵ĳ���
    private Ground space;        //����ĵص�
    private int midX;            
    private int midY;            //���͵����ĵ�(����˵���͵�������ʼ��)
    private Creature[] creatures;//�����������
    public Formation();
    public Formation(FormationType type, int direction, Ground room, Creature[] creatures, int X, int Y);
    private void HeYiFormation();
    private void YanXingFormation();
    private void HengEFormation();
    private void ChangSheFormation();
    private void YuLinFormation();
    private void FangMenFormation();
    private void YanYueFormation();
    private void FengShiFormation(); //8�����ͺ��������ڽ����ﰴ�����ͳ�������ص�Ȳ�����������
    public void DealFormation();  //���ݴ�����������Ƶ�����Ӧ�����ͺ�����������
    public void SetDirection(int direction);
    public void SetFormation(FormationType type);
    public void SetGound(Ground space);
    public void SetCreature(Creature[] creatures);
    public void SetMidPoint(int X, int Y);  //һϵ�е��������Ա���ݵĺ���
}
```


##����̳�
����ֻ�������������ʵ�ֶ��ڽ������ҵ�ǲ����ģ���ͬ��������в�ͬ�Ĺ��ܺ����ԣ�ִ���������в�ͬ�㷨
Ϊ�˾�ȷ����ͬ�������²�ͬ����������ԣ�����̳л��ƣ���չ�����ļ���������

**1.Creature**
�������Ϊ��«��HuluWa��үүGrandpa������Monster3������
���������࣬�����һ����Ϊ�߾�Snake��Ы�Ӿ�Scorpio��ආ�LittleMonster3������
ͨ�������ļ̳У���һ�������˸���������֮��Ĺ�ϵ�Ͳ�ͬ��Ϊ���������಻ͬ������Ӹ���Ĺ����ṩ�˷���


 **��** HuluWa
��«���ཫ��ǰ��ҵ2����enumʵ�ֵĺ�«������Ϊ��Ա��ͨ�����캯���ṩ����������rankʵ�廯һ����«��
�����ж�Ӧ�ĺ�«��enum�ࡣ
���������еķ�ʽ�����enum�಻���ٴμ̳�Creature�������

 **��** Grandpa
үү�ڴ˳�������Ϊһ��ָ���ߵ�������֣�������ָ�Ӻ�«�����ų��������ԶԿ����ֵĹ��ƣ������үү��
���������һ��Formation�����ڶԺ�«�޽������Ͱ��ţ�midPoint���ڴ洢үү��Ҫ��ĳ��չ�����͵��������ꡣ

ʵ���ϣ�ֻ��Ҫ��Formation���ú��ʵĲ������ɶ�Ŀ��������󣬵���һ��δ֪������ǿ�н�����������ƶ�̫
��ͻأ����˽�������ֱ����main�����е���Formation��������������Զ�������ķ�ʽȫ��ת�Ƶ���үү���У�Ҳ���ǽ�үү������һ��ָ���ߡ�

 ```
        public class Grandpa extends Creature{
            private int[] midPoint;
            private Formation HuluFormation;
            public Grandpa();
	    public void standInLine(HuluWa[] brothers); //���ź�«�����վ��
            public void standByOrder(HuluWa[] brothers);//ͨ��Sort�����Ժ�«�޽�������
            public void setMidPoint(int X, int Y);      //ȷ��һ������չ����
            public void chooseUnit(Ground space); //�ڰ������«�޺�үү�����������ҵ�һ���ط�վ����Ϊ��«������
            public void initializeFormation(int direction, Ground space, Creature[] creatures);
                                                  //������Ĳ������ú�����Ĳ���
            public void commandHuluWa(FormationType type);
                                                  //ָ�Ӻ�«�ް����ͽ������У���ʵ����ͨ��Formation����үү�����
            public void waitNewLocation(HuluWa[] creatures, Ground space);
                                                  //����Ŀ��������ʱ�뿪���أ��ȴ��ƶ����µ�Ŀ�ĵ�
        }
```

**��**Snake
�߾���үүһ����Ҳ��Ϊ���ֵ����ָ���߳��֣���˲��ɱ���������һЩ��үү�����ظ��ĺ�������ָ�����ֽ�������

```
public class Snake extends Monster{
    private int[] midPoint;
    private Formation monFormation;
    public Snake();
    public void setMidPoint(int X, int Y);
    public void chooseUnit(Ground space);
    public void initializeFormation(int direction, Ground space, Creature[] creatures);
    public void commandMonsters(FormationType type);
    public void waitNewLocation(Monster[] monsters, Ground space);
}
```

**��**other
�����������ʱû������µĹ��ܣ����ֻ�в�ͬ�Ĺ��캯����û������Ĺ��ܺ���

**2.Sort**
 **��**BubbleSort
������BubbleSort����ð�������㷨��д��sort()����

