package world;

import java.util.HashSet;
import java.util.Set;

import world.entities.*;
import world.entities.Entity.EntityState;
import world.formations.*;
import world.util.*;

/**
 *	�����磬����Ļ���. <br>
 *	�����ն���ʾ��������
 *
 *	@author Mirror
 *
 *	@see #broForm
 *	@see #monForm
 *	@see #entities
 *	@see #getLiveEntityAt(Point)
 *	@see #initEntities()
 *	@see #start()
 *	@see #changeFormation(FormationType, GroupType)
 *	@see #showWorld()
 *	@see GUIWindow
 */
public final class CharWindow {

	// ���ͣ��������ڶ�ʵ��ĳ�ʼ��
	/**	�����«�����Ͷ��� */
	public Formation broForm;
	/**	�����������Ͷ��� */
	public Formation monForm;

	// ʵ��
	/**	������+λ��+�̣߳�һ����Ϊ�ķ����� */
	public static Set<Entity> entities = new HashSet<>();

	/**	�ж�ĳλ���Ƿ���ʵ��
	 *	@return ���򷵻ظ�ʵ��Entity��û���򷵻�null
	 */
	public static Entity getLiveEntityAt(Point pos) {
		for (Entity en: entities) {
			if ((en.position().equals(pos)) && (en.state() == EntityState.LIVE))
				return en;
		}
		return null;
	}
	
	/**	���ݵ�ǰ��������д���ʼ����ʵ�� */
	public void initEntities() {
		// ���Ƴ���ǰ���͵�ȫ��ʵ��
		entities.removeAll(entities);
		for (Point p : broForm.formMap.keySet()) { // ����ȫ����«��
			Point pos = Global.leftCenterP.mov(broForm.getFormCen().reverse()).mov(p);
			entities.add(new Entity(broForm.getCreature(p), pos));
		}
		for (Point p : monForm.formMap.keySet()) { // ����ȫ������
			Point pos = Global.rightCenterP.mov(monForm.getFormCen().reverse()).mov(p);
			entities.add(new Entity(monForm.getCreature(p), pos));
		}
	}

	/**	��������ʵ����߳�.<br>
	 *	���к�«������ǰ����������������ǰ�� 
	 */
	public void start() {
		for (Entity en: entities) {
			en.start();
		}
	}
	
	/**	��ʼ�� */
	public void initAll() {
		broForm = new ChangShe(GroupType.Bro); // ��«�����ͣ���ʼ��Ϊ������
		monForm = new HeYi(GroupType.Mon); // �������ͣ���ʼ��Ϊ������
		// ������������ʵ�弯
		initEntities();
	}
	
	/**	���캯������ʼ�����ж�����λ�� */
	public CharWindow() {
		initAll();
	}
	
	/**	@param type ��������ֵ
	 *	@return �������Ͷ��� */
	private Formation setForm(FormationType type, GroupType ctype) {
		switch (type) {
		case HY: return new HeYi(ctype); 
		case YX: return new YanXing(ctype); 
		case CE: return new ChongE(ctype);
		case CS: return new ChangShe(ctype);
		case YL: return new YuLin(ctype);
		case FY: return new FangYuan(ctype);
		case YY: return new YanYue(ctype);
		case FS: return new FengShi(ctype);
		default: return new ChangShe(ctype); 
		}
	}

	/**	�ı����͵�ͬʱ���ã�λ�ó�ʼ��ΪĬ��λ�� */
	public void changeFormation(FormationType type, GroupType ctype) {
		if (ctype == GroupType.Bro) 
			broForm = setForm(type, GroupType.Bro);
		else 
			monForm = setForm(type, GroupType.Mon);
		initEntities();
	}
	
	/**	��ʾ������ */
	public void showWorld() {
		 // ��ʼ����ʾ�ĵ�ͼ
		char[][] cMap = new char[Global.rowNum][Global.colNum];
		for (int i = 0; i < Global.rowNum; i++) { 
			for (int j = 0; j < Global.colNum; j++)
				cMap[i][j] = ' '; 
		}
		// ��������ʵ��
		for (Entity en: entities) {
			if (en.state() == EntityState.LIVE) {
				cMap[en.position().row()][en.position().col()] = en.creature().getSymbol();
			}
		}
		// ��ʼ��ӡ��ͼ
		char boundary = '#';
		// ��һ�У���ͼ�߽�
		for (int j = 0; j < Global.colNum + 2; j++)
			System.out.print(boundary + " ");
		System.out.println();
		// ��ͼ����
		for (int i = 0; i < Global.rowNum; i++) {
			System.out.print(boundary);
			for (int j = 0; j < Global.colNum; j++)
				System.out.print(" " + cMap[i][j]);
			System.out.println(" " + boundary);
		}
		// ���һ�У���ͼ�߽�
		for (int j = 0; j < Global.colNum + 2; j++)
			System.out.print(boundary + " ");
		System.out.println();
	}
}
