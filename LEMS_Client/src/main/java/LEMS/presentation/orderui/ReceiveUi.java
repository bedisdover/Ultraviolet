package LEMS.presentation.orderui;

import javax.swing.JPanel;

import java.awt.Rectangle;

import javax.swing.JButton;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

@SuppressWarnings("serial")
public class ReceiveUi extends JPanel {

	/**
	 * Create the panel.
	 */
	public ReceiveUi() {
		setBounds(new Rectangle(0, 0, 1024, 768));
		setLayout(null);
		
		JButton button = new JButton("返回");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		button.setBounds(877, 686, 132, 67);
		add(button);

	}

}
