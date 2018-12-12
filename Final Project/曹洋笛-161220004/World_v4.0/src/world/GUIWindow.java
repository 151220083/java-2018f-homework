package world;


import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import world.util.*;

/**
 *	�����磬���������. <br>
 *	��ȫ����������{@code CharWindow}���Ա�֤ͬ�� <br>
 *	����GUI��ʾ��������
 *
 *	@author Mirror
 *	
 *	@see #menuBar
 *	@see #menuMonitor
 *	@see #keyMonitor
 *	@see #cWin
 *	@see #pWin
 *	@see CharWindow
 *	@see GUIPanel
 */
public final class GUIWindow extends JFrame {

	private static final long serialVersionUID = 1L;

	/**	����˵��� */
	private JMenuBar menuBar;
	
	/**	���塰��ʼ���˵����˵���Ϊ�����á� */
	private JMenu menuStart; 
	/**	����ʼ���˵�������á� */
	private JMenuItem menuItReset;
	
	/**	���塰���͡��˵����˵���Ϊ����/��«�޵����� */
	private JMenu menuMonFormation, menuBroFormation;
	/**	�����͡��˵�����ֵ����� */
	private JMenuItem menuMonItHY, menuMonItYX, menuMonItCE, menuMonItCS, 
						menuMonItYL, menuMonItFY, menuMonItYY, menuMonItFS;
	/**	�����͡��˵����«�޵����� */
	private JMenuItem menuBroItHY, menuBroItYX, menuBroItCE, menuBroItCS, 
						menuBroItYL, menuBroItFY, menuBroItYY, menuBroItFS;
	
	/**	�˵��¼����� */
	private MenuMonitor menuMonitor;
	
	/**	�����¼����� */
	private KeyMonitor keyMonitor;

	/**	GUI�����ԭ�� ���� char���� */
	private CharWindow cWin;
	
	/**	GUI�������ʾ */
	private GUIPanel pWin;

	/**	���캯������char����Ϊ����������GUI���細�� */
	public GUIWindow(CharWindow w) {
		super("��«�޴�ս����"); // ���ñ���
		// ���ò˵���
		menuBar = new JMenuBar();
		menuStart = new JMenu("��ʼ");
		menuItReset = new JMenuItem("����");
		menuBroFormation = new JMenu("��«������");
		menuBroItHY = new JMenuItem("������");
		menuBroItYX = new JMenuItem("������");
		menuBroItCE = new JMenuItem("������");
		menuBroItCS = new JMenuItem("������");
		menuBroItYL = new JMenuItem("������");
		menuBroItFY = new JMenuItem("������");
		menuBroItYY = new JMenuItem("������");
		menuBroItFS = new JMenuItem("��ʸ��");
		menuMonFormation = new JMenu("��������");
		menuMonItHY = new JMenuItem("������");
		menuMonItYX = new JMenuItem("������");
		menuMonItCE = new JMenuItem("������");
		menuMonItCS = new JMenuItem("������");
		menuMonItYL = new JMenuItem("������");
		menuMonItFY = new JMenuItem("������");
		menuMonItYY = new JMenuItem("������");
		menuMonItFS = new JMenuItem("��ʸ��");
		menuStart.add(menuItReset);
		menuBroFormation.add(menuBroItHY);
		menuBroFormation.add(menuBroItYX);
		menuBroFormation.add(menuBroItCE);
		menuBroFormation.add(menuBroItCS);
		menuBroFormation.add(menuBroItYL);
		menuBroFormation.add(menuBroItFY);
		menuBroFormation.add(menuBroItYY);
		menuBroFormation.add(menuBroItFS);
		menuMonFormation.add(menuMonItHY);
		menuMonFormation.add(menuMonItYX);
		menuMonFormation.add(menuMonItCE);
		menuMonFormation.add(menuMonItCS);
		menuMonFormation.add(menuMonItYL);
		menuMonFormation.add(menuMonItFY);
		menuMonFormation.add(menuMonItYY);
		menuMonFormation.add(menuMonItFS);
		menuBar.add(menuStart);
		menuBar.add(menuBroFormation);
		menuBar.add(menuMonFormation);
		this.add(menuBar, BorderLayout.NORTH); // ��Ӳ˵���
		this.setSize(Global.winWidth, Global.winHeight);
		this.setLocation(Global.winLocationXY, Global.winLocationXY); // ����λ��
		this.setResizable(false); // ���ڴ�С���ɸ���
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		// ���ü��������
		keyMonitor = new KeyMonitor();
		this.addKeyListener(keyMonitor);
		// ���ò˵������
		menuMonitor = new MenuMonitor();
		menuItReset.addActionListener(menuMonitor);
		menuBroItHY.addActionListener(menuMonitor);
		menuBroItYX.addActionListener(menuMonitor);
		menuBroItCE.addActionListener(menuMonitor);
		menuBroItCS.addActionListener(menuMonitor);
		menuBroItYL.addActionListener(menuMonitor);
		menuBroItFY.addActionListener(menuMonitor);
		menuBroItYY.addActionListener(menuMonitor);
		menuBroItFS.addActionListener(menuMonitor);
		menuMonItHY.addActionListener(menuMonitor);
		menuMonItYX.addActionListener(menuMonitor);
		menuMonItCE.addActionListener(menuMonitor);
		menuMonItCS.addActionListener(menuMonitor);
		menuMonItYL.addActionListener(menuMonitor);
		menuMonItFY.addActionListener(menuMonitor);
		menuMonItYY.addActionListener(menuMonitor);
		menuMonItFS.addActionListener(menuMonitor);
		// ����char���磬��ʼ�����ͻ���
		cWin = new CharWindow();
		pWin = new GUIPanel(cWin);
		this.add(pWin, BorderLayout.CENTER);
		this.setVisible(true);
		cWin.showWorld();
		pWin.paintWindow();
	}
	
