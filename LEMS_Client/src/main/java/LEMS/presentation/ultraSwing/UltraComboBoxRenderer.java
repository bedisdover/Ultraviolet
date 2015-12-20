package LEMS.presentation.ultraSwing;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.DefaultListCellRenderer;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

public class UltraComboBoxRenderer implements ListCellRenderer {
		 
		 private DefaultListCellRenderer defaultCellRenderer = new DefaultListCellRenderer();

		 public UltraComboBoxRenderer() {
		  super();
		 }

		 public Component getListCellRendererComponent(JList list, Object value,
		   int index, boolean isSelected, boolean cellHasFocus) {

		  JLabel renderer = (JLabel)defaultCellRenderer.getListCellRendererComponent(
		    list, value, index, isSelected, cellHasFocus);
		  if(isSelected){
			  /**
			   * 
			   */
		   renderer.setBackground(Color.gray.brighter());
		   renderer.setForeground(Color.black.darker());
		  }else{
			  /**
			   * 下拉框的背景色
			   */
		   renderer.setBackground(Color.white.brighter());
		  }
		  
		  /**
		   * 选中之后在上面框的背景颜色
		   */
		  list.setSelectionBackground(Color.white);
		  list.setBorder(null);
		  Font font = new Font("Courier", Font.PLAIN, 15);
		  renderer.setFont(font);
		  renderer.setHorizontalAlignment(JLabel.CENTER);
		  return renderer;
		 }
		}

