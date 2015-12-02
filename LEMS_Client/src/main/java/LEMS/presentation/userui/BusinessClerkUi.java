package LEMS.presentation.userui;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import LEMS.presentation.MainFrame;
import LEMS.presentation.informationui.DriverManageUi;
import LEMS.presentation.informationui.VehicleManageUi;
import LEMS.presentation.orderui.LoadUi;
import LEMS.presentation.orderui.ReceiptRecordUi;
import LEMS.presentation.orderui.ReceiveUi;
import LEMS.presentation.orderui.SendUi;
import LEMS.presentation.orderui.TransferUi;
import LEMS.presentation.orderui.VehicleLoadUi;

/**
 * @author 周梦佳
 * 营业厅业务员界面
 */
public class BusinessClerkUi extends JPanel {
	
	MainFrame mainFrame;
	private JTabbedPane tabbedPane;
	
	ReceiveUi receiveUi;		//接收
	SendUi	sendUi;			//派件
	ReceiptRecordUi	receiptRecordUi;	//记录收款单
	LoadUi	loadUi;		//装车管理
	VehicleManageUi	vehicleManageUi;	//车辆信息管理
	DriverManageUi		driverManageUi;//司机信息管理
	
	public BusinessClerkUi(final MainFrame mainFrame) {
		this.mainFrame = mainFrame;
		this.setLayout(new BorderLayout());
		this.setBounds(0, 0, MainFrame.JFRAME_WIDTH, MainFrame.JFRAME_HEIGHT);
		receiveUi = new ReceiveUi(this.mainFrame);
		sendUi = new SendUi(this.mainFrame);
		receiptRecordUi = new ReceiptRecordUi(this.mainFrame);
		loadUi = new LoadUi(this.mainFrame);
		vehicleManageUi = new VehicleManageUi(this.mainFrame);
		driverManageUi = new DriverManageUi(this.mainFrame);
		init();
		initComponents();
	}
	
	private void init(){
		tabbedPane = new JTabbedPane(); 
		ImageIcon image1=new ImageIcon("source\\tabbedpanel\\生成出库单.png");
		ImageIcon image2=new ImageIcon("source\\tabbedpanel\\装运管理.png");
		ImageIcon image3=new ImageIcon("source\\tabbedpanel\\生成出库单.png");
		ImageIcon image4=new ImageIcon("source\\tabbedpanel\\装运管理.png");
		ImageIcon image5=new ImageIcon("source\\tabbedpanel\\生成出库单.png");
		ImageIcon image6=new ImageIcon("source\\tabbedpanel\\装运管理.png");
		
	//tabbedPane.addTab(title, icon, component, tip);
		//添加由 title 和/或 icon 表示的 component 和 tip，其中任意一个都可以为 null。
		
		tabbedPane.addTab(null,image1,receiveUi,"接收");  
        tabbedPane.addTab(null,image2,sendUi,"派件");
        tabbedPane.addTab(null,image3,receiptRecordUi,"记录收款单");
        tabbedPane.addTab(null,image4,loadUi,"装车管理");
        tabbedPane.addTab(null,image5,vehicleManageUi,"车辆信息管理");
        tabbedPane.addTab(null,image6,driverManageUi,"司机信息管理");
        
	}
	
	private void initComponents(){
		tabbedPane.setTabPlacement(JTabbedPane.NORTH);
		this.add(tabbedPane);
	}
	
//	public void paintComponent(Graphics g) {
//		g.drawImage(MainFrame.background, 0, 0, this.getWidth(), this.getHeight(), null);
//		this.repaint();
//	}




}
