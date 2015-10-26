package LEMS.presentation.orderui;

import javax.swing.JPanel;
import java.awt.Rectangle;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * @author 章承尧
 * 装运管理界面
 */
@SuppressWarnings("serial")
public class VehicleLoadUi extends JPanel {

	/**
	 * Create the panel.
	 */
	public VehicleLoadUi() {
		setBounds(new Rectangle(0, 0, 1024, 768));
		setLayout(null);
		
		JButton button = new JButton("返回");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		button.setBounds(884, 686, 125, 67);
		add(button);

	}

}
