package LEMS.presentation.userui;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;

import java.awt.Color;

import javax.swing.JButton;

import LEMS.presentation.mainUi;

import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * @author 章承尧
 * 营业厅业务员界面
 */
public class BusinessClerkUi extends JPanel {

	/**
	 * Create the panel.
	 */
	public BusinessClerkUi() {
		setBounds(new Rectangle(0, 0, mainUi.WIDTH, mainUi.HEIGHT));
		setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "\u8425\u4E1A\u5385\u4E1A\u52A1\u5458\u754C\u9762", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setLayout(null);
		
		JButton button = new JButton("车辆信息管理");
		button.setBounds(336, 191, 172, 86);
		add(button);
		
		JButton button_1 = new JButton("司机信息管理");
		button_1.setBounds(336, 308, 172, 86);
		add(button_1);
		
		JButton button_2 = new JButton("车辆装车管理");
		button_2.setBounds(336, 422, 172, 86);
		add(button_2);
		
		JButton button_3 = new JButton("记录收款单");
		button_3.setBounds(568, 191, 172, 86);
		add(button_3);
		
		JButton button_4 = new JButton("派件");
		button_4.setBounds(568, 308, 172, 86);
		add(button_4);
		
		JButton button_5 = new JButton("接收");
		button_5.setBounds(568, 419, 172, 89);
		add(button_5);
		
		JButton button_6 = new JButton("退出");
		button_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				mainUi.frame.setContentPane(mainUi.contentPane);
			}
		});
		button_6.setBounds(846, 647, 134, 68);
		add(button_6);

	}

}
