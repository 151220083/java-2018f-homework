package calabash;

public class Calabash extends Organism {
	private Color color;
	private int ranking; //from 1 to 7;
	
	Calabash(int i,Color c){
		ranking = i;
		color = c;
		setAttr(Attribute.CALABASH);
	}
	
	public void numberOff(){
		System.out.print(ranking+"�� ");
	}
	public void colorOff(){
		System.out.print(color+" ");
	}
	public int getNum(){
		return ranking;
	}
	public Color getColor(){
		return color;
	}
}

enum Color{ RED, ORANGE, YELLOW, GREEN, CYAN, BLUE, PURPLE};
