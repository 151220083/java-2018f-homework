package world;

import world.util.*;
import world.xml.*;

/**	
 *	ȫ�ֳ���������ȫ�ֺ���.
 *	��������ֵ������λ�ã�ʤ�����ʣ���������
 *	
 *	@author Mirror
	*/
public final class Global {

	/**	���� {@value}	*/
	public static final int rowNum = 17; // 0 ~ 16
	
	/**	���� {@value}	*/
	public static final int colNum = 18; // 0 ~ 17

	/**	���ս�����ĵ�	*/
	public static final Point leftCenterP = new Point(7, 4);

	/**	�Ҳ�ս�����ĵ�	*/
	public static final Point rightCenterP = new Point(7, 13);	

	/**	����λ�� {@value}	*/
	public static final double winLocationXY = 0;
	
	/**	���ڿ� {@value}	*/
	public static final double winWidth = 906;
	
	/**	���ڸ� {@value}	*/
	public static final double winHeight = 917;

	/**	����ͼƬ�� {@value}	*/
	public static final double groundWidth = 900;
	
	/**	����ͼƬ��  {@value}	*/
	public static final double groundHeight = 850;	

	/**	ʵ��ͼƬ�� {@value}	*/
	public static final double entityWidth = 100;
	
	/**	ʵ��ͼƬ�� {@value}	*/
	public static final double entityHeight = 100;
	
	/**	GridPane��ƫ��x��ԭ������ {@value}	*/
	public static final double marginX = -25;
	
	/**	GridPane��ƫ��y��ԭ������ {@value}	*/
	public static final double marginY = -400;
	
	/**	������ {@value}	*/
	public static final double span = 50;
	
	/**	˫������ԭ���͵İ�غ���	*/
	public static final int keepFormationRoundNum = 2;
	
	/**	˫������ԭ���͵İ�غ���	*/
	public static int keepFormationRound = keepFormationRoundNum;

	/**	����ʱ��«�޵�ʤ��	*/
	public static final int BroWinPercent = 50;
	
	/**	����ʱ���ֵ�ʤ��	*/
	public static final int MonWinPercent = 100 - BroWinPercent;
	
	/**	��������ʱ��(ms)	*/
	public static final int durTime = 500;

	/**	ս���غ���	*/
	public static int roundNum = 0;

	/**	ս���Ƿ�ʼ	*/
	public static boolean battleStart = false;
	
	/**	ս���Ƿ����	*/
	public static boolean battleEnd = false;
	
	/**	�ж�ս���Ƿ����	*/
	public static boolean isEnded() {
		boolean hasBro = false;
		boolean hasMon = false;
		for (Entity en: CoreWorld.entities.values()) {
			if ((en.state == EntityState.LIVE) && (en.creature.getGroup() == GroupType.Bro))
				hasBro = true;
			if ((en.state == EntityState.LIVE) && (en.creature.getGroup() == GroupType.Mon))
				hasMon = true;
		}
		return !(hasBro && hasMon);
	}
	
	/**	����ս��	*/
	public static XMLRecordWriter recordWriter = null;
	
	/**	��ȡս��	*/
	public static XMLRecordReader recordReader = null;
	
	/**	Ĭ�ϱ����ļ�	*/
	public static final String defaultFilename = "records/defaultRecordFile.xml";
	
}
