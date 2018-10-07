import java.util.Random;

// ����ö������
enum Guys {
    ST1("�ϴ�",'A'), ND2("�϶�",'B'), RD3("����",'C'),
    TH4("����",'D'), TH5("����",'E'), TH6("����",'F'), TH7("����",'G');
    public String rank;
    public char symbol;
    private Guys(String rank, char symbol) { // ���췽��
        this.rank = rank;
        this.symbol = symbol;
    }
}
// ���£�����ԭ��������Ͻǣ�ָ�����º�����
// �����«������
class brotherFormation {
    private int[] posX, posY; // 7��λ������
    private int cheerX, cheerY; // ��������λ��
    public brotherFormation(int x, int y) {
        posX = new int[7];
        posY = new int[7];
        for (int i = 0; i < 7; i++) {
            posX[i] = x;
            posY[i] = y + i - 3;
        }
    }
    private void oldCheer() { // ��үү����
        if ('@' == FieldFormation.findField(cheerX, cheerY))
            FieldFormation.setField(cheerX, cheerY, ' ');
        Random randArray = new Random(); // �����������
        // ��үү��λ��Ϊ���ο������«�޵�λ��ƫ���������(<=2)
        int ref = randArray.nextInt(7) % 7; // posX/posY[0 ~ 6]
        int dx, dy;
        while (true) { // ֱ���ҵ�����λ��
            dx = randArray.nextInt(5) % 5 - 2; // -2 ~ 2
            dy = randArray.nextInt(5) % 5 - 2; // -2 ~ 2
            if (' ' == FieldFormation.findField(posX[ref] + dx, posY[ref] + dy))
                break;
        }
        cheerX = posX[ref] + dx;
        cheerY = posY[ref] + dy;
        FieldFormation.setField(cheerX, cheerY, '@');
    }
    public void inField() { // �����ͷ��볡��
        for (Guys g : Guys.values()) {
            int i = g.compareTo(Guys.ST1);
            FieldFormation.setField(posX[i], posY[i], g.symbol);
        }
        oldCheer();
    }
    public void delFormation() { // ȡ������
        for (int i = 0; i < 7; i++)
            FieldFormation.setField(posX[i], posY[i], ' ');
        FieldFormation.setField(cheerX, cheerY, ' ');
    }
    public void movFormation(int dx, int dy) { // �ƶ�����
        for (int i = 0; i < 7; i++) {
            FieldFormation.setField(posX[i], posY[i], ' ');
            posX[i] += dx;
            posY[i] += dy;
        }
        inField();
    }
}
// ������������
class monsterFormation {
    protected int lackeyNum; // Сආ�����
    protected int[] lackeyX, lackeyY; // Сආ�+Ы�Ӿ�����
    private int cheerX, cheerY; // ��������λ��
    private void snakeCheer() { // �߾�����
        if ('$' == FieldFormation.findField(cheerX, cheerY))
            FieldFormation.setField(cheerX, cheerY, ' ');
        Random randArray = new Random(); // �����������
        // �߾���λ��Ϊ���ο������Ա��λ��ƫ���������(<=2)
        int num = lackeyNum + 1;
        int ref = randArray.nextInt(num) % num; // lackeyX/lackeyY[0 ~ lackeyNum]
        int dx, dy;
        while (true) { // ֱ���ҵ�����λ��
            dx = randArray.nextInt(5) % 5 - 2; // -2 ~ 2
            dy = randArray.nextInt(5) % 5 - 2; // -2 ~ 2
            if (' ' == FieldFormation.findField(lackeyX[ref] + dx, lackeyY[ref] + dy))
                break;
        }
        cheerX = lackeyX[ref] + dx;
        cheerY = lackeyY[ref] + dy;
        FieldFormation.setField(cheerX, cheerY, '$');
    }
    public void inField() { // �����ͷ��볡��
        for (int i = 0; i < lackeyNum; i++)
            FieldFormation.setField(lackeyX[i], lackeyY[i], 'o');
        FieldFormation.setField(lackeyX[lackeyNum], lackeyY[lackeyNum], '&');
        snakeCheer();
    }
    public void delFormation() { // ȡ������
        for (int i = 0; i <= lackeyNum; i++)
            FieldFormation.setField(lackeyX[i], lackeyY[i], ' ');
        FieldFormation.setField(cheerX, cheerY, ' ');
    }
    public void movFormation(int dx, int dy) { // �ƶ�����
        for (int i = 0; i <= lackeyNum; i++) {
            FieldFormation.setField(lackeyX[i], lackeyY[i], ' ');
            lackeyX[i] += dx;
            lackeyY[i] += dy;
        }
        inField();
    }
}
// ������
class vFormation extends monsterFormation {
    public vFormation(int x, int y) { // ������Ĺ��캯������ʾ�ĵ��ø���Ĺ��캯��
        super();
        lackeyNum = 6;
        lackeyX = new int[lackeyNum + 1];
        lackeyY = new int[lackeyNum + 1];
        lackeyX[0] = x - 3; lackeyY[0] = y - 3;
        lackeyX[1] = x - 2; lackeyY[1] = y - 2;
        lackeyX[2] = x - 1; lackeyY[2] = y - 1;
        lackeyX[3] = x + 1; lackeyY[3] = y - 1;
        lackeyX[4] = x + 2; lackeyY[4] = y - 2;
        lackeyX[5] = x + 3; lackeyY[5] = y - 3;
        lackeyX[6] = x; lackeyY[6] = y; // Ы�Ӿ�
    }
}
// ������
class iFormation extends monsterFormation {
    public iFormation(int x, int y) { // ������Ĺ��캯������ʾ�ĵ��ø���Ĺ��캯��
        super();
        lackeyNum = 4;
        lackeyX = new int[lackeyNum + 1];
        lackeyY = new int[lackeyNum + 1];
        lackeyX[0] = x - 2; lackeyY[0] = y + 2;
        lackeyX[1] = x - 1; lackeyY[1] = y + 1;
        lackeyX[2] = x + 1; lackeyY[2] = y - 1;
        lackeyX[3] = x + 2; lackeyY[3] = y - 2;
        lackeyX[4] = x; lackeyY[4] = y; // Ы�Ӿ�
    }
}
// ������
class llFormation extends monsterFormation {
    public llFormation(int x, int y) { // ������Ĺ��캯������ʾ�ĵ��ø���Ĺ��캯��
        super();
        lackeyNum = 5;
        lackeyX = new int[lackeyNum + 1];
        lackeyY = new int[lackeyNum + 1];
        lackeyX[0] = x; lackeyY[0] = y - 2;
        lackeyX[1] = x; lackeyY[1] = y + 2;
        lackeyX[2] = x + 1; lackeyY[2] = y - 3;
        lackeyX[3] = x + 1; lackeyY[3] = y - 1;
        lackeyX[4] = x + 1; lackeyY[4] = y + 1;
        lackeyX[5] = x; lackeyY[5] = y; // Ы�Ӿ�
    }
}
// ������
class xFormation extends monsterFormation {
    public xFormation(int x, int y) { // ������Ĺ��캯������ʾ�ĵ��ø���Ĺ��캯��
        super();
        lackeyNum = 9;
        lackeyX = new int[lackeyNum + 1];
        lackeyY = new int[lackeyNum + 1];
        lackeyX[0] = x; lackeyY[0] = y - 2;
        lackeyX[1] = x + 1; lackeyY[1] = y - 1;
        lackeyX[2] = x + 2; lackeyY[2] = y;
        lackeyX[3] = x + 3; lackeyY[3] = y + 1;
        lackeyX[4] = x + 1; lackeyY[4] = y + 1;
        lackeyX[5] = x - 1; lackeyY[5] = y + 1;
        lackeyX[6] = x - 3; lackeyY[6] = y + 1;
        lackeyX[7] = x - 2; lackeyY[7] = y;
        lackeyX[8] = x; lackeyY[8] = y + 2;
        lackeyX[9] = x; lackeyY[9] = y; // Ы�Ӿ�
    }
}
// ������
class oFormation extends monsterFormation {
    public oFormation(int x, int y) { // ������Ĺ��캯������ʾ�ĵ��ø���Ĺ��캯��
        super();
        lackeyNum = 7;
        lackeyX = new int[lackeyNum + 1];
        lackeyY = new int[lackeyNum + 1];
        lackeyX[0] = x + 1; lackeyY[0] = y - 1;
        lackeyX[1] = x + 1; lackeyY[1] = y + 1;
        lackeyX[2] = x + 2; lackeyY[2] = y - 2;
        lackeyX[3] = x + 2; lackeyY[3] = y + 2;
        lackeyX[4] = x + 3; lackeyY[4] = y - 1;
        lackeyX[5] = x + 3; lackeyY[5] = y + 1;
        lackeyX[6] = x + 4; lackeyY[6] = y;
        lackeyX[7] = x; lackeyY[7] = y; // Ы�Ӿ�
    }
}
// ������
class cFormation extends monsterFormation {
    public cFormation(int x, int y) { // ������Ĺ��캯������ʾ�ĵ��ø���Ĺ��캯��
        super();
        lackeyNum = 18;
        lackeyX = new int[lackeyNum + 1];
        lackeyY = new int[lackeyNum + 1];
        lackeyX[0] = x - 1; lackeyY[0] = y - 1;
        lackeyX[1] = x - 1; lackeyY[1] = y;
        lackeyX[2] = x - 1; lackeyY[2] = y + 1;
        lackeyX[3] = x; lackeyY[3] = y - 1;
        lackeyX[4] = x; lackeyY[4] = y + 1;
        lackeyX[5] = x + 1; lackeyY[5] = y - 2;
        lackeyX[6] = x + 1; lackeyY[6] = y - 1;
        lackeyX[7] = x + 1; lackeyY[7] = y;
        lackeyX[8] = x + 1; lackeyY[8] = y + 1;
        lackeyX[9] = x + 1; lackeyY[9] = y + 2;
        lackeyX[10] = x + 2; lackeyY[10] = y - 3;
        lackeyX[11] = x + 2; lackeyY[11] = y - 2;
        lackeyX[12] = x + 2; lackeyY[12] = y + 2;
        lackeyX[13] = x + 2; lackeyY[13] = y + 3;
        lackeyX[14] = x + 3; lackeyY[14] = y - 3;
        lackeyX[15] = x + 3; lackeyY[15] = y + 3;
        lackeyX[16] = x + 4; lackeyY[16] = y - 4;
        lackeyX[17] = x + 4; lackeyY[17] = y + 4;
        lackeyX[18] = x; lackeyY[18] = y; // Ы�Ӿ�
    }
}
// ��ʸ��
class mFormation extends monsterFormation {
    public mFormation(int x, int y) { // ������Ĺ��캯������ʾ�ĵ��ø���Ĺ��캯��
        super();
        lackeyNum = 11;
        lackeyX = new int[lackeyNum + 1];
        lackeyY = new int[lackeyNum + 1];
        lackeyX[0] = x - 2; lackeyY[0] = y - 1;
        lackeyX[1] = x - 2; lackeyY[1] = y;
        lackeyX[2] = x - 2; lackeyY[2] = y + 1;
        lackeyX[3] = x - 1; lackeyY[3] = y - 2;
        lackeyX[4] = x - 1; lackeyY[4] = y;
        lackeyX[5] = x - 1; lackeyY[5] = y + 2;
        lackeyX[6] = x; lackeyY[6] = y - 3;
        lackeyX[7] = x; lackeyY[7] = y + 3;
        lackeyX[8] = x + 1; lackeyY[8] = y;
        lackeyX[9] = x + 2; lackeyY[9] = y;
        lackeyX[10] = x + 3; lackeyY[10] = y;
        lackeyX[11] = x; lackeyY[11] = y; // Ы�Ӿ�
    }
}

