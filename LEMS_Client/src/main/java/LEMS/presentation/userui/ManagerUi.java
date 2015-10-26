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
 * 管理人员界面
 */
public class ManagerUi extends JPanel {

	/**
	 * Create the panel.
	 */
	public ManagerUi() {
		setBounds(new Rectangle(0, 0, mainUi.WIDTH, mainUi.HEIGHT));
		setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "\u7BA1\u7406\u5458\u754C\u9762", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setLayout(null);
		
		JButton button = new JButton("用户管理");
		button.setBounds(475, 332, 170, 89);
		add(button);
		
		JButton button_1 = new JButton("退出");
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				mainUi.frame.setContentPane(mainUi.contentPane);
			}
		});
		button_1.setBounds(827, 644, 146, 82);
		add(button_1);

	}

}
