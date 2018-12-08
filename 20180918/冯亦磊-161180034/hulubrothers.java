import java.util.*;

public enum hulubrothers {
    RED(1, "��ɫ", "�ϴ�"), ORANGE(2, "��ɫ", "�϶�"), YELLOW(3, "��ɫ", "����"), GREEN(4, "��ɫ", "����"),
    CYAN(5, "��ɫ", "����"), BLUE(6, "��ɫ", "����"), PURPLE(7, "��ɫ", "����");
    private int rank;
    private String color;
    private String desc;//��������

    private hulubrothers(int rank, String color, String desc) {
        this.rank = rank;
        this.color = color;
        this.desc = desc;
    }



    public static void BubbleSort(hulubrothers[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j].rank > arr[j + 1].rank) {
                    System.out.println(arr[i].desc + ":" + (j + 1) + "->" + (j + 2));
                    hulubrothers temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void BinaryInsertSort(hulubrothers[] arr) {
        for (int i = 1; i < arr.length; i++) {
                hulubrothers temp = arr[i];
                int low= 0;
                int high = i - 1;
                while (low <= high) {
                    int mid = (low + high) / 2;
                    if (arr[mid].rank > temp.rank) {
                        high = mid - 1;
                    } else if(arr[mid].rank < temp.rank){
                        low = mid + 1;
                    }
                }
                    for (int j = i-1; j >= low; j--) {
                        arr[j+1] = arr[j];
                    }
                    arr[low] = temp;
                    System.out.println(temp.desc + ":" + (i + 1) + "->" + (low+1) );

        }
    }

    public static hulubrothers[] RandomArray(hulubrothers[] arr){
        int len=arr.length;
        for(int i=0;i<len-1;i++){
            int randomi=(int)(Math.random()*(len-i));
            hulubrothers tmp=arr[randomi];
            arr[randomi]=arr[len-i-1];
            arr[len-i-1]=tmp;
        }
        return arr;
    }

    public static void PrintName(hulubrothers[] arr) {
        for (int i=0; i < arr.length; i++) {
            System.out.println(arr[i].desc);
        }
    }

    public static void PrintColor(hulubrothers[] arr) {
        for (int i=0; i < arr.length; i++) {
            System.out.println(arr[i].color);
        }
    }

    public static void main(String[] args) {
        hulubrothers[] arr = {RED,ORANGE,YELLOW,GREEN,CYAN,BLUE,PURPLE};
        RandomArray(arr);
        System.out.println("Random list:");
        PrintName(arr);
        System.out.println("ð������:");
        BubbleSort(arr);
        System.out.println("�������:");
        PrintName(arr);
        RandomArray(arr);
        System.out.println("Random list:");
        PrintName(arr);
        System.out.println("��������:");
        BinaryInsertSort(arr);
        System.out.println("�������:");
        PrintColor(arr);
    }
}
