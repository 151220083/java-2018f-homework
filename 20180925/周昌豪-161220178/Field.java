package Battle;

public class Field 
{
	private Tile[][] plant;
	
	public static final int PlantSize = 10;
	
	/*Field������,*****��ÿ��λ��newһ��Tile*****����������*/
	public Field()
	{
		plant = new Tile[PlantSize][PlantSize];
		for(int i = 0;i < PlantSize;i++)
			for(int j = 0;j < PlantSize;j++)
				plant[i][j] = new Tile();
	}

	/*��plant[i][j]����Creature*/
	public boolean Set(Creature creature, int x, int y)
	{
		if(true == plant[x][y].IsEmpty())
		{
			plant[x][y].Set(creature);
			return true;
		}
		else
			return false;
	}
	
	/*���plant������ƽ̨*/
	public void AllClear()
	{
		for(int i = 0;i < PlantSize; i++)
			for(int j = 0; j < PlantSize; j++)
				plant[i][j].Clear();
	}
	
	/*��ӡƽ̨*/
	public void PrintPlant()
	{
		System.out.println("");
		for(int i = 0;i < PlantSize;i++)
		{
			for(int j = 0;j < PlantSize;j++)
			{
				plant[i][j].Print();
			}
			System.out.println();
		}
	}
}
