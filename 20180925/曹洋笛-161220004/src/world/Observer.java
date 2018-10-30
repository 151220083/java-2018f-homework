package world;

import java.util.Scanner;
import world.tools.*;

/* ����������ϵͳ֮����Թ��� */

public class Observer {

	public static void main(String[] args) {
		WorldMap world = new WorldMap();
		Scanner sc = new Scanner(System.in);
		while (true) {
			world.showWorld();
			System.out.println("��ѡ��1/2/3/4/5������q�˳�����");
			System.out.println("1. �ƶ���«��");
			System.out.println("2. �ƶ�����");
			System.out.println("3. �ƶ���үү");
			System.out.println("4. �ƶ��߾�");
			System.out.println("5. �ı���������");
			String cmd = sc.next();
			if (cmd.equals("q") || cmd.equals("\n")) break;
			if (cmd.equals("5")) {
				System.out.println("�ı�Ϊ�����������ͣ�");
				System.out.println("1. ������2. ������3. ������4. ������5. ������6. ������7. ��ʸ���������룺�˳�");
				int choice = sc.nextInt();
				switch (choice) {
				case 1: world.setMonType(Types.HY); break;
				case 2: world.setMonType(Types.YX); break;
				case 3: world.setMonType(Types.CE); break;
				case 4: world.setMonType(Types.YL); break;
				case 5: world.setMonType(Types.FY); break;
				case 6: world.setMonType(Types.YY); break;
				case 7: world.setMonType(Types.FS); break;
				default: continue;
				}
			}
			else if (cmd.equals("1") || cmd.equals("2") || cmd.equals("3") || cmd.equals("4")) {
				System.out.print("��ֱ�ƶ������ϸ�������������");
				int dr = sc.nextInt();
				System.out.print("ˮƽ�ƶ������󸺣�����������");
				int dc = sc.nextInt();
				if (cmd.equals("1"))
					world.movBroPosition(dr, dc);
				else if (cmd.equals("2"))
					world.movMonPosition(dr, dc);
				else if (cmd.equals("3"))
					world.movEldPosition(dr, dc);
				else
					world.movSnkPosition(dr, dc);
			}
		}
		sc.close();
	}
}
