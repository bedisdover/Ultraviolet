package LEMS.presentation.inquireui;

import javax.swing.JPanel;

import LEMS.presentation.MainFrame;
import LEMS.presentation.mainUi;

import java.awt.Rectangle;

/**
 * @author 章承尧
 * 查看统计分析界面
 */
@SuppressWarnings("serial")
public class StatisticsUi extends JPanel {

	/**
	 * Create the panel.
	 */
	public StatisticsUi(MainFrame mainFrame) {
		setBounds(new Rectangle(0, 0, mainUi.WIDTH, mainUi.HEIGHT));

	}

}
