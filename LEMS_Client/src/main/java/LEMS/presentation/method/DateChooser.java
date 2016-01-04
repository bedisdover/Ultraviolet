package LEMS.presentation.method;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.Stroke;
import java.awt.Toolkit;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Popup;
import javax.swing.PopupFactory;
import javax.swing.SwingUtilities;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;

import LEMS.presentation.ultraSwing.UltraTextField;

/**
 * public DateChooser(JPanel panel,int x,int y) panel为当前panel; (x,y)为组件嵌入位置
 */
public class DateChooser extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private Date initDate;
	private Calendar now = Calendar.getInstance();
	private Calendar select;
	private JPanel monthPanel;// 月历
	private JP1 jp1;// 四块面板,组成
	@SuppressWarnings("unused")
	private JP2 jp2;
	private JP3 jp3;
	@SuppressWarnings("unused")
	private JP4 jp4;
	private Font font = new Font("宋体", Font.PLAIN, 12);
	private final LabelManager lm = new LabelManager();
	public UltraTextField showDate;
	private JButton choose;
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
	private boolean isShow = false;
	private Popup pop;
	private int x;
	private int y;
	public int width = 100;
	public int length = 24;
	private JPanel panel;

	/**
	 * Creates a new instance of DateChooser
	 */
	public DateChooser(JPanel panel, int x, int y) {

		this(new Date(), panel, x, y);
	}

	public DateChooser(Date date, JPanel panel, int x, int y) {
		this.panel = panel;
		this.x = x;
		this.y = y;
		initDate = date;
		select = Calendar.getInstance();
		select.setTime(initDate);
		initPanel();
		initLabel();
		panel.add(showDate);

	}
	
	public DateChooser(JPanel panel, int x, int y,int w,int h) {

		this(new Date(), panel, x, y,w,h);
	}

	public DateChooser(Date date, JPanel panel, int x, int y,int w,int h) {
		this.panel = panel;
		this.x = x;
		this.y = y;
		this.width=w;
		this.length=h;
		initDate = date;
		select = Calendar.getInstance();
		select.setTime(initDate);
		initPanel();
		initLabel();
		panel.add(showDate);

	}

	public void setEnabled(boolean b) {
		super.setEnabled(b);
		showDate.setEnabled(b);
	}

	/**
	 * 得到当前选择框的日期
	 */
	public Date getDate() {
		return select.getTime();
	}

	// 根据初始化的日期,初始化面板
	private void initPanel() {
		monthPanel = new JPanel(new BorderLayout());
		monthPanel.setBorder(BorderFactory.createLineBorder(Color.gray.brighter()));
		JPanel up = new JPanel(new BorderLayout());
		up.add(jp1 = new JP1(), BorderLayout.NORTH);
		up.add(jp2 = new JP2(), BorderLayout.CENTER);
		monthPanel.add(jp3 = new JP3(), BorderLayout.CENTER);
		monthPanel.add(up, BorderLayout.NORTH);
		monthPanel.add(jp4 = new JP4(), BorderLayout.SOUTH);
		this.addAncestorListener(new AncestorListener() {
			public void ancestorAdded(AncestorEvent event) {

			}

			public void ancestorRemoved(AncestorEvent event) {

			}

			// 只要祖先组件一移动,马上就让popup消失
			public void ancestorMoved(AncestorEvent event) {
				hidePanel();
			}

		});
	}
	

	// 初始化标签
	private void initLabel() {
		showDate = new UltraTextField(sdf.format(initDate));
		showDate.setBorder(null);
		showDate.setRequestFocusEnabled(true);
		showDate.setVisible(true);
		showDate.setBounds(x, y, width, length);
		ImageIcon dateIcon = new ImageIcon("source\\time.jpg");
		choose = new JButton(dateIcon);
		choose.setBounds(x + width, y, 23, length);
		choose.setVisible(true);
		panel.add(choose);
		panel.add(showDate);
		choose.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent me) {
				choose.requestFocusInWindow();
			}
		});
		// toSelect=new JLabel(sdf.format(initDate));
		// toSelect.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		// toSelect.setRequestFocusEnabled(true);
		this.setBackground(Color.ORANGE);
		this.add(showDate, BorderLayout.CENTER);
		// this.add(toSelect,BorderLayout.EAST);
		this.setPreferredSize(new Dimension(90, 25));
		this.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		choose.addMouseListener(new MouseAdapter() {

			public void mousePressed(MouseEvent me) {
				if (showDate.isEnabled()) {
					showDate.setForeground(Color.BLACK);
					if (isShow) {
						hidePanel();
					} else {
						showPanel(showDate);
					}
				}
			}
		});
		showDate.addFocusListener(new FocusListener() {
			public void focusLost(FocusEvent e) {
				hidePanel();
			}

			public void focusGained(FocusEvent e) {

			}
		});
	}

	// 根据新的日期刷新
	private void refresh() {
		jp1.updateDate();
		jp3.updateDate();
		SwingUtilities.updateComponentTreeUI(this);
	}

	// 提交日期
	private void commit() {
		showDate.setText(sdf.format(select.getTime()));
		hidePanel();
	}

	private void hidePanel() {
		if (pop != null) {
			isShow = false;
			pop.hide();
			pop = null;
		}
	}

	private void showPanel(Component owner) {
		if (pop != null) {
			pop.hide();
		}
		Point show = new Point(0, showDate.getHeight());
		SwingUtilities.convertPointToScreen(show, showDate);
		Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
		int x = show.x;
		int y = show.y;
		if (x < 0) {
			x = 0;
		}
		if (x > size.width - 295) {
			x = size.width - 295;
		}
		if (y < size.height - 170) {
		} else {
			y -= 188;
		}
		pop = PopupFactory.getSharedInstance().getPopup(owner, monthPanel, x, y);
		pop.show();
		isShow = true;
	}

	private class JP1 extends JPanel {
		private static final long serialVersionUID = 1L;
		
		JLabel left, right, center;

		public JP1() {
			super(new BorderLayout());
			this.setBackground(Color.GRAY.brighter());
			initJP1();
		}

		private void initJP1() {
			left = new JLabel(" << ", JLabel.CENTER);
			left.setToolTipText("上一月");
			right = new JLabel(" >> ", JLabel.CENTER);
			right.setToolTipText("下一月");
			left.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
			right.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
			center = new JLabel("", JLabel.CENTER);
			updateDate();
			this.add(left, BorderLayout.WEST);
			this.add(center, BorderLayout.CENTER);
			this.add(right, BorderLayout.EAST);
			this.setPreferredSize(new Dimension(295, 25));
			left.addMouseListener(new MouseAdapter() {
				public void mouseEntered(MouseEvent me) {
					left.setCursor(new Cursor(Cursor.HAND_CURSOR));
					// left.setForeground(Color.RED);
				}

				public void mouseExited(MouseEvent me) {
					left.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
					left.setForeground(Color.BLACK);
				}

				public void mousePressed(MouseEvent me) {
					select.add(Calendar.MONTH, -1);
					left.setForeground(Color.WHITE);
					refresh();
				}

				public void mouseReleased(MouseEvent me) {
					left.setForeground(Color.BLACK);
				}
			});
			right.addMouseListener(new MouseAdapter() {
				public void mouseEntered(MouseEvent me) {
					right.setCursor(new Cursor(Cursor.HAND_CURSOR));
					// right.setForeground(Color.RED);
				}

				public void mouseExited(MouseEvent me) {
					right.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
					right.setForeground(Color.BLACK);
				}

				public void mousePressed(MouseEvent me) {
					select.add(Calendar.MONTH, 1);
					right.setForeground(Color.WHITE);
					refresh();
				}

				public void mouseReleased(MouseEvent me) {
					right.setForeground(Color.BLACK);
				}
			});
		}

		private void updateDate() {
			center.setText(select.get(Calendar.YEAR) + "年" + (select.get(Calendar.MONTH) + 1) + "月");
		}
	}

	private class JP2 extends JPanel {
		private static final long serialVersionUID = 1L;

		public JP2() {
			this.setPreferredSize(new Dimension(295, 20));
		}

		protected void paintComponent(Graphics g) {
			g.setFont(font);
			g.drawString("星期日 星期一 星期二 星期三 星期四 星期五 星期六", 5, 10);
			g.drawLine(0, 15, getWidth(), 15);
		}
	}

	private class JP3 extends JPanel {
		private static final long serialVersionUID = 1L;

		public JP3() {
			super(new GridLayout(6, 7));
			this.setPreferredSize(new Dimension(295, 100));
			initJP3();
		}

		private void initJP3() {
			updateDate();
		}

		public void updateDate() {
			this.removeAll();
			lm.clear();
			Date temp = select.getTime();
			Calendar select = Calendar.getInstance();
			select.setTime(temp);
			select.set(Calendar.DAY_OF_MONTH, 1);
			int index = select.get(Calendar.DAY_OF_WEEK);
			int sum = (index == 1 ? 8 : index);
			select.add(Calendar.DAY_OF_MONTH, 0 - sum);
			for (int i = 0; i < 42; i++) {
				select.add(Calendar.DAY_OF_MONTH, 1);
				lm.addLabel(new MyLabel(select.get(Calendar.YEAR), select.get(Calendar.MONTH),
						select.get(Calendar.DAY_OF_MONTH)));
			}
			for (MyLabel my : lm.getLabels()) {
				this.add(my);
			}
			select.setTime(temp);
		}
	}

	private class MyLabel extends JLabel implements Comparator<MyLabel>, MouseListener, MouseMotionListener {
		private static final long serialVersionUID = 1L;
		private int year, month, day;
		private boolean isSelected;

		public MyLabel(int year, int month, int day) {
			super("" + day, JLabel.CENTER);
			this.year = year;
			this.day = day;
			this.month = month;
			this.addMouseListener(this);
			this.addMouseMotionListener(this);
			this.setFont(font);
			if (month == select.get(Calendar.MONTH)) {
				this.setForeground(Color.BLACK);
			} else {
				this.setForeground(Color.LIGHT_GRAY);
			}
			if (day == select.get(Calendar.DAY_OF_MONTH)) {
				this.setBackground(new Color(160, 185, 215));
			} else {
				this.setBackground(Color.WHITE);
			}
		}

		public boolean getIsSelected() {
			return isSelected;
		}

		public void setSelected(boolean b, boolean isDrag) {
			isSelected = b;
			if (b && !isDrag) {
				int temp = select.get(Calendar.MONTH);
				select.set(year, month, day);
				if (temp == month) {
					SwingUtilities.updateComponentTreeUI(jp3);
				} else {
					refresh();
				}
			}
			this.repaint();
		}

		protected void paintComponent(Graphics g) {
			if (day == select.get(Calendar.DAY_OF_MONTH) && month == select.get(Calendar.MONTH)) {
				// 如果当前日期是选择日期,则高亮显示
				g.setColor(Color.GRAY.brighter());
				//g.setColor(new Color(147, 210, 233));
				g.fillRect(0, 0, getWidth(), getHeight());
			}
			if (year == now.get(Calendar.YEAR) && month == now.get(Calendar.MONTH)
					&& day == now.get(Calendar.DAY_OF_MONTH)) {
				// 如果日期和当前日期一样,则用红框


				Graphics2D gd = (Graphics2D) g;
				gd.setColor(Color.DARK_GRAY);
				Polygon p = new Polygon();
				p.addPoint(0, 0);
				p.addPoint(getWidth() - 1, 0);
				p.addPoint(getWidth() - 1, getHeight() - 1);
				p.addPoint(0, getHeight() - 1);
				gd.drawPolygon(p);
			}
			if (isSelected) {// 如果被选中了就画出一个虚线框出来
				Stroke s = new BasicStroke(1.0f, BasicStroke.CAP_SQUARE, BasicStroke.JOIN_BEVEL, 1.0f,
						new float[] { 2.0f, 2.0f }, 1.0f);
				Graphics2D gd = (Graphics2D) g;
				gd.setStroke(s);
				gd.setColor(Color.BLACK);
				Polygon p = new Polygon();
				p.addPoint(0, 0);
				p.addPoint(getWidth() - 1, 0);
				p.addPoint(getWidth() - 1, getHeight() - 1);
				p.addPoint(0, getHeight() - 1);
				gd.drawPolygon(p);
			}
			super.paintComponent(g);
		}

		public boolean contains(Point p) {
			return this.getBounds().contains(p);
		}

		private void update() {
			repaint();
		}

		public void mouseClicked(MouseEvent e) {
		}

		public void mousePressed(MouseEvent e) {
			isSelected = true;
			update();
		}

		public void mouseReleased(MouseEvent e) {
			Point p = SwingUtilities.convertPoint(this, e.getPoint(), jp3);
			lm.setSelect(p, false);
			commit();
		}

		public void mouseEntered(MouseEvent e) {
		}

		public void mouseExited(MouseEvent e) {
		}

		public void mouseDragged(MouseEvent e) {
			Point p = SwingUtilities.convertPoint(this, e.getPoint(), jp3);
			lm.setSelect(p, true);
		}

		public void mouseMoved(MouseEvent e) {
		}

		public int compare(MyLabel o1, MyLabel o2) {
			Calendar c1 = Calendar.getInstance();
			c1.set(o1.year, o2.month, o1.day);
			Calendar c2 = Calendar.getInstance();
			c2.set(o2.year, o2.month, o2.day);
			return c1.compareTo(c2);
		}
	}

	private class LabelManager {
		private List<MyLabel> list;

		public LabelManager() {
			list = new ArrayList<MyLabel>();
		}

		public List<MyLabel> getLabels() {
			return list;
		}

		public void addLabel(MyLabel my) {
			list.add(my);
		}

		public void clear() {
			list.clear();
		}

		@SuppressWarnings("unused")
		public void setSelect(MyLabel my, boolean b) {
			for (MyLabel m : list) {
				if (m.equals(my)) {
					m.setSelected(true, b);
				} else {
					m.setSelected(false, b);
				}
			}
		}

		public void setSelect(Point p, boolean b) {
			// 如果是拖动,则要优化一下,以提高效率
			if (b) {
				// 表示是否能返回,不用比较完所有的标签,能返回的标志就是把上一个标签和
				// 将要显示的标签找到了就可以了
				boolean findPrevious = false, findNext = false;
				for (MyLabel m : list) {
					if (m.contains(p)) {
						findNext = true;
						if (m.getIsSelected()) {
							findPrevious = true;
						} else {
							m.setSelected(true, b);
						}
					} else if (m.getIsSelected()) {
						findPrevious = true;
						m.setSelected(false, b);
					}
					if (findPrevious && findNext) {
						return;
					}
				}
			} else {
				MyLabel temp = null;
				for (MyLabel m : list) {
					if (m.contains(p)) {
						temp = m;
					} else if (m.getIsSelected()) {
						m.setSelected(false, b);
					}
				}
				if (temp != null) {
					temp.setSelected(true, b);
				}
			}
		}

	}

	private class JP4 extends JPanel {
		private static final long serialVersionUID = 1L;

		public JP4() {
			super(new BorderLayout());
			this.setPreferredSize(new Dimension(295, 20));
			this.setBackground(Color.GRAY.brighter());
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
			final JLabel jl = new JLabel("今天: " + sdf.format(new Date()));
			jl.setToolTipText("点击回到今天日期");
			this.add(jl, BorderLayout.CENTER);
			jl.addMouseListener(new MouseAdapter() {
				public void mouseEntered(MouseEvent me) {
					jl.setCursor(new Cursor(Cursor.HAND_CURSOR));
					jl.setForeground(Color.DARK_GRAY);
				}

				public void mouseExited(MouseEvent me) {
					jl.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
					jl.setForeground(Color.BLACK);
				}

				public void mousePressed(MouseEvent me) {
					jl.setForeground(Color.WHITE);
					select.setTime(new Date());
					refresh();
					commit();
				}

				public void mouseReleased(MouseEvent me) {
					jl.setForeground(Color.BLACK);
				}
			});
		}
	}

	public String getTime() {
		String temp = sdf.format(select.getTime());
		String result = "";
		for (int i = 0; i < temp.length(); i++) {
			char ch = temp.charAt(i);
			if ((ch >= '0') && (ch <= '9')) {
				result = result + ch;
			}
		}
		return result;
	}

	/**
	 * 设置选择器时间
	 */
	public void setTime(String date) {
		int year = Integer.parseInt(date.substring(0, 4));
		int month = Integer.parseInt(date.substring(4, 6));
		int day = Integer.parseInt(date.substring(6));
		@SuppressWarnings("deprecation")
		Date time = new Date(year, month, day);
		new DateChooser(time, this.panel, this.x, this.y);
	}
	
	public void setWidth(int w){
		this.width=x;
	}
	
	public void setHeight(int h){
		this.length=h;
	}

}
