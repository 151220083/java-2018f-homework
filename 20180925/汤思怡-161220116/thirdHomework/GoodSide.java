package thirdHomework;

public class GoodSide implements Formate {
	private Human grandpa = new Human();
	private CalabashBrothers calabashBrothers;

	public GoodSide(int order[]) {
		// TODO Auto-generated constructor stub
		calabashBrothers = new CalabashBrothers(order);
	}

	@Override
	public void formate(Creature[][] dimension, Formation form) {
		// TODO Auto-generated method stub
		System.out.println("�����ѹ̶������ñ任");
	}

	@Override
	public void formate(Creature[][] dimension) {
		// TODO Auto-generated method stub
		calabashBrothers.sort();
		calabashBrothers.snakeForm(dimension);
		grandpa.stand(dimension, 6, 0);
	}
}
