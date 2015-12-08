package LEMS.presentation.userui;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;
import java.awt.Font;

import LEMS.presentation.MainFrame;
import LEMS.presentation.financeui.ExamDocumentUi;
import LEMS.presentation.informationui.InstitutionManageUi;
import LEMS.presentation.informationui.StuffManageUi;
import LEMS.presentation.inquireui.DiaryUi;
import LEMS.presentation.inquireui.StatisticsReportUi;
import LEMS.vo.uservo.UserVO;

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
	StatisticsReportUi statisticsReportUi;
	LEMS.presentation.financeui.SettingPriceUi SettingPriceUi;
	Font font = new Font("宋体", Font.PLAIN, 12);

	/**
	 * Create the panel.
	 */
	public GeneralManagerUi(final MainFrame mainFrame,UserVO uvo) {
		user=uvo;
		this.mainFrame = mainFrame;
		this.setLayout(new BorderLayout());
		this.setBounds(0, 0, MainFrame.JFRAME_WIDTH, MainFrame.JFRAME_HEIGHT);
		
		examDocumentUi = new ExamDocumentUi(this.mainFrame);
		institutionManageUi = new InstitutionManageUi(this.mainFrame,user);
		diaryUi = new DiaryUi(this.mainFrame,user);
		stuffManageUi = new StuffManageUi(this.mainFrame,user);
		statisticsReportUi = new StatisticsReportUi(this.mainFrame);
		SettingPriceUi = new LEMS.presentation.financeui.SettingPriceUi(this.mainFrame);
		init();
		initComponents();

	}

	private void init(){
		tabbedPane = new JTabbedPane();
		ImageIcon image1=new ImageIcon("source\\tabbedpanel\\查询日志.png");
		ImageIcon image2=new ImageIcon("source\\tabbedpanel\\审批单据.png");
		ImageIcon image3=new ImageIcon("source\\tabbedpanel\\机构管理.png");
		ImageIcon image4=new ImageIcon("source\\tabbedpanel\\人员管理.png");
		ImageIcon image5=new ImageIcon("source\\tabbedpanel\\查看统计分析.png");
		ImageIcon image6=new ImageIcon("source\\tabbedpanel\\制定价格.png");
		
		tabbedPane.addTab(null,image1,diaryUi,"查询日志界面");  
        tabbedPane.addTab(null,image2,examDocumentUi,"审批单据界面");
        tabbedPane.addTab(null,image3,institutionManageUi,"机构管理界面"); 
        tabbedPane.addTab(null,image4,stuffManageUi,"人员管理界面"); 
        tabbedPane.addTab(null,image5,statisticsReportUi,"查看统计分析界面");
        tabbedPane.addTab(null,image6,SettingPriceUi,"制定价格界面");
	}
	
	private void initComponents(){
		tabbedPane.setTabPlacement(JTabbedPane.NORTH);
		this.add(tabbedPane);
	}
}
