package LEMS.presentation.userui;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JButton;

public class BusinessClerkUi extends JPanel {

	/**
	 * Create the panel.
	 */
	public BusinessClerkUi() {
		setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "\u8425\u4E1A\u5385\u4E1A\u52A1\u5458\u754C\u9762", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setLayout(null);
		
		JButton button = new JButton("车辆信息管理");
		button.setBounds(56, 58, 149, 43);
		add(button);
		
		JButton button_1 = new JButton("司机信息管理");
		button_1.setBounds(56, 132, 149, 43);
		add(button_1);
		
		JButton button_2 = new JButton("车辆装车管理");
		button_2.setBounds(56, 213, 149, 43);
		add(button_2);
		
		JButton button_3 = new JButton("记录收款单");
		button_3.setBounds(265, 58, 149, 43);
		add(button_3);
		
		JButton button_4 = new JButton("派件");
		button_4.setBounds(265, 132, 149, 43);
		add(button_4);
		
		JButton button_5 = new JButton("接收");
		button_5.setBounds(265, 213, 149, 43);
		add(button_5);

	}

}
