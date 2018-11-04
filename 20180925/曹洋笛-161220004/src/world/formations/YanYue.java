package world.formations;

import world.creatures.Monsters;
import world.creatures.Scorpion;
import world.tools.*;

/* ������row*col = 9 * 6
 * 
 *  		0	1	2	3	4	5
 *  
 * 0		O	O	O	O	O	&
 * 1		O	O	O	&	&	O
 * 2		O	O	&	&	O	O
 * 3		&	&	&	O	O	O
 * 4		&	&	&	O	O	O
 * 5		&	&	&	O	O	O
 * 6		O	O	&	&	O	O
 * 7		O	O	O	&	&	O
 * 8		O	O	O	O	O	&
 * 
 */

public class YanYue extends Formation {
	
	public YanYue() {		
		super(9, 6); // ������ͼ��ռ���й���
		
		type = Types.YY;
		
		// ��������λ��
		formCenter = new Point(4, 2);
		formLeader = new Point(4, 1);
		
		// ʵ���������ֵ�λ��
		creatureMap[0][5] = new Monsters();
		creatureMap[1][3] = new Monsters();
		creatureMap[1][4] = new Monsters();
		creatureMap[2][2] = new Monsters();
		creatureMap[2][3] = new Monsters();
		creatureMap[3][0] = new Monsters();
		creatureMap[3][1] = new Monsters();
		creatureMap[3][2] = new Monsters();
		creatureMap[4][0] = new Monsters();
		creatureMap[4][1] = new Scorpion(); // Ы�Ӿ�
		creatureMap[4][2] = new Monsters();
		creatureMap[5][0] = new Monsters();
		creatureMap[5][1] = new Monsters();
		creatureMap[5][2] = new Monsters();
		creatureMap[6][2] = new Monsters();
		creatureMap[6][3] = new Monsters();
		creatureMap[7][3] = new Monsters();
		creatureMap[7][4] = new Monsters();
		creatureMap[8][5] = new Monsters();
	}
}
