package LEMS.presentation.storeui;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;


import LEMS.presentation.MainFrame;


/**
 * @author 周梦佳
 * 仓库管理选项卡界面
 */
@SuppressWarnings("serial")
public class StoreUi extends JPanel {

		MainFrame mainFrame;
		private JTabbedPane tabbedPane;
		GenerateInboundOrderUi inboundUi;
		GenerateOutboundOrderUi outboundUi;
		StoreInquireUi inquireUi;
		StoreCheckUi checkUi;
		/**
		 * Create the panel.
		 */
		public StoreUi(final MainFrame mainFrame) {
			this.mainFrame = mainFrame;
			this.setLayout(new BorderLayout());
			this.setBounds(0, 0, MainFrame.JFRAME_WIDTH, MainFrame.JFRAME_HEIGHT);
			inboundUi = new GenerateInboundOrderUi(this.mainFrame);
			outboundUi = new GenerateOutboundOrderUi(this.mainFrame);
			inquireUi = new StoreInquireUi(this.mainFrame);
			checkUi = new StoreCheckUi(this.mainFrame);
			init();
			initComponents();
		}
		
		private void init(){
			tabbedPane = new JTabbedPane(); 
			ImageIcon image1=new ImageIcon("source\\store\\生成入库单.png");
			ImageIcon image2=new ImageIcon("source\\store\\生成出库单.png");
			ImageIcon image3=new ImageIcon("source\\store\\库存查看.png");
			ImageIcon image4=new ImageIcon("source\\store\\库存盘点.png");
			
		//tabbedPane.addTab(title, icon, component, tip);
			//添加由 title 和/或 icon 表示的 component 和 tip，其中任意一个都可以为 null。
			
			 tabbedPane.addTab(null,image1,inboundUi,"生成入库单");  
	        tabbedPane.addTab(null,image2,outboundUi,"生成出库单");
	        tabbedPane.addTab(null,image3,inquireUi,"库存查看"); 
	        tabbedPane.addTab(null,image4,checkUi,"库存盘点"); 
	        
		}
		
		private void initComponents(){
			tabbedPane.setTabPlacement(JTabbedPane.LEFT);
			tabbedPane.setPreferredSize(new Dimension(22,22));
	//		tabbedPane.setBounds(0, 0, 50, this.getHeight());
			this.add(tabbedPane);
		}
		
//		public void paintComponent(Graphics g) {
//			g.drawImage(MainFrame.background, 0, 0, this.getWidth(), this.getHeight(), null);
//			this.repaint();
//		}

		
	
	
	
	
	

}
