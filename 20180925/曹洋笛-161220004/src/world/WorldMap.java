package world;

import world.creatures.*;
import world.formations.*;
import world.tools.*;

/* ������ת��
 * ��ĳ���������ڵ�ͼ��
 * ��������
 * �����ƶ�
 * �����������ڵ�ͼ��
 * �������ƶ�
 * չʾ��������
 */

public class WorldMap {
	
	public static final int rangeRow = 20; // �з�Χ (0, rangeRow-1)
	public static final int rangeCol  = 20; // �з�Χ (0, rangeCol-1)
	
	// ����
	private Formation broForm; // �����«������
	private Formation monForm; // ������������
	private Snake snake = new Snake(); // �߾�
	private Elder elder = new Elder(); // ��үү
	
	// ��������
	private HeYi hyForm = new HeYi();
	private YanXing yxForm = new YanXing();
	private ChongE ceForm = new ChongE();
	private ChangShe csForm = new ChangShe();
	private YuLin ylForm = new YuLin();
	private FangYuan fyForm = new FangYuan();
	private YanYue yyForm = new YanYue();
	private FengShi fsForm = new FengShi();

	// ��λ
	private final Point LU = new Point(0, 0); // ��ͼ���Ͻ�
	private final Point RD = new Point(rangeRow - 1, rangeCol - 1); // ��ͼ���½�
	private Point broCen;  // ��«���������ĵ�
	private Point broLU; // ��«���������Ͻǵĵ�
	private Point broRD; // ��«���������½ǵĵ�
	private Point monCen; // �����������ĵ�
	private Point monLU; // �����������Ͻǵĵ�
	private Point monRD; // �����������½ǵĵ�
	private Point snkP; // �߾�λ��
	private Point eldP; // ��үүλ��
	
	private void updateBroLURD() { // ���� Cen ֵˢ�� Bro �� LU��RDֵ
		broLU.reset(broCen.row() - broForm.center().row(), broCen.col() - broForm.center().col());
		broRD.reset(broLU.row() + broForm.getRowNum() - 1, broLU.col() + broForm.getColNum() - 1);
	}

	private void updateMonLURD() { // ���� Cen ֵˢ�� Mon �� LU��RDֵ
		monLU.reset(monCen.row() - monForm.center().row(), monCen.col() - monForm.center().col());
		monRD.reset(monLU.row() + monForm.getRowNum() - 1, monLU.col() + monForm.getColNum() - 1);
	}
	
	public WorldMap() {
		broForm = csForm; // ��«�����ͣ�ֻ���ǳ�����
		monForm = hyForm; // �������ͣ�ָ��ĳ�����ͣ���ʼ��Ϊ������
		// ����λ��ĳ�ʼ��
		broCen = new Point(rangeRow/2 - 1, rangeCol/4 - 1);
		broLU = new Point(0, 0);
		broRD = new Point(0, 0);
		updateBroLURD();
		monCen = new Point(rangeRow/2 - 1, rangeCol*3/4 - 1);
		monLU = new Point(0, 0);
		monRD = new Point(0, 0);
		updateMonLURD();
		eldP = new Point(rangeRow*3/4, rangeCol/4 - 1);
		snkP = new Point(rangeRow*3/4, rangeCol*3/4 - 1);
	}

	private Formation getForm(Types type) {
		Formation form = null;
		switch (type) {
		case HY: form = hyForm; break;
		case YX: form = yxForm; break;
		case CE: form = ceForm; break;
		case CS: form = csForm; break;
		case YL: form = ylForm; break;
		case FY: form = fyForm; break;
		case YY: form = yyForm; break;
		case FS: form = fsForm; break;
		default: form = hyForm;
		}
		return form;
	}

	private boolean inRange(Point p) { // �жϵ�p�Ƿ��ڵ�ͼ��Χ��
		return p.in(LU, RD);
	}

	private boolean inRange(Point pLU, Point pRD) { // �ж�(LU -> RD)��Χ�Ƿ��ڵ�ͼ��Χ��
		return ((pLU.row() >= LU.row()) && (pRD.row() <= RD.row()) 
				&& (pLU.col() >= LU.col()) && (pRD.col() <= RD.col()));
	}
	
	private boolean inBroRange(Point p) { // �жϵ�p�Ƿ��ں�«�����ͷ�Χ��
		return p.in(broLU, broRD);
	}
	
	private boolean inBroRange(Point pLU, Point pRD) { // �ж�(LU -> RD)��Χ�Ƿ����«�����ͷ�Χ���ص�
		return !((pLU.row() > broRD.row()) || (pRD.row() < broLU.row()) 
				|| (pLU.col() > broRD.col()) || (pRD.col() < broLU.col()));
	}
	
	private boolean inMonRange(Point p) { // �жϵ�p�Ƿ����������ͷ�Χ��
		return p.in(monLU, monRD);
	}
	
	private boolean inMonRange(Point pLU, Point pRD) { // �ж�(LU -> RD)��Χ�Ƿ����������ͷ�Χ���ص�
		return !((pLU.row() > monRD.row()) || (pRD.row() < monLU.row()) 
				|| (pLU.col() > monRD.col()) || (pRD.col() < monLU.col()));
	}
	
	private boolean onMascotPoint(Point p) { // �жϵ�p�Ƿ񸲸���������
		return (p.equ(eldP) || p.equ(snkP));
	}

	private boolean onMascotPoint(Point pLU, Point pRD) { // �ж�(LU -> RD)��Χ�Ƿ񸲸���������
		return ((eldP.in(pLU, pRD)) || (snkP.in(pLU, pRD)));
	}
	
