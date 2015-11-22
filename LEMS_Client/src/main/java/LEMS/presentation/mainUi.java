package LEMS.presentation;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

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

import LEMS.presentation.inquireui.LogisticsInfoUi;
import LEMS.presentation.userui.GeneralManagerUi;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * @author 章承尧
 *  系统主界面
 *
 */
public class mainUi extends JFrame {
	
	/**
	 * 主界面Panel
	 */
	static public JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	public static mainUi frame;
	/**
	 * 窗体宽度
	 */
	public static final int WIDTH=1024;
	/**
	 * 窗体高度
	 */
	public static final int HEIGHT=768;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new mainUi();
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
		//创建frame
		Dimension scrSize=Toolkit.getDefaultToolkit().getScreenSize(); 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Toolkit toolkit=Toolkit.getDefaultToolkit();
		int x = (int)(toolkit.getScreenSize().getWidth()-WIDTH)/2;
		int y = (int)(toolkit.getScreenSize().getHeight()-HEIGHT)/2;
		setBounds( x,y,WIDTH, HEIGHT);
		
		//创建mainUi的Panel
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("账号");
		label.setBounds(258, 123, 102, 41);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("密码");
		label_1.setBounds(258, 201, 90, 41);
		contentPane.add(label_1);
		
		textField = new JTextField();
		textField.setBounds(407, 130, 200, 27);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(407, 208, 200, 27);
		contentPane.add(textField_1);
		
		JButton button = new JButton("登录");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				GeneralManagerUi generalManager=new GeneralManagerUi();
				setContentPane(generalManager);
			}
		});
		button.setBounds(443, 348, 116, 64);
		contentPane.add(button);
		
//		JButton button_2 = new JButton("查询物流信息");
//		button_2.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseClicked(MouseEvent e) {
//				LogisticsInfoUi logisticsUi=new LogisticsInfoUi();
//				logisticsUi.setBounds(0, 0, 1024, 768);
//				frame.setContentPane(logisticsUi);
//				logisticsUi.setVisible(true);
//			}
//		});
//		button_2.setBounds(393, 461, 245, 56);
//		contentPane.add(button_2);
//		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(443, 269, 116, 32);
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
