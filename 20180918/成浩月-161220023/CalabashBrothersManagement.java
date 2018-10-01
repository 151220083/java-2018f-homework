import java.util.Random;

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

class CalabashBrothers{
	public static final int len=7;
	private CalabashBrother[] cala=new CalabashBrother[len];
	public CalabashBrothers() {
		for(int i=0;i<len;i++)
			cala[i]=CalabashBrother.values()[i];
	}
	public void swap(int i,int j) {
		if(i<0||i>=len||j<0||j>=len)
			System.out.println("error!");
		CalabashBrother temp=cala[i];
		cala[i]=cala[j];
		cala[j]=temp;
		tellmove(i,j);
		tellmove(j,i);
	}
	private void tellmove(int x,int y) {
		if(x<0||x>=len||y<0||y>=len)
			System.out.println("error!");
		cala[y].tellstatus();
		System.out.println(":"+(x+1)+"->"+(y+1));
	}
	public boolean larger(int i,int j) {
		return cala[i].ordinal()>cala[j].ordinal();
	}
	public void countoffbystatus() {
		for(int i=0;i<len;i++)
			cala[i].tellstatus();
		System.out.println();
	}
	public void countoffbycolor() {
		for(int i=0;i<len;i++)
			cala[i].tellcolor();
		System.out.println();
	}

}

interface Sort{
	public void sort(CalabashBrothers c);
}

class BubbleSort implements Sort{
	public void sort(CalabashBrothers c) {
		System.out.println("BubbleSort");
		int i,j;
		boolean exchange;
		int len=CalabashBrothers.len;
		for(i=0;i<len-1;i++) {
			exchange=false;
			for(j=len-1;j>i;j--) {
				if(c.larger(j-1,j)) {
					c.swap(j-1, j);
					exchange=true;
				}
			}
			if(!exchange)
				break;
		}
	}
}

class BinarySort implements Sort{
	public void sort(CalabashBrothers c) {
		System.out.println("BinarySort");
		int i;
		int len=CalabashBrothers.len;
		for(i=1;i<len;i++) {
			int left=0,right=i-1;
			while(left<=right) {
				int middle=(right+left)/2;
				if(c.larger(middle, i))
					right=middle-1;
				else
					left=middle+1;
			}
			//�嵽leftλ��
			//��i���������left��λ��
			for(int j=i;j>=left+1;j--)
				c.swap(j,j-1);
		}
	}
}

class Randomize implements Sort{
	public void sort(CalabashBrothers c) {
		Random random=new Random();
		System.out.println("Randomizing...");
		for(int i=0;i<10;i++) {
			int x=random.nextInt(6);
			int y=random.nextInt(6);
			if(x!=y)
				c.swap(x,y);
		}
	}
}

public class CalabashBrothersManagement{
	public static void main(String[] args) {
		CalabashBrothers calabashbrothers=new CalabashBrothers();
		Randomize randomize=new Randomize();
		BubbleSort bubblesort=new BubbleSort();
		BinarySort binarysort=new BinarySort();
		randomize.sort(calabashbrothers);
		System.out.print("Randomization result:");
		calabashbrothers.countoffbystatus();
		bubblesort.sort(calabashbrothers);
		System.out.print("bubblesort result:");
		calabashbrothers.countoffbystatus();
		randomize.sort(calabashbrothers);
		System.out.print("Randomization result:");
		calabashbrothers.countoffbystatus();
		binarysort.sort(calabashbrothers);
		System.out.print("binarysort result:");
		calabashbrothers.countoffbycolor();
	}
}