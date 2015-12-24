package LEMS.presentation.ultraSwing;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.geom.RoundRectangle2D;
import java.util.Vector;

import javax.swing.ComboBoxModel;
import javax.swing.JComboBox;

public class UltraComboBox extends JComboBox {

		 public UltraComboBox(){
		  super();
		  init();
		 }
		 public UltraComboBox(ComboBoxModel model){
		  super(model);
		  init();
		 }
		 public UltraComboBox(Object[] items){
		  super(items);
		  init();
		 }
		 public UltraComboBox(Vector<?> items){
		  super(items);
		  init();
		 }
		 private void init(){
		  setOpaque(false);
		  setUI(new UltraComboBoxUI());
		  setRenderer(new UltraComboBoxRenderer());
		  /**
		   * 一开始点击新建后看到的框背景
		   */
		  setBackground(Color.white.brighter());
		 }
		 public Dimension getPreferredSize(){
		  return super.getPreferredSize();
		 }
		 protected void paintComponent(Graphics g) {
				
			   g.setColor(Color.white);
			   g.fillRoundRect(0, 0, getWidth()-1, getHeight()-1, 15, 15);
			   super.paintComponent(g);
			 }
			 protected void paintBorder(Graphics g) {
			   g.setColor(Color.gray.brighter());
			   g.drawRoundRect(0, 0, getWidth()-1, getHeight()-1, 15, 15);
			 }

		}
	
	

