package LEMS.presentation.informationui;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import LEMS.businesslogic.informationbl.InformationAdd;
import LEMS.businesslogic.informationbl.InformationDelete;
import LEMS.businesslogic.informationbl.InformationFind;
import LEMS.businesslogic.informationbl.InformationUpdate;
import LEMS.po.informationpo.InstitutionPO;
import LEMS.po.userpo.UserRole;
import LEMS.presentation.LoginUi;
import LEMS.presentation.MainFrame;
import LEMS.presentation.Table;
import LEMS.presentation.userui.ManagerUi;
import LEMS.vo.uservo.UserVO;

/**
 * @author 苏琰梓
 * 账户管理界面
 * 2015年12月9日
 */
public class AccountManageUi extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private MainFrame mainFrame;
	private JLabel title;
	private JButton butOut;
	private JButton butAdd;
	private JButton butDel;
	private JButton butFind;
	private JButton butChange;
	private JButton OK;
	private JButton cancel;

	private JLabel labelID;
	private JTextField textID;
	private JLabel labelPassword;
	private JTextField textPassword;
	private JLabel labelBalance;
	private JTextField textBalance;

	private Font fnt1 = new Font("Courier", Font.PLAIN, 26);
	
	Table table;

	private UserVO user;
	private boolean isAdd;
	private boolean isUpdate;
	private String originalID;
	public AccountManageUi(final MainFrame mainFrame,UserVO uvo){
		user = uvo;
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
	
	/**
	 * 初始化
	 */
	private void init() {
		title = new JLabel("用户管理");
		butOut = new JButton("登出");
		butAdd = new JButton("新增");
		butDel = new JButton("删除");
		butFind = new JButton("查询");
		butChange = new JButton("修改");
		OK = new JButton("确定");
		cancel = new JButton("取消");

		labelID = new JLabel("账户ID:");
		textID = new JTextField();
		labelPassword = new JLabel("密码:");
		textPassword = new JTextField();
		labelBalance = new JLabel("账户余额:");
		textBalance = new JTextField();
	}

	/**
	 * 初始化各组件
	 */
	private void initComponents() {

		title.setBounds(449, 37, 148, 39);
		title.setFont(fnt1);
		labelID.setBounds(86, 140, 131, 30);
		textID.setBounds(206, 144, 144, 24);
		labelPassword.setBounds(96, 240, 131, 30);
		textPassword.setBounds(206, 243, 144, 24);
		labelBalance.setBounds(81, 339, 131, 30);
		textBalance.setBounds(206, 342, 144, 24);

		OK.setBounds(86, 533, 120, 40);
		cancel.setBounds(230, 533, 120, 40);
		butOut.setBounds(52, 36, 120, 40);
		butAdd.setBounds(114, 632, 120, 40);
		butDel.setBounds(336, 632, 120, 40);
		butFind.setBounds(557, 632, 120, 40);
		butChange.setBounds(779, 632, 120, 40);

		this.add(title);
		this.add(labelID);
		this.add(textID);
		this.add(labelPassword);
		this.add(textPassword);
		this.add(labelBalance);
		this.add(textBalance);
		this.add(OK);
		this.add(cancel);
		this.add(butOut);
		this.add(butAdd);
		this.add(butDel);
		this.add(butFind);
		this.add(butChange);

		String[] columnNames = { "账户ID", "密码", "账户余额"};
		int[] list = { 40, 181, 14, 30, 20, 384, 126, 561, 465 };
		// list里面参数分别为需要的列数，每一列的宽度,设置第一行字体大小,设置第一行行宽,
		// * 剩下行的行宽,表格setbounds（list[5],list[6], list[7], list[8]）
		// *
		table = new Table();
		add(table.drawTable(columnNames, list));
		
		JLabel label = new JLabel("*");
		label.setBounds(75, 148, 21, 15);
		add(label);
		
		JLabel label_1 = new JLabel("*");
		label_1.setBounds(85, 245, 21, 15);
		add(label_1);
		
		JLabel label_2 = new JLabel("*");
		label_2.setBounds(73, 347, 21, 15);
		add(label_2);
		

//		 InformationFind findInfo=new InformationFind();
//		 ArrayList<UserVO> users=findInfo.findStaff();
//		 for(int i=0;i<users.size();i++){
//		 table.setValueAt(i, 0, users.get(i).getId());
//		 table.setValueAt(i, 1, users.get(i).getPassword());
//		 table.setValueAt(i, 2, users.get(i).getName());
//		 }
	}

	/**
	 * 设置输入框状态
	 * 
	 * @param state
	 *            输入框状态（是否可编辑）
	 */
	private void setTestState(boolean state) {
		textID.setEditable(state);
		textPassword.setEditable(state);
		textBalance.setEditable(state);

		OK.setEnabled(state);
		cancel.setEnabled(state);
	}

	/**
	 * 清空输入框
	 */
	private void empty() {
		textID.setText(null);
		textPassword.setText(null);
		textBalance.setText(null);
	}

	/**
	 * 为按钮添加事件监听器
	 */
	private void addListener() {
		butOut.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				mainFrame.setContentPane(new LoginUi(mainFrame));
			}
		});

		butAdd.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				// 设置输入框可编辑
				setTestState(true);
				isAdd=true;
			}
		});

		butDel.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int currentLine = table.table.getSelectedRow();
				if (currentLine == -1) {
					JOptionPane.showMessageDialog(AccountManageUi.this, "请选择要删除的行!");
				}
				else {
					int i = table.numOfEmpty();	
					
					InformationDelete dele=new InformationDelete();
					dele.deleteStaff(table.getValueAt(currentLine, 0).trim());
										
					for(int j=currentLine;j<i;j++){
						table.setValueAt(j, 0, table.getValueAt(j+1, 0));
						table.setValueAt(j, 1, table.getValueAt(j+1, 1));
						table.setValueAt(j, 2, table.getValueAt(j+1, 2));
						table.setValueAt(j, 3, table.getValueAt(j+1, 3));
					}
					
					
				}
			}
		});

		butFind.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				String inputValue=JOptionPane.showInputDialog(AccountManageUi.this,"请输入用户账号：");
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
						JOptionPane.showMessageDialog(AccountManageUi.this, "未找到该用户");
					}
				}
			}
		});

		butChange.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				// 设置输入框可编辑
				setTestState(true);
				isUpdate=true;
				
				//将被选中人员的详细信息显示出来
