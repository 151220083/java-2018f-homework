package world.formations;

import world.creatures.Monsters;
import world.creatures.Scorpion;
import world.tools.*;

/* ������row*col = 7 * 4
 * 
 *  		0	1	2	3
 *  
 * 0		O	O	O	&
 * 1		O	O	&	O
 * 2		O	&	O	O
 * 3		&	O	O	O
 * 4		O	&	O	O
 * 5		O	O	&	O
 * 6		O	O	O	&
 * 
 */

public final class HeYi extends Formation {
	
	public HeYi() {		
		super(7, 4); // ������ͼ��ռ���й���
		
		type = Types.HY;
		
		// ��������λ��
		formCenter = new Point(3, 2);
		formLeader = new Point(3, 0);
		
		// ʵ���������ֵ�λ��
		creatureMap[0][3] = new Monsters();
		creatureMap[1][2] = new Monsters();
		creatureMap[2][1] = new Monsters();
		creatureMap[3][0] = new Scorpion(); // Ы�Ӿ�
		creatureMap[4][1] = new Monsters();
		creatureMap[5][2] = new Monsters();
		creatureMap[6][3] = new Monsters();
	}
}
