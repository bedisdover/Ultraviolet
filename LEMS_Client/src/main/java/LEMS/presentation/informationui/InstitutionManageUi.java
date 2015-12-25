package LEMS.presentation.informationui;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import LEMS.businesslogic.informationbl.InformationAdd;
import LEMS.businesslogic.informationbl.InformationDelete;
import LEMS.businesslogic.informationbl.InformationFind;
import LEMS.businesslogic.informationbl.InformationUpdate;
import LEMS.po.userpo.UserRole;
import LEMS.presentation.LoginUi;
import LEMS.presentation.MainFrame;
import LEMS.presentation.method.Table;
import LEMS.presentation.ultraSwing.UltraButton;
import LEMS.vo.informationvo.InstitutionVO;
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
	private UltraButton butOut;
	private UltraButton butAdd;
	private UltraButton butDel;
	private UltraButton butFind;
	private UltraButton butChange;
	private UltraButton OK;
	private UltraButton cancel;
	
	private JLabel labelID;
	private JTextField textID;
	private JLabel labelLocation;
	private JTextField textLocation;
	private JLabel userId;
	private JLabel userRole;
	
	private Font fnt1 = new Font("Courier", Font.PLAIN, 26);

	Table table;

	private boolean isAdd;
	private boolean isUpdate;
	private UserVO user;
	private String originalID;
	public InstitutionManageUi(final MainFrame mainFrame,UserVO uvo) {
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
		title = new JLabel("机构管理");
		butOut = new UltraButton("返回");
		butAdd = new UltraButton("新增");
		butDel = new UltraButton("删除");
		butFind = new UltraButton("查找");
		butChange = new UltraButton("修改");
		OK = new UltraButton("确定");
		cancel = new UltraButton("取消");
		
		userId = new JLabel(" 账号： "+user.getId());
		
		userRole = new JLabel("身份： "+UserRole.transfer(user.getRole()));
		
		
		labelID = new JLabel("* 机构编号::");
		textID = new JTextField();
		labelLocation = new JLabel("* 机构所处位置");
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
		
		userId.setLocation(389, 62);
		userId.setSize(180, 25);
		userRole.setLocation(514, 62);
		userRole.setSize(180, 25);
		
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
		this.add(userId);
		this.add(userRole);
		
		String[] columnNames = { "机构编号", "机构所处城市" };
		int[] list = { 40, 272, 14, 30, 20, 384, 126-change, 561, 465 };
		// list里面参数分别为需要的列数，每一列的宽度,设置第一行字体大小,设置第一行行宽,
		// * 剩下行的行宽,表格setbounds（list[5],list[6], list[7], list[8]）
		// *
		table = new Table();
		add(table.drawTable(columnNames, list));
		
		InformationFind findInfo=new InformationFind();
		ArrayList<InstitutionVO> ins=findInfo.findInstitution();
		for(int i=0;i<ins.size();i++){
			table.setValueAt(i, 1, ins.get(i).getLocation());
			table.setValueAt(i, 0, ins.get(i).getID());
		}
		
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
					dele.deleteInstitution(table.getValueAt(currentLine, 0).trim());
										
					for(int j=currentLine;j<i;j++){
						table.setValueAt(j, 0, table.getValueAt(j+1, 0));
						table.setValueAt(j, 1, table.getValueAt(j+1, 1));
					}		
				}
			}
		});

		butFind.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				String inputValue=JOptionPane.showInputDialog(InstitutionManageUi.this,"请输入机构编号：");
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
						JOptionPane.showMessageDialog(InstitutionManageUi.this, "未找到该机构!");
					}
				}
			}
		});

		butChange.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				// 设置输入框可编辑
				setTestState(true);
				isUpdate=true;
				
				//将被选中机构的详细信息显示出来
				int currentLine=table.table.getSelectedRow();
				InformationFind find=new InformationFind();
				InstitutionVO inst=find.findTheInstitution(table.getValueAt(currentLine, 0));
				textID.setText(inst.getID());
				textLocation.setText(inst.getLocation());
				originalID=textID.getText();
			}
		});
		OK.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if(isAdd){
					if(isComplete()){
						// 获得第几行为空
					int i = table.numOfEmpty();
					// 在界面上显示新增机构信息
					table.setValueAt(i, 0, textID.getText());
					table.setValueAt(i, 1, textLocation.getText());
					
					//在数据库中存入新增机构信息
					InstitutionVO ivo = new InstitutionVO(textID
							.getText(), textLocation.getText());				
					InformationAdd add = new InformationAdd();
					add.addInstitution(ivo);
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
					//在数据库中修改该机构信息
					InstitutionVO ivo = new InstitutionVO(textID
							.getText(), textLocation.getText());
					
					if(!originalID.equals(textID.getText())){
						InformationDelete de=new InformationDelete();
						de.deleteInstitution(originalID);
					}
					InformationUpdate update = new InformationUpdate();
					update.updateInstitution(ivo);
					//在界面上修改该机构信息
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
	
	/**
	 * @return boolean
	 * 判断信息是否填写完整
	 */
	private boolean isComplete(){
		if(!textID.getText().equals("")&&!textLocation.getText().equals("")){
			return true;
		}
		else{
			return false;
		}
	}
}
