package LEMS.presentation.informationui;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import LEMS.businesslogic.informationbl.InformationFind;
import LEMS.businesslogic.informationbl.InformationUpdate;
import LEMS.po.userpo.UserRole;
import LEMS.presentation.LoginUi;
import LEMS.presentation.MainFrame;
import LEMS.presentation.method.Table;
import LEMS.presentation.ultraSwing.UltraButton;
import LEMS.presentation.ultraSwing.UltraTextField;
import LEMS.vo.financevo.SalaryVO;
import LEMS.vo.uservo.UserVO;

/**
 * @author 苏琰梓
 * 人员管理界面
 * 2015年12月4日
 */
public class StuffManageUi extends JPanel  {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private MainFrame mainFrame;
	private JLabel title;
	private UltraButton butOut;
	private UltraButton butAdd;
	private UltraButton butDel;
	private UltraButton butFind;
	private UltraButton butChange;
	private UltraButton OK;
	private UltraButton cancel;
	
	private JLabel labelName;
	private UltraTextField textName;
	private JLabel labelID;
	private UltraTextField textID;
	private JLabel labelInstitution;
	private UltraTextField textInstitution;
	private JLabel labelSalary;
	private UltraTextField textSalary;
	private JLabel userId;
	private JLabel userRole;
	private Font fnt1 = new Font("Courier", Font.PLAIN, 26);

	Table table;

	private UserVO user;
	public StuffManageUi(final MainFrame mainFrame,UserVO uvo){
		user=uvo;
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
	}
	
	private void init() {
		title = new JLabel("人员管理");
		butOut = new UltraButton("返回");
		butAdd = new UltraButton("新增");
		butDel = new UltraButton("删除");
		butFind = new UltraButton("查找");
		butChange = new UltraButton("修改");
		OK = new UltraButton("确定");
		cancel = new UltraButton("取消");
		
		userId = new JLabel(" 账号： "+user.getId());
		userId.setLocation(389, 62);
		userId.setSize(180, 25);
		userRole = new JLabel("身份： "+UserRole.transfer(user.getRole()));
		userRole.setLocation(514, 62);
		userRole.setSize(180, 25);
		labelID = new JLabel("  员工ID:");
		textID = new UltraTextField();
		labelInstitution = new JLabel("  所处机构编号:");
		textInstitution = new UltraTextField();
		labelName = new JLabel("  姓名:");
		textName = new UltraTextField();
		labelSalary = new JLabel("* 工资:(月)");
		textSalary = new UltraTextField();
	}
	
	private void initComponents() {
		int change = 30;
		
		title.setBounds(449, 27, 148, 39);
		title.setFont(fnt1);
		labelName.setBounds(86, 140-change, 131, 30);
		textName.setBounds(206, 144-change, 144, 24);
		labelID.setBounds(86, 240-change, 131, 30);
		textID.setBounds(206, 243-change, 144, 24);
		labelInstitution.setBounds(81, 339-change, 131, 30);
		textInstitution.setBounds(206, 342-change, 144, 24);
		labelSalary.setBounds(88, 440-change, 131, 30);
		textSalary.setBounds(206, 442-change, 144, 24);
		
		OK.setBounds(86, 533-change, 120, 40);
		cancel.setBounds(230, 533-change, 120, 40);
		butOut.setBounds(52, 36, 120, 40);
		butAdd.setBounds(114, 632-change, 120, 40);
		butDel.setBounds(336, 632-change, 120, 40);
		butFind.setBounds(236, 632-change, 120, 40);
		butChange.setBounds(657, 632-change, 120, 40);
		
		this.add(title);
		this.add(labelID);
		this.add(textID);
		this.add(labelInstitution);
		this.add(textInstitution);
		this.add(labelName);
		this.add(textName);
		this.add(OK);
		this.add(cancel);
		this.add(butOut);
		this.add(butFind);
		this.add(butChange);
		this.add(labelSalary);
		this.add(textSalary);
		this.add(userId);
		this.add(userRole);
		
		String[] columnNames = { "员工ID","姓名", "所处机构编号" ,"工资"};
		int[] list = { 40, 136, 14, 30, 20, 384, 126-change, 561, 465 };
		// list里面参数分别为需要的列数，每一列的宽度,设置第一行字体大小,设置第一行行宽,
		// * 剩下行的行宽,表格setbounds（list[5],list[6], list[7], list[8]）
		// *
		table = new Table();
		add(table.drawTable(columnNames, list));
		
		InformationFind findInfo=new InformationFind();
		ArrayList<SalaryVO> sa=findInfo.findSalary();
		for(int i=0;i<sa.size();i++){
			table.setValueAt(i, 0, sa.get(i).getId());
			table.setValueAt(i, 1, sa.get(i).getName());
			table.setValueAt(i, 2, sa.get(i).getInstitution());
			table.setValueAt(i, 3, sa.get(i).getSalary()+"");
			
		}
	}
	
