package thirdHomework;

import javax.swing.ImageIcon;

/*
 * Сආ�
 */

public class Minion extends Creature {

	public Minion(int index) {
		this.name = "ආ�" + index;
		this.species = Species.MINION;
		this.icon = new ImageIcon("image/minion.jpg");
		this.standardIcon();
	}
}
