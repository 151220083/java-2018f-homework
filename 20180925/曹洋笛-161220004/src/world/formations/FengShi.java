package world.formations;

import world.creatures.Monsters;
import world.creatures.Scorpion;
import world.tools.*;

/* ��ʸ��row*col = 7 * 6
 * 
 *  		0	1	2	3	4	5
 *  
 * 0		O	O	&	O	O	O
 * 1		O	&	O	O	O	O
 * 2		&	O	O	O	O	O
 * 3		&	&	&	&	&	&
 * 4		&	O	O	O	O	O
 * 5		O	&	O	O	O	O
 * 6		O	O	&	O	O	O
 * 
 */

public class FengShi extends Formation {
	
	public FengShi() {		
		super(7, 6); // ������ͼ��ռ���й���
		
		type = Types.FS;
		
		// ��������λ��
		formCenter = new Point(3, 2);
		formLeader = new Point(3, 0);
		
		// ʵ���������ֵ�λ��
		creatureMap[0][2] = new Monsters();
		creatureMap[1][1] = new Monsters();
		creatureMap[2][0] = new Monsters();
		creatureMap[3][0] = new Scorpion(); // Ы�Ӿ�
		creatureMap[3][1] = new Monsters();
		creatureMap[3][2] = new Monsters();
		creatureMap[3][3] = new Monsters();
		creatureMap[3][4] = new Monsters();
		creatureMap[3][5] = new Monsters();
		creatureMap[4][0] = new Monsters();
		creatureMap[5][1] = new Monsters();
		creatureMap[6][2] = new Monsters();
	}
}
