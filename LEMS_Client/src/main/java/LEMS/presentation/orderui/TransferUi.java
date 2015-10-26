package LEMS.presentation.orderui;

import javax.swing.JPanel;
import java.awt.Rectangle;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * @author 章承尧
 * 中转接收界面
 */
@SuppressWarnings("serial")
public class TransferUi extends JPanel {

	/**
	 * Create the panel.
	 */
	public TransferUi() {
		setBounds(new Rectangle(0, 0, 1024, 768));
		setLayout(null);
		
		JButton button = new JButton("返回");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		button.setBounds(886, 688, 123, 65);
		add(button);

	}

}
