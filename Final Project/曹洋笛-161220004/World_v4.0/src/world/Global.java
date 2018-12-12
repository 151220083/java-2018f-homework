package world;

import java.util.Random;

import world.util.*;

/**	
 *	ȫ�ֳ���������ȫ�ֺ���.
 *	��������ֵ������λ�ã�ʤ�����ʣ���������
 *	
 *	@author Mirror
 */
public final class Global {

	/**	���� {@value} */
	public static final int rowNum = 17; // 0 ~ 16
	
	/**	���� {@value} */
	public static final int colNum = 18; // 0 ~ 17
	
	/**	���ս�����ĵ� */
	public static final Point leftCenterP = new Point(7, 4);

	/**	�Ҳ�ս�����ĵ� */
	public static final Point rightCenterP = new Point(7, 13);	

	/**	����λ�� {@value} */
	public static final int winLocationXY = 0;
	
	/**	���ڳ� {@value} */
	public static final int winWidth = 814;
	
	/**	���ڿ� {@value} */
	public static final int winHeight = 822;

	/**	ͼƬ�� {@value} */
	public static final int groundWidth = 800;
	
	/**	ͼƬ�� {@value} */
	public static final int groundHeight = 760;	

	/**	ͼƬ�߾ࣨ�� {@value} */
	public static final int marginWidth = 40;	
	
	/**	ͼƬ�߾ࣨ�ߣ� {@value} */
	public static final int marginHeight = 40 + 25;	
	
	/**	������ {@value} */
	public static final int span = 40;

	/**	������sleep */
	public static final void worldSleep(int time){
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
	
	/**	ĳ��p�Ƿ������緶Χ�� */
	public static final boolean inWorld(Point p) {
		return p.in(new Point(0, 0), new Point(rowNum - 1, colNum - 1));
	}
	
	/**	����ʱ��«�޵�ʤ�� */
	public static final int BroWinPercent = 50;
	
	/**	����ʱ���ֵ�ʤ�� */
	public static final int MonWinPercent = 100 - BroWinPercent;
	
	public static Random rand = null;

	/**	����[min, max]��������� */
	public static final int getRandom(int min, int max) {
		rand = new Random();
		return (rand.nextInt(max - min + 1) + min);
	}
	
	/**	������ʤ�� */
	public static final boolean win(GroupType type) {
		if (type == GroupType.Bro)
			return (getRandom(0, 99) < BroWinPercent);
		else
			return (getRandom(0, 99) < MonWinPercent);
	}
	
}
