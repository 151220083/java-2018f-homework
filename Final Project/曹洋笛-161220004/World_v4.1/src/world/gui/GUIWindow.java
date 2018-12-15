package world.gui;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import javafx.fxml.FXML;
import javafx.animation.*;
import javafx.util.Duration;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;

import world.*;
import world.util.*;

public class GUIWindow {

	/**	CoreWorldָ��	*/
	public CoreWorld cWrd = null;
	
	@FXML
	private Label background; // ����ͼƬ��ǩ
	
	@FXML
	public GridPane entityLayer; // �����ָ��
	
	@FXML
	public GridPane animLayer; // ������ָ��
	
	@FXML
	private Label observer; // ���ڴ�ӡս�����
	
	@FXML
	private TextField receiver; // �������ü��̼���
	
	/**	����Label��ά����	*/
	private Label cells[][] = new Label[Global.rowNum][Global.colNum];

	/**	����Label��	*/
	public static Map<Integer, Label> animItems = new HashMap<>();

	/**	��ʼ��GUIWindow.
     *	�ڼ���WorldWindow.fxml��ɺ��Զ�����	*/
    @FXML
    private void initialize() {
    	// ��ʼ������
    	Image backImg = new Image("file:img/BackGround.png");
    	background.setGraphic(new ImageView(backImg));
    	// GridPaneƫ�ƣ�ԭ������
    	entityLayer.setTranslateX(Global.marginX);
    	// ��ʼ��cells���޶�������animItems�����𶯻���
		initAnimItems();
		initCells();
		paintWindow(); // ���ƴ��ڣ��޶�����
		// ��ʼ��Ĭ���ж���
		entityLayer.setVisible(false);
		animLayer.setVisible(true);
		// ���ü����¼�
		receiver.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode() == KeyCode.SPACE && cWrd != null) {
                	pressKeySpace();
                }
            }
        });
    }

    /**	ÿ�������̿ո����	*/
	private void pressKeySpace() {
		Global.battleStart = true;
		if (!Global.battleEnd) { // ս��δ����
			clearWindow(); // �޶���
			// �غ�����1���ӡ���1�غϡ���ʼ��
			Global.roundNum += 1; 
			System.out.print("��" + (Global.roundNum + 1) / 2 + "�غϣ�[");
			if (Global.roundNum % 2 == 1) System.out.print("��«��");
			else System.out.print("����");
			System.out.println("]�ж��غ�");
	        start(Global.roundNum);
			// ��ʱ�洢
			Global.recordWriter.addRoundElements(Global.roundNum);
			// �ȴ������߳�ִ�����ٴ�ӡ
	        try { 
	            Thread.sleep(100);
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
			Global.keepFormationRound -= 1;
			cWrd.showWorld();
			paintWindow(); // �޶���
			// ����ж�һ��ս���Ƿ����
			Global.battleEnd = Global.isEnded();
			// ��������˾������Ĭ���ļ�
			if (Global.battleEnd)
				Global.recordWriter.saveRecord(Global.defaultFilename);
		}
	}

	/**	��������ʵ����̲߳����Ŷ���	*/
	public void start(int n) {
		for (Entity en: CoreWorld.entities.values()) {
			// �����غϺ�«�޶���ż���غ����ֶ�
			if (((n % 2 == 1) && (en.creature.getGroup() == GroupType.Bro))
					|| ((n % 2 == 0) && (en.creature.getGroup() == GroupType.Mon))) {
				if (en.state != EntityState.LIVE)
					continue;
				// ��ʼ�ƶ�
            	en.start(); // ���ܻ���
				// ���ʱ����
				Timeline timeline = new Timeline(); // ��ѭ��
		        KeyFrame keyFrame = new KeyFrame(Duration.millis(1), new EventHandler<ActionEvent>() {  
		            @Override  
		            public void handle(ActionEvent event) { 
		            	playAnimation(en); // ����Ч��
		            }  
		        });  
		        timeline.getKeyFrames().add(keyFrame); 
		        timeline.play(); // ��ʼ����
			}
		}
	}
    
	/**	���ö���	*/
	private void playAnimation(Entity en) {
		if (!en.position.equals(new Point(0, 0))) {
			// �ƶ�����
			TranslateTransition tt = new TranslateTransition(Duration.millis(Global.durTime));
	        tt.setByX(en.direction.col() * Global.span); // xλ��
	        tt.setByY(en.direction.row() * Global.span); // yλ��
	        ParallelTransition animMov = new ParallelTransition(animItems.get(en.id), tt);
	        // �ŵ�ʱ������
        	animMov.play(); // �ƶ�
		}
        // ��ʧ����
        FadeTransition ft = new FadeTransition(Duration.millis(Global.durTime));
        ft.setToValue(0);
        ParallelTransition animFade = null;
        // �Լ�����һ�غ�������
		if (en.state == EntityState.DEAD) { 
			animFade = new ParallelTransition(animItems.get(en.id), ft);
			animFade.play();
		}
		// ����һ�غϻ����˵���
		if (en.hasWined) {
			animFade = new ParallelTransition(animItems.get(en.target.id), ft);
			animFade.play();
		}
	}
	
    /**	��ʼ���̶���ǩ��ά����cells	*/
    private void initCells() {
		for (int i = 0; i < Global.rowNum; i++) {
			for (int j = 0; j < Global.colNum; j++) {
				// ��ʼ�����и���
				cells[i][j] = new Label();
				setEntityImage(cells[i][j], null); // ���͸��ͼƬ
				cells[i][j].setScaleX(Global.span / Global.entityWidth); // ��ǩ��������
				cells[i][j].setScaleY(Global.span / Global.entityHeight);
				entityLayer.add(cells[i][j], j, i); // ���õ������ͼ��
			}
		}
    }

	/**	����entities����д���ʼ����animItems	*/
	public void initAnimItems() {
		// ���Ƴ���ǰ��ȫ��Label
		Iterator<Integer> it = animItems.keySet().iterator();
        while (it.hasNext()) {
            animLayer.getChildren().remove(animItems.get(it.next()));
            it.remove();
        }
		// ����entities����д��
		for (Entry<Integer, Entity> item : CoreWorld.entities.entrySet()) {
			Label tmpLab = new Label();
			setEntityImage(tmpLab, item.getValue().creature.getType()); // ���ͼƬ
			tmpLab.setScaleX(Global.span / Global.entityWidth); // ��ǩ��������
			tmpLab.setScaleY(Global.span / Global.entityHeight);
			tmpLab.setTranslateX(Global.marginX + item.getValue().position.col() * Global.span); // ��ǩλ��
			tmpLab.setTranslateY(Global.marginY + item.getValue().position.row() * Global.span);
			animLayer.getChildren().add(tmpLab);
			animItems.put(item.getKey(), tmpLab);
		}
	}
	
	/**	��ʼ��CoreWorld	*/
    public void setWin(CoreWorld cw) {
    	cWrd = cw;
    }

	/**	�����������ͻ�ȡ��Ӧ��ͼ��	*/
	private Image getEntityImage(CreatureType ctype) {
    	Image creatureImg = null;
    	if (ctype == null)
    		creatureImg = new Image("file:img/none.png");
			//creatureImg = new Image("file:img/debug.png");
    	else
    		creatureImg = new Image("file:img/" + ctype.imgName + ".png");
    	return creatureImg;
	}
	
	/**	����һ�����ӵ�ͼ��	*/
    private void setEntityImage(Label cellLabel, CreatureType ctype) {
    	cellLabel.setGraphic(new ImageView(getEntityImage(ctype)));
    }

    /**	���ȫ�������޶�����	*/
    public void clearWindow() {
		for (Entity en: CoreWorld.entities.values()) {
			if (en.state == EntityState.LIVE) {
				setEntityImage(cells[en.position.row()][en.position.col()], null);
			}
		}
    }
    
    /**	����entities����ȫ�������޶�����	*/
    public void paintWindow() {
		for (Entity en: CoreWorld.entities.values()) {
			if (en.state == EntityState.LIVE) 
				setEntityImage(cells[en.position.row()][en.position.col()], en.creature.getType());
		}
	}
}
