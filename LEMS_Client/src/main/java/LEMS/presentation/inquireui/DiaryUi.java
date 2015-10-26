package LEMS.presentation.inquireui;

import javax.swing.JPanel;
import java.awt.Rectangle;
import javax.swing.JButton;

/**
 * @author 章承尧
 * 查询日志界面
 */
public class DiaryUi extends JPanel{
	/**
	 * Create the panel.
	 */
	public DiaryUi() {
		setBounds(new Rectangle(0, 0, 1024, 768));
		setLayout(null);
		
		JButton button = new JButton("退出");
		button.setBounds(866, 30, 132, 63);
		add(button);
		
	}
}
