package LEMS.presentation.userui;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import java.awt.Color;

import javax.swing.border.LineBorder;
import javax.swing.JButton;
import java.awt.Rectangle;

@SuppressWarnings("serial")
public class StoreManagerUi extends JPanel {

	/**
	 * Create the panel.
	 */
	public StoreManagerUi() {
		setBounds(new Rectangle(0, 0, 1024, 768));
		setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 1, true), "\u4ED3\u5E93\u7BA1\u7406\u4EBA\u5458\u754C\u9762", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		setLayout(null);
		
		JButton button = new JButton("仓库管理");
		button.setBounds(132, 108, 184, 84);
		add(button);

	}

}
