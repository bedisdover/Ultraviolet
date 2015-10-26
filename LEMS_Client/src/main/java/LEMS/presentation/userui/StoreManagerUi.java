package LEMS.presentation.userui;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import java.awt.Color;

import javax.swing.border.LineBorder;
import javax.swing.JButton;

import LEMS.presentation.mainUi;

import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * @author 章承尧
 * 仓库管理人员界面
 */
@SuppressWarnings("serial")
public class StoreManagerUi extends JPanel {

	/**
	 * Create the panel.
	 */
	public StoreManagerUi() {
		setBounds(new Rectangle(0, 0, mainUi.WIDTH, mainUi.HEIGHT));
		setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 1, true), "\u4ED3\u5E93\u7BA1\u7406\u4EBA\u5458\u754C\u9762", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		setLayout(null);
		
		JButton button = new JButton("仓库管理");
		button.setBounds(494, 323, 184, 84);
		add(button);
		
		JButton button_1 = new JButton("退出");
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				mainUi.frame.setContentPane(mainUi.contentPane);
			}
		});
		button_1.setBounds(838, 650, 134, 74);
		add(button_1);

	}

}
