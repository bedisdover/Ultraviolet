package LEMS.presentation;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableColumn;

public class Table {
	
		public JScrollPane drawTable(String[] name,int[] list){
			/**
			 * list里面参数分别为需要的列数，每一列的宽度,设置第一行字体大小,设置第一行行宽,
			 * 剩下行的行宽,表格setbounds（list[5],list[6], list[7], list[8]）
			 * 
			 * 调用的时候在你的panel构造函数里
			 * Table table=new Table();
			 * add(table.drawTable(name, list));
			 */
	
		int columns=name.length;
		Object[][] obj = new Object[list[0]][columns];  
		 JTable table = new JTable(obj, name);  
	        /* 
	         * 设置JTable的列默认的宽度和高度 
	         */  
		
	        TableColumn column = null;  
	        int colunms = table.getColumnCount();  
	        for(int i = 0; i < colunms; i++)  
	        {  
	            column = table.getColumnModel().getColumn(i);  
	            /*将每一列的默认宽度设置为*/  
	            column.setPreferredWidth(list[1]);  
	        }  
	      
	        Font fnt2 = new Font("Courier", Font.PLAIN, list[2]);
	        table.getTableHeader().setFont(fnt2);
	        table.getTableHeader().setPreferredSize(new Dimension(table.getTableHeader().getWidth(),list[3]));
	        table.setRowHeight(list[4]);
	        
	        /* 
	         * 设置JTable自动调整列表的状态，此处设置为关闭 
	         */  
	        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);  
	  //         table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);		//设置可以调节
	        /*用JScrollPane装载JTable，这样超出范围的列就可以通过滚动条来查看*/  
	        JScrollPane scroll = new JScrollPane(table);  
	      
	          scroll.setBounds(list[5],list[6], list[7], list[8]);
	      return  scroll; 
	      
	}
}
