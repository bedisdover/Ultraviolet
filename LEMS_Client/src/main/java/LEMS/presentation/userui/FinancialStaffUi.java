package LEMS.presentation.userui;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import LEMS.presentation.MainFrame;
import LEMS.presentation.financeui.CostUi;
import LEMS.presentation.financeui.SettlementUi;
import LEMS.presentation.informationui.AccountManageUi;
import LEMS.presentation.inquireui.DiaryUi;
import LEMS.presentation.inquireui.StatisticsReportUi;
import LEMS.vo.uservo.UserVO;

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
	AccountManageUi accountPanel;
	/**
	 * Create the panel.
	 */
	public FinancialStaffUi(final MainFrame mainFrame, UserVO uvo) {
		this.mainFrame = mainFrame;
		this.setLayout(new BorderLayout());
		this.setBounds(0, 0, MainFrame.JFRAME_WIDTH, MainFrame.JFRAME_HEIGHT);
		
		statisticsReportUi = new StatisticsReportUi(this.mainFrame,uvo);
		costPanel = new CostUi(this.mainFrame,uvo);
		diaryUi = new DiaryUi(this.mainFrame, uvo);
		settlementPanel = new SettlementUi(this.mainFrame,uvo);
		accountPanel=new AccountManageUi(this.mainFrame,uvo);
		init();
		initComponents();
	}
	
	private void init(){
		tabbedPane = new JTabbedPane();
		ImageIcon image1=new ImageIcon("source\\tabbedpanel\\结算管理.png");
		ImageIcon image2=new ImageIcon("source\\tabbedpanel\\成本管理.png");
		ImageIcon image3=new ImageIcon("source\\tabbedpanel\\统计报表.png");
		ImageIcon image4=new ImageIcon("source\\tabbedpanel\\查询日志.png");
		ImageIcon image5=new ImageIcon("source\\tabbedpanel\\账户管理.png");
		
		tabbedPane.addTab(null,image1,settlementPanel,"结算管理界面");  
        tabbedPane.addTab(null,image2,costPanel,"成本管理界面");
        tabbedPane.addTab(null,image3,statisticsReportUi,"统计报表界面"); 
        tabbedPane.addTab(null,image4,diaryUi,"查询日志界面"); 
        tabbedPane.addTab(null,image5,accountPanel,"账户管理界面"); 
	}
	
	private void initComponents(){
		tabbedPane.setTabPlacement(JTabbedPane.NORTH);
		this.add(tabbedPane);
	}
	
}
