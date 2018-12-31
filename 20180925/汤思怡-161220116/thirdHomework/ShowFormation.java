package thirdHomework;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;
import java.awt.*;

public class ShowFormation extends JFrame implements Constants {
	private JPanel frame;
	private JButton btnCrane, btnGoose, btnYoke, btnFish, btnSquare, btnMoon, btnFront;
	private JLabel[][] label = new JLabel[Constants.NUM][Constants.NUM];
	Creature[][] dimension = new Creature[Constants.NUM][Constants.NUM];
	private final ImageIcon background = new ImageIcon("image\\background.jpg");
	EvilSide evilSide;
	GoodSide goodSide;

	// ��������������д�ӡ��������
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ShowFormation sFormation = new ShowFormation();
	}

	public ShowFormation() {
		initDimension();
		initFrame();
		initButton();
	}

	// ��ʼ�������ά����
	private void initDimension() {
		for (int i = 0; i < Constants.NUM; i++) {
			for (int j = 0; j < Constants.NUM; j++) {
				dimension[i][j] = null;
			}
		}
		int[] order = { 2, 6, 3, 5, 1, 4, 0 };
		goodSide = new GoodSide(order);
		evilSide = new EvilSide();
		goodSide.formate(dimension);
		background.setImage(background.getImage().getScaledInstance(IMAGE_WIDTH, IMAGE_HEIGHT, Image.SCALE_DEFAULT));
	}

	// ��ʼ��������
	private void initFrame() {
		frame = new JPanel();
		getContentPane().add(frame);
		frame.setLayout(null);
		frame.setSize(Constants.TOTAL_WIDTH, Constants.TOTAL_HEIGHT);
		getContentPane().add(frame);
		this.setSize(Constants.TOTAL_WIDTH, Constants.TOTAL_HEIGHT);
		this.setResizable(false);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("��«�޴�սЫ�Ӿ�������С����");
	}

	// ��ʼ����ť
	private void initButton() {
		initLabel();
		initCraneButton();
		initGooseButton();
		initYokeButton();
		initFishButton();
		initSquareButton();
		initMoonButton();
		initFrontButton();
	}

	// ��ʼ��ÿ����ǩ
	private void initLabel() {
		for (int i = 0; i < Constants.NUM; i++) {
			for (int j = 0; j < Constants.NUM; j++) {
				label[i][j] = new JLabel();
				frame.add(label[i][j]);
			}
		}
	}

	// ���ð�ť����
	private void initCraneButton() {
		btnCrane = new JButton();
		frame.add(btnCrane);
		btnCrane.setText("����");
		btnCrane.setBounds(TOTAL_WIDTH - 2 * IMAGE_WIDTH, IMAGE_HEIGHT / 2, IMAGE_WIDTH, IMAGE_HEIGHT / 2);
		btnCrane.addMouseListener(new MouseAdapter() {// ����ť���ϼ����¼�
			public void mouseClicked(MouseEvent e1) {
				System.out.println("����");
				initDimension();
				evilSide.formate(dimension, Formation.CRANE);
				setDimension();
			}

		});
	}

	// ���ð�ť����
	private void initGooseButton() {
		btnGoose = new JButton();
		frame.add(btnGoose);
		btnGoose.setText("����");
		btnGoose.setBounds(TOTAL_WIDTH - 2 * IMAGE_WIDTH, IMAGE_HEIGHT * 3 / 2, IMAGE_WIDTH, IMAGE_HEIGHT / 2);
		btnGoose.addMouseListener(new MouseAdapter() {// ����ť���ϼ����¼�
			public void mouseClicked(MouseEvent e1) {
				System.out.println("����");
				initDimension();
				evilSide.formate(dimension, Formation.GOOSE);
				setDimension();
			}
		});
	}

	// ���ð�ť����
	private void initYokeButton() {
		btnYoke = new JButton();
		frame.add(btnYoke);
		btnYoke.setText("����");
		btnYoke.setBounds(TOTAL_WIDTH - 2 * IMAGE_WIDTH, IMAGE_HEIGHT * 5 / 2, IMAGE_WIDTH, IMAGE_HEIGHT / 2);
		btnYoke.addMouseListener(new MouseAdapter() {// ����ť���ϼ����¼�
			public void mouseClicked(MouseEvent e1) {
				System.out.println("����");
				initDimension();
				evilSide.formate(dimension, Formation.YOKE);
				setDimension();
			}
		});
	}

	// ���ð�ť����
	private void initFishButton() {
		btnFish = new JButton();
		frame.add(btnFish);
		btnFish.setText("����");
		btnFish.setBounds(TOTAL_WIDTH - 2 * IMAGE_WIDTH, IMAGE_HEIGHT * 7 / 2, IMAGE_WIDTH, IMAGE_HEIGHT / 2);
		btnFish.addMouseListener(new MouseAdapter() {// ����ť���ϼ����¼�
			public void mouseClicked(MouseEvent e1) {
				System.out.println("����");
				initDimension();
				evilSide.formate(dimension, Formation.FISH);
				setDimension();
			}
		});
	}

	// ���ð�ť����
	private void initSquareButton() {
		btnSquare = new JButton();
		frame.add(btnSquare);
		btnSquare.setText("����");
		btnSquare.setBounds(TOTAL_WIDTH - 2 * IMAGE_WIDTH, IMAGE_HEIGHT * 9 / 2, IMAGE_WIDTH, IMAGE_HEIGHT / 2);
		btnSquare.addMouseListener(new MouseAdapter() {// ����ť���ϼ����¼�
			public void mouseClicked(MouseEvent e1) {
				System.out.println("����");
				initDimension();
				evilSide.formate(dimension, Formation.SQAURE);
				setDimension();
			}
		});
	}

	// ���ð�ť����
	private void initMoonButton() {
		btnMoon = new JButton();
		frame.add(btnMoon);
		btnMoon.setText("����");
		btnMoon.setBounds(TOTAL_WIDTH - 2 * IMAGE_WIDTH, IMAGE_HEIGHT * 11 / 2, IMAGE_WIDTH, IMAGE_HEIGHT / 2);
		btnMoon.addMouseListener(new MouseAdapter() {// ����ť���ϼ����¼�
			public void mouseClicked(MouseEvent e1) {
				System.out.println("����");
				initDimension();
				evilSide.formate(dimension, Formation.MOON);
				setDimension();
			}
		});
	}

	// ���ð�ť��ʧ
	private void initFrontButton() {
		btnFront = new JButton();
		frame.add(btnFront);
		btnFront.setText("��ʧ");
		btnFront.setBounds(TOTAL_WIDTH - 2 * IMAGE_WIDTH, IMAGE_HEIGHT * 13 / 2, IMAGE_WIDTH, IMAGE_HEIGHT / 2);
		btnFront.addMouseListener(new MouseAdapter() {// ����ť���ϼ����¼�
			public void mouseClicked(MouseEvent e1) {
				System.out.println("��ʧ");
				initDimension();
				evilSide.formate(dimension, Formation.FRONT);
				setDimension();
			}
		});

	}

	// ���������ʾͼƬ
	private void setDimension() {
		for (int i = 1; i < Constants.NUM; i++) {
			for (int j = 0; j < Constants.NUM; j++) {
				label[i][j].setBounds(j * IMAGE_WIDTH, (i - 1) * IMAGE_HEIGHT, IMAGE_WIDTH, IMAGE_HEIGHT);
				if (dimension[i][j] != null) {
					label[i][j].setIcon(dimension[i][j].icon);
					System.out.print(dimension[i][j].name + "\t");
				} else {
					System.out.print("\t");
					label[i][j].setIcon(background);
				}
			}
			System.out.println();
		}
	}
}
