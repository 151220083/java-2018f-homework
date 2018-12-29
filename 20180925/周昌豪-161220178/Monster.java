package Battle;
import java.util.Random;

enum MonsterType{Snake, Scorpion, minion};//�߾��� Ы�Ӿ��� Сආ�

class Monster extends Creature
{
	MonsterType type;
	
	public Monster(MonsterType aMon)
	{
		this.type = aMon;
	}
	
	@Override
	public String OutPutInfo()
	{
		if(this.type == MonsterType.Snake)
			return "CheerLeader";
		else
			return this.type.name();
	}
}

class MonsterTeam extends CreatureTeam
{	
	public static final int MonsterNumMax = 7;
	
	/*�����µ�Monster�б�*/
	@Override
	protected void GetRandomList()
	{
		list = new Monster[MonsterNumMax];
		list[0] = new Monster(MonsterType.Scorpion);
		for(int i = 1;i < list.length; i++)
			list[i] = new Monster(MonsterType.minion);
	}
	
	/*MonsterTeam����������ʼ��Monster�б���ʼ��Snake*/
	public MonsterTeam()
	{
		GetRandomList();
		this.cheerleader = new Monster(MonsterType.Snake);
	}
	
	/*���ɷ�Χ�����*/
	private int RandomNumberInRange(int min, int max)
	{
		return new Random().nextInt(max -min) + min;
	}
	
	/*����*/
	@Override
	public void SetRandomFormation(Field field)
	{
		/* 1 <= y <= 3, 1 <= x <= 2*/
		int rx = RandomNumberInRange(8, 9);
		int ry = RandomNumberInRange(1, 4);
		//System.out.println(ry + " " + rx);
		Position[] pos = Formation.GetRandomFormation();
		
		assert(this.list.length == pos.length);
		for(int i = 0;i < this.list.length; i++)
		{
			list[i].pos.SetPos(ry + pos[i].y() , rx - pos[i].x());
			field.Set(list[i], ry + pos[i].y(), rx - pos[i].x());
		}
		
		int cheerleaderPos = 0;
		do {
			cheerleaderPos = RandomNumberInRange(0, Field.PlantSize - 1);
		}while(false == field.Set(this.cheerleader, cheerleaderPos, Field.PlantSize - 1));
			
	}
}