	private boolean checkPointGround(Point p) { // ����p�ĳ����Ƿ����
		if (!inRange(p)) {
			System.out.println("������ͼ��Χ");
			return false;
		}
		else if (onMascotPoint(p)) {
			System.out.println("��λ���ѱ�������ռ��");
			return false;
		}
		else if ((inMonRange(p) && !monForm.isEmpty(p.row() - monLU.row(), p.col() - monLU.col()))
				|| (inBroRange(p) && !broForm.isEmpty(p.row() - broLU.row(), p.col() - broLU.col()))) {
			System.out.println("��λ���ѱ���������ռ��");
			return false;				
		}
		else return true;
	}
	
	private boolean checkFormGround(Point cen) { // ����«��ĳ���͵ĳ����Ƿ����
		Point lu = new Point(cen.row() - broForm.center().row(), cen.col() - broForm.center().col());
		Point rd = new Point(lu.row() + broForm.getRowNum() - 1, lu.col() + broForm.getColNum() - 1);
		if (!inRange(lu, rd)) {
			System.out.println("������ͼ��Χ");
			return false;
		}
		else if (inMonRange(lu, rd) || onMascotPoint(lu, rd)) {
			System.out.println("��λ���ѱ���������ռ��");
			return false;
		}
		else return true;
	}
	
	private boolean checkFormGround(Point cen, Types type) { // �������ĳ���͵ĳ����Ƿ����
		Formation form = getForm(type);
		Point lu = new Point(cen.row() - form.center().row(), cen.col() - form.center().col());
		Point rd = new Point(lu.row() + form.getRowNum() - 1, lu.col() + form.getColNum() - 1);
		if (!inRange(lu, rd)) {
			System.out.println("������ͼ��Χ");
			return false;
		}
		else if (inBroRange(lu, rd) || onMascotPoint(lu, rd)) {
			System.out.println("��λ���ѱ���������ռ��");
			return false;
		}
		else return true;
	}
	
	public void setBroPosition(Point cen) { // ��cen���ź�«������
		if (cen.equ(broCen))
			System.out.println("��«���������ڸ�λ��");
		else if (checkFormGround(cen)) {
			broCen.reset(cen.row(), cen.col());
			updateBroLURD();
		}
	}

	public void movBroPosition(int dr, int dc) { // �ƶ���«������
		if (dr == 0 && dc == 0)
			System.out.println("��«������δ�ƶ�");
		else if (checkFormGround(new Point(broCen.row() + dr, broCen.col() + dc))) {
			broCen.mov(dr, dc);
			updateBroLURD();
		}
	}
	
	public void setMonType(Types type) { // ���� Type Ϊ monForm ��ֵ
		monForm = getForm(type);
		updateMonLURD();
	}
	
	public void setMonPosition(Point cen) { // ��cen������������
		if (cen.equ(monCen))
			System.out.println("�����������ڸ�λ��");
		else if (checkFormGround(cen, monForm.getType())) {
			monCen.reset(cen.row(), cen.col());
			updateMonLURD();
		}
	}
	
	public void movMonPosition(int dr, int dc) { // �ƶ���������
		if (dr == 0 && dc == 0)
			System.out.println("��������δ�ƶ�");
		else if (checkFormGround(new Point(monCen.row() + dr, monCen.col() + dc), monForm.getType())) {
			monCen.mov(dr, dc);
			updateMonLURD();
		}
	}
	
	public void movEldPosition(int dr, int dc) { // �ƶ���үү
		if (dr == 0 && dc == 0)
			System.out.println("��үүδ�ƶ�");
		else if (checkPointGround(new Point(eldP.row() + dr, eldP.col() + dc)))
			eldP.mov(dr, dc);
	}
	
	public void movSnkPosition(int dr, int dc) { // �ƶ��߾�
		if (dr == 0 && dc == 0)
			System.out.println("�߾�δ�ƶ�");
		else if (checkPointGround(new Point(snkP.row() + dr, snkP.col() + dc)))
			snkP.mov(dr, dc);
	}

	public void showWorld() { // ��ʾ����
		 // ��ʼ����ʾ�ĵ�ͼ
		char[][] map = new char[rangeRow][rangeCol];
		for (int i = 0; i < rangeRow; i++) { 
			for (int j = 0; j < rangeCol; j++)
				map[i][j] = ' '; 
		}
		// �ֱ�Ѻ�«�ޡ����֡������ӷ���ȥ
		char[][] broFormMap = broForm.getFormMap();
		for (int i = broLU.row(); i <= broRD.row(); i++) {
			for (int j = broLU.col(); j <= broRD.col(); j++)
				map[i][j] = broFormMap[i - broLU.row()][j - broLU.col()];
		}
		char[][] monFormMap = monForm.getFormMap();
		for (int i = monLU.row(); i <= monRD.row(); i++) {
			for (int j = monLU.col(); j <= monRD.col(); j++)
				map[i][j] = monFormMap[i - monLU.row()][j - monLU.col()];
		}
		map[eldP.row()][eldP.col()] = elder.getSymbol();
		map[snkP.row()][snkP.col()] = snake.getSymbol();
		// ��ʼ��ӡ��ͼ
		char boundary = '#';
		// ��һ�У���ͼ�߽�
		for (int j = 0; j < rangeCol + 2; j++)
			System.out.print(boundary + " ");
		System.out.println();
		// ��ͼ����
		for (int i = 0; i < rangeRow; i++) {
			System.out.print(boundary);
			for (int j = 0; j < rangeCol; j++)
				System.out.print(" " + map[i][j]);
			System.out.println(" " + boundary);
		}
		// ���һ�У���ͼ�߽�
		for (int j = 0; j < rangeCol + 2; j++)
			System.out.print(boundary + " ");
		System.out.println();
	}
}
