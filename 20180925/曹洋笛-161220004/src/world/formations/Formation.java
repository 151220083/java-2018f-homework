package world.formations;

import world.creatures.Creature;
import world.tools.*;

/* ���ͳ����� */

public abstract class Formation {
		
	protected Types type; // ��������
	protected int formRangeRow; // ������ռ����
	protected int formRangeCol; // ������ռ����
	protected Creature[][] creatureMap; // ����ͼ������ʵ�壩
	
	protected Point formCenter; // ����ͼ���ĵ㣬���ڶ�λ
	protected Point formLeader; // �������쵼�����ڵ�
	
	protected Formation(int r, int c) {
		formRangeRow = r;
		formRangeCol = c;
		formCenter = null;
		formLeader = null;
		
		creatureMap = new Creature[formRangeRow][formRangeRow];
		for (int i = 0; i < formRangeRow; i++) {
			for (int j = 0; j < formRangeRow; j++) {
				creatureMap[i][j] = null;  // ��ʼ��ȫ��
			}
		}
	}
	
	public Point center() { // �õ�������������
		return formCenter;
	}
	
	public Types getType() { // �õ���������
		return type;
	}
	
	public int getRowNum() { // �õ���������
		return formRangeRow;
	}
	
	public int getColNum() { // �õ���������
		return formRangeCol;
	}
	
	public boolean isEmpty(int r, int c) { // ĳ���Ƿ�����
		return (creatureMap[r][c] == null);
	}
	
	public char[][] getFormMap() { // �õ�������ʾͼ
		char[][] form = new char[formRangeRow][formRangeCol];
		for (int i = 0; i < formRangeRow; i++) {
			for (int j = 0; j < formRangeCol; j++) {
				if (creatureMap[i][j] == null)
					form[i][j]= ' '; 
				else
					form[i][j] = creatureMap[i][j].getSymbol();
			}
		}
		return form;
	}
		
	public void showFormation() { // ��ӡ����
		for (int i = 0; i < formRangeRow; i++) {
			for (int j = 0; j < formRangeCol; j++) {
				if (creatureMap[i][j] == null)
					System.out.print("  ");
				else
					System.out.print(creatureMap[i][j].getSymbol() + " ");
			}
			System.out.println();
		}
	}
}
