package world;

/**	
 *	��������Ķ���Ȼ���Ǹ�˦���ƹ�
 *
 *	@author Mirror
 *	
 *	@see CharWindow
 *	@see GUIWindow
 */
public final class Main {
	
	public static void main(String[] args) {
		CharWindow cWin = new CharWindow();
		new GUIWindow(cWin);
	}
}
