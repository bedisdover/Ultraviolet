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
 * 财务人员界面
 */
@SuppressWarnings("serial")
public class FinancialStaffUi extends JPanel {

	/**
	 * Create the panel.
	 */
	public FinancialStaffUi() {
		setBounds(new Rectangle(0, 0, mainUi.WIDTH, mainUi.HEIGHT));
		setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "\u8D22\u52A1\u4EBA\u5458\u754C\u9762", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setLayout(null);
		
		JButton button = new JButton("结算管理");
		button.setBounds(375, 194, 203, 83);
		add(button);
		
		JButton button_1 = new JButton("成本管理");
		button_1.setBounds(375, 307, 203, 83);
		add(button_1);
		
		JButton button_2 = new JButton("账户管理");
		button_2.setBounds(375, 410, 203, 83);
		add(button_2);
		
		JButton button_3 = new JButton("统计报表");
		button_3.setBounds(649, 231, 203, 83);
		add(button_3);
		
		JButton button_4 = new JButton("查询日志");
		button_4.setBounds(649, 356, 203, 83);
		add(button_4);
		
		JButton button_5 = new JButton("退出");
		button_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				mainUi.frame.setContentPane(mainUi.contentPane);
			}
		});
		button_5.setBounds(834, 648, 134, 69);
		add(button_5);

	}

}
