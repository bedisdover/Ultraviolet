package LEMS.presentation.inquireui;

import javax.swing.*;

import LEMS.presentation.MainFrame;

public class StatisticsReportUi extends JPanel {
	MainFrame mainFrame;
	JLabel title;

	public StatisticsReportUi(final MainFrame mainFrame) {
		this.mainFrame = mainFrame;
		this.init();
	}

	private void init() {
		title = new JLabel("查看统计分析");
	}
	
	private void initComponent(){
		title.setBounds(435, 16, 249, 45);
		this.add(title);
	}
}
