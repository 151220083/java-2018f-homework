package second_homework;


//��«������ֻ��7��������ͬ���ޣ����ܵ��������«�ޣ�ֻ����7����«��һ�����������7����«������Ϊ��̬�����ҽ����캯������Ϊ˽�У�ȷ��ֻ��7����«�ޣ�ͨ����������������7����«�ޡ�
public class CalabashBrothers {
	enum CalabashBrother{
		FIRST("�ϴ�","��ɫ"),SECOND("�϶�","��ɫ"),THIRD("����","��ɫ"),FOURTH("����","��ɫ"),FIFTH("����","��ɫ"),SIXTH("����","��ɫ"),SEVENTH("����","��ɫ");
		private String status;
		private String color;
		
		CalabashBrother(String status,String color){
			this.status=status;
			this.color=color;
		}
		
		public void tellstatus() {
			System.out.print(status);
		}
		
		public void tellcolor() {
			System.out.print(color);
		}
	}
	public static final int number=7;
	private static CalabashBrother[] cala=new CalabashBrother[number];
	private static CalabashBrothers c=new CalabashBrothers();
	
	private CalabashBrothers() {
		for(int i=0;i<number;i++)
			cala[i]=CalabashBrother.values()[i];
	}
	
	static CalabashBrothers GetCalabashBrothers() {
		return c;
	}
	
  	void swap(int i,int j) {
		if(i<0||i>=number||j<0||j>=number)
			System.out.println("error!");
		CalabashBrother temp=cala[i];
		cala[i]=cala[j];
		cala[j]=temp;
		tellmove(i,j);
		tellmove(j,i);
	}
		
	boolean larger(int i,int j) {
		return cala[i].ordinal()>cala[j].ordinal();
	}
		
	void countoffbystatus() {
		for(int i=0;i<number;i++)
			cala[i].tellstatus();
		System.out.println();
	}
		
	void countoffbycolor() {
		for(int i=0;i<number;i++)
			cala[i].tellcolor();
		System.out.println();
	}
	
	private void tellmove(int x,int y) {
		if(x<0||x>=number||y<0||y>=number)
			System.out.println("error!");
		cala[y].tellstatus();
		System.out.println(":"+(x+1)+"->"+(y+1));
	}
}