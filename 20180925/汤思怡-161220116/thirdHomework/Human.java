package thirdHomework;

import javax.swing.ImageIcon;

/*
 * ��үү
 */

public class Human extends Creature {

	public Human() {
		// TODO Auto-generated constructor stub
		this.name = "��үү";
		this.species = Species.GRANDPA;
		this.icon = new ImageIcon("image/grandpa.jpg");
		this.standardIcon();
	}
}