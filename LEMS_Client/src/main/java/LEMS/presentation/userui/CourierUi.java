package LEMS.presentation.userui;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;

@SuppressWarnings("serial")
public class CourierUi extends JPanel {

	/**
	 * Create the panel.
	 */
	public CourierUi() {
		setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "\u5FEB\u9012\u5458\u754C\u9762", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		setLayout(null);
		
		JButton button = new JButton("查询物流信息");
		button.setBounds(128, 54, 177, 51);
		add(button);
		
		JButton button_1 = new JButton("订单管理");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button_1.setBounds(128, 174, 177, 51);
		add(button_1);

	}
}
