package thirdHomework;

public enum Species {
	/*
	 * ���ֵ����֣���«�ޡ���үү���߾���Ы�Ӿ���Сආ�
	 */
	CALABASH("��«��"), GRANDPA("��үү"), SNAKE("�߾�"), SCORPION("Ы�Ӿ�"), MINION("Сආ�");
	private String name;

	private Species(String name) {
		this.name = name;
	}

	public String toString() {
		return name;
	}
}
