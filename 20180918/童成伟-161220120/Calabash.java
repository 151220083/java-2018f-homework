package homework2;

enum Name{�ϴ�,�϶�,����,����,����,����,����}
enum Color{��ɫ,��ɫ,��ɫ,��ɫ,��ɫ,��ɫ,��ɫ}

public class Calabash {
	public Color brocolor;
	public Name broname;
	
	Calabash(Name name, Color color){//��ʼ��
		this.broname = name;
		this.brocolor = color;
	}

	public void printname(){
		System.out.print(broname+ " ");
	}

	public void printcolor(){
		System.out.print(brocolor+ " ");
	}

	public void printPoschange(int Old,int New)
	{
		 System.out.println(broname+":"+Old+"->"+New);
	}

}
