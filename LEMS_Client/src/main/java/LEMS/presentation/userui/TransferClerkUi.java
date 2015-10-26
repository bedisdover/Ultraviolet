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
 * 中转中心业务员界面
 */
public class TransferClerkUi extends JPanel {

	/**
	 * Create the panel.
	 */
	public TransferClerkUi() {
		setBounds(new Rectangle(0, 0, mainUi.WIDTH, mainUi.HEIGHT));
		setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "\u4E2D\u8F6C\u4E2D\u5FC3\u4E1A\u52A1\u5458\u754C\u9762", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setLayout(null);
		
		JButton button = new JButton("中转接收");
		button.setBounds(454, 216, 201, 125);
		add(button);
		
		JButton button_1 = new JButton("装运管理");
		button_1.setBounds(454, 384, 201, 125);
		add(button_1);
		
		JButton button_2 = new JButton("退出");
		button_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				mainUi.frame.setContentPane(mainUi.contentPane);
			}
		});
		button_2.setBounds(841, 647, 121, 76);
		add(button_2);

	}

}
