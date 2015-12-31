package LEMS.presentation.userui;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;

import LEMS.presentation.MainFrame;
import LEMS.presentation.storeui.GenerateInboundOrderUi;
import LEMS.presentation.storeui.GenerateOutboundOrderUi;
import LEMS.presentation.storeui.StoreCheckUi;
import LEMS.presentation.storeui.StoreInquireUi;
import LEMS.vo.uservo.UserVO;

/**
 * @author 周梦佳
 * 仓库管理人员主界面
 */
@SuppressWarnings("serial")
public class StoreManagerUi extends JPanel {

	MainFrame mainFrame;
	private JTabbedPane tabbedPane;
	GenerateInboundOrderUi inboundUi;
	GenerateOutboundOrderUi outboundUi;
	StoreInquireUi inquireUi;
	StoreCheckUi checkUi;
	UserVO user;
	public StoreManagerUi(final MainFrame mainFrame,UserVO userVO) {
		user=userVO;
		this.mainFrame = mainFrame;
		this.setLayout(new BorderLayout());
		this.setBounds(0, 0, MainFrame.JFRAME_WIDTH, MainFrame.JFRAME_HEIGHT);
		inboundUi = new GenerateInboundOrderUi(this.mainFrame,userVO);
		outboundUi = new GenerateOutboundOrderUi(this.mainFrame,userVO);
		inquireUi = new StoreInquireUi(this.mainFrame,userVO);
		checkUi = new StoreCheckUi(this.mainFrame,userVO);
		init();
		initComponents();
	}
	
	private void init(){
		tabbedPane = new JTabbedPane(); 
		ImageIcon image1=new ImageIcon("source\\tabbedpanel\\生成入库单.png");
		ImageIcon image2=new ImageIcon("source\\tabbedpanel\\生成出库单.png");
		ImageIcon image3=new ImageIcon("source\\tabbedpanel\\库存查看.png");
		ImageIcon image4=new ImageIcon("source\\tabbedpanel\\库存盘点.png");
		
	//tabbedPane.addTab(title, icon, component, tip);
		//添加由 title 和/或 icon 表示的 component 和 tip，其中任意一个都可以为 null。
		
		tabbedPane.addTab(null,image1,inboundUi,"生成入库单");  
        tabbedPane.addTab(null,image2,outboundUi,"生成出库单");
        tabbedPane.addTab(null,image3,inquireUi,"库存查看"); 
        tabbedPane.addTab(null,image4,checkUi,"库存盘点"); 
        
	}
	
	private void initComponents(){
		tabbedPane.setTabPlacement(JTabbedPane.NORTH);
	//	tabbedPane.setTabPlacement(JTabbedPane.LEFT);
		this.add(tabbedPane);
	}
	
//	public void paintComponent(Graphics g) {
//		g.drawImage(MainFrame.background, 0, 0, this.getWidth(), this.getHeight(), null);
//		this.repaint();
//	}

}