// ʵ��
public class FieldFormation {
    // ���峡��
    private static int fieldLen; // ���أ��������߳�
    private static char[][] field; // ����
    static { // ��̬������ʼ��
        fieldLen = 15;
        field = new char[fieldLen][fieldLen];
        initField();
    }
    public static void initField() {
        for (int i = 0; i < fieldLen; i++) {
            for (int j = 0; j < fieldLen; j++)
                field[i][j] = ' ';
        }
    }
    public static char findField(int x, int y) { // ȡ����(x,y)��ֵ
        if ((x >= 0) && (x < fieldLen) && (y >= 0) && (y < fieldLen))
            return field[x][y];
        else return '-';
    }
    public static void setField(int x, int y, char c) { // ������(x,y)����һ������
        if ((x >= 0) && (x < fieldLen) && (y >= 0) && (y < fieldLen))
            field[x][y] = c;
    }
    public static void printField() {
        for (int j = 0; j < fieldLen; j++) {
            for (int i = 0; i < fieldLen; i++) {
                System.out.print(field[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        System.out.println("��������Ы�Ӿ�&�Ĵ������ų��˺����󣬺�«��ABCDEFG�ų��˳�����");
        System.out.println("��үү��@��Ϊ��«���������߾���$��Ϊ�����Ǽ���");
        brotherFormation broForm = new brotherFormation(3, 7);
        broForm.inField();
        vFormation vForm = new vFormation(10, 7);
        vForm.inField();
        printField();
        vForm.delFormation();
        System.out.println("�����ǻ����������󣬺�«�޿�Ȼ����");
        iFormation iForm = new iFormation(10, 7);
        iForm.inField();
        printField();
        iForm.delFormation();
        System.out.println("�����ǻ����˳����󣬺�«�޿�Ȼ����");
        llFormation llForm = new llFormation(10, 7);
        llForm.inField();
        printField();
        llForm.delFormation();
        System.out.println("�����ǻ����������󣬺�«�޿�Ȼ����");
        xFormation xForm = new xFormation(10, 7);
        xForm.inField();
        printField();
        xForm.delFormation();
        System.out.println("�����ǻ����˷����󣬺�«�޿�Ȼ����");
        oFormation oForm = new oFormation(10, 7);
        oForm.inField();
        printField();
        oForm.delFormation();
        System.out.println("�����ǻ����������󣬺�«�޿�Ȼ����");
        cFormation cForm = new cFormation(10, 7);
        cForm.inField();
        printField();
        cForm.delFormation();
        System.out.println("�����ǻ����˷�ʸ�󣬺�«�޿�Ȼ����");
        mFormation mForm = new mFormation(10, 7);
        mForm.inField();
        printField();
        System.out.println("���������󷢶��������«������ӭս");
        mForm.movFormation(-3, 0);
        broForm.movFormation(1, 0);
        printField();
        System.out.println("��������ȴ�ˣ���«�޳�ʤ׷��");
        mForm.movFormation(2, 0);
        broForm.movFormation(1, 0);
        printField();
    }
}