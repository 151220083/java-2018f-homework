package world;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import world.util.*;

/**
 *	���ӣ������ͼ�Ϸ���ʵ���λ�õ�Ԫ.
 * 
 *	@author Mirror
 *
 *	@see #cellLabel
 *	@see #x()
 *	@see #y()
 *	@see #width()
 *	@see #height()
 *	@see #setImage(CreatureType)
 */
public class GUICell {

	/**	Cellλ���У���0��ʼ */
	private int cRow;
	/**	Cellλ���У���0��ʼ */
	private int cCol;
	
	/**	CellͼƬ��ǩ��Ĭ��Ϊnone.png */
	public JLabel cellLabel;
	
	/**	��ʼ��λ�ú�ͼƬ */
	public GUICell(int r, int c) {
		cRow = r;
		cCol = c;
		cellLabel = new JLabel();
		setImage(null);
		cellLabel.setSize(width(), height());
		cellLabel.setLocation(x(), y());
		cellLabel.setOpaque(false);
	}
	
	/**	ΪcellLabel������ͼƬ */
	public void setImage(CreatureType t) {
		ImageIcon creatureIcon = null;
		if (t== null)
			creatureIcon = new ImageIcon("img\\none.png");
		else
			creatureIcon = new ImageIcon("img\\" + t.imgName + ".png");
		creatureIcon.setImage(creatureIcon.getImage().getScaledInstance(width(), height(),Image.SCALE_DEFAULT));
		cellLabel.setIcon(creatureIcon);
	}
	
	/**	x���� */
	public int x() {
		return (Global.marginWidth + cCol * Global.span);
	}

	/**	y���� */
	public int y() {
		return (Global.marginHeight + cRow * Global.span);
	}

	/**	Cell�� */
	public int width() {
		return Global.span;
	}

	/**	Cell�� */
	public int height() {
		return Global.span;
	}
}
