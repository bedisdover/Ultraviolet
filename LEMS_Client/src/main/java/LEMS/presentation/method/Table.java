package LEMS.presentation.method;

import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;

import LEMS.presentation.ultraSwing.UltraScrollPane;

public class Table extends JTable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1302577670244342772L;

	private Object[][] rowData;
	public JTable table;

	/**
	 * 表的列数
	 */
	private int columnNum = 0;

	/**
	 * 总行数
	 */
	private int rowNum = 0;

	/**
	 * 表中最后一行
	 */
	private int currentRow = 0;

	public UltraScrollPane drawTable(String[] name, int[] list) {
		/**
		 * list里面参数分别为需要的行数，每一列的宽度,设置第一行字体大小,设置第一行行宽,
		 * 剩下行的行宽,表格setbounds（list[5],list[6], list[7], list[8]）
		 * 
		 * 调用的时候在你的panel构造函数里 Table table=new Table(); add(table.drawTable(name,
		 * list));
		 */

		columnNum = name.length;
		rowNum = list[0];
		rowData = new Object[rowNum][columnNum];
		table = new JTable(rowData, name);
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
		 * 用UltraScrollPane装载JTable
		 */
		UltraScrollPane scroll = new UltraScrollPane(table);
		scroll.setBounds(list[5], list[6], list[7], list[8]);
		return scroll;

	}

	public void setValueAt(int r, int c, String value) {
		rowData[r][c] = value;
	}

	public void setValueAt(int row, String[] values) {
		for (int column = 0; column < values.length; column++) {
			rowData[row][column + 1] = values[column];
		}
		
		if (row != table.getSelectedRow()) {
			currentRow++;
		}
		
		this.identify();
	}
	
	public String getValueAt(int r, int c) {
		return (String) rowData[r][c];
	}

	public int getSelectedRow() {
		return table.getSelectedRow();
	}

	public int numOfEmpty() {
		int count = 0;
		while (rowData[count][0] != null) {
			count++;
		}
		return count;
	}

	public ArrayList<String> getValueAt(int r) {
		ArrayList<String> al = new ArrayList<String>();
		for (int i = 0; i < columnNum; i++) {
			if (rowData[r][i] == null) {
				return null;
			}
			al.add(rowData[r][i].toString());
		}
		return al;
	}

	public int columnNum() {
		return columnNum;
	}

	// 删除某一行
	public void remove(int r) {
		for (int i = r; i < rowNum - 1; i++) {
			for (int j = 0; j < columnNum; j++) {
				setValueAt(i, j, rowData[i + 1][j].toString());
			}
		}
		for (int k = 0; k < columnNum; k++) {
			setValueAt(rowNum - 1, k, "");
		}
	}

	public void removeLine(int row) {
		for (int i = row; i < numOfEmpty(); i++) {
			for (int j = 0; j < columnNum; j++) {
				rowData[i][j] = rowData[i + 1][j];
			}
		}

		currentRow--;
		
		this.identify();
	}
	
	/**
	 * 判断表中是否已存在指定内容（data）
	 * 
	 * @param column 列数（参数中从1开始计数）
	 * @param data 指定内容
	 * @return 返回指定内容所在行数，若不存在，返回-1
	 */
	public int alreadyExisted(int column, String data) {
		for (int i = 0; i < currentRow; i++) {
			if (rowData[i][column - 1].toString().equals(data)) {
				return i;
			}
		}
		return -1;
	}
	
	/**
	 * 给表格中的项编号
	 */
	private void identify() {
		for (int i = 0; i < currentRow; i++) {
			rowData[i][0] = i + 1;
		}
	}
	
	/**
	 * 清空表
	 */
	public void clean() {
		for (int i = 0; i < rowData.length; i++) {
			for (int j = 0; j < rowData[0].length; j++) {
				rowData[i][j] = null;
			}
		}
	}
}
