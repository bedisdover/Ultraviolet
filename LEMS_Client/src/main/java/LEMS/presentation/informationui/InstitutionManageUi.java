package LEMS.presentation.informationui;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import LEMS.businesslogic.informationbl.InformationDelete;
import LEMS.businesslogic.informationbl.InformationFind;
import LEMS.presentation.LoginUi;
import LEMS.presentation.MainFrame;
import LEMS.presentation.Table;
import LEMS.vo.uservo.UserVO;

/**
 * @author 苏琰梓 机构管理界面 2015年12月4日
 */
public class InstitutionManageUi extends JPanel {
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
	private JLabel labelLocation;
	private JTextField textLocation;
	
	private Font fnt1 = new Font("Courier", Font.PLAIN, 26);

	Table table;

	private boolean isAdd;
	private boolean isUpdate;
	

	public InstitutionManageUi(final MainFrame mainFrame) {
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
		title = new JLabel("机构管理");
		butOut = new JButton("登出");
		butAdd = new JButton("新增");
		butDel = new JButton("删除");
		butFind = new JButton("查询");
		butChange = new JButton("修改");
		OK = new JButton("确定");
		cancel = new JButton("取消");
		
		labelID = new JLabel("* 员工ID:");
		textID = new JTextField();
		labelLocation = new JLabel("* 所处机构编号:");
		textLocation = new JTextField();
	}
	
	private void initComponents() {
		int change = 30;
		
		title.setBounds(449, 27, 148, 39);
		title.setFont(fnt1);
		labelID.setBounds(100, 180-change, 131, 30);
		textID.setBounds(206, 184-change, 144, 24);
		labelLocation.setBounds(86, 300-change, 131, 30);
		textLocation.setBounds(206, 303-change, 144, 24);
		
		OK.setBounds(86, 533-change, 120, 40);
		cancel.setBounds(230, 533-change, 120, 40);
		butOut.setBounds(52, 36, 120, 40);
		butAdd.setBounds(114, 632-change, 120, 40);
		butDel.setBounds(336, 632-change, 120, 40);
		butFind.setBounds(557, 632-change, 120, 40);
		butChange.setBounds(779, 632-change, 120, 40);
		
		this.add(title);
		this.add(labelID);
		this.add(textID);
		this.add(labelLocation);
		this.add(textLocation);
		this.add(OK);
		this.add(cancel);
		this.add(butOut);
		this.add(butAdd);
		this.add(butDel);
		this.add(butFind);
		this.add(butChange);
		
		String[] columnNames = { "机构所处城市", "机构编号" };
		int[] list = { 40, 272, 14, 30, 20, 384, 126-change, 561, 465 };
		// list里面参数分别为需要的列数，每一列的宽度,设置第一行字体大小,设置第一行行宽,
		// * 剩下行的行宽,表格setbounds（list[5],list[6], list[7], list[8]）
		// *
		table = new Table();
		add(table.drawTable(columnNames, list));
		
	}
	
	private void setTestState(boolean state) {
		textID.setEditable(state);
		textLocation.setEditable(state);

		OK.setEnabled(state);
		cancel.setEnabled(state);
	}
	
	private void empty() {
		textID.setText(null);
		textLocation.setText(null);
	}
	
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
					JOptionPane.showMessageDialog(InstitutionManageUi.this, "请选择要删除的行!");
				}
				else {
					int i = table.numOfEmpty();	
					
					InformationDelete dele=new InformationDelete();
					dele.deleteStaff(table.getValueAt(currentLine, 0).trim());
										
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
				String inputValue=JOptionPane.showInputDialog("请输入用户账号：");
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
						JOptionPane.showMessageDialog(InstitutionManageUi.this, "未找到该用户");
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
				int currentLine=table.table.getSelectedRow();
				InformationFind find=new InformationFind();
				UserVO theStaff=find.findStaff(table.getValueAt(currentLine, 0));
				textID.setText(theStaff.getId());
				textLocation.setText(theStaff.getInstitution().getLocation());
			}
		});
		OK.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if(isAdd){
					if(isComplete()){
						// 获得第几行为空
					int i = table.numOfEmpty();
					// 确定按钮的具体实现
					table.setValueAt(i, 0, textID.getText());
					table.setValueAt(i, 1, textLocation.getText());
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
						JOptionPane.showMessageDialog(InstitutionManageUi.this, "请将必填信息填写完整");
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
					table.setValueAt(currentLine, 1, textLocation.getText());
					
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
		if(!textID.getText().equals("")&&!textLocation.getText().equals("")){
			return true;
		}
		else{
			return false;
		}
	}
}
