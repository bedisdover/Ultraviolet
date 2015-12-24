package LEMS.presentation.userui;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import LEMS.presentation.MainFrame;
import LEMS.presentation.informationui.DriverManageUi;
import LEMS.presentation.informationui.VehicleManageUi;
import LEMS.presentation.orderui.ReceiptRecordUi;
import LEMS.presentation.orderui.ReceiveUi;
import LEMS.presentation.orderui.SendUi;
import LEMS.presentation.orderui.VehicleLoadUi;
import LEMS.vo.uservo.UserVO;

/**
 * @author 周梦佳
 * 营业厅业务员界面
 */
@SuppressWarnings("serial")
public class BusinessClerkUi extends JPanel {
	
	MainFrame mainFrame;
	private JTabbedPane tabbedPane;
	private ReceiveUi receiveUi;		//接收
	private SendUi	sendUi;			//派件
	private ReceiptRecordUi	receiptRecordUi;	//记录收款单
	private VehicleLoadUi	vehicleLoadUi;		//装车管理
	private VehicleManageUi	vehicleManageUi;	//车辆信息管理
	private DriverManageUi	driverManageUi;//司机信息管理
	
	public BusinessClerkUi(final MainFrame mainFrame, UserVO userVO) {
		this.mainFrame = mainFrame;
		this.setLayout(new BorderLayout());
		this.setBounds(0, 0, MainFrame.JFRAME_WIDTH, MainFrame.JFRAME_HEIGHT);
		receiveUi = new ReceiveUi(this.mainFrame, userVO);
		sendUi = new SendUi(this.mainFrame, userVO);
		receiptRecordUi = new ReceiptRecordUi(this.mainFrame, userVO);
		vehicleLoadUi = new VehicleLoadUi(this.mainFrame, userVO);
		vehicleManageUi = new VehicleManageUi(this.mainFrame, userVO);
		driverManageUi = new DriverManageUi(this.mainFrame,userVO);
		init();
		initComponents();
	
	}
	
	
	private void init(){
		tabbedPane = new JTabbedPane(); 
		ImageIcon image1=new ImageIcon("source\\tabbedpanel\\接收.png");
		ImageIcon image2=new ImageIcon("source\\tabbedpanel\\派件.png");
		ImageIcon image3=new ImageIcon("source\\tabbedpanel\\记录收款单.png");
		ImageIcon image4=new ImageIcon("source\\tabbedpanel\\车辆装车管理.png");
		ImageIcon image5=new ImageIcon("source\\tabbedpanel\\车辆信息管理.png");
		ImageIcon image6=new ImageIcon("source\\tabbedpanel\\司机信息管理.png");
		
		//tabbedPane.addTab(title, icon, component, tip);
		//添加由 title 和/或 icon 表示的 component 和 tip，其中任意一个都可以为 null。
		tabbedPane.addTab(null,image1,receiveUi,"接收");  
        tabbedPane.addTab(null,image2,sendUi,"派件");
        tabbedPane.addTab(null,image3,receiptRecordUi,"记录收款单");
        tabbedPane.addTab(null,image4,vehicleLoadUi,"车辆装车管理");
        tabbedPane.addTab(null,image5,vehicleManageUi,"车辆信息管理");
        tabbedPane.addTab(null,image6,driverManageUi,"司机信息管理");
        
	}
	
	private void initComponents(){
		tabbedPane.setTabPlacement(JTabbedPane.NORTH);
		this.add(tabbedPane);
	}
	
	public void paintComponent(Graphics g) {
		g.drawImage(MainFrame.background, 0, 0, this.getWidth(), this.getHeight(), null);
		this.repaint();
	}

}