	/**	���������� */
	class KeyMonitor implements KeyListener {
		@Override
		public void keyTyped(KeyEvent e) {
		}
		@Override
		public void keyPressed(KeyEvent e) {
		}
		@Override
		public void keyReleased(KeyEvent e) {
			pWin.clearWindow(); // �����������
			switch (e.getKeyCode()) {
			// �ո�start()
			case KeyEvent.VK_SPACE: 
				cWin.start();
				break;
			}
			Global.worldSleep(100); // �ȴ������߳�ִ�����ٴ�ӡ
			cWin.showWorld();
			pWin.paintWindow(); // ������������
		}
	}
	
	/**	�����˵��� */
	class MenuMonitor implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == menuItReset)
				handleReset();
			else if (e.getSource() == menuBroItHY)
				handleForm(FormationType.HY, GroupType.Bro);
			else if (e.getSource() == menuBroItYX)
				handleForm(FormationType.YX, GroupType.Bro);
			else if (e.getSource() == menuBroItCE)
				handleForm(FormationType.CE, GroupType.Bro);
			else if (e.getSource() == menuBroItCS)
				handleForm(FormationType.CS, GroupType.Bro);
			else if (e.getSource() == menuBroItYL)
				handleForm(FormationType.YL, GroupType.Bro);
			else if (e.getSource() == menuBroItFY)
				handleForm(FormationType.FY, GroupType.Bro);
			else if (e.getSource() == menuBroItYY)
				handleForm(FormationType.YY, GroupType.Bro);
			else if (e.getSource() == menuBroItFS)
				handleForm(FormationType.FS, GroupType.Bro);
			else if (e.getSource() == menuMonItHY)
				handleForm(FormationType.HY, GroupType.Mon);
			else if (e.getSource() == menuMonItYX)
				handleForm(FormationType.YX, GroupType.Mon);
			else if (e.getSource() == menuMonItCE)
				handleForm(FormationType.CE, GroupType.Mon);
			else if (e.getSource() == menuMonItCS)
				handleForm(FormationType.CS, GroupType.Mon);
			else if (e.getSource() == menuMonItYL)
				handleForm(FormationType.YL, GroupType.Mon);
			else if (e.getSource() == menuMonItFY)
				handleForm(FormationType.FY, GroupType.Mon);
			else if (e.getSource() == menuMonItYY)
				handleForm(FormationType.YY, GroupType.Mon);
			else if (e.getSource() == menuMonItFS)
				handleForm(FormationType.FS, GroupType.Mon);
		}
	}
	
	/**	�˵�������ʼ��->�����á� */
	public void handleReset() {
		pWin.clearWindow(); // �����������
		cWin.initAll();
		cWin.showWorld();
		pWin.paintWindow(); // ������������
	}
	
	/**	�˵�������ʼ��->�����͡� */
	public void handleForm(FormationType type, GroupType ctype) {
		pWin.clearWindow(); // �����������
		cWin.changeFormation(type, ctype);
		cWin.showWorld();
		pWin.paintWindow(); // ������������
	}

}
