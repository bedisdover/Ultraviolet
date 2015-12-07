package LEMS.presentation.userui;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;

import LEMS.presentation.MainFrame;
import LEMS.presentation.mainUi;
import LEMS.presentation.financeui.CostUi;
import LEMS.presentation.financeui.ExamDocumentUi;
import LEMS.presentation.financeui.SettlementUi;
import LEMS.presentation.informationui.InstitutionManageUi;
import LEMS.presentation.informationui.StuffManageUi;
import LEMS.presentation.inquireui.DiaryUi;
import LEMS.presentation.inquireui.StatisticsReportUi;
import LEMS.presentation.inquireui.StatisticsUi;
import LEMS.vo.uservo.UserVO;

import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * @author 章承尧
 * 总经理界面
 */
@SuppressWarnings("serial")
public class GeneralManagerUi extends JPanel {
	
	MainFrame mainFrame;
	private JTabbedPane tabbedPane;
	UserVO user;
	
	DiaryUi diaryUi;
	ExamDocumentUi examDocumentUi;
	InstitutionManageUi institutionManageUi;
	StuffManageUi stuffManageUi;
	StatisticsUi statisticsUi;
	LEMS.presentation.financeui.SettingPriceUi SettingPriceUi;
	Font font = new Font("宋体", Font.PLAIN, 26);

	/**
	 * Create the panel.
	 */
	public GeneralManagerUi(final MainFrame mainFrame,UserVO uvo) {
		user=uvo;
		this.mainFrame = mainFrame;
		this.setLayout(new BorderLayout());
		this.setBounds(0, 0, MainFrame.JFRAME_WIDTH, MainFrame.JFRAME_HEIGHT);
		
		examDocumentUi = new ExamDocumentUi(this.mainFrame);
		institutionManageUi = new InstitutionManageUi(this.mainFrame);
		diaryUi = new DiaryUi(this.mainFrame);
		stuffManageUi = new StuffManageUi(this.mainFrame);
		statisticsUi = new StatisticsUi(this.mainFrame);
		SettingPriceUi = new LEMS.presentation.financeui.SettingPriceUi(this.mainFrame);
		init();
		initComponents();

	}

	private void init(){
		tabbedPane = new JTabbedPane();
		tabbedPane.setFont(font);
		tabbedPane.addTab("机构管理",null,institutionManageUi,"机构管理界面"); 
		tabbedPane.addTab("查询日志",null,diaryUi,"查询日志界面");  
        tabbedPane.addTab("审批单据",null,examDocumentUi,"审批单据界面");
        tabbedPane.addTab("人员管理",null,stuffManageUi,"人员管理界面"); 
        tabbedPane.addTab("查看统计分析",null,statisticsUi,"查看统计分析界面");
        tabbedPane.addTab("制定价格",null,SettingPriceUi,"制定价格界面");
	}
	
	private void initComponents(){
		tabbedPane.setTabPlacement(JTabbedPane.NORTH);
		this.add(tabbedPane);
	}
}
