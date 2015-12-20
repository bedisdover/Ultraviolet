package LEMS.presentation.ultraSwing;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Rectangle;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

public class UltraScrollPane {
//	private JList list = new JList();
//	private JScrollPane scrollPane = new JScrollPane();
//	 public  UltraScrollPane() {
//	        scrollPane.getViewport().setView(list);
//
//	        scrollPane.getVerticalScrollBar().setUI(new UltraScrollBarUI());
//	        scrollPane.getHorizontalScrollBar().setUI(new UltraScrollBarUI());
//
//	        if (scrollPane.getCorner(ScrollPaneConstants.LOWER_RIGHT_CORNER) == null) {
//	            Component component = new JLabel("") {
//
//	                protected void paintComponent(Graphics g) {
//	                    Graphics2D g2 = (Graphics2D) g;
//	                    Paint oldPaint = g2.getPaint();
//	                    Rectangle bounds = getBounds();
//	                    Paint backgroupRectPaint = new GradientPaint(0, 0, new Color(216, 216, 216),
//	                            bounds.width, bounds.height, new Color(152, 152, 152));
//	                    g2.setPaint(backgroupRectPaint);
//	                    g2.fillRect(0, 0, bounds.width, bounds.height);
//	                    g2.setPaint(oldPaint);
//
//	                }
//	            };
//	            scrollPane.setCorner(ScrollPaneConstants.LOWER_RIGHT_CORNER, component);
//	        }
//	    }
}