//				int currentLine=table.table.getSelectedRow();
//				InformationFind find=new InformationFind();
//				UserVO theStaff=find.findStaff(table.getValueAt(currentLine, 0));
//				InstitutionPO ins=theStaff.getInstitution();
//				textID.setText(theStaff.getId());
//				textPassword.setText(theStaff.getPassword());
//				textName.setText(theStaff.getName());
//				textInstitutionID.setText(ins.getID());
//				textLocation.setText(ins.getLocation());
//				comboBox.setSelectedItem(UserRole.transfer(theStaff.getRole()));
//				originalID=theStaff.getId();
			}
		});
		OK.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if(isAdd){
					if(isComplete()){
						// 获得第几行为空
					int i = table.numOfEmpty();
					// 确定按钮的具体实现
//					table.setValueAt(i, 0, textID.getText());
//					table.setValueAt(i, 1, textPassword.getText());
//					table.setValueAt(i, 2, textName.getText());
//					InstitutionPO ipo = new InstitutionPO(textInstitutionID
//							.getText(), textLocation.getText());
//					UserVO uvo = new UserVO(textID.getText(), textPassword
//							.getText(), UserRole.exchange((String) comboBox
//							.getSelectedItem()), textName.getText(), ipo);
//					InformationAdd add = new InformationAdd();
//					add.addStaff(uvo);
					// 清空输入框
					empty();
					// 使输入框不可编辑
					setTestState(false);
					isAdd=false;
					}
					else{
						JOptionPane.showMessageDialog(AccountManageUi.this, "请将必填信息填写完整");
					}
				}
				
				if(isUpdate){
					int currentLine=table.table.getSelectedRow();
					//在数据库中修改该人员信息
//					InstitutionPO ipo = new InstitutionPO(textInstitutionID
//							.getText(), textLocation.getText());
//					UserVO uvo = new UserVO(textID.getText(), textPassword
//							.getText(), UserRole.exchange((String) comboBox
//							.getSelectedItem()), textName.getText(), ipo);
//					if(!originalID.equals(textID.getText())){
//						InformationDelete de=new InformationDelete();
//						de.deleteStaff(originalID);
//					}
//					InformationUpdate update = new InformationUpdate();
//					update.updateStaff(uvo);
					//在界面上修改该人员信息
					table.setValueAt(currentLine, 0, textID.getText());
					table.setValueAt(currentLine, 1, textPassword.getText());
					table.setValueAt(currentLine, 2, textBalance.getText());
					
					// 清空输入框
					empty();
					// 使输入框不可编辑
					setTestState(false);
					isUpdate=false;
				}
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
		g.draw3DRect(63, 126, 306, 465, false);
		this.repaint();
	}
	
	private boolean isComplete(){
		if(!textID.getText().equals("")&&!textPassword.getText().equals("")&&!textBalance.getText().equals("")){
			return true;
		}
		else{
			return false;
		}
	}

}
