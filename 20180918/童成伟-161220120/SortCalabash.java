package homework2;

import java.util.Random;

public class SortCalabash {

	public Calabash[] bro = new Calabash[7];

	SortCalabash() {
		for(int i = 0; i < bro.length; i++) {
			Calabash temp = new Calabash(Name.values()[i],Color.values()[i]);//��ʼ��
	    	bro[i] = temp;
	    }
	}

	public void messbro() //���Һ�«��˳��
	{
		int rank1,rank2;
		Random random = new Random();
		for(int i = 0; i < 14;i++) {//14�α�֤��ֽ���
			rank1 = random.nextInt(7);//���Ʒ�Χ
			rank2 = random.nextInt(7);
			if(rank1 != rank2) {//���ɵ������������һ��,����˳��
				Calabash temp = bro[rank1];
				bro[rank1] = bro[rank2];
				bro[rank2] = temp;
			}
		}
		System.out.print("����˳��:");
		for(int i = 0;i < bro.length;i++) {
			System.out.print(bro[i].broname.ordinal()+" ");
		}
		System.out.println();
	 }
	
	 // ð������
	 public void CalabashBubble() {
		 System.out.println("����ð������");
	     for(int i = 0; i < bro.length-1; i++) {
	    	 for(int j = 0; j < bro.length-1; j++) {
	    		 if(bro[j].broname.ordinal() > bro[j+1].broname.ordinal()) {
	    			 bro[j].printPoschange(j, j+1);
	                 bro[j+1].printPoschange(j+1, j);
	                 Calabash temp = bro[j];
	                 bro[j] = bro[j+1];
	                 bro[j+1] = temp;
	             }
	         }
	     }
	        
	 }

	 // ���ַ�
	 public void CalabashBinary() {
		 System.out.println("���ж�������");
		 for(int i = 1; i < bro.length; i++) {
			 Calabash temp = bro[i];
	         int low = 0, high = i-1, mid = -1;
	         while(low <= high) {
	        	 mid = (low + high) / 2;
	             if (bro[mid].brocolor.ordinal() > temp.brocolor.ordinal())
	            	 high = mid - 1;
	             else
	                 low = mid + 1;
	         }
	         for(int j = i-1; j >= low; j--) {
	        	 bro[j + 1] = bro[j];
	             bro[j].printPoschange(j, j+1);
	         }
	         bro[low] = temp;
	         bro[low].printPoschange(i, low);
	     }
	        
	 }
	  
	 public void Calaname() {
		 for(int i = 0; i < bro.length; i++)
			 bro[i].printname();
		 System.out.println();
	 }
	    
	 public void Calacolor() {
		 for(int i = 0; i < bro.length; i++)
	         bro[i].printcolor();
	     System.out.println();
	 }
	        
	 public static void main(String[] args) {
		// TODO Auto-generated method stub
		 SortCalabash A = new SortCalabash();
		 A.messbro();
	     A.CalabashBubble();
	     A.Calaname();
	      
	     A.messbro();
	     A.CalabashBinary();
	     A.Calacolor();
	}

}
