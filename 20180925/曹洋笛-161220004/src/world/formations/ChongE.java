package world.formations;

import world.creatures.Monsters;
import world.creatures.Scorpion;
import world.tools.*;

/* ������row*col = 6 * 2
 * 
 *  		0	1
 *  
 * 0		O	&
 * 1		&	O
 * 2		O	&
 * 3		&	O
 * 4		O	&
 * 5		&	O
 * 
 */

public class ChongE extends Formation {
	
	public ChongE() {		
		super(6, 2); // ������ͼ��ռ���й���
		
		type = Types.CE;
		
		// ��������λ��
		formCenter = new Point(3, 0);
		formLeader = new Point(3, 0);
		
		// ʵ���������ֵ�λ��
		creatureMap[1][0] = new Monsters();
		creatureMap[3][0] = new Scorpion(); // Ы�Ӿ�
		creatureMap[5][0] = new Monsters();
		creatureMap[0][1] = new Monsters();
		creatureMap[2][1] = new Monsters();
		creatureMap[4][1] = new Monsters();
	}
}
