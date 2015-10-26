package LEMS.presentation.userui;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JButton;

public class ManagerUi extends JPanel {

	/**
	 * Create the panel.
	 */
	public ManagerUi() {
		setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "\u7BA1\u7406\u5458\u754C\u9762", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setLayout(null);
		
		JButton button = new JButton("用户管理");
		button.setBounds(131, 104, 170, 89);
		add(button);

	}

}
