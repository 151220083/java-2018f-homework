package thirdHomework;

import javax.swing.ImageIcon;

/*
 * �߾�
 */

public class Snake extends Creature {

	public Snake() {
		this.name = "�߾�";
		this.species = Species.SNAKE;
		this.icon = new ImageIcon("image/snake.jpg");
		this.standardIcon();
	}

}