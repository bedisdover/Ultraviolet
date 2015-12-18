package LEMS.presentation.ultraSwing;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.text.IconView;

import org.apache.poi.hpsf.Constants;

public class UltraButton extends JButton{

		public String text;
		  public UltraButton(String text){
			  this.setOpaque(false);
			  this.setContentAreaFilled(false);
			  setBorderPainted(false); 
			  setBorder(null);
			  
			  Image imageExit=Toolkit.getDefaultToolkit().getImage("source/exit.png");
			  Image imageAdd=Toolkit.getDefaultToolkit().getImage("source/add.png");
			  Image imageDelete=Toolkit.getDefaultToolkit().getImage("source/delete.png");
			  Image imageUpdate=Toolkit.getDefaultToolkit().getImage("source/update.png");
			  Image imageInquire=Toolkit.getDefaultToolkit().getImage("source/inquire.png");
			  Image imageOK=Toolkit.getDefaultToolkit().getImage("source/OK.png");
			  Image imageCancel=Toolkit.getDefaultToolkit().getImage("source/cancel.png");
			  Image imageStart=Toolkit.getDefaultToolkit().getImage("source/start.png");
			  Image imageStop=Toolkit.getDefaultToolkit().getImage("source/stop.png");
			  Image imageExcel=Toolkit.getDefaultToolkit().getImage("source/excel1.png");
			  
			  ImageIcon iconExit=new ImageIcon(imageExit);
			  ImageIcon iconAdd=new ImageIcon(imageAdd);
			  ImageIcon iconDelete=new ImageIcon(imageDelete);
			  ImageIcon iconUpdate=new ImageIcon(imageUpdate);
			  ImageIcon iconInquire=new ImageIcon(imageInquire);
			  ImageIcon iconOK=new ImageIcon(imageOK);
			  ImageIcon iconCancel=new ImageIcon(imageCancel);
			  ImageIcon iconStart=new ImageIcon(imageStart);
			  ImageIcon iconStop=new ImageIcon(imageStop);
			  ImageIcon iconExcel=new ImageIcon(imageExcel);
			  if(text.equals("返回")){
				  this.setIcon(iconExit);
			  } if(text.equals("新增")){
				  this.setIcon(iconAdd);
			  } if(text.equals("删除")){
				  this.setIcon(iconDelete);
			  } if(text.equals("修改")){
				  this.setIcon(iconUpdate);
			  } if(text.equals("查找")){
				  this.setIcon(iconInquire);
			  } if(text.equals("确定")){
				  this.setIcon(iconOK);
			  } if(text.equals("取消")){
				  this.setIcon(iconCancel);
			  } if(text.equals("开始盘点")){
				  this.setIcon(iconStart);
			  } if(text.equals("取消盘点")){
				  this.setIcon(iconStop);
			  } if(text.equals("导出表格")){
				  this.setIcon(iconExcel);
			  }
			  
		  }
		   
}
////	        setMargin(new Insets(0, 0, 0, 0)); //设置按钮边框和标签之间的空白  
////	        setIconTextGap(0);   //设置文本间隙  
////	        setBorderPainted(false); //设置是否允许绘制边框  
   
////	        //设置背景透明
////	        this.setOpaque(false);
////	        //设置边框背景色透明
////	        setContentAreaFilled(false);

	

