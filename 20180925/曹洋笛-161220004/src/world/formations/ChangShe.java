package world.formations;

import world.creatures.Brothers;
import world.tools.*;

/* ������row*col = 7 * 1
 */

public class ChangShe extends Formation {
	
	public ChangShe() {		
		super(7, 1); // ������ͼ��ռ���й���
		
		type = Types.CS;
		
		// ��������λ��
		formCenter = new Point(3, 0);
		formLeader = new Point(3, 0);
		
		// ʵ������«�޵�λ��
		creatureMap[0][0] = new Brothers(0);
		creatureMap[1][0] = new Brothers(1);
		creatureMap[2][0] = new Brothers(2);
		creatureMap[3][0] = new Brothers(3);
		creatureMap[4][0] = new Brothers(4);
		creatureMap[5][0] = new Brothers(5);
		creatureMap[6][0] = new Brothers(6);
	}}
