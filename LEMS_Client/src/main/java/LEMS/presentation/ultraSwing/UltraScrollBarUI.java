package LEMS.presentation.ultraSwing;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.plaf.basic.BasicArrowButton;
import javax.swing.plaf.basic.BasicScrollBarUI;

public class UltraScrollBarUI extends BasicScrollBarUI{
	 Image image=Toolkit.getDefaultToolkit().getImage("source\\arrow.png");
		 public UltraScrollBarUI(){
		  super();
		 }

		 protected void paintThumb(Graphics g, JComponent c, Rectangle thumbBounds) {
		  int width = thumbBounds.width;
		  int height = thumbBounds.height;
		  Graphics2D g2 = (Graphics2D)g;
		  g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
		          RenderingHints.VALUE_ANTIALIAS_ON);
		  
		  g2.translate(thumbBounds.x, thumbBounds.y);
		  /**
		   * 
		   */
		  g2.setColor(Color.gray);
		  g2.drawRoundRect(1,1,width-2, height-2,5,5);
		  /**
		   * 
		   */
		  g2.setColor(Color.ORANGE);
		  g2.drawLine(3,height/2,width-4,height/2);
		  g2.drawLine(3,height/2+3,width-4,height/2+3);
		  g2.translate(-thumbBounds.x, -thumbBounds.y);
		 }

		 protected void paintTrack(Graphics g, JComponent c, Rectangle trackBounds) {
		  g.setColor(Color.white);
		  int x = trackBounds.x;
		  int y = trackBounds.y;
		  int width = trackBounds.width;
		  int height = trackBounds.height;
		  Graphics2D g2 = (Graphics2D)g;
		  g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
		          RenderingHints.VALUE_ANTIALIAS_ON);
		  g2.setComposite(AlphaComposite
		    .getInstance(AlphaComposite.SRC_OVER, 0.1f));
		  
		  g2.fill3DRect(x, y, width, height, true);
		  g2.setComposite(AlphaComposite
		    .getInstance(AlphaComposite.SRC_OVER, 1f));
		  g2.setColor(Color.white.brighter());
		  g2.fill3DRect(x, y, 1, height+1, true);
		  if(trackHighlight == DECREASE_HIGHLIGHT) {
		      paintDecreaseHighlight(g);
		  } 
		  else if(trackHighlight == INCREASE_HIGHLIGHT)  {
		      paintIncreaseHighlight(g);
		  }
		 }

		 protected JButton createIncreaseButton(int orientation) {
		  JButton button = new BasicArrowButton(orientation){
		   public void paint(Graphics g) {
		    Graphics2D g2 = (Graphics2D)g;
		    g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
		            RenderingHints.VALUE_ANTIALIAS_ON);
		    g2.setColor(Color.white);
		    g2.drawLine(0,0,0,getHeight());
		    g2.drawLine(0,0,getWidth(),0-1);
		   
		    g2.drawImage(image,-1,0,null);
		   }
		  };
		  button.setOpaque(false);
		  return button;
		 }

		 protected JButton createDecreaseButton(int orientation) {

		  
		  JButton button = new BasicArrowButton(orientation){
		   public void paint(Graphics g) {
		    Graphics2D g2 = (Graphics2D)g;
		    g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
		            RenderingHints.VALUE_ANTIALIAS_ON);
		    g2.setColor(Color.white);
		    g2.drawLine(0,0,0,getHeight());
		    g2.drawLine(0,getHeight()-1,getWidth(),getHeight());
		    g2.drawImage(image,-1,0,null);
		   }
		  };
		  button.setOpaque(false);
		  return button;
		 }
		}

