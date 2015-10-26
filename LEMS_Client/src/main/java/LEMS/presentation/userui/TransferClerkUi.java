package LEMS.presentation.userui;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Rectangle;

/**
 * @author 章承尧
 * 中转中心业务员界面
 */
public class TransferClerkUi extends JPanel {

	/**
	 * Create the panel.
	 */
	public TransferClerkUi() {
		setBounds(new Rectangle(0, 0, 1024, 768));
		setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "\u4E2D\u8F6C\u4E2D\u5FC3\u4E1A\u52A1\u5458\u754C\u9762", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setLayout(null);
		
		JButton button = new JButton("中转接收");
		button.setBounds(496, 279, 159, 62);
		add(button);
		
		JButton button_1 = new JButton("装运管理");
		button_1.setBounds(496, 384, 159, 62);
		add(button_1);

	}

}
