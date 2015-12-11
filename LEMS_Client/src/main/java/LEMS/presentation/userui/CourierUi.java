package LEMS.presentation.userui;

import java.awt.Graphics;

import javax.swing.JPanel;

import LEMS.presentation.MainFrame;

public class CourierUi extends JPanel{
	MainFrame mainFrame;
	
	public CourierUi(final MainFrame mainFrame){
		this.mainFrame = mainFrame;
		this.setLayout(null);
		this.setBounds(0, 0, MainFrame.JFRAME_WIDTH, MainFrame.JFRAME_HEIGHT);
		
		this.init();
		this.initComponent();
		this.addListener();
	}
	
	private void init(){
		
	}
	
	private void initComponent(){
		
	}
	
	private void addListener(){
		
	}
	
	private boolean isCompelete(){
		
		return false;
	}
	
	public void paintComponent(Graphics g) {
		g.drawImage(MainFrame.background, 0, 0, this.getWidth(), this.getHeight(), null);
		this.repaint();
	}
}
