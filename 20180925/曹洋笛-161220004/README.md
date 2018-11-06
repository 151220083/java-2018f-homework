# ����˵��

## ����˵��
- ABCDEFG����«���ϴ�����  
- Y����үү��������  
- &��Ы�Ӿ�  
- o��Сආ�  
- S���߾���������  

## Ч����ʾ

<img src="img_readme/0.png" width=45%>
<img src="img_readme/1.png" width=85%>
<img src="img_readme/2.png" width=45%>
<img src="img_readme/3.png" width=45%>
<img src="img_readme/4.png" width=85%>
<img src="img_readme/5.png" width=45%>
<img src="img_readme/6.png" width=45%>

## ��ͼ

<img src="img_readme/Main.jpg" width=100%>

## Point
�����ͣ�����Ϊ�к��У��ܹ����м򵥵���ʾ���С��ж��Ƿ���ȡ��ƶ��Ȳ�����  

## Type
enum ���ͣ�Ϊ�����͵����֣�  
HY("������"), YX("������"), CE("������"), CS("������"), YL("������"),
FY("������"), YY("������"), FS("��ʸ��");  

## Creature
�����У����� String name����ӡ���� char symbol  
������Ϊ��ʽ�Ĳ�ͬ�����̳�Ϊ3�ࣺ  
- ��«�ޣ�Brothers  
  - �ڲ��� enum Members���涨��7����«�޵����֣����У���ɫ  
- ���֣�Monsters  
  - �ӡ�Сආ����м̳г������족Ы�Ӿ���Scorpion
- �����ӣ�Mascot
  - ������үү�� Elder �롱�߾��� Snake �̳�  

## Formation
�����԰�����  
- �������� Types type  
- �������� int formRangeRow  
- �������� int formRangeCol  
- ����ͼ Creature[][] creatureMap ��û���˵�λ��Ϊ null��
- ���͵����ĵ� Point formCenter ��������λ��  

�䷽��������  
- Point center() // �õ�������������  
- Types getType() // �õ���������  
- int getRowNum() // �õ���������  
- int getColNum() // �õ���������  
- boolean isEmpty(int r, int c) // ĳ���Ƿ�����  
- char[][] getFormMap() // �õ����ʹ�ӡЧ��  

������ǰ�������:  
�������� HeYi�������� YanXing�������� ChongE�������� ChangShe�������� YuLin�������� FangYuan�������� YanYue����ʸ�� FengShi��  
���ǵĲ�֮ͬ�����ڹ��캯����

## WorldMap
������ Formation �̶������統�С�  
WorldMap �ڶ����˵�ͼ�������� rangeRow, rangeCol ֮�󣬽��������������͵Ķ����Լ��������ڵ�ͼ��Ӧ���ڵ�λ�ã�Point ���ͣ�ָʾ���������ĵ����꣩��  
�ƶ����͵Ĳ���ֻ��Ҫ�ı�����͵����ĵ㶨λ��  
�ı��������͵Ĳ���ֻ��Ҫ�ı��������������õĶ�������������Ϊ��������ԭ���� monForm = yxForm ��Ϊ monForm = ylForm������ monForm �� Formation ���ͣ�yxForm/ylForm �� YanXing/YuLin ���ͣ���  
����ӡ�����ͼ���� showWorld() �Ĺ��̣����ǰѸ���������ʽ���ս����������ͼ�ϣ�������ǣ�  
- ����һ������Ϊ rangeRow, rangeCol �ĵ�ͼ char[][] map  
- ��ʼ����ʹ map ��ÿ��Ԫ�ض�Ϊ ' '���ո�  
- ͨ�� Formation ����Ϊ char[][] getFormMap()���õ���«�޺��������;ֲ�����ʾͼ  
- ͨ����«�����ͺ��������͵����ĵ㶨λ�����������ֲ�Сͼ�����ݸ��ǵ������ͼ map ��  
- ͨ����������үү���߾��Ķ�λ�㣬����үү���߾��ķ��Ÿ��ǵ������ͼ map ��  
- ��ӡ�����ͼ

## Observer
main �������ڵ��ࡣ
�γ�һ��������mud��Ϸ��Ч�������Թ�ʹ��������ѡ���Կ��� WorldMap ����Ϊ��
