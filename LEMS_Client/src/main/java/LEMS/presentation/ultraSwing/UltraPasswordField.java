package LEMS.presentation.ultraSwing;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class UltraPasswordField extends JPasswordField {
	private static final long serialVersionUID = 1L;
	private Shape shape;
	 public UltraPasswordField() {
//	  super(size);
	  setHorizontalAlignment(JTextField.CENTER);
	  setOpaque(false);
	 }
	 protected void paintComponent(Graphics g) {
	   g.setColor(new Color(240,240,240));
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
