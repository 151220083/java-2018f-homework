/*
 * ����һ��Warriors�Ľӿڣ����ڹ淶Warrior�������
 * @see interface Warrior
 * @author why
 * @Time 2018-9-27
 * @version 1.0
 * 
 * */
package javahw3;

public interface Warriors {	
	/*
	 * Methods: getName(), getFunction(), getPosition(), changePosition();
	 * */
	public String getName();
	public String getFunction();
	public int[] getPosition();
	public void changePosition(int m, int n);
}
