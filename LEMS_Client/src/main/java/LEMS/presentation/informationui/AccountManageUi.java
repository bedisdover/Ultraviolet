package LEMS.presentation.informationui;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import LEMS.businesslogic.informationbl.InformationAdd;
import LEMS.businesslogic.informationbl.InformationDelete;
import LEMS.businesslogic.informationbl.InformationFind;
import LEMS.businesslogic.informationbl.InformationUpdate;
import LEMS.po.userpo.UserRole;
import LEMS.presentation.LoginUi;
import LEMS.presentation.MainFrame;
import LEMS.presentation.method.Table;
import LEMS.presentation.ultraSwing.UltraButton;
import LEMS.presentation.ultraSwing.UltraTextField;
import LEMS.vo.informationvo.AccountVO;
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
	private UltraButton butOut;
	private UltraButton butAdd;
	private UltraButton butDel;
	private UltraButton butFind;
	private UltraButton butChange;
	private UltraButton OK;
	private UltraButton cancel;

	private JLabel labelID;
	private UltraTextField textID;
	private JLabel labelPassword;
	private UltraTextField textPassword;
	private JLabel labelBalance;
	private UltraTextField textBalance;
	private JLabel userId;
	private JLabel userRole;
	private Font fnt1 = new Font("Courier", Font.PLAIN, 26);
	private Font fnt = new Font("Courier", Font.PLAIN, 15);//其余字体格式
	
	Table table = new Table();

	private UserVO user;
	private boolean isAdd;
	private boolean isUpdate;

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
		title = new JLabel("账户管理");
		butOut = new UltraButton("返回");
		butAdd = new UltraButton("新增");
		butDel = new UltraButton("删除");
		butFind = new UltraButton("查找");
		butChange = new UltraButton("修改");
		OK = new UltraButton("确定");
		cancel = new UltraButton("取消");

		labelID = new JLabel("账户ID:");
		textID = new UltraTextField();
		labelPassword = new JLabel("密码:");
		textPassword = new UltraTextField();
		labelBalance = new JLabel("账户余额:");
		textBalance = new UltraTextField();
		
		userId = new JLabel(" 账号： "+user.getId());
		userId.setLocation(802, 36);
		userId.setSize(180, 25);
		userRole = new JLabel("身份： "+UserRole.transfer(user.getRole()));
		userRole.setLocation(802, 62);
		userRole.setSize(180, 25);
	}

	/**
	 * 初始化各组件
	 */
	private void initComponents() {
		int up = 30;//整体上移量 
		
		title.setBounds(449, 37, 148, 39);
		title.setFont(fnt1);
		labelID.setBounds(86, 140-up, 131, 30);
		textID.setBounds(206, 144-up, 144, 24);
		labelPassword.setBounds(96, 240-up, 131, 30);
		textPassword.setBounds(206, 243-up , 144, 24);
		labelBalance.setBounds(81, 339-up, 131, 30);
		textBalance.setBounds(206, 342-up, 144, 24);

		OK.setBounds(86, 533-up, 120, 40);
		cancel.setBounds(230, 533-up, 120, 40);
		butOut.setBounds(52, 36, 120, 40);
		butAdd.setBounds(114, 632-up, 120, 40);
		butDel.setBounds(336, 632-up, 120, 40);
		butFind.setBounds(557, 632-up, 120, 40);
		butChange.setBounds(779, 632-up, 120, 40);
		
		//设置字体
		labelID.setFont(fnt);
		labelPassword.setFont(fnt);
		labelBalance.setFont(fnt);

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
		this.add(userId);
		this.add(userRole);
		
		String[] columnNames = { "账户ID", "密码", "账户余额"};
		int[] list = { 40, 181, 14, 30, 20, 384, 126-up, 561, 465 };
		// list里面参数分别为需要的列数，每一列的宽度,设置第一行字体大小,设置第一行行宽,
		// * 剩下行的行宽,表格setbounds（list[5],list[6], list[7], list[8]）
		// *
		for(int i = 0;i<list[0];i++){
			for(int j = 0;j<columnNames.length;j++){
				table.isCellEditable(i, j);
			}
		}
		add(table.drawTable(columnNames, list));
		
		JLabel label = new JLabel("*");
		label.setBounds(75, 148-up, 21, 15);
		add(label);
		
		JLabel label_1 = new JLabel("*");
		label_1.setBounds(85, 245-up, 21, 15);
		add(label_1);
		
		JLabel label_2 = new JLabel("*");
		label_2.setBounds(73, 347-up, 21, 15);
		add(label_2);
		

		 InformationFind findInfo=new InformationFind();
		 ArrayList<AccountVO> accounts=findInfo.findAccount();
		 for(int i=0;i<accounts.size();i++){
			 table.setValueAt(i, 0, accounts.get(i).getId());
			 table.setValueAt(i, 1, accounts.get(i).getPassword());
			 table.setValueAt(i, 2, accounts.get(i).getBalance()+"");
		 }
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
					dele.deleteAccount(table.getValueAt(currentLine, 0).trim());
										
					for(int j=currentLine;j<i;j++){
						table.setValueAt(j, 0, table.getValueAt(j+1, 0));
						table.setValueAt(j, 1, table.getValueAt(j+1, 1));
						table.setValueAt(j, 2, table.getValueAt(j+1, 2));
					}				
				}
			}
		});

		butFind.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				String inputValue=JOptionPane.showInputDialog(AccountManageUi.this,"请输入卡号：");
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
						JOptionPane.showMessageDialog(AccountManageUi.this, "未找到该账户");
					}
				}
			}
		});

		butChange.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if(table.getValueAt(table.table.getSelectedRow(), 0)==null){
					JOptionPane.showMessageDialog(AccountManageUi.this, "请选择要修改的账户!");
				}
				else{
					// 设置输入框可编辑
					setTestState(true);
					textID.setEditable(false);
					textBalance.setEditable(false);
					isUpdate=true;
					
					//将被选中账户的详细信息显示出来
					int currentLine=table.table.getSelectedRow();
					InformationFind find=new InformationFind();
					AccountVO theAccount=find.findTheAccount(table.getValueAt(currentLine, 0));
					textID.setText(theAccount.getId());
					textPassword.setText(theAccount.getPassword());
					textBalance.setText(theAccount.getBalance()+"");
				}
				
			}
		});
		OK.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if(isAdd){
					if(isComplete()){
						// 获得第几行为空
					int i = table.numOfEmpty();
					// 在界面上显示新建账户信息
					table.setValueAt(i, 0, textID.getText());
					table.setValueAt(i, 1, textPassword.getText());
					table.setValueAt(i, 2, textBalance.getText());

					//向数据库中存入新建账户信息
					AccountVO avo = new AccountVO(textID.getText(), textPassword
							.getText(), Double.parseDouble(textBalance.getText()));
					InformationAdd add = new InformationAdd();
					add.addAccount(avo);
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
					//在数据库中修改该账户信息
					AccountVO avo = new AccountVO(textID.getText(), textPassword
							.getText(), Double.parseDouble(textBalance.getText()));
					InformationUpdate update = new InformationUpdate();
					update.updateAccount(avo);
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
		g.draw3DRect(63, 126-30, 306, 465, false);
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
