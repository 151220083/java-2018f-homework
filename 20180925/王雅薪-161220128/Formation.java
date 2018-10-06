package calabash;

import java.util.Random;

public class Formation {
	private char[][]Ground;   //NxN�ռ�
	private int N;  //�ռ��С
	Formation(int n){
		N = n;
		Ground = new char[N][N];
		initial();
	}
	/*��ʼ�ռ�Ϊ�գ�û��վ������*/
	private void initial(){
		for(int i = 0; i < N; i++)
			Ground[i] = new char[N];
		for(int i = 0; i < N; i++)
			for(int j = 0; j < N; j++)
				Ground[i][j] = '.';
	}
	
	public void printStation(){
		System.out.println("Show current situation:");
		for(int i = 0; i < N; i++){
			for(int j = 0; j < N; j++){
				System.out.append(Ground[i][j]);
				System.out.print("  ");
			}
			System.out.println();
		}
	}
	
	/*������Ա*/
	public void formationS(Organism Org,char type){
		switch(Org.getAttr()){
		case GRANDPA:formationCheer(Org,type);break;
		case SERPENT:formationCheer(Org,type);break;
		default:System.out.println("formation error!");
		}
	}
	
	public void formationCheer(Organism Org,char type){
		int row = N/2;
		int col = (type == 'G')?0:N-1;   //үү������ߣ��߾������ұ�
		Ground[row][col] = type;
		Coordinate Coor = Org.getCoordinate();
		Coor.setC(row, col);
	}
	
	
	/*��ʼվ��*/
	public void formationC(Organism []Org,Form f,int n,char type){
		switch(f){
		case SERPEN:formSerpen(Org,n,type);break;
		case WING:formWing(Org,n,type);break;
		case SHIELD:formShield(Org,n,type);break;
		default:System.out.println("formation error!");
		}
	}
	
	/*�任��*/
	public void changeForm(Organism []Org,Form f,int n,char type){
		clearForm(Org);
		formationC(Org,f,n,type);
		System.out.println("change formation success!");
	}
	
	/*���λ����Ϣ*/
	public void clearForm(Organism []Org){
		for(int i = 0; i < Org.length; i++){
			int x = 0, y = 0;
			Coordinate Coor = Org[i].getCoordinate();
			x = Coor.getCx();
			y = Coor.getCy();
			Ground[x][y] = '.';
		}
	}
	
	/*����վ��*/
	public void formSerpen(Organism []Org,int n,char type){
		Random R = new Random();  //����ҳ�ʼ��
		int max = (type == 'C')?(N/2-n/2):(N-2);  //����Ǻ�«�޾�վ����࣬�����Ы�Ӿ���վ���Ҳ�
		int min = (type == 'C')?1:(N/2+n/2);
		int col = 0;
		int row = 0;
		boolean flag = false;
		while(flag == false){
			flag = true;
			int count = 0;
			col = R.nextInt(max)%(max-min+1) + min;
			row = N/2-n/2;  //��������
			for(int j = row; j < N; j++){
				if(Ground[j][col] == '.')
					count++;
				else
					break;
			}
			if(count < n){
				flag = false;
			}
		}
		
		int index = 0;
		for(int i = row; i < N && index < n; i++){
			if(Ground[i][col] == '.'){
				Ground[i][col] = type;
				Coordinate Coor = Org[index++].getCoordinate();
				Coor.setC(i, col);
			}
		}
		
	}
	
	/*������*/
	public void formWing(Organism []Org,int n,char type){
		Random R = new Random();
		int row = 0, col = 0;
		int max = (type == 'C')?(N/2-n/2):(N-n-1);  //����Ǻ�«�޾�վ����࣬�����Ы�Ӿ���վ���Ҳ�
		int min = (type == 'C')?1:(N/2+n/2);
		boolean flag = false;
		while(flag == false){
			flag = true;
			col = R.nextInt(max)%(max-min+1) + min;
			row = N/2-n/4;
			for(int i = 0; i < (n+1)/2;i++){
				if((row+(n+1)/2) >= N || (col+n-1) >= N){
					flag = false;
					break;
				}
				if(!(Ground[row+i][col+i] == '.' && Ground[row+i][col+n-i-1] == '.' )){
					flag = false;
				}
			}
		}
		
		int index = 0;
		for(int i = 0; i < n/2;i++){
			Ground[row+i][col+i] = 'M';
			Coordinate Coor = Org[index++].getCoordinate();
			Coor.setC(row+i, col+i);
			Ground[row+i][col+n-i-1] = 'M';
			Coor = Org[index++].getCoordinate();
			Coor.setC(row+i, col+n-i-1);
		}
		if(n%2 != 0){
			Ground[row+n/2][col+n/2] = 'M';
			Coordinate Coor = Org[index++].getCoordinate();
			Coor.setC(row+n/2, col+n/2);
		}
	}
	
	/*����*/
	public void formShield(Organism []Org,int n,char type){
		Random R = new Random();
		int row = 0, col = 0;
		int max = (type == 'C')?(N/2-n/2):(N-n-1);  //����Ǻ�«�޾�վ����࣬�����Ы�Ӿ���վ���Ҳ�
		int min = (type == 'C')?1:(N/2+n/2);
		boolean flag = false;
		while(flag == false){
			flag = true;
			int count = 0;
			col = R.nextInt(max)%(max-min+1) + min;
			row = N/2+n/2;  //��������
			int c = col;
			for(int j = row; j >= 0 && c < N; j--){
				if(Ground[j][c++] == '.')
					count++;
				else
					break;
			}
			if(count < n){
				flag = false;
			}
		}
		
		int index = 0;
		for(int i = row; i > 0 && index < n; i--){
			if(Ground[i][col] == '.'){
				Ground[i][col] = type;
				Coordinate Coor = Org[index++].getCoordinate();
				Coor.setC(i, col);
				col++;
			}
		}
		
	}
}

/*����:�������У�������ߣ����ۣ����Σ����£���ʸ*/
enum Form{WING,WGOOSE,SHIELD,SERPEN,SCALE,SQUARE,CMOON,ARROW }; 
