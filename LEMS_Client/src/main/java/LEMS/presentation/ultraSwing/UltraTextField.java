package LEMS.presentation.ultraSwing;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;

import javax.swing.JComponent;
import javax.swing.JTextField;

public class UltraTextField extends JTextField{
	private Shape shape;
	 public UltraTextField() {
//	  super(size);
	  setHorizontalAlignment(JTextField.CENTER);
	  setOpaque(false);
	  Font fnt = new Font("Courier", Font.PLAIN, 15);// 其余字体格式
		 setFont(fnt);
	 }
	 public UltraTextField(String text) {
		  super(text);
		  setHorizontalAlignment(JTextField.CENTER);
		  setOpaque(false);
		  Font fnt = new Font("Courier", Font.PLAIN, 13);// 其余字体格式
			 setFont(fnt);
			 setText(text);
		 }
	 protected void paintComponent(Graphics g) {
		
	   g.setColor(getBackground());
	   g.fillRoundRect(0, 0, getWidth()-1, getHeight()-1, 15, 15);
	   super.paintComponent(g);
	 }
	 protected void paintBorder(Graphics g) {
	   g.setColor(Color.gray.brighter());
	   g.drawRoundRect(0, 0, getWidth()-1, getHeight()-1, 15, 15);
	 }
	 public boolean contains(int x, int y) {
	   if (shape == null || !shape.getBounds().equals(getBounds())) {
	    shape = new RoundRectangle2D.Float(0, 0, getWidth()-1, getHeight()-1, 15, 15);
	   }
	   return shape.contains(x, y);
	 }

}
