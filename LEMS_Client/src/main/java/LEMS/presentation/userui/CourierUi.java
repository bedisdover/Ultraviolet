package LEMS.presentation.userui;

import javax.swing.JPanel;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;

import LEMS.presentation.mainUi;
import LEMS.presentation.inquireui.LogisticsInfoUi;

import java.awt.Color;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * @author 章承尧
 * 快递员界面
 */
@SuppressWarnings("serial")
public class CourierUi extends JPanel {

	/**
	 * Create the panel.
	 */
	public CourierUi() {
		setBounds(new Rectangle(0, 0, mainUi.WIDTH, mainUi.HEIGHT));
		setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "\u5FEB\u9012\u5458\u754C\u9762", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		setLayout(null);
		
		JButton button = new JButton("查询物流信息");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				LogisticsInfoUi logistics=new LogisticsInfoUi();
				mainUi.frame.setContentPane(logistics);
			}
		});
		button.setBounds(455, 177, 265, 135);
		add(button);
		
		JButton button_1 = new JButton("订单管理");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button_1.setBounds(455, 381, 265, 135);
		add(button_1);
		
		JButton button_2 = new JButton("退出");
		button_2.setBounds(813, 642, 140, 78);
		add(button_2);

	}
}
