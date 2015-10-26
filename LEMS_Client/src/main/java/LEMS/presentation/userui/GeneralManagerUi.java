package LEMS.presentation.userui;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;

import java.awt.Color;

import javax.swing.JButton;

import LEMS.presentation.mainUi;
import LEMS.presentation.inquireui.DiaryUi;

import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * @author 章承尧
 * 总经理界面
 */
@SuppressWarnings("serial")
public class GeneralManagerUi extends JPanel {
	mainUi mainui=new mainUi();
	/**
	 * Create the panel.
	 */
	public GeneralManagerUi() {
		setBounds(new Rectangle(0, 0, 1024, 768));
		setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "\u603B\u7ECF\u7406\u754C\u9762", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setLayout(null);
		
		JButton btnNewButton = new JButton("查询日志");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DiaryUi diaryui=new DiaryUi();
				mainui.frame.setContentPane(diaryui);
				diaryui.setVisible(true);
			}
		});
		btnNewButton.setBounds(353, 216, 175, 74);
		add(btnNewButton);
		
		JButton button = new JButton("审批单据");
		button.setBounds(353, 323, 175, 67);
		add(button);
		
		JButton button_1 = new JButton("机构管理");
		button_1.setBounds(353, 423, 175, 74);
		add(button_1);
		
		JButton button_2 = new JButton("人员管理");
		button_2.setBounds(581, 216, 168, 74);
		add(button_2);
		
		JButton button_3 = new JButton("制定价格");
		button_3.setBounds(581, 323, 168, 67);
		add(button_3);
		
		JButton button_4 = new JButton("查看统计分析");
		button_4.setBounds(581, 423, 168, 74);
		add(button_4);

	}

}
