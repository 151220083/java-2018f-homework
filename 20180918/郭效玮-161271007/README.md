




#��«������

##��«����

        public enum CalabashBro
Ϊö�����ͣ��ܹ�ֻ���߸�ʵ��

```java

    private int order;
    private String name;
    private String color;

    private CalabashBro(String name,String color,int order);
    public String getName();
    public String getColor();
    public int getOrder();
    public void tellName();
    public void tellColor()��
    public void tellPosEx(int i,int j) {
    	System.out.print(name+": "+i+" -> "+j+"\n");
    }//����λ�õ�ʱ�򱨸�
```
##��«������Ա��

        public class CalabashSorter



```java

    private CalabashBro[] calabashList;
	public CalabashSorter();
	public void randomList();//���ڴ�������
	public void reportName()��//���ú�«����ʵ����tellName����
	public void reportColor()��//ͬ��
	public void bubbleSort()��
	public void binarySort()��
```


            