/*
 * ���������ĽǶȣ�����˫���ϳ���սʿ����������֯����ս���С�
 * @see class FightFileld, class Formation, Class Team.
 * @author why
 * @Time 2018-11-5
 * @version 2.0
 * 
 * version 3.0 �޸Ľ��飺
 * �޸�Ŀ�꣬��collection�����������«�޵ĳ���       finished
 * ѡȡ�����ʵ�collection�������е�ʵ�����Դ��ķ���ʵ��    finished
 * ����������������������ʹ�ó�����ӷ���Ҫ�� undo
 * ����Interface
 * 
 * */

package javahw3;
//import java.util.ArrayList;
import java.util.Scanner;

public class FightField {
	/*
	 * ������Ҫ��ִ����ڣ��ڴ����е���ս��������սʿ��ѡ�����ͣ���ʾս����Ϣ.
	 * <p>
	 *     �ڴ���������Warrior�ĳ�Ա����Ϊ����ս���������Ա<br>
	 *     �����л��õ���Team��ĳ�Ա�Լ�Formation��ĳ�Ա<br>
	 *     ���е�ִ���Զ����ڱ�������ɡ�<br>
	 * @param true: ��ȷ, false: ����
	 * @return�� boolean 
	 * */
	private static final int N = 15;
	public Warrior[][] fields;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		FightField ff = new FightField();
		//��¼ÿ�ӵ�սʿ��������ʾ�������Ϣ
		Team teamGood = new Team("GoodMan");
		Team teamBad = new Team("BadMan");
		loading(teamGood, teamBad);
		try {
			teamGood.checkMember();
			teamBad.checkMember();
		}catch(MyException e) {
		}
		teamGood.showWarriors();
		teamBad.showWarriors();
		//��ʼ������
		Formation.initialization();
		/*-----------------------ROUND 1------------------------*/
		System.out.println("ROUND1");
		ff.round(teamGood, teamBad, in);
		ff.showFields();
		
		System.out.println();
		/*-----------------------ROUND 2------------------------*/
		ff.initialization();
		System.out.println("ROUND2");
		ff.round(teamGood, teamBad, in);
		ff.showFields();
		
		in.close();
		
		teamGood.showWarriors();
		teamBad.showWarriors();
	}
	//Constructor
	private FightField() {
		initialization();
	}

	private void initialization() {
		fields = new Warrior[N][N];
	}
	
	private static void loading(Team teamGood, Team teamBad) {
		System.out.println("���������ϳ����жԾ��Ķ���......");
		String name = "�������������";
		for (int i=0; i<7; i++) {
			teamGood.add(new CalabashBrothers(name.charAt(i) + "��", ""));
		}
		teamGood.add(new Warrior("��үү", "��Ϸ", teamBad.getSide()));
		teamBad.add(new Warrior("Ы�Ӿ�", "���", teamBad.getSide()));
		for (int i=0; i<5; i++) {
			teamBad.add(new Warrior("С��"+i, "���", teamBad.getSide()));
		}
		teamBad.add(new Warrior("С��"+6, "���", teamGood.getSide()));
		teamBad.add(new Warrior("�߾�", "��Ϸ", teamBad.getSide()));
		// �˴���Ҫһ������˳��Ĳ����Լ�һ���������
		// ��Java���ܲ��ܹ���C++�����Զ�������
	}
	
	// show the fields
	private void showFields() {
		System.out.println("***************************************************ս���������****************************************************");
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
		System.out.println("***************************************************ս���������****************************************************");
	}
	
	//��˫�����佫����ս��
	private void goBattle(Team team, int[][] place) {
		team.goBattle(fields, place);
	}
	
	//�Զ���ѡ��˫��������
	private void round(Team teamGood, Team teamBad, Scanner in) {
		System.out.println("************˫��սʿ�ϳ�*************");
		System.out.println("********��ѡ�������ϳ�������*********");
		System.out.println("**********0----------������**********");
		System.out.println("**********1----------������**********");
		System.out.println("**********2----------������**********");
		System.out.println("**********3----------������**********");
		int f1 = -1;
		// deal with the error: index out of bounds
		this.goBattle(teamGood, Formation.getForm(0, 1));
		try {
			f1 = in.nextInt();
			this.goBattle(teamBad, Formation.getForm(f1, 2));
		}catch( IndexOutOfBoundsException e){
			System.out.println("your input is out of bound! please input again!");
			f1 = in.nextInt();
			this.goBattle(teamBad, Formation.getForm(f1, 2));
		}
	}
}


