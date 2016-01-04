package LEMS.presentation.financeui;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import LEMS.businesslogic.financebl.Price;
import LEMS.businesslogic.orderbl.Distance;
import LEMS.po.orderpo.City;
import LEMS.po.orderpo.Express;
import LEMS.po.orderpo.Packing;
import LEMS.po.userpo.UserRole;
import LEMS.presentation.LoginUi;
import LEMS.presentation.MainFrame;
import LEMS.presentation.method.Table;
import LEMS.presentation.ultraSwing.UltraButton;
import LEMS.presentation.ultraSwing.UltraComboBox;
import LEMS.vo.uservo.UserVO;
import javax.swing.DefaultComboBoxModel;

/**
 * @author 苏琰梓 制定价格界面 2015年12月4日
 */
public class SettingPriceUi extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private UserVO user;

	private MainFrame mainFrame;
	private JLabel title = new JLabel("制定常量");
	private Table table1;
	private UltraButton butModify = new UltraButton("修改");

	private UltraButton butOut = new UltraButton("返回");
	private Font font = new Font("Courier", Font.PLAIN, 26);

	private JLabel name;
	private JLabel statue;
	JLabel labelPrice = new JLabel("价格：");
	JLabel labelDistance = new JLabel("距离：");
	JLabel city1 = new JLabel("城市：");
	JLabel city2 = new JLabel("城市：");
	JLabel mid1 = new JLabel("至");
	JLabel labelExpress = new JLabel("快递类型：");
	JLabel labelPackage = new JLabel("包装类型：");
	JLabel Transport = new JLabel("运输方式：");

	private UltraComboBox comboxPrice = new UltraComboBox();
	private UltraComboBox comboxDistance = new UltraComboBox();
	
	UltraComboBox City1 = new UltraComboBox();
	UltraComboBox City2 = new UltraComboBox();
	UltraComboBox expressType = new UltraComboBox();
	UltraComboBox packageType = new UltraComboBox();
	UltraComboBox transportType = new UltraComboBox();

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public SettingPriceUi(final MainFrame mainFrame, UserVO uvo) {
		this.setBounds(0, 0, MainFrame.JFRAME_WIDTH, MainFrame.JFRAME_HEIGHT);
		this.setLayout(null);
		this.mainFrame = mainFrame;
		user = uvo;
		name = new JLabel("账号：  " + user.getId());
		statue = new JLabel("身份： " + UserRole.transfer(user.getRole()));
		title.setBounds(456, 26, 249, 45);
		title.setFont(font);
		butOut.setBounds(60, 41, 120, 40);
		butModify.setBounds(860, 41, 120, 40);

		labelPrice.setBounds(265, 150, 70, 30);
		labelDistance.setBounds(565, 150, 70, 30);
		comboxPrice.setModel(new DefaultComboBoxModel(new String[] {"快递价格", "包装价格", "运输价格"}));
		comboxPrice.setBounds(320, 150, 120, 30);
		comboxDistance.setModel(new DefaultComboBoxModel(new String[] {"城市距离", "营业厅距离"}));
		comboxDistance.setBounds(630, 150, 120, 30);
		city1.setBounds(265, 220, 40, 30);
		City1.setBounds(305, 220, 120, 30);
		mid1.setBounds(485, 220, 20, 30);
		city2.setBounds(550, 220, 80, 30);
		City2.setBounds(590, 220, 120, 30);
		labelExpress.setBounds(690, 220, 80, 30);
		expressType.setBounds(750, 220, 120, 30);
		labelPackage.setBounds(70, 220, 80, 30);
		packageType.setBounds(135, 220, 120, 30);
		Transport.setBounds(406, 220, 80, 30);
		transportType.setBounds(465, 220, 120, 30);
		name.setBounds(355, 75, 135, 28);
		statue.setBounds(528, 75, 183, 28);

		City1.addItem("北京");
		City1.addItem("上海");
		City1.addItem("广州");
		City1.addItem("南京");
		City2.addItem("北京");
		City2.addItem("上海");
		City2.addItem("广州");
		City2.addItem("南京");
		expressType.addItem("标准");
		expressType.addItem("特快");
		packageType.addItem("纸袋");
		packageType.addItem("箱子");
		packageType.addItem("其他");
		transportType.addItem("火车");
		transportType.addItem("汽车");
		transportType.addItem("飞机");

		this.add(title);
		this.add(butOut);
		this.add(butModify);
		this.add(city1);
		this.add(City1);
		this.add(mid1);
		this.add(city2);
		this.add(City2);
		this.add(labelExpress);
		this.add(expressType);
		this.add(labelPackage);
		this.add(packageType);
		this.add(Transport);
		this.add(transportType);
		this.add(labelPrice);
		this.add(labelDistance);
		this.add(comboxPrice);
		this.add(comboxDistance);
		this.add(name);
		this.add(statue);
		this.initComponents();
		this.addListener();
		
		this.showPrice();
	}

	public void initComponents() {
		String[] columnNames1 = { "项目", "数值" };
		int[] list1 = { 120, 392, 20, 30, 20, 102, 280, 801, 360 };
		// list里面参数分别为需要的列数，每一列的宽度,设置第一行字体大小,设置第一行行宽,
		// * 剩下行的行宽,表格setbounds（list[5],list[6], list[7], list[8]）
		// *
		table1 = new Table();
		add(table1.drawTable(columnNames1, list1));
		// 将每一列的默认宽度设置为
		table1.table.setRowHeight(40);

	}

	private void addListener() {
		comboxPrice.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					//清空表格
					table1.clean();
					
					if (e.getSource() == comboxPrice) {
						showPrice();
					}
				}
			}
		});
		
		comboxDistance.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					//清空表格
					table1.clean();
					
					if (e.getSource() == comboxDistance) {
						showDistance();
					}
				}
			}
		});
		
		butOut.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				mainFrame.setContentPane(new LoginUi(mainFrame));
			}
		});

		butModify.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (table1.getSelectedRow() != -1) {
					modifyOperation();
				}
			}
		});

	}

	public void paintComponent(Graphics g) {
		g.drawImage(MainFrame.background, 0, 0, this.getWidth(), this.getHeight(), null);
		this.repaint();
	}

	/**
	 * 在界面中显示距离数据
	 */
	private void showDistance() {
		if (comboxDistance.getSelectedItem() == "城市距离") {
			this.showCityDistance();
		}
	}
	
	private void showCityDistance() {
		for (String city : City.cityList) {
			this.showCityDistance(city);
		}
//		
//		Distance cityDistance = new Distance();
//		double distance = 0;
//		int line = 0;
//		String departure = "", destination = "";
//
//		table1.clean();
//		
//		// 同一城市间距离
//		distance = cityDistance.getDistance(City.cityList.get(0), City.cityList.get(0));
//		table1.setValueAt(line, 0, "城市各营业厅");
//		table1.setValueAt(line, 1, distance + "");
//
//		for (int i = 0; i < City.cityList.size(); i++) {
//			departure = City.cityList.get(i);
//			for (int j = i + 1; j < City.cityList.size(); j++) {
//				destination = City.cityList.get(j);
//				line = table1.numOfEmpty();
//
//				distance = cityDistance.getDistance(departure, destination);
//				table1.setValueAt(line, 0, departure + "---" + destination);
//				table1.setValueAt(line, 1, distance + "");
//			}
//		}
	}
	
	/**
	 * 显示目标城市与其他城市间的距离
	 */
	private void showCityDistance(String city) {
		int line = 0;
		double distance = 0.0;
		
		for (String destination : City.cityList) {
			if (city.equals(destination)) {
				continue;
			}
			line = table1.numOfEmpty();
			distance = new Distance().getDistance(city, destination);
			table1.setValueAt(line, 0, city + " --- " + destination);
			table1.setValueAt(line, 1, distance + "");
		}
	}

	/**
	 * 在界面中显示价格数据
	 */
	private void showPrice() {
		if (comboxPrice.getSelectedItem() == "快递价格") {
			this.showExpressPrice();
		} else if (comboxPrice.getSelectedItem() == "包装价格"){
			this.showPackagePrice();
		}
	}

	private void showExpressPrice() {
		int line = 0;
		Price price = new Price();
		
		for (Express e : Express.values()) {
			line = table1.numOfEmpty();
			table1.setValueAt(line, 0, Express.transfer(e));
			table1.setValueAt(line, 1, price.getPrice(e) + "");
		}
	}
	
	private void showPackagePrice() {
		int line = 0;
		Price price = new Price();
		
		for (Packing p : Packing.values()) {
			line = table1.numOfEmpty();
			table1.setValueAt(line, 0, Packing.transfer(p));
			table1.setValueAt(line, 1, price.getPrice(p) + "");
		}
	}

	/**
	 * 修改按钮按下的操作
	 */
	private void modifyOperation() {
		if (comboxPrice.getSelectedIndex() == 0) {
			// “制定价格”选项
			this.modifyPrice();
		} else {
			// “制定距离”选项
			this.modifyDistance();
		}
	}

	/**
	 * 修改距离
	 */
	private void modifyDistance() {

	}

	/**
	 * 修改价格
	 */
	private void modifyPrice() {
		JOptionPane.showInputDialog(mainFrame, "shuru", "请输入价格", JOptionPane.INFORMATION_MESSAGE);
	}
}
