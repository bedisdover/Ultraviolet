package LEMS.presentation;

import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;

public class Table extends JTable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1302577670244342772L;
	
	Object[][] obj;
	public JTable table;
	int columns=0;
	int rows=0;
	public JScrollPane drawTable(String[] name, int[] list) {
		/**
		 * list里面参数分别为需要的行数，每一列的宽度,设置第一行字体大小,设置第一行行宽,
		 * 剩下行的行宽,表格setbounds（list[5],list[6], list[7], list[8]）
		 * 
		 * 调用的时候在你的panel构造函数里 Table table=new Table(); add(table.drawTable(name,
		 * list));
		 */

		 columns = name.length;
		 rows=list[0];
		obj = new Object[rows][columns];
		table = new JTable(obj, name);
		/**
		 * 设置表格不能编辑但能选中一行
		 */
		// table.setEnabled(false);

		/*
		 * 设置JTable的列默认的宽度和高度
		 */

		TableColumn column = null;
		int colunms = table.getColumnCount();
		for (int i = 0; i < colunms; i++) {
			column = table.getColumnModel().getColumn(i);

			// 将每一列的默认宽度设置为

			column.setPreferredWidth(list[1]);
		}

		Font fnt2 = new Font("Courier", Font.PLAIN, list[2]);
		table.getTableHeader().setFont(fnt2);
		table.getTableHeader().setPreferredSize(new Dimension(table.getTableHeader().getWidth(), list[3]));
		table.setRowHeight(list[4]);

		/*
		 * 设置JTable自动调整列表的状态，此处设置为关闭
		 */
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		/**
		 * 设置table内容居中
		 */
		DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
		tcr.setHorizontalAlignment(SwingConstants.CENTER);// 这句和上句作用一样
		table.setDefaultRenderer(Object.class, tcr);
		/**
		 * 用JScrollPane装载JTable
		 */
		JScrollPane scroll = new JScrollPane(table);
		scroll.setBounds(list[5], list[6], list[7], list[8]);
		return scroll;

	}
	
	public void setValueAt(int r,int c,String value){
		obj[r][c] = value;
	}
	
	public String getValueAt(int r,int c){
		return (String)obj[r][c];
	}

	public int numOfEmpty(){
		int count = 0;
		while(obj[count][0]!=null){
			count++;
		}
		return count;
	}
	
	public ArrayList<String> getValueAt(int r){
		ArrayList<String> al=new ArrayList<String>();
		for(int i=0;i<columns;i++){
			al.add(obj[r][i].toString());
		}
		return al;
	}
	
	public int columnNum(){
		return columns;
	}
	//删除某一行
	public void remove(int r){
		for(int i=r;i<rows-1;i++){
			for(int j=0;j<columns;j++){
				setValueAt(i,j,obj[i+1][j].toString());
			}
		}
		for(int k=0;k<columns;k++){
		setValueAt(rows-1,k,"");
		}
	}
}
