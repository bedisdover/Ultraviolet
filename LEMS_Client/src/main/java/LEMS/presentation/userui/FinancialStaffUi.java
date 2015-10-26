package LEMS.presentation.userui;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;

import java.awt.Color;

import javax.swing.JButton;
import java.awt.Rectangle;

@SuppressWarnings("serial")
public class FinancialStaffUi extends JPanel {

	/**
	 * Create the panel.
	 */
	public FinancialStaffUi() {
		setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "\u8D22\u52A1\u4EBA\u5458\u754C\u9762", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setLayout(null);
		
		JButton button = new JButton("结算管理");
		button.setBounds(49, 57, 139, 47);
		add(button);
		
		JButton button_1 = new JButton("成本管理");
		button_1.setBounds(49, 134, 139, 47);
		add(button_1);
		
		JButton button_2 = new JButton("账户管理");
		button_2.setBounds(new Rectangle(0, 0, 1024, 768));
		button_2.setBounds(49, 218, 139, 47);
		add(button_2);
		
		JButton button_3 = new JButton("统计报表");
		button_3.setBounds(259, 94, 139, 47);
		add(button_3);
		
		JButton button_4 = new JButton("查询日志");
		button_4.setBounds(259, 183, 139, 47);
		add(button_4);

	}

}
