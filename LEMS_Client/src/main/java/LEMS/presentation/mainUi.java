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

import javax.swing.JList;
import javax.swing.JComboBox;

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
	@SuppressWarnings("rawtypes")
	public mainUi() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 820, 570);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("账号");
		label.setBounds(142, 80, 102, 41);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("密码");
		label_1.setBounds(142, 158, 90, 41);
		contentPane.add(label_1);
		
		textField = new JTextField();
		textField.setBounds(291, 87, 200, 27);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(291, 165, 200, 27);
		contentPane.add(textField_1);
		
		JButton button = new JButton("登录");
		button.setBounds(327, 305, 116, 64);
		contentPane.add(button);
		
		JButton button_2 = new JButton("查询物流信息");
		button_2.setBounds(277, 418, 245, 56);
		contentPane.add(button_2);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(327, 226, 116, 32);
		contentPane.add(comboBox);
		comboBox.addItem("管理员");
		comboBox.addItem("总经理");
		comboBox.addItem("财务人员");
		comboBox.addItem("快递员");
		comboBox.addItem("营业厅业务员");
		comboBox.addItem("中转中心业务员");
		comboBox.addItem("仓库管理人员");
	}
}
