package LEMS.presentation.ultraSwing;

import java.awt.Insets;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class ultraButton extends JButton{
	 
	/**
	 *
	 * @author rslee 自定义button类,可以直接绘制icon
	 */
	 
	    public ultraButton(String img) {
	        this(getIcon(img));
	    }
	 
	    public ultraButton(ImageIcon icon) {
	        setSize(icon.getImage().getWidth(null), icon.getImage().getHeight(null));
	        setIcon(icon);
	        setMargin(new Insets(0, 0, 0, 0)); //设置按钮边框和标签之间的空白  
	        setIconTextGap(0);   //设置文本间隙  
	        setBorderPainted(false); //设置是否允许绘制边框  
	 
	        setBorder(null);
	        setText(null);
	        //设置背景透明
//	        this.setOpaque(false);
	        //设置边框背景色透明
	        setContentAreaFilled(false);
	    }
	 
	    private static ImageIcon getIcon(String iconName) {
	        URL url = ultraButton.class.getResource("/cn/seek4/swing/resource/" + iconName);
	        if (url != null) {
	            return new ImageIcon(url);
	        } else {
	            System.out.println("加载icon失败:" + iconName);
	        }
	        return null;
	    }
	 
	  
	
}
