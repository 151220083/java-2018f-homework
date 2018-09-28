package sort;

import java.util.Random;

enum Color{
	��ɫ,��ɫ,��ɫ,��ɫ,��ɫ,��ɫ,��ɫ;
}
enum Name{
	�ϴ�,�϶�,����,����,����,����,����;
}
public enum CalabashBrothers {
	One(Name.�ϴ�,Color.��ɫ),
	Two(Name.�϶�,Color.��ɫ),
	Three(Name.����,Color.��ɫ),
	Four(Name.����,Color.��ɫ),
	Five(Name.����,Color.��ɫ),
	Six(Name.����,Color.��ɫ),
	Seven(Name.����,Color.��ɫ);
	
	private Name name;
	private Color color;
	
	private CalabashBrothers(Name n,Color c) {
		this.name = n;
		this.color = c;
	}
	
	public Name getName() {
		return name;
	}
	
	public Color getColor() {
		return color;
	}
	public void swapClaim(Name people,int old_location,int new_location) {
		System.out.println(people+":"+old_location+"->"+new_location);
	}
}

class CalabashQueue {
	Random random = new Random();
	public void RandomSort(CalabashBrothers[] Calabash) {
		System.out.println("��ʼ�����п�ʼ");
		for(int i=0;i<Calabash.length;i++) {
			int p=random.nextInt(i+1);
			CalabashBrothers temp=Calabash[i];
			Calabash[i]=Calabash[p];
			Calabash[p]=temp;
		}
		System.out.println("��ʼ�����н���");
	}
	
	public void BubbleSort(CalabashBrothers[] Calabash) {
		System.out.println("\nð������ʼ");
		for(int i=0;i<Calabash.length;i++) {
			for(int j=i+1;j<Calabash.length;j++) {
				if(Calabash[i].ordinal()>Calabash[j].ordinal()) {
					Calabash[i].swapClaim(Calabash[i].getName(), i, j);
					CalabashBrothers Temp=Calabash[i];
					Calabash[i]=Calabash[j];
					Calabash[j]=Temp;
				}
			}
		}
		System.out.println("ð���������");
	}
	
	public void BinarySort(CalabashBrothers[] Calabash) {
		System.out.println("\n��������ʼ");
		for(int i=1;i<Calabash.length;i++) {
			CalabashBrothers temp=Calabash[i];
			int temp_old_location=i;
			int low=0,high=i-1;
			int mid=-1;
			while(low<high) {
				mid=low+(high-low)/2;
				if(temp.getColor().ordinal()<Calabash[mid].getColor().ordinal()) 
					high=mid-1;
				else
					low=mid+1;
			}
			for(int j=i-1;j>=low;j--) {
				Calabash[j+1]=Calabash[j];
			}
			Calabash[low]=temp;
			Calabash[low].swapClaim(Calabash[low].getName(),temp_old_location,low);
		}
		System.out.println("�����������");
	}
	
	public void queueClaimName(CalabashBrothers[] Calabash) {
		System.out.println("\n������ʼ");
		for(int i=0;i<Calabash.length;i++)
			System.out.println(Calabash[i].getName());
		System.out.println("��������\n");
	}
	
	public void queueClaimColor(CalabashBrothers[] Calabash) {
		System.out.println("\n����ɫ��ʼ");
		for(int i=0;i<Calabash.length;i++)
			System.out.println(Calabash[i].getColor());
		System.out.println("����ɫ����");
	}

	
}
