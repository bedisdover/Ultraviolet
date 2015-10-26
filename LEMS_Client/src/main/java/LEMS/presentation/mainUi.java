package LEMS.presentation;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class mainUi extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mainUi frame = new mainUi();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public mainUi() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 820, 570);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("账号");
		label.setBounds(143, 133, 102, 41);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("密码");
		label_1.setBounds(143, 211, 90, 41);
		contentPane.add(label_1);
		
		textField = new JTextField();
		textField.setBounds(292, 140, 200, 27);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(292, 218, 200, 27);
		contentPane.add(textField_1);
		
		JButton button = new JButton("登录");
		button.setBounds(340, 305, 102, 67);
		contentPane.add(button);
		
		JButton button_2 = new JButton("查询物流信息");
		button_2.setBounds(277, 447, 245, 27);
		contentPane.add(button_2);
	}
}
