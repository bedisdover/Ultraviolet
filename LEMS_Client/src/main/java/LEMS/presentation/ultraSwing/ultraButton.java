package LEMS.presentation.ultraSwing;

import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class UltraButton extends JButton {
	private static final long serialVersionUID = 1L;

	public String text;

	public UltraButton(String text) {
		this.setOpaque(false);
		this.setContentAreaFilled(false);
		setBorderPainted(false);
		setBorder(null);
		setContentAreaFilled(false);

		Image imageExit = Toolkit.getDefaultToolkit().getImage("source/exit.png");
		Image imageAdd = Toolkit.getDefaultToolkit().getImage("source/add.png");
		Image imageDelete = Toolkit.getDefaultToolkit().getImage("source/delete.png");
		Image imageUpdate = Toolkit.getDefaultToolkit().getImage("source/update.png");
		Image imageInquire = Toolkit.getDefaultToolkit().getImage("source/inquire.png");
		Image imageOK = Toolkit.getDefaultToolkit().getImage("source/OK.png");
		Image imageCancel = Toolkit.getDefaultToolkit().getImage("source/cancel.png");
		Image imageStart = Toolkit.getDefaultToolkit().getImage("source/start.png");
		Image imageStop = Toolkit.getDefaultToolkit().getImage("source/stop.png");
		Image imageExcel = Toolkit.getDefaultToolkit().getImage("source/excel1.png");
		Image imageFinish = Toolkit.getDefaultToolkit().getImage("source/finish.png");
		Image imageFinish1 = Toolkit.getDefaultToolkit().getImage("source/finish1.png");
		Image imageLook = Toolkit.getDefaultToolkit().getImage("source/look.png");
		Image imageAddToReceiptRecord = Toolkit.getDefaultToolkit().getImage("source/addtoreceiptrecord.png");
		Image imageInquireInformation = Toolkit.getDefaultToolkit().getImage("source/inquireinformation.png");
		Image imagePass = Toolkit.getDefaultToolkit().getImage("source/pass.png");
		Image imageNoPass = Toolkit.getDefaultToolkit().getImage("source/NoPass.png");
		Image imageAllPass = Toolkit.getDefaultToolkit().getImage("source/AllPass.png");
		Image imageLogin = Toolkit.getDefaultToolkit().getImage("source/login1.png");
		Image imageInquireLogisticsInformation = Toolkit.getDefaultToolkit().getImage("source/inquireLogisticsInformation.png");
		
		ImageIcon iconExit = new ImageIcon(imageExit);
		ImageIcon iconAdd = new ImageIcon(imageAdd);
		ImageIcon iconDelete = new ImageIcon(imageDelete);
		ImageIcon iconUpdate = new ImageIcon(imageUpdate);
		ImageIcon iconInquire = new ImageIcon(imageInquire);
		ImageIcon iconOK = new ImageIcon(imageOK);
		ImageIcon iconCancel = new ImageIcon(imageCancel);
		ImageIcon iconStart = new ImageIcon(imageStart);
		ImageIcon iconStop = new ImageIcon(imageStop);
		ImageIcon iconExcel = new ImageIcon(imageExcel);
		ImageIcon iconFinish = new ImageIcon(imageFinish);
		ImageIcon iconFinish1 = new ImageIcon(imageFinish1);
		ImageIcon iconLook = new ImageIcon(imageLook);
		ImageIcon iconAddToReceiptRecord = new ImageIcon(imageAddToReceiptRecord);
		ImageIcon iconInquireInformation = new ImageIcon(imageInquireInformation);
		ImageIcon iconPass = new ImageIcon(imagePass);
		ImageIcon iconNoPass = new ImageIcon(imageNoPass);
		ImageIcon iconAllPass = new ImageIcon(imageAllPass);
		ImageIcon iconLogin = new ImageIcon(imageLogin);
		ImageIcon iconInquireLogisticsInformation = new ImageIcon(imageInquireLogisticsInformation);
		
		if (text.equals("返回")) {
			this.setIcon(iconExit);
		}
		if (text.equals("新增")) {
			this.setIcon(iconAdd);
		}
		if (text.equals("删除")) {
			this.setIcon(iconDelete);
		}
		if (text.equals("修改")) {
			this.setIcon(iconUpdate);
		}
		if (text.equals("查找")) {
			this.setIcon(iconInquire);
		}
		if (text.equals("确定")) {
			this.setIcon(iconOK);
		}
		if (text.equals("取消")) {
			this.setIcon(iconCancel);
		}
		if (text.equals("开始盘点")) {
			this.setIcon(iconStart);
		}
		if (text.equals("取消盘点")) {
			this.setIcon(iconStop);
		}
		if (text.equals("导出表格")) {
			this.setIcon(iconExcel);
		}
		if (text.equals("生成")) {
			this.setIcon(iconFinish);
		}
		if (text.equals("完成")) {
			this.setIcon(iconFinish1);
		}
		if (text.equals("查看")) {
			this.setIcon(iconLook);
		}
		if (text.equals("添加到收款单")) {
			this.setIcon(iconAddToReceiptRecord);
		}
		if (text.equals("查看收款信息")) {
			this.setIcon(iconInquireInformation);
		}
		if (text.equals("通过")) {
			this.setIcon(iconPass);
		}
		if (text.equals("不通过")) {
			this.setIcon(iconNoPass);
		}
		if (text.equals("全部通过")) {
			this.setIcon(iconAllPass);
		}
		if (text.equals("登录")) {
			this.setIcon(iconLogin);
		}
		if (text.equals("查询物流信息")) {
			this.setIcon(iconInquireLogisticsInformation);
		}

	}

}
//// setMargin(new Insets(0, 0, 0, 0)); //设置按钮边框和标签之间的空白
//// setIconTextGap(0); //设置文本间隙
//// setBorderPainted(false); //设置是否允许绘制边框

//// //设置背景透明
//// this.setOpaque(false);
//// //设置边框背景色透明
//// setContentAreaFilled(false);
