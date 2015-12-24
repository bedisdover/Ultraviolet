package LEMS.presentation;

import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Point;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @author 苏琰梓
 * 所有界面的窗口
 * 2015年11月16日
 */
public class MainFrame extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static final int JFRAME_WIDTH = 1024;
	public static final int JFRAME_HEIGHT = 728;
	
	/**
	 * 背景图片
	 */
	public static final Image background = Toolkit.getDefaultToolkit().getImage("02.jpg");

	private int LocationX;
	private int LocationY;

	public MainFrame(){
		this.setLayout(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(JFRAME_WIDTH, JFRAME_HEIGHT);
//		this.setBackground(SystemColor.inactiveCaptionBorder);
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
		panel.addMouseListener(new MouseAdapter() {
			public void mouseReleased(MouseEvent e) {
				isDragged = false;
				//TODO 恢复鼠标图案
				frame.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			public void mousePressed(MouseEvent e) {
				tmp = new Point(e.getX(), e.getY());
				isDragged = true;
				//TODO 更换拖动时的鼠标图案
				frame.setCursor(new Cursor(Cursor.MOVE_CURSOR));
			}
		});
		panel.addMouseMotionListener(new MouseMotionAdapter() {
			public void mouseDragged(MouseEvent e) {
				if(isDragged) {
					loc = new Point(frame.getLocation().x + e.getX() - tmp.x,
							frame.getLocation().y + e.getY() - tmp.y);
					frame.setLocation(loc);
				}
			}
		});
	}
}
