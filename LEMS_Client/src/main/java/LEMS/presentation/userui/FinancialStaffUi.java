package LEMS.presentation.userui;

import javax.swing.*;
import javax.swing.border.*;

import LEMS.presentation.MainFrame;
import LEMS.presentation.mainUi;
import LEMS.presentation.financeui.CostUi;
import LEMS.presentation.financeui.SettlementUi;
import LEMS.presentation.inquireui.DiaryUi;
import LEMS.presentation.inquireui.StatisticsReportUi;
import LEMS.vo.uservo.UserVO;

import java.awt.*;
import java.awt.event.*;

/**
 * @author 章承尧
 * 财务人员界面
 */
@SuppressWarnings("serial")
public class FinancialStaffUi extends JPanel {
	MainFrame mainFrame;
	private JTabbedPane tabbedPane;
	StatisticsReportUi statisticsReportUi;
	CostUi costPanel;
	DiaryUi diaryUi;
	SettlementUi settlementPanel;
	UserVO user;
	/**
	 * Create the panel.
	 */
	public FinancialStaffUi(final MainFrame mainFrame,UserVO uvo) {
		user=uvo;
		this.mainFrame = mainFrame;
		this.setLayout(new BorderLayout());
		this.setBounds(0, 0, MainFrame.JFRAME_WIDTH, MainFrame.JFRAME_HEIGHT);
		
		statisticsReportUi = new StatisticsReportUi(this.mainFrame);
		costPanel = new CostUi(this.mainFrame);
		diaryUi = new DiaryUi(this.mainFrame);
		settlementPanel = new SettlementUi(this.mainFrame);
		init();
		initComponents();
	}
	
	private void init(){
		tabbedPane = new JTabbedPane();
		ImageIcon image1=new ImageIcon("source\\tabbedpanel\\结算管理.png");
		ImageIcon image2=new ImageIcon("source\\tabbedpanel\\成本管理.png");
		ImageIcon image3=new ImageIcon("source\\tabbedpanel\\统计报表.png");
		ImageIcon image4=new ImageIcon("source\\tabbedpanel\\查询日志.png");
		
		tabbedPane.addTab(null,image1,settlementPanel,"结算管理界面");  
        tabbedPane.addTab(null,image2,costPanel,"成本管理界面");
        tabbedPane.addTab(null,image3,statisticsReportUi,"统计报表界面"); 
        tabbedPane.addTab(null,image4,diaryUi,"查询日志界面"); 
        
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
