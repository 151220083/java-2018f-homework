package world.creatures;

/* �߸���«�� */

public final class Brothers extends Creature {
	
	enum Members {
		Bro1("�ϴ�", "��ɫ", 'A'), 
		Bro2("�϶�", "��ɫ", 'B'), 
		Bro3("����", "��ɫ", 'C'),
		Bro4("����", "��ɫ", 'D'), 
		Bro5("����", "��ɫ", 'E'), 
		Bro6("����", "��ɫ", 'F'), 
		Bro7("����", "��ɫ", 'G');
		
	    public String rank;
	    public String color;
	    public char symbol;
	    private Members(String rank, String color, char symbol) { // ���췽��
	        this.rank = rank;
	        this.color = color;
	        this.symbol = symbol;
	    }
	}
	
	private Members bro;
	
    public Brothers(int b) { // b �� 0 �� 6�������ϴ����ߣ������ڴ˷�Χ��ȡ mod 7
    	super();
        bro = Members.values()[b % 7];
        name = "��«��" + bro.rank;
        symbol = bro.symbol;
    }
    
    public String getColor() {
        return bro.color;
    }
}
