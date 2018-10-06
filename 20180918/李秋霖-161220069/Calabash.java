package CalabashBrothers;

enum COLOR {
	RED, ORANGE, YELLOW, GREEN, CYAN, BLUE, PURPLE;
}

public class Calabash {
	private COLOR color;
	private String name;

	public Calabash(COLOR color) {
		super();
		this.color = color;
		switch (color) {
		case RED:
			name = "�ϴ�";
			break;
		case ORANGE:
			name = "�϶�";
			break;
		case YELLOW:
			name = "����";
			break;
		case GREEN:
			name = "����";
			break;
		case CYAN:
			name = "����";
			break;
		case BLUE:
			name = "����";
			break;
		case PURPLE:
			name = "����";
			break;
		default:
			break;
		}
	}

	public void printSign() {
		System.out.print(color.toString());
	}

	public void printName() {
		System.out.print(name);
	}

	public int getValue() {
		return color.ordinal();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		Calabash[] bro = new Calabash[7];
		// EnumTest e : EnumTest.values()

//		for (COLOR c : COLOR.values()) {
//			bro[c.ordinal()] = new Calabash(c);
//		}

		// for (int i = 0; i < 7; i++) {
		// bro[i] = new Calabash(COLOR.RED);
		// }
		// bro[5].printSign();
		System.out.println("The main code was in CalaBrothers.java");

	}

}
