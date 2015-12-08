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
import LEMS.po.informationpo.Gender;
import LEMS.presentation.LoginUi;
import LEMS.presentation.MainFrame;
import LEMS.presentation.Table;
import LEMS.vo.informationvo.DriverVO;
import LEMS.vo.uservo.UserVO;

/**
 * @author 周梦佳 司机信息管理界面
 */
public class DriverManageUi extends JPanel {

	private static final long serialVersionUID = 1L;
	private static final int LOCATION_LABEL_X = 85;
	private static final int LOCATION_LABEL_Y = 120;
	private static final int LOCATION_TEXT_X = 175;
	private static final int LOCATION_TEXT_Y = 125;
	private static final int BOUND_X = 130;
	private static final int BOUND_Y = 30;

	private MainFrame mainFrame;
	private Table table;
	private JLabel title;
	private JButton exit;
	private JButton OK;
	private JButton cancel;
	private JButton add;
	private JButton delete;
	private JButton update;
	private JButton inquire;
	private JLabel labelId;
	private JLabel labelName;
	private JLabel labelTime;
	private JLabel labelSex;
	private JLabel labelCard;
	private JLabel labelMobile;
	private JLabel labelBirthTime;
	private JLabel labelYear;
	private JLabel labelMonth;
	private JLabel labelDay;
	private JTextField textId;
	private JTextField textName;
	private JTextField textTime;
	private JTextField textCard;
	private JTextField textMobile;
	private JTextField textYear;
	private JTextField textMonth;
	private JTextField textDay;
	private JComboBox<String> comboBox;// sex

	private Font fnt1 = new Font("Courier", Font.BOLD, 26);// 标题字体格式
	private Font fnt = new Font("Courier", Font.PLAIN, 15);// 其余字体格式
	private Font fnt2 = new Font("宋体", Font.BOLD, 16);// 按钮字体格式
	private UserVO uvo;
	private boolean isAdd;
	private boolean isUpdate;
	
	public DriverManageUi(final MainFrame mainFrame,UserVO uvo) {
		this.uvo=uvo;
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
		title = new JLabel("司机信息管理");
		exit = new JButton("返回");
		OK = new JButton("确定");
		cancel = new JButton("取消");
		add=new JButton("新增");
		delete=new JButton("删除");
		update=new JButton("修改");
		inquire=new JButton("查找");
		labelId = new JLabel("司机编号:");
		labelName = new JLabel("姓名:");
		labelTime = new JLabel("行驶证期限:");
		labelSex = new JLabel("性别:");
		labelCard = new JLabel("身份证号：");
		labelMobile = new JLabel("手机号:");
		labelBirthTime = new JLabel("出生日期:");
		labelYear=new JLabel("年");
		labelMonth=new JLabel("月");
		labelDay=new JLabel("日");
		textId = new JTextField();
		textName = new JTextField();
		textTime = new JTextField();
		textCard = new JTextField();
		textMobile = new JTextField();
		textYear= new JTextField();
		textMonth= new JTextField();
		textDay= new JTextField();
		comboBox = new JComboBox<String>();
	}

