package world.creatures;

/* ��������� */

public abstract class Creature {

    protected String name; // ��������

    protected char symbol; // ��ʾ����

    protected Creature() {}
    
    public String getName() {
        return name;
    }

    public char getSymbol() {
        return symbol;
    }
}
