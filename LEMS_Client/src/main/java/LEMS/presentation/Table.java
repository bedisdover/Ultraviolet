package LEMS.presentation;

import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;

public class Table extends JTable {
	private static final long serialVersionUID = 1L;

	/**
	 * 表中存储的数据
	 */
	private String[][] rowData;
	
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

	public JTable table;

	public JScrollPane drawTable(String[] name, int[] bounds) {
		/**
		 * list里面参数分别为需要的行数，每一列的宽度,设置第一行字体大小,设置第一行行宽,
		 * 剩下行的行宽,表格setbounds（list[5],list[6], list[7], list[8]）
		 * 
		 * 调用的时候在你的panel构造函数里 Table table=new Table(); add(table.drawTable(name,
		 * list));
		 */
		columnNum = name.length;
		rowNum = bounds[0];
		rowData = new String[rowNum][columnNum];
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
			column.setPreferredWidth(bounds[1]);
		}

		Font fnt2 = new Font("Courier", Font.PLAIN, bounds[2]);
		table.getTableHeader().setFont(fnt2);
		table.getTableHeader().setPreferredSize(new Dimension(table.getTableHeader().getWidth(), bounds[3]));
		table.setRowHeight(bounds[4]);

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
		scroll.setBounds(bounds[5], bounds[6], bounds[7], bounds[8]);

		return scroll;
	}

	public int numOfEmpty() {
		return currentRow;
	}

	public int getSelectedRow() {
		return table.getSelectedRow();
	}
	
	public ArrayList<String> getValueAt(int r) {
		ArrayList<String> al = new ArrayList<String>();
		for (int i = 0; i < columnNum; i++) {
			al.add(rowData[r][i].toString());
		}
		return al;
	}

	public void setValueAt(int row, String[] values) {
		for (int column = 0; column < values.length; column++) {
			rowData[row][column] = values[column];
		}
		
		currentRow++;
	}
	
	public void setValueAt(int row, int column, String value) {
		rowData[row][column] = value;
	}
	
	public void remove(int row) {
		for (int i = row; i < numOfEmpty(); i++) {
			for (int j = 0; j < columnNum; j++) {
				rowData[i][j] = rowData[i + 1][j];
			}
		}
		
		currentRow--;
	}
}
