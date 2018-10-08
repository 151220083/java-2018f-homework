/*
 * ��Warriors�ӿڵ�Ҫ���£�����һ��Warrior�࣬���ڶ�˫��սʿ������
 * @see class Warrior
 * @author why
 * @Time 2018-9-27
 * @version 1.0
 * 
 * */
package javahw3;

public class Warrior implements Warriors {
	/*
	 * Variables: name, function, position, team;
	 * Methods: getName(), getFunction(), getPosition(), changePosition(), toString(), showMe();
	 * */
	private String name;
	private String function;
	private int[] position;
	private String team;
	
	public Warrior(String name, String function, int team) {
		this.name = name;
		this.function = function;
		if(team==1)
			this.team = "GoodMan";
		else
			this.team = "BadMan";
		position = new int[2];
	}
	
	public String getName() {
		return name;
	}

	public String getFunction() {
		return function;
	}

	public int[] getPosition() {
		return position;
	}

	public void changePosition(int m, int n) {
		position[0] = m;
		position[1] = n;
	}
	//�����Դ���toString����������System.out�ĵ���
	public String toString() {
		return name;
	}
	//�Զ�����ʾ��������ӡ����������йؼ���Ϣ
	public void showMe() {
		System.out.println(name+" team:"+team+" ["+position[0]+","+position[1]+"]");
	}
	
}
