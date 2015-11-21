package ui;

import java.awt.*;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @author 苏琰梓
 * 所有界面的窗口
 * 2015年11月16日
 */
public class MainFrame extends JFrame{
	public static final int JFRAME_WIDTH = 1024;
	public static final int JFRAME_HEIGHT = 728;


	private int LocationX;
	private int LocationY;

	public MainFrame(){
		this.setLayout(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(JFRAME_WIDTH, JFRAME_HEIGHT);
		//不能自由改变大小
		this.setResizable(false);
		//下面为居中
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension screen = toolkit.getScreenSize();
		LocationX = (screen.width-this.getWidth())/2;
		LocationY = 0; 
		this.setLocation(LocationX,LocationY);
		//不显示Windows自带边框
		this.setUndecorated(true);
		//
		Toolkit tk = Toolkit.getDefaultToolkit();
		Image image = tk.createImage("I.png");
		this.setIconImage(image);
		this.setVisible(true);
	}
	
	private Point loc = null;
	private Point tmp = null;
	private boolean isDragged = false;
	private MainFrame frame = this;
	public void setDragable(JPanel panel) {
		panel.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseReleased(java.awt.event.MouseEvent e) {
				isDragged = false;
				//TODO 恢复鼠标图案
				frame.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			public void mousePressed(java.awt.event.MouseEvent e) {
				tmp = new Point(e.getX(), e.getY());
				isDragged = true;
				//TODO 更换拖动时的鼠标图案
				frame.setCursor(new Cursor(Cursor.MOVE_CURSOR));
			}
		});
		panel.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
			public void mouseDragged(java.awt.event.MouseEvent e) {
				if(isDragged) {
					loc = new Point(frame.getLocation().x + e.getX() - tmp.x,
							frame.getLocation().y + e.getY() - tmp.y);
					frame.setLocation(loc);
				}
			}
		});
	}
}
