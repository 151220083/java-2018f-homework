package square;

enum Member {
	EMPTY(" "),
	RED("����"),
	ORANGE("����"),
	YELLOW("����"),
	GREEN("����"),
	CYAN("����"),
	BLUE("����"),
	PURPLE("����"),
	GRANDFATHER("үү"),
	SCORPION("��򼾫"),
	SERPENT("�߾�"),
	UNDERLING("ආ�");
	Member(String name){
		this.name=name;
	}
	String name;
};
enum Forces{
	HULUWA,
	ENEMY;
};