	/**
	 * 初始化各组件
	 */
	private void initComponents() {

		title.setBounds(420, 27, 230, 39);
		labelId.setBounds(LOCATION_LABEL_X, LOCATION_LABEL_Y, BOUND_X, BOUND_Y);
		labelName.setBounds(LOCATION_LABEL_X + 15, LOCATION_LABEL_Y + 55, BOUND_X, BOUND_Y);
		labelTime.setBounds(LOCATION_LABEL_X - 7, LOCATION_LABEL_Y + 110, BOUND_X, BOUND_Y);
		labelSex.setBounds(LOCATION_LABEL_X + 15, LOCATION_LABEL_Y + 165, BOUND_X, BOUND_Y);
		labelCard.setBounds(LOCATION_LABEL_X, LOCATION_LABEL_Y + 220, BOUND_X, BOUND_Y);
		labelMobile.setBounds(LOCATION_LABEL_X + 7, LOCATION_LABEL_Y + 275, BOUND_X, BOUND_Y);
		labelBirthTime.setBounds(LOCATION_LABEL_X, LOCATION_LABEL_Y + 330, BOUND_X, BOUND_Y);
		labelYear.setBounds(LOCATION_LABEL_X+132, LOCATION_LABEL_Y + 330, BOUND_X-100, BOUND_Y);
		labelMonth.setBounds(LOCATION_LABEL_X+175, LOCATION_LABEL_Y + 330, BOUND_X-100, BOUND_Y);
		labelDay.setBounds(LOCATION_LABEL_X+217, LOCATION_LABEL_Y + 330, BOUND_X-100, BOUND_Y);
		textId.setBounds(LOCATION_TEXT_X, LOCATION_TEXT_Y, BOUND_X, BOUND_Y - 6);
		textName.setBounds(LOCATION_TEXT_X, LOCATION_TEXT_Y + 55, BOUND_X, BOUND_Y - 6);
		textTime.setBounds(LOCATION_TEXT_X, LOCATION_TEXT_Y + 110, BOUND_X, BOUND_Y - 6);
		textCard.setBounds(LOCATION_TEXT_X, LOCATION_TEXT_Y + 220, BOUND_X, BOUND_Y - 6);
		textMobile.setBounds(LOCATION_TEXT_X, LOCATION_TEXT_Y + 275, BOUND_X, BOUND_Y - 6);
		textYear.setBounds(LOCATION_TEXT_X, LOCATION_TEXT_Y + 330, BOUND_X-90, BOUND_Y - 6);
		textMonth.setBounds(LOCATION_TEXT_X+58, LOCATION_TEXT_Y + 330, BOUND_X-105, BOUND_Y - 6);
		textDay.setBounds(LOCATION_TEXT_X+101, LOCATION_TEXT_Y + 330, BOUND_X-105, BOUND_Y - 6);
		comboBox.setBounds(LOCATION_TEXT_X, LOCATION_TEXT_Y + 165, BOUND_X, BOUND_Y - 5);
		comboBox.addItem("男");
		comboBox.addItem("女");
		OK.setBounds(LOCATION_LABEL_X + 5, LOCATION_LABEL_Y + 385, BOUND_X - 40, BOUND_Y + 10);
		cancel.setBounds(LOCATION_LABEL_X + 125, LOCATION_LABEL_Y + 385, BOUND_X - 40, BOUND_Y + 10);
		exit.setBounds(80, 50, 100, 40);
		add.setBounds(150, 590, 120, 40);
		delete.setBounds(350, 590, 120,40);
		update.setBounds(550, 590, 120, 40);
		inquire.setBounds(750, 590, 120, 40);

		title.setFont(fnt1);
		labelId.setFont(fnt);
		labelName.setFont(fnt);
		labelSex.setFont(fnt);
		labelTime.setFont(fnt);
		labelCard.setFont(fnt);
		labelMobile.setFont(fnt);
		labelBirthTime.setFont(fnt);
		labelYear.setFont(fnt);
		labelMonth.setFont(fnt);
		labelDay.setFont(fnt);
		textId.setFont(fnt);
		textName.setFont(fnt);
		textTime.setFont(fnt);
		textCard.setFont(fnt);
		textMobile.setFont(fnt);
		textYear.setFont(fnt);
		textMonth.setFont(fnt);
		textDay.setFont(fnt);
		comboBox.setFont(fnt);
		cancel.setFont(fnt2);
		OK.setFont(fnt2);
		exit.setFont(fnt2);
		add.setFont(fnt2);
		delete.setFont(fnt2);
		update.setFont(fnt2);
		inquire.setFont(fnt2);

		this.add(title);
		this.add(labelId);
		this.add(labelName);
		this.add(labelSex);
		this.add(labelTime);
		this.add(labelCard);
		this.add(labelMobile);
		this.add(labelBirthTime);
		this.add(labelYear);
		this.add(labelMonth);
		this.add(labelDay);
		this.add(textId);
		this.add(textName);
		this.add(textTime);
		this.add(textMobile);
		this.add(textCard);
		this.add(textYear);
		this.add(textMonth);
		this.add(textDay);
		this.add(comboBox);
		this.add(OK);
		this.add(cancel);
		this.add(exit);
		this.add(add);
		this.add(delete);
		this.add(update);
		this.add(inquire);

		String[] columnNames = { "司机编号", "姓名", "行驶证期限", "性别", "身份证号", "手机号" };
		int[] list = { 40, 96, 14, 30, 20, 362, 105, 594, 460 };

		table = new Table();
		add(table.drawTable(columnNames, list));
		
		InformationFind findInfo=new InformationFind();
		 ArrayList<DriverVO> drivers=findInfo.findDriver(uvo.getId().substring(6, 9));
//		ArrayList<DriverVO> drivers=findInfo.findDriver("000");
		 for(int i=0;i<drivers.size();i++){
		 table.setValueAt(i, 0, drivers.get(i).getId());
		 table.setValueAt(i, 1, drivers.get(i).getName());
		 table.setValueAt(i, 2, drivers.get(i).getDrivingPeriod());
		 table.setValueAt(i, 3, drivers.get(i).getGender()+"");
		 table.setValueAt(i, 4, drivers.get(i).getIDcardNumber());
		 table.setValueAt(i, 5, drivers.get(i).getPhoneNumber());
		 }
	}

	/**
	 * 设置输入框状态
	 * 
	 * @param state
	 *            输入框状态（是否可编辑）
	 */
	private void setTestState(boolean state) {

		textId.setEditable(state);
		textName.setEditable(state);
		textTime.setEditable(state);
		textCard.setEditable(state);
		textMobile.setEditable(state);
		textYear.setEditable(state);
		textMonth.setEditable(state);
		textDay.setEditable(state);
		comboBox.setEnabled(state);
		OK.setEnabled(state);
		cancel.setEnabled(state);
	}

	/**
	 * 清空输入框
	 */
	private void empty() {
		textId.setText(null);
		textName.setText(null);
		textTime.setText(null);
		textMobile.setText(null);
		textCard.setText(null);
		textYear.setText(null);
		textMonth.setText(null);
		textDay.setText(null);
		comboBox.setSelectedIndex(0);
	}

