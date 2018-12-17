package world.test;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.junit.Test;

import world.CoreWorld;
import world.Entity;
import world.Global;
import world.util.EntityState;
import world.util.FormationType;
import world.util.GroupType;
import world.util.Point;
import world.xml.XMLRecordReader;

public class XMLRecordReaderTest {

	private CoreWorld cWrd;
	
	private XMLRecordReader recordReader;
	
	private Map<Integer, Entity> expectedEntities;
	
	public XMLRecordReaderTest() {
		System.out.println("# ��ʼ��������� XMLRecordReaderTest");
		cWrd = new CoreWorld();
		// �����ļ��ĳ�ʼ��̬�� YL + CE
		cWrd.initFormation(FormationType.YL, GroupType.Bro);
		cWrd.initFormation(FormationType.CE, GroupType.Mon);
		// ��ȷ��entities����Ӧ������
		expectedEntities = new HashMap<>();
		for (Point p : cWrd.broForm.formMap.keySet()) { // ����ȫ����«��
			Point pos = Global.leftCenterP.mov(cWrd.broForm.getFormCen().reverse()).mov(p);
			Entity en = new Entity(p, cWrd.broForm.getCreature(p), pos);
			expectedEntities.put(en.id, en);
		}
		for (Point p : cWrd.monForm.formMap.keySet()) { // ����ȫ������
			Point pos = Global.rightCenterP.mov(cWrd.monForm.getFormCen().reverse()).mov(p);
			Entity en = new Entity(p, cWrd.monForm.getCreature(p), pos);
			expectedEntities.put(en.id, en);
		}
		// �����������Զ���Ҫ��һ����ʼ��
		// ��ʱ��CoreWorld.entities�Ѿ��Ǵ��ļ���ȡ�Ľ����
		recordReader = new XMLRecordReader(Global.defaultTestFilename);
		System.out.println("# �����๹��ɹ�");
	}
	
	@Test
	public void testXMLRecordReader() {
		System.out.println("# ���Է��� XMLRecordReader");
		// ���������XMLRecordReader(String)���õ�(private)���� initEntitiesByElement()
		// �����Դ��ļ���ȡ��CoreWorld.entities��expectedEntities�Ƿ����
		Iterator<Integer> it = CoreWorld.entities.keySet().iterator();
        while (it.hasNext()) {
            Integer actualId = it.next();
            Entity actualEntity = CoreWorld.entities.get(actualId);
            Entity expectedEntity = expectedEntities.get(actualId);
            // expectedEntity != null
            assertNotNull(expectedEntity); 
            // expectedEntity equals actualEntity
            assertTrue(expectedEntity.id == actualEntity.id);
            assertTrue(expectedEntity.state == actualEntity.state);
            assertTrue(expectedEntity.creature.equals(actualEntity.creature));
            assertTrue(expectedEntity.position.equals(actualEntity.position));
            assertTrue(expectedEntity.direction.equals(actualEntity.direction));
        }
		System.out.println("# ͨ������");
	}
	
	/**	��ս�����̵� Round 18	*/
	private void setExpectedEntitiesToRound18() {
		expectedEntities.get(1056).resetEntity(EntityState.DEAD, 8, 8, 0, 0);
		expectedEntities.get(2018).resetEntity(EntityState.DEAD, 5, 9, 0, 0);
		expectedEntities.get(2054).resetEntity(EntityState.DEAD, 6, 9, 0, 0);
		expectedEntities.get(1001).resetEntity(EntityState.DEAD, 5, 10, 0, 0);
		expectedEntities.get(2090).resetEntity(EntityState.DEAD, 7, 7, 0, 0);
		expectedEntities.get(1036).resetEntity(EntityState.DEAD, 9, 6, 0, 0);
		expectedEntities.get(1037).resetEntity(EntityState.LIVE, 8, 7, 0, 0);
		expectedEntities.get(2126).resetEntity(EntityState.LIVE, 9, 6, 0, -1);
		expectedEntities.get(1039).resetEntity(EntityState.LIVE, 7, 10, 0, 0);
		expectedEntities.get(1073).resetEntity(EntityState.DEAD, 8, 9, 0, 0);
		expectedEntities.get(2001).resetEntity(EntityState.LIVE, 4, 11, 1, 0);
		expectedEntities.get(2037).resetEntity(EntityState.DEAD, 5, 10, 0, 0);
		expectedEntities.get(2073).resetEntity(EntityState.LIVE, 5, 10, -1, 0);
		expectedEntities.get(1019).resetEntity(EntityState.LIVE, 5, 9, 0, 0);
		expectedEntities.get(2109).resetEntity(EntityState.DEAD, 7, 10, 0, 0);
		expectedEntities.get(1055).resetEntity(EntityState.DEAD, 9, 10, 0, 0);
	}

	@Test
	public void testSetEntityByRound() {
		System.out.println("# ���Է��� SetEntityByRound");
		// ��������Զ�ȡ Round 18 ����ȷ��
		setExpectedEntitiesToRound18(); // ������ȷֵ
		// ����ֵ
		Iterator<Integer> it = CoreWorld.entities.keySet().iterator();
        while (it.hasNext()) {
            Integer actualId = it.next();
            Entity actualEntity = CoreWorld.entities.get(actualId);
            recordReader.setEntityByRound(actualEntity, 18);
            // ����CoreWorld.entities�Ѿ��Ǵ��ļ���ȡ�Ľ����
            Entity expectedEntity = expectedEntities.get(actualId);
            assertNotNull(expectedEntity); 
            // expectedEntity equals actualEntity
            assertTrue(expectedEntity.id == actualEntity.id);
            assertTrue(expectedEntity.state == actualEntity.state);
            assertTrue(expectedEntity.creature.equals(actualEntity.creature));
            assertTrue(expectedEntity.position.equals(actualEntity.position));
            assertTrue(expectedEntity.direction.equals(actualEntity.direction));
        }
		System.out.println("# ͨ������");
	}

}
