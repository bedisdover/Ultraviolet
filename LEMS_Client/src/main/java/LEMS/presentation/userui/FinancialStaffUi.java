package LEMS.presentation.userui;

import javax.swing.*;
import javax.swing.border.*;

import LEMS.presentation.MainFrame;
import LEMS.presentation.mainUi;
import LEMS.presentation.financeui.CostPanel;
import LEMS.presentation.inquireui.StatisticsReportUi;

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
	CostPanel costPanel;
	
	
	/**
	 * Create the panel.
	 */
	public FinancialStaffUi(final MainFrame mainFrame) {
		this.mainFrame = mainFrame;
		this.setLayout(new BorderLayout());
		this.setBounds(0, 0, MainFrame.JFRAME_WIDTH, MainFrame.JFRAME_HEIGHT);
		
		statisticsReportUi = new StatisticsReportUi(this.mainFrame);
		costPanel = new CostPanel(this.mainFrame);
		statisticsReportUi.setBackground(Color.yellow);  
		init();
		initComponents();
	}
	
	private void init(){
		tabbedPane = new JTabbedPane();
		tabbedPane.addTab("标签1",null,statisticsReportUi,"First panel");  
        tabbedPane.addTab("标签2",null,costPanel,"Second panel");  
	}
	
	private void initComponents(){
		this.add(tabbedPane);
	}
}
