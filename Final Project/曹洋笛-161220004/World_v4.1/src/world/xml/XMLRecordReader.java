package world.xml;

import java.io.File;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import world.*;
import world.util.*;

public class XMLRecordReader extends XMLRecordStructure {

	/**	�ĵ�	*/
	private Document doc = null;
	/**	��Ԫ��	*/
	private Element root = null;
	
	public XMLRecordReader(String filename) {
		super();
		try {
			// ʹ��SAXReader��ȡ�ĵ�
			SAXReader reader = new SAXReader();
			doc = reader.read(new File(filename));
			// ��ȡ��Ԫ��
			root = doc.getRootElement();
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}

	/**	��entitiesд��
	 *	��root�н���������ʵ������ʼֵ������0�غϣ������浽entities����	*/
	public void getEntitiesByElement() {
		// ���Ƴ���ǰentities���ϵ�ȫ��ʵ��
		Iterator<Integer> it = CoreWorld.entities.keySet().iterator();
        while (it.hasNext()) {
            it.next();
            it.remove();
        }
        // �����ȡ��Entity����
		List<Element> entityEleList = root.elements();
		for (Element entityEle: entityEleList) {
			String istr = entityEle.getName();
			// ��ȡentityEle��name�ĺ�4λ
			int i = Integer.parseInt(istr.substring(istr.length() - 4, istr.length()));
			CreatureType ct = toCreatureType(entityEle.attributeValue(ctype));
			int orgr = Integer.parseInt(entityEle.attributeValue(r));
			int orgc = Integer.parseInt(entityEle.attributeValue(c));
			Entity en = new Entity(i, ct, orgr, orgc);
			CoreWorld.entities.put(en.id, en);
		}
	}
	
	/**	��entitiesд��
	 *	��root�н���������ʵ������n�غϵ�ֵ������entities����	*/
	public void setEntitiesByRound(int n) {
		// ʹ�ô˺�����ȷ��entities���ϲ�Ϊ��
		for (Entity en: CoreWorld.entities.values()) {
			Element roundEle = root.element(entity + en.id).element(round + n);
			EntityState st = toEntityState(roundEle.attributeValue(state));
			int pr = Integer.parseInt(roundEle.attributeValue(posr));
			int pc = Integer.parseInt(roundEle.attributeValue(posc));
			int movr = Integer.parseInt(roundEle.attributeValue(dr));
			int movc = Integer.parseInt(roundEle.attributeValue(dc));
			boolean w = toBoolean(roundEle.attributeValue(win));
			en.resetEntity(st, pr, pc, movr, movc, w);
		}
	}
}
