/*
 * ����һ��Warriors�Ľӿڣ����ڹ淶Warrior�������
 * �ӿ��е����ݽ�Ϊ����
 * */
package javahw3;

public interface WarriorInterface {	
	/*
	 * Methods: getName(), getFunction(), getPosition(), changePosition();
	 * */
	abstract public String getName();
	abstract public String getFunction();
	abstract public int[] getPosition();
	abstract public void changePosition(int m, int n);
}
