package homework2;

enum Name {�ϴ�,�϶�,����,����,����,����,����}
enum Color {��ɫ,��ɫ,��ɫ,��ɫ,��ɫ,��ɫ,��ɫ}

 public class CalabashBro {
	public Color brocolor;
	public Name broname;
	//��ʼ��
	CalabashBro(Name name, Color color){
		this.broname = name;
		this.brocolor = color;
	}
	//��ӡ����
	public void printname(){
		System.out.print(broname+ " ");
	}
	//��ӡ��ɫ
	public void printcolor(){
		System.out.print(brocolor+ " ");
	}
	//��ӡλ�ñ仯
	public void printPoschange(int Old,int New)
	{
		 System.out.println(broname+":"+Old+"->"+New);
	}

}