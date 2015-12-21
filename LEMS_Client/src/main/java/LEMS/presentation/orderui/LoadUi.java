package LEMS.presentation.orderui;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.rmi.RemoteException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import LEMS.businesslogic.orderbl.transfer.Transfer;
import LEMS.presentation.LoginUi;
import LEMS.presentation.MainFrame;
import LEMS.presentation.method.DateChooser;
import LEMS.presentation.method.Table;
import LEMS.vo.ordervo.LoadVO;
import LEMS.vo.uservo.UserVO;

/**
 * @author 周梦佳
 * 装运管理界面
 */
public class LoadUi extends JPanel {

	private static final long serialVersionUID = 1L;
	private static final int LOCATION_LABEL_X=120;
	private static final int LOCATION_LABEL_Y=115;
	private static final int LOCATION_TEXT_X=220;
	private static final int LOCATION_TEXT_Y=210;
	private static final int BOUND_X=130;
	private static final int BOUND_Y=30;

	private MainFrame mainFrame;
	private JLabel title;
	private JButton exit;
	private JButton OK;
	private JButton cancel;
	private JButton add;
	private JButton delete;
	private JButton update;
	private JButton finish;
	
	private JLabel labelDate;
	private JLabel labelDestination;
	private JLabel labelTransferNum;
	private JLabel labelVehicleId;
	private JLabel labelGuard;
	private JLabel labelDeliverStaff;
	private JLabel labelGoodsNum;
	private JLabel labelGoodsWeight;

	private JTextField textTransferNum;
	private JTextField textDestination;
	private JTextField textVehicleId;
	private JTextField textGuard;
	private JTextField textDeliverStaff;
	private JTextField textGoodsWeight;
	private JTextField textID;
	private DateChooser dc;
	private Table table;
	
	private Font fnt1 = new Font("Courier", Font.BOLD, 26);//标题字体格式
	private Font fnt = new Font("Courier", Font.PLAIN, 15);//其余字体格式
	private Font fnt2 = new Font("宋体", Font.BOLD, 16);//按钮字体格式
	
	private Transfer load;
	
	private LoadVO loadVO;
	
	private boolean isUpdate;
	
	public LoadUi(final MainFrame mainFrame, UserVO userVO) {
		this.mainFrame = mainFrame;
		this.setLayout(null);
		this.setBounds(0, 0, MainFrame.JFRAME_WIDTH, MainFrame.JFRAME_HEIGHT);
		// 初始化
		this.init();
		// 初始化组件
		this.initComponents();
		// 设置输入框不可编辑
		this.setTestState(false);
		// 添加事件监听器
		this.addListener();

		loadVO = new LoadVO();
		load = new Transfer(loadVO, userVO);
		
		isUpdate = false;
	}

	/**
	 * 初始化
	 */
	private void init() {
		title = new JLabel("装运管理");
		exit = new JButton("返回");
		OK = new JButton("确定");
		cancel = new JButton("取消");
		add=new JButton("新增");
		delete=new JButton("删除");
		update=new JButton("修改");
		finish=new JButton("完成");
		
		labelDate = new JLabel("装车日期:");
		labelDestination = new JLabel("目的地:");
		labelTransferNum = new JLabel("汽运编号:");
		labelVehicleId = new JLabel("车辆代号：");
		labelDeliverStaff = new JLabel("押运员:");
		labelGuard = new JLabel("监装员:");
		labelGoodsNum = new JLabel("货物总重量:");
		labelGoodsWeight= new JLabel("订单条形码号：");
		textDestination=new JTextField();
		textTransferNum = new JTextField();
		textVehicleId = new JTextField();
		textDeliverStaff = new JTextField();
		textGuard = new JTextField();
		textGoodsWeight = new JTextField();
		textID=new JTextField();
		
		dc=new DateChooser(this, LOCATION_TEXT_X+2, LOCATION_TEXT_Y-90);
	}

	/**
	 * 初始化各组件
	 */
	private void initComponents() {
		title.setBounds(420, 27, 230, 39);
		
		labelDate.setBounds(LOCATION_LABEL_X, LOCATION_LABEL_Y, BOUND_X, BOUND_Y);
		labelDestination.setBounds(LOCATION_LABEL_X+7, LOCATION_LABEL_Y+45, BOUND_X, BOUND_Y);
		labelTransferNum.setBounds(LOCATION_LABEL_X, LOCATION_LABEL_Y+90, BOUND_X, BOUND_Y);
		labelVehicleId.setBounds(LOCATION_LABEL_X, LOCATION_LABEL_Y+135, BOUND_X, BOUND_Y);
		labelGuard.setBounds(LOCATION_LABEL_X+7, LOCATION_LABEL_Y+180, BOUND_X, BOUND_Y);
		labelDeliverStaff.setBounds(LOCATION_LABEL_X+7, LOCATION_LABEL_Y+225, BOUND_X, BOUND_Y);
		labelGoodsNum.setBounds(LOCATION_LABEL_X, LOCATION_LABEL_Y+285, BOUND_X, BOUND_Y);
		labelGoodsWeight.setBounds(LOCATION_LABEL_X, LOCATION_LABEL_Y+330, BOUND_X+40, BOUND_Y);
		
		textTransferNum.setBounds(LOCATION_TEXT_X, LOCATION_TEXT_Y, BOUND_X, BOUND_Y-6);
		textVehicleId.setBounds(LOCATION_TEXT_X, LOCATION_TEXT_Y+45, BOUND_X, BOUND_Y-6);
		textGuard.setBounds(LOCATION_TEXT_X, LOCATION_TEXT_Y+90, BOUND_X, BOUND_Y-6);
		textDeliverStaff.setBounds(LOCATION_TEXT_X, LOCATION_TEXT_Y+135, BOUND_X, BOUND_Y-6);
		textGoodsWeight.setBounds(LOCATION_TEXT_X, LOCATION_TEXT_Y+195, BOUND_X, BOUND_Y-6);
		textID.setBounds(LOCATION_TEXT_X, LOCATION_TEXT_Y+240, BOUND_X, BOUND_Y-6);
		
		textDestination.setBounds(LOCATION_TEXT_X, LOCATION_TEXT_Y-45, BOUND_X, BOUND_Y-5);
		
		OK.setBounds(100, 513, BOUND_X-10, BOUND_Y+10);
		cancel.setBounds(250, 513, BOUND_X-10, BOUND_Y+10);
		exit.setBounds(80, 50, 100, 40);
		add.setBounds(370, 590, 120, 40);
		delete.setBounds(520, 590, 120,40);
		update.setBounds(670, 590, 120, 40);
		finish.setBounds(820, 590, 120, 40);
		
		title.setFont(fnt1);
		labelDate.setFont(fnt);
		labelDestination.setFont(fnt);
		labelTransferNum.setFont(fnt);
		labelVehicleId.setFont(fnt);
		labelDeliverStaff.setFont(fnt);
		labelGuard.setFont(fnt);
		labelGoodsNum.setFont(fnt);
		labelGoodsWeight.setFont(fnt);
		textTransferNum.setFont(fnt);
		textVehicleId.setFont(fnt);
		textGuard.setFont(fnt);
		textDeliverStaff.setFont(fnt);
		textGoodsWeight.setFont(fnt);
		textID.setFont(fnt);
		textDestination.setFont(fnt);
		cancel.setFont(fnt2);
		OK.setFont(fnt2);
		exit.setFont(fnt2);
		add.setFont(fnt2);
		delete.setFont(fnt2);
		update.setFont(fnt2);
		finish.setFont(fnt2);
		
		textGoodsWeight.setEditable(false);
		textID.setEditable(false);
		
		this.add(title);
		this.add(labelDate);
		this.add(labelDestination);
		this.add(labelTransferNum);
		this.add(labelVehicleId);
		this.add(labelDeliverStaff);
		this.add(labelGuard);
		this.add(labelGoodsNum);
		this.add(labelGoodsWeight);
		this.add(textTransferNum);
		this.add(textVehicleId);
		this.add(textGuard);
		this.add(textDeliverStaff);
		this.add(textGoodsWeight);
		this.add(textID);
		this.add(textDestination);
		this.add(OK);
		this.add(cancel);
		this.add(exit);
		this.add(add);
		this.add(delete);
		this.add(update);
		this.add(finish);
		String[] columnNames = {"序号","订单ID","名称","重量" };  
		int[] list={40,120,14,30,20,425,110,498,440};

	    table=new Table();
		add(table.drawTable(columnNames, list));
	}

	/**
	 * 设置输入框状态
	 * 
	 * @param state
	 *            输入框状态（是否可编辑）
	 */
	private void setTestState(boolean state) {
		textTransferNum.setEditable(state);
		textVehicleId.setEditable(state);
		textDeliverStaff.setEditable(state);
		textGuard.setEditable(state);
		textDestination.setEnabled(state);
		textID.setEditable(state);
		OK.setEnabled(state);
		cancel.setEnabled(state);
	}

	/**
	 * 清空输入框
	 */
	private void empty() {
		textTransferNum.setText(null);
		textVehicleId.setText(null);
		textDeliverStaff.setText(null);
		textGuard.setText(null);
		textGoodsWeight.setText(null);
		textID.setText(null);
		textID.setText(null);
		textDestination.setText(null);
	}

	/**
	 * 为按钮添加事件监听器
	 */
	private void addListener() {
		add.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				setTestState(true);
			}
		});
		delete.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				table.removeLine(table.getSelectedRow());
			}
		});
		update.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (table.getValueAt(table.getSelectedRow()) != null) {
					updateOperation();
					isUpdate = true;
				}
			}
		});
		finish.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				finishOperation();
			}
		});
		
		exit.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				LoginUi loginUi=new LoginUi(mainFrame);
				mainFrame.setContentPane(loginUi);
			}
		});
		
		OK.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				OKOperation();
				isUpdate = false;
			}
		});
		cancel.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				empty();
				setTestState(false);
			}
		});
	}

	public void paintComponent(Graphics g) {
		g.drawImage(MainFrame.background, 0, 0, this.getWidth(), this.getHeight(), null);
		g.draw3DRect(80, 110, 305, 270, false);  //输入框外框
		g.draw3DRect(80, 393, 305, 100, false);  //输入框外框
		g.draw3DRect(80, 505, 305, 55, false);  //输入框外框
		this.repaint();
	}
	
	private void updateOperation() {
		ArrayList<String> values = table.getValueAt(table.getSelectedRow());
		textID.setText(values.get(1));
	}
	
	private void OKOperation() {
		try {
			String id = textID.getText();
			String name = load.getName(id);
			double weight = load.getWeight(id);
			
			load.addOrder(id);
			if (!textGoodsWeight.getText().equals("")) {
				textGoodsWeight.setText(Double.parseDouble(textGoodsWeight.getText()) + weight + "");
			} else {
				textGoodsWeight.setText(weight + "");
			}
			
			String[] values = {id, name, weight + ""};
			if (isUpdate) {
				table.setValueAt(table.getSelectedRow(), values);
			} else {
				table.setValueAt(table.numOfEmpty(), values);
			}
			
			textID.setText(null);
		} catch (RemoteException e) {
			JOptionPane.showMessageDialog(mainFrame, "请检查网络连接！", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	private void finishOperation() {
		loadVO.setDate(dc.getTime());
		loadVO.setDestination(textDestination.getText());
		loadVO.setVehicle(textVehicleId.getText());
		loadVO.setSuperCargo(textDeliverStaff.getText());
		loadVO.setSuperVision(textGuard.getText());
		
		try {
			load.createLoadNote();
		} catch (RemoteException e) {
			JOptionPane.showMessageDialog(mainFrame, "请检查网络连接！", "Error", JOptionPane.ERROR_MESSAGE);
		}
		
		this.empty();
	}
}
