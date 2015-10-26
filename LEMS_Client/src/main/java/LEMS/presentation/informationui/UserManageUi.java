package LEMS.presentation.informationui;

import javax.swing.JPanel;
import java.awt.Rectangle;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * @author 章承尧
 * 用户管理界面
 */
@SuppressWarnings("serial")
public class UserManageUi extends JPanel {

	/**
	 * Create the panel.
	 */
	public UserManageUi() {
		setBounds(new Rectangle(0, 0, 1024, 768));
		setLayout(null);
		
		JButton button = new JButton("返回");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		button.setBounds(886, 694, 123, 59);
		add(button);

	}

}
