package LEMS.presentation.orderui;

import javax.swing.JPanel;
import java.awt.Rectangle;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * @author 章承尧
 * 装车管理界面
 */
@SuppressWarnings("serial")
public class LoadUi extends JPanel {

	/**
	 * Create the panel.
	 */
	public LoadUi() {
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
