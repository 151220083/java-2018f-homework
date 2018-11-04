package world.formations;

import world.creatures.Monsters;
import world.creatures.Scorpion;
import world.tools.*;

/* ������row*col = 7 * 5
 * 
 *  		0	1	2	3	4
 *  
 * 0		O	O	O	&	O
 * 1		O	O	&	O	O
 * 2		O	&	O	&	O
 * 3		&	O	&	O	&
 * 4		O	O	O	&	O
 * 5		O	O	&	O	O
 * 6		O	O	O	&	O
 * 
 */

public class YuLin extends Formation {
	
	public YuLin() {		
		super(7, 5); // ������ͼ��ռ���й���
		
		type = Types.YL;
		
		// ��������λ��
		formCenter = new Point(3, 2);
		formLeader = new Point(3, 2);
		
		// ʵ���������ֵ�λ��
		creatureMap[0][3] = new Monsters();
		creatureMap[1][2] = new Monsters();
		creatureMap[2][1] = new Monsters();
		creatureMap[2][3] = new Monsters();
		creatureMap[3][0] = new Monsters();
		creatureMap[3][2] = new Scorpion(); // Ы�Ӿ�
		creatureMap[3][4] = new Monsters();
		creatureMap[4][3] = new Monsters();
		creatureMap[5][2] = new Monsters();
		creatureMap[6][3] = new Monsters();
	}
}
