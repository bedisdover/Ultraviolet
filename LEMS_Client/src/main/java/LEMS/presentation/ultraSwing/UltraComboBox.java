package LEMS.presentation.ultraSwing;

import java.awt.Color;
import java.awt.Dimension;
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
		}
	
	

