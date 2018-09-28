package javahw3;
import java.util.ArrayList;
import java.util.Scanner;

public class FightField {
	private static final int N = 15;
	private Warrior[][] fields;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		FightField ff = new FightField();
		//��¼ÿ�ӵ�սʿ��������ʾ�������Ϣ
		Team teamGood = new Team();
		Team teamBad = new Team();
		loading(teamGood.team, teamBad.team);
		teamGood.showWarriors();
		teamBad.showWarriors();
		//��ʼ������
		Formation.initialization();
		/*----------------------------------------------------*/
		System.out.println("ROUND1");
		ff.round(teamGood, teamBad, in);
		ff.showFields();
		
		System.out.println();
		/*----------------------------------------------------*/
		ff.initialization();
		System.out.println("ROUND2");
		ff.round(teamGood, teamBad, in);
		ff.showFields();
		
		in.close();
		
		teamGood.showWarriors();
		teamBad.showWarriors();
	}
	
	public FightField() {
		initialization();
	}
	
	public void initialization() {
		fields = new Warrior[N][N];
	}
	//loading the warriors of two teams.
	public static void loading(ArrayList<Warrior> teamGood, ArrayList<Warrior> teamBad) {
		System.out.println("���������ϳ����жԾ��Ķ���......");
		String name = "�������������";
		for (int i=0; i<7; i++) {
			teamGood.add(new CalabashBrothers(name.charAt(i) + "��", ""));
		}
		teamGood.add(new Warrior("��үү", "�Թ�", 1));
		teamBad.add(new Warrior("Ы�Ӿ�", "���", 2));
		for (int i=0; i<6; i++) {
			teamBad.add(new Warrior("С�� ", "��ͷ", 2));
		}
		teamBad.add(new Warrior("�߾�", "�Թ�", 2));
	}
	
	public void showFields() {
		System.out.println("*****************************************************ս���������*****************************************************");
		for (int i=0; i<N; i++) {
			for (int j=0; j<N; j++) {
				if(fields[i][j]==null)
					System.out.print("---");
				else
					System.out.print(fields[i][j]);
				System.out.print("\t");
			}
			System.out.println();
		}
		System.out.println("*****************************************************ս���������*****************************************************");
	}
	
	public void goBattle(ArrayList<Warrior> team, int[][] place) {
		for (int i=0; i<team.size(); i++) {
			int m = place[i][0];
			int n = place[i][1];
			team.get(i).changePosiion(m, n);
			fields[m][n] = team.get(i);
		}
	}
	
	public void round(Team teamGood, Team teamBad, Scanner in) {
		System.out.println("**************˫��սʿ�ϳ�*************");
		System.out.println("**********��ѡ�������ϳ�������***********");
		System.out.println("**********0----------������**********");
		System.out.println("**********1----------������**********");
		System.out.println("**********2----------������**********");
		System.out.println("**********3----------������**********");
		int f1 = in.nextInt();
		this.goBattle(teamGood.team, Formation.getForm(0, 1));
		this.goBattle(teamBad.team, Formation.getForm(f1, 2));
	}
}


class Team{
	public ArrayList<Warrior> team;
	
	Team(){
		team = new ArrayList<Warrior>();
	}
	public void showWarriors() {
		for(Warrior k:team)
			k.showMe();
	}
}


class Formation{
	public static ArrayList<int[][]> book1;
	public static ArrayList<int[][]> book2;
	
	public static void initialization() {
		book1 = new ArrayList<int[][]>();
		book2 = new ArrayList<int[][]>();
		int x1[][] = {{4,4},{5,4},{6,4},{7,4},{8,4},{9,4},{10,4},{7,2}} ;
		int x2[][] = {{4,6},{5,5},{6,4},{7,3},{8,2},{9,1},{10,0},{5,1}} ;
		int x3[][] = {{4,6},{5,5},{6,4},{7,3},{6,2},{5,1},{4,0},{4,3}} ;
		int x4[][] = {{3,3},{4,4},{5,3},{6,4},{7,3},{8,4},{9,3},{6,1}} ;
		
		book1.add(x1);
		book2.add(convert(x1));
		book1.add(x2);
		book2.add(convert(x2));
		book1.add(x3);
		book2.add(convert(x3));
		book1.add(x4);
		book2.add(convert(x4));
	}
	
	public static int[][] getForm(int m, int team){
		if (team == 1)
			return book1.get(m);
		else
			return book2.get(m);
	}
	private static int[][] convert(int[][] xx){
		int[][] y = new int[8][2];
		for (int i=0; i<7; i++) {
			y[i][1] = 14 - xx[i][1];
			y[i][0] = xx[i][0];
		}
		y[7][1] = 14 - xx[7][1];
		y[7][0] = xx[7][0];
		return y;
	}
	
}


/*
�߸���«�ޣ���үү���߾���Ы�Ӿ��������ڶ�һ�޶��ĸ��壬��С�����ǿ����кܶ����
�жԵ�˫��������һ����ս������ս���������ɽ�Ҫ�ϳ��Ķ�����һ������ս����
������������¼��ÿ��λ���ϵĸ�������֣���������У���ѯλ�á�����λ����Ϣ����ӡ�Ȳ���
˫���Ķ��󣺶��߱�һ��λ����Ϣ����¼�����������ս���е�λ�ã���¼�Ÿ��Ե����֣��Լ�������ս��
ս�����󣺼�¼�˶�����Ϣ������������ս�Ӳ�ͬ������ս�������е�λ�ò�ͬ

��«�޿���ʹ��ö�����ͣ�Ҳ����ʹ�����޵��ࣨö�����͵�ʹ����Ϊ�Լ�����ϰ��
�ö�ά��ArrayList�ƺ���Ƚ��鷳��Java�еĴ�ȡû��cpp����ô���㣬���Զ���ս�������ʵ�֣�����
 * 
 * */
