package sort;
enum Color{
	��ɫ,��ɫ,��ɫ,��ɫ,��ɫ,��ɫ,��ɫ;
}
public enum CalabashBrothers {
	One("�ϴ�",Color.��ɫ),
	Two("�϶�",Color.��ɫ),
	Three("����",Color.��ɫ),
	Four("����",Color.��ɫ),
	Five("����",Color.��ɫ),
	Six("����",Color.��ɫ),
	Seven("����",Color.��ɫ);
	
	private String name;
	private Color color;
	
	private CalabashBrothers(String n,Color c) {
		this.name = n;
		this.color = c;
	}
	
	public String getName() {
		return name;
	}
	
	public Color getColor() {
		return color;
	}
	
	public void queueClaimName(CalabashBrothers[] Calabash) {
		System.out.println("\n������ʼ");
		for(int i=0;i<Calabash.length;i++)
			System.out.println(Calabash[i].getName());
		System.out.println("��������\n");
	}
	
	public void queueClaimColor(CalabashBrothers[] Calabash) {
		System.out.println("\n����ɫ��ʼ");
		for(int i=0;i<Calabash.length;i++)
			System.out.println(Calabash[i].getColor());
		System.out.println("����ɫ����");
	}
	public void swapClaim(String people,int old_location,int new_location) {
		System.out.println(people+":"+old_location+"->"+new_location);
	}
	
	
}
