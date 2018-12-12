package world;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import world.entities.Entity;
import world.entities.Entity.EntityState;
import world.util.*;

/**
 *	�������ݵ���ʾ������������ + ʵ��ͼ��.
 *
 *	@author Mirror
 *
 *	@see #ground
 *	@see #cells
 *	@see #paintWindow()
 *	@see #clearWindow()
 *	@see GUIWindow
 *	@see GUICell
 */
public class GUIPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	/**	ÿ������ռ��һ������ */
	public GUICell[][] cells;
	
	/**	����ͼƬ */
	private JLabel ground;
	
	/**	��ʼ�� */
	public GUIPanel(CharWindow w) {
		// ������layout���ֲ����ڣ�������������ص�
		this.setLayout(null);
		this.setVisible(true);
		// ��ʼ��cells����ӵ���ͼ
		cells = new GUICell[Global.rowNum][Global.colNum];
		for (int i = 0; i < Global.rowNum; i++) {
			for (int j = 0; j < Global.colNum; j++) {
				cells[i][j] = new GUICell(i, j); 
				this.add(cells[i][j].cellLabel);
			}
		}
		// ��ӱ���ͼƬ
		ImageIcon groundIcon = new ImageIcon("img\\BackGround.png");
		groundIcon.setImage(groundIcon.getImage().getScaledInstance(Global.groundWidth, Global.groundHeight,Image.SCALE_DEFAULT));
		//groundIcon.setImage(groundIcon.getImage().getScaledInstance(Range.span, Range.span,Image.SCALE_DEFAULT));
		ground = new JLabel(groundIcon, JLabel.CENTER);
		ground.setSize(Global.groundWidth, Global.groundHeight);
		ground.setLocation(0, 0);
		this.add(ground);
	}

	/**	�����������ͻ���һ������ */
	private void paintCell(int r, int c, CreatureType t){
		cells[r][c].setImage(t);
	}

	/**	����һ������ */
	private void clearCell(int r, int c) {
		cells[r][c].setImage(null);
	}

	/**	�������и��� */
	public void paintWindow() {
		for (Entity en: CharWindow.entities) {
			if (en.state() == EntityState.LIVE) {
				paintCell(en.position().row(), en.position().col(), en.creature().getType());
			}
		}
	}
	
	/**	�������и��� */
	public void clearWindow() {
		for (Entity en: CharWindow.entities) {
			if (en.state() == EntityState.LIVE) {
				clearCell(en.position().row(), en.position().col());
			}
		}
	}
}
