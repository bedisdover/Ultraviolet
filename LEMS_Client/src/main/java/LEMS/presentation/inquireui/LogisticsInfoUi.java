package LEMS.presentation.inquireui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import LEMS.businesslogic.inquirebl.inquirelogisticsinfo.InquireLogisticsInfo;
import LEMS.presentation.LoginUi;
import LEMS.presentation.MainFrame;
import LEMS.presentation.method.Table;
import LEMS.presentation.ultraSwing.UltraButton;
import LEMS.presentation.ultraSwing.UltraTextField;
import LEMS.vo.inquirevo.LogisticsInfoVO;

/**
 * 查询物流界面
 */
@SuppressWarnings("serial")
public class LogisticsInfoUi extends JPanel {

	private MainFrame mainFrame;
	private UltraTextField textField;
	private Font font;
	private JLabel title;
	private JLabel date;
	private UltraButton but;
	private UltraButton butOut;
	

	private Table table;
	Image im = Toolkit.getDefaultToolkit().getImage("source/02.jpg");

	/**
	 * Create the panel.
	 */
	public LogisticsInfoUi(final MainFrame mainFrame) {
		this.mainFrame = mainFrame;
		this.setLayout(null);
		this.setBounds(0, 0, MainFrame.JFRAME_WIDTH, MainFrame.JFRAME_HEIGHT);

		this.init();
		this.initComponent();
		this.addListener();
	}

	private void init() {
		date = new JLabel("订单号：");
		title = new JLabel("物流信息查询");
		but = new UltraButton("查找");
		textField = new UltraTextField();
		font = new Font("Courier", Font.PLAIN, 26);
		butOut = new UltraButton("返回");
	}

	private void initComponent() {
		date.setBounds(237, 122, 160, 25);
		date.setFont(new Font("Courier", Font.PLAIN, 22));
		title.setBounds(444, 26, 249, 45);
		title.setFont(font);
		title.setForeground(Color.BLACK);
		date.setForeground(Color.BLACK);
		but.setBounds(692, 119, 100, 40);
		textField.setBounds(415, 122, 160, 25);
		butOut.setBounds(52, 36, 100, 40);

		this.add(date);
		this.add(title);
		this.add(but);
		this.add(textField);
		this.add(butOut);

		String[] columnNames = { "物流轨迹" };
		int[] list = { 15, 464, 14, 30, 20, 260, 172, 482, 520 };
		// list里面参数分别为需要的列数，每一列的宽度,设置第一行字体大小,设置第一行行宽,
		// * 剩下行的行宽,表格setbounds（list[5],list[6], list[7], list[8]）
		// *
		table = new Table();
		add(table.drawTable(columnNames, list));
		// column = table.getColumnModel().getColumn(i);
		int j = table.table.getRowHeight();
		// 将每一列的默认宽度设置为
		j += 15;
		table.table.setRowHeight(j);
	}

	private void addListener() {
		but.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if(textField.getText().equals("")){
					JOptionPane.showMessageDialog(LogisticsInfoUi.this, "请输入订单号！");
				}
				else{
					int k = table.numOfEmpty();
					for (; k >= 0; k--) {
						table.setValueAt(k, 0, "");
					}
					InquireLogisticsInfo inquirel = new InquireLogisticsInfo();
					LogisticsInfoVO logistics = inquirel.getLogisticsInfo(textField.getText());
					ArrayList<String> operations = logistics.getTrace();
					for (int i = 0; i < operations.size(); i++) {
						table.setValueAt(i, 0, operations.get(i));
					}
				}
				
			}
		});

		butOut.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				mainFrame.setContentPane(new LoginUi(mainFrame));
			}
		});
	}

	public void paintComponent(Graphics g) {
		g.drawImage(im, 0, 0, this.getWidth(), this.getHeight(), null);
		this.repaint();
	}
}