	private void setTestState(boolean state) {
		textID.setEditable(state);
		textInstitution.setEditable(state);
		textName.setEditable(state);
		textSalary.setEditable(state);
		
		OK.setEnabled(state);
		cancel.setEnabled(state);
	}
	
	private void empty() {
		textID.setText(null);
		textInstitution.setText(null);
		textName.setText(null);
		textSalary.setText(null);
	}
	
	private void addListener() {
		butOut.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				mainFrame.setContentPane(new LoginUi(mainFrame));
			}
		});


		butFind.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				String inputValue=JOptionPane.showInputDialog(StuffManageUi.this,"请输入人员账号：");
				int i = table.numOfEmpty();
				for(i=i-1;i>=0;i--){
					if(table.table.getValueAt(i, 0).equals(inputValue)){
						break;
					}
				}
				if(i>=0){
					table.table.setRowSelectionInterval(i, i);
				}
				else{
					if(inputValue!=null){
						JOptionPane.showMessageDialog(StuffManageUi.this, "未找到该人员");
					}
				}
			}
		});

		butChange.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				// 设置输入框可编辑
				setTestState(true);
				textID.setEditable(false);
				textName.setEditable(false);
				textInstitution.setEditable(false);
				//将被选中人员的详细信息显示出来
				int currentLine=table.table.getSelectedRow();
				InformationFind find=new InformationFind();
				SalaryVO theSala=find.findTheSalary(table.getValueAt(currentLine, 0));
				textID.setText(theSala.getId());
				textInstitution.setText(theSala.getInstitution());
				textName.setText(theSala.getName());
				textSalary.setText(theSala.getSalary()+"");
			}
		});
		OK.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {												
					int currentLine=table.table.getSelectedRow();
					//在数据库中修改该人员薪水信息
					SalaryVO svo = new SalaryVO(textID.getText(),textInstitution.getText(),textName.getText(),Double.parseDouble(textSalary.getText()));
					InformationUpdate update = new InformationUpdate();
					update.updateSalary(svo);
					//在界面上修改该人员薪水信息
					table.setValueAt(currentLine, 0, textID.getText());
					table.setValueAt(currentLine, 1, textName.getText());
					table.setValueAt(currentLine, 2, textInstitution.getText());									
					table.setValueAt(currentLine, 3, textSalary.getText()+"");
					// 清空输入框
					empty();
					// 使输入框不可编辑
					setTestState(false);
				
			}
		});
		cancel.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				// 清空输入框
				empty();
				// 设置输入框不可编辑
				setTestState(false);
			}
		});
	}

	public void paintComponent(Graphics g) {
		g.drawImage(MainFrame.background, 0, 0, this.getWidth(),
				this.getHeight(), null);
		g.draw3DRect(63, 126-30, 306, 465, false);
		this.repaint();
	}
	
}
