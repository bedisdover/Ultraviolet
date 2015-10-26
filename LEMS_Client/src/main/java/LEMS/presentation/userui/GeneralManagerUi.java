package LEMS.presentation.userui;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class GeneralManagerUi extends JPanel {

	/**
	 * Create the panel.
	 */
	public GeneralManagerUi() {
		setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "\u603B\u7ECF\u7406\u754C\u9762", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setLayout(null);
		
		JButton btnNewButton = new JButton("查询日志");
		btnNewButton.setBounds(66, 45, 141, 46);
		add(btnNewButton);
		
		JButton button = new JButton("审批单据");
		button.setBounds(66, 116, 141, 46);
		add(button);
		
		JButton button_1 = new JButton("机构管理");
		button_1.setBounds(66, 180, 141, 46);
		add(button_1);
		
		JButton button_2 = new JButton("人员管理");
		button_2.setBounds(260, 45, 141, 46);
		add(button_2);
		
		JButton button_3 = new JButton("制定价格");
		button_3.setBounds(260, 116, 141, 46);
		add(button_3);
		
		JButton button_4 = new JButton("查看统计分析");
		button_4.setBounds(260, 180, 141, 46);
		add(button_4);

	}

}