	/**
	 * 为按钮添加事件监听器
	 */
	private void addListener() {
		add.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				setTestState(true);
				isAdd=true;
			}
		});
		delete.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int currentLine = table.table.getSelectedRow();
				if (currentLine == -1) {
					JOptionPane.showMessageDialog(DriverManageUi.this, "请选择要删除的行!");
				}
				else {
					int i = table.numOfEmpty();	
					
					InformationDelete dele=new InformationDelete();
					dele.deleteDriver(table.getValueAt(currentLine, 0).trim());
										
					for(int j=currentLine;j<i;j++){
						table.setValueAt(j, 0, table.getValueAt(j+1, 0));
						table.setValueAt(j, 1, table.getValueAt(j+1, 1));
						table.setValueAt(j, 2, table.getValueAt(j+1, 2));
						table.setValueAt(j, 3, table.getValueAt(j+1, 3));
						table.setValueAt(j, 4, table.getValueAt(j+1, 4));
						table.setValueAt(j, 5, table.getValueAt(j+1, 5));
					}					
				}
			}
		});
		update.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				setTestState(true);
				isUpdate=true;
				
				//将被选中司机的详细信息显示出来
				int currentLine=table.table.getSelectedRow();
				InformationFind find=new InformationFind();
				DriverVO dvo=find.findTheDriver(table.getValueAt(currentLine, 0));
				textId.setText(dvo.getId());
				textName.setText(dvo.getName());
				textTime.setText(dvo.getDrivingPeriod());
				comboBox.setSelectedItem(Gender.toString(dvo.getGender()));
				textCard.setText(dvo.getIDcardNumber());
				textMobile.setText(dvo.getPhoneNumber());
				textYear.setText(dvo.getDateOfBirth().substring(0,4));
				textMonth.setText(dvo.getDateOfBirth().substring(5, 7));
				textDay.setText(dvo.getDateOfBirth().substring(8, 10));
			}
		});
		
		inquire.addMouseListener(new MouseAdapter() {
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
						JOptionPane.showMessageDialog(DriverManageUi.this, "未找到该用户");
					}
				}
			}
		});
		
		exit.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				LoginUi loginUi=new LoginUi(mainFrame);
				mainFrame.setContentPane(loginUi);
			}
		});

		OK.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				//新建司机信息
				if(isAdd){
					if(isComplete()){
						int i = table.numOfEmpty();
						table.setValueAt(i, 0, textId.getText());
						table.setValueAt(i, 1, textName.getText());
						table.setValueAt(i, 2, textTime.getText());
						table.setValueAt(i, 3, (String)comboBox.getSelectedItem());
						table.setValueAt(i, 4, textCard.getText());
						table.setValueAt(i, 5, textMobile.getText());
						
						DriverVO dvo=new DriverVO(textId.getText(),textName.getText(),textYear.getText()+"年"+textMonth.getText()+"月"+textDay.getText()+"日",textCard.getText(),textMobile.getText(),textTime.getText(),Gender.exchange((String)comboBox.getSelectedItem()));
						InformationAdd add = new InformationAdd();
						add.addDriver(dvo);
						
						empty();
						setTestState(false);
						isAdd=false;
					}
					else{
						JOptionPane.showMessageDialog(DriverManageUi.this, "请将信息填写完整");
					}
				}
				
				//修改司机信息
				if(isUpdate){
					int currentLine=table.table.getSelectedRow();
					//在数据库中修改该司机信息
					DriverVO dvo=new DriverVO(textId.getText(),textName.getText(),textYear.getText()+"年"+textMonth.getText()+"月"+textDay.getText()+"日",textCard.getText(),textMobile.getText(),textTime.getText(),Gender.exchange((String)comboBox.getSelectedItem()));
					InformationUpdate update = new InformationUpdate();
					update.updateDriver(dvo);
					
					//在界面上修改该司机信息
					table.setValueAt(currentLine, 0, textId.getText());
					table.setValueAt(currentLine, 1, textName.getText());
					table.setValueAt(currentLine, 2, textTime.getText());
					table.setValueAt(currentLine, 3, (String)comboBox.getSelectedItem());
					table.setValueAt(currentLine, 4, textCard.getText());
					table.setValueAt(currentLine, 5, textMobile.getText());
					
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
				empty();
				setTestState(false);
			}
		});
	}

	public void paintComponent(Graphics g) {
		g.drawImage(MainFrame.background, 0, 0, this.getWidth(), this.getHeight(), null);
		g.draw3DRect(70, 105, 250, 460, false); // 输入框外框
		this.repaint();
	}
	
	//判断司机信息是否填写完整
	private boolean isComplete(){
		if(textId.equals("")||textName.equals("")||textTime.equals("")||textCard.equals("")||textMobile.equals("")||textYear.equals("")||textMonth.equals("")||textDay.equals("")){
			return false;
		}
		else{
			return true;
		}
	}
}
