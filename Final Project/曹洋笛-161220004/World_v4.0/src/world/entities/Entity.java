package world.entities;

import world.CharWindow;
import world.Global;
import world.creatures.Creature;
import world.util.*;

/**
 *	����ʵ����. <br>
 *	���� + λ�� + �̣߳���Ϊ���������ÿ�����ﶼ�����Ӧ��ʵ��
 * 
 *	@author Mirror
 * 
 *	@see CharWindow.#entities
 *	@see #creature
 *	@see #position
 *	@see #thread
 *	@see #state
 *	@see #die()
 *	@see #out()
 *	@see #move(Point)
 *	@see #run()
 *	@see #start()
 */
public class Entity implements Runnable {

	public enum EntityState {
		LIVE, // ����
		DEAD, // ����
		OUT; // �������緶Χ
	}
	
	/**	״̬ */
	private EntityState state;
	
	/**	���� */
	private Creature creature;
	
	/**	λ�� */
	private Point position;
	
	/**	�߳� */
	private Thread thread; 
	
	/**	�Լ����� */
	public void die() {
		state = EntityState.DEAD;
	}
	
	/**	�Լ����� */
	public void out() {
		state = EntityState.OUT;
	}
	
	/**	@return ״̬ */
	public EntityState state() {
		return state;
	}

	/**	@return λ�� */
	public Point position() {
		return position;
	}

	/**	@return ʵ�� */
	public Creature creature() {
		return creature;
	}
	
	public Entity(Creature c, Point p) {
		state = EntityState.LIVE;
		creature = c.copy();
		position = p.copy();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (obj instanceof Entity) {
			Entity en = (Entity) obj;
			return ((this.position.equals(en.position)) && (this.creature.equals(en.creature)));
		}
		return false;
	}
	
	/**	�������ƶ�Entity
	 *	����Entity�������ʵ���ķ���
	 */
	public void move(Point d) {
		synchronized (this) {
			// �������ƶ�Ŀ��λ�������緶Χ֮���ұ�ʵ����LIVE��
			if ((state == EntityState.LIVE) && (Global.inWorld(position.mov(d)))) {
				Entity target = CharWindow.getLiveEntityAt(position.mov(d));
				if (target != null) { // ����һ��ʵ��������
					// ͬ��Ӫ����ʱ�ص���������target���߳�֮����Դ�
					if (target.creature().getGroup() == creature.getGroup()) {
						position.reset(position.mov(d));
					}
					else { // ���˾�����
						if (Global.win(creature.getGroup())) {
							target.die();
							position.reset(position.mov(d));
						}
						else this.die();
					}
				}
				else // ǰ���ǿյأ�����ǰ��
					position.reset(position.mov(d));
			}
			else { // �����ƶ�Ŀ��λ�ó������緶Χ
				position.reset(position.mov(d));
				out();
			}
		}
	}
	
	@Override
	public void run() {
		if (creature.getGroup() == GroupType.Bro)
			move(new Point(0, 1));
		else move(new Point(0, -1));
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	/**	�����߳� */
	public void start() {
    	  thread = new Thread(this);
    	  thread.start();
	   }
}
