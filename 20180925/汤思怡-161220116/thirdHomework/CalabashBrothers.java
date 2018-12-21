package thirdHomework;

import javax.swing.ImageIcon;

/*
 * ��«���ֵ�
 */

//���е�ö����
enum Rank {
	ONE("����", "image/one.jpg"), TWO("����", "image/two.jpg"), THREE("����", "image/three.jpg"),
	FOUR("����", "image/four.jpg"), FIVE("����", "image/five.jpg"), SIX("����", "image/six.jpg"),
	SEVEN("����", "image/seven.jpg");
	private String rank;
	private String path;

	private Rank(String rank, String path) {
		this.rank = rank;
		this.path = path;
	}

	public String getRank() {
		return this.rank;
	}

	public String getPath() {
		return this.path;
	}
};

public class CalabashBrothers implements Constants {

	private final int NUM = 7;

	// ��«���ڲ��� ��ʼ��ÿ����«��
	private class Calabash extends Creature {
		public Calabash(int index) {
			super(index);
			this.name = Rank.values()[index].getRank();
			this.species = Species.CALABASH;
			this.icon = new ImageIcon(Rank.values()[index].getPath());
			this.standardIcon();
		}

		protected Rank getName() {
			for (int index = 0; index < NUM; index++) {
				if (Rank.values()[index].getRank() == name)
					return Rank.values()[index];
			}
			return null;
		}
	}

	// ��«���ֵ�
	private Calabash calabashBrothers[] = new Calabash[NUM];

	// ���캯������ʼ����«�ֵ�վ��˳��
	public CalabashBrothers(int order[]) {
		for (int i = 0; i < NUM; i++) {
			Calabash calabash = new Calabash(order[i]);
			calabashBrothers[i] = calabash;
		}
	}

	// �Ժ�«�޽��ж��ַ�����
	public void sort() {
		// TODO Auto-generated method stub
		Calabash temp = null;
		for (int i = 1; i < NUM; i++) {
			temp = calabashBrothers[i];
			int left = 0, right = i - 1;
			while (left <= right) {
				int mid = (left + right) / 2;
				if (calabashBrothers[mid].getName().ordinal() > temp.getName().ordinal())
					right = mid - 1;
				else
					left = mid + 1;
			}
			for (int j = i - 1; j > right; j--) {
				calabashBrothers[j + 1] = calabashBrothers[j];
			}
			calabashBrothers[right + 1] = temp;
		}
	}

	// ��«��վ��������
	protected void snakeForm(Creature dimension[][]) {
		calabashBrothers[0].stand(dimension, 3, 1);
		calabashBrothers[1].stand(dimension, 4, 1);
		calabashBrothers[2].stand(dimension, 5, 1);
		calabashBrothers[3].stand(dimension, 6, 1);
		calabashBrothers[4].stand(dimension, 7, 1);
		calabashBrothers[5].stand(dimension, 8, 1);
		calabashBrothers[6].stand(dimension, 9, 1);
	}

}