
public enum CalabashBro {
	CB1("�ϴ�","��ɫ",1),
	CB2("�϶�","��ɫ",2),
	CB3("����","��ɫ",3),
	CB4("����","��ɫ",4),
	CB5("����","��ɫ",5),
	CB6("����","��ɫ",6),
	CB7("����","��ɫ",7);

    private int order;
    private String name;
    private String color;

    private CalabashBro(String name,String color,int order)
    {
        this.name = name;
        this.color = color;
        this.order = order;
    }

    public String getName() {
    	return name;
    }

    public String getColor() {
    	return color;
    }
    
    public int getOrder() {
    	return order;
	}
    
    public void tellName() {
		System.out.print(name+" ");
	}
    
    public void tellColor() {
		System.out.print(color+" ");
	}
    
    public void tellPosEx(int i,int j) {
    	System.out.print(name+": "+i+" -> "+j+"\n");
    }
}
