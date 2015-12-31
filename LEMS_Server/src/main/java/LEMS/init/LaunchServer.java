package LEMS.init;

import java.rmi.registry.LocateRegistry;

import javax.swing.JFrame;
import javax.swing.JTextField;

import LEMS.data.factoryImpl.DatabaseFactoryImpl;
import LEMS.dataservice.factory.DatabaseFactory;
import java.awt.Rectangle;
import java.awt.Font;
import javax.swing.SwingConstants;

/**
 * @author 章承尧
 * 初始化服务器
 */
public class LaunchServer {
	public static final int PORT=1099;
	public static void main(String[] args){
		JFrame frame=new JFrame();
		frame.setBounds(new Rectangle(500, 400, 200, 150));
		JTextField field=new JTextField();
		field.setEditable(false);
		field.setHorizontalAlignment(SwingConstants.CENTER);
		field.setFont(new Font("宋体", Font.PLAIN, 40));
		frame.getContentPane().add(field);
		frame.setVisible(true);

		 try {
			  DatabaseFactory data=new DatabaseFactoryImpl();
			  LocateRegistry.createRegistry(PORT); 
			  java.rmi.Naming.rebind("rmi://172.26.27.105:1099/data",  data);
			  field.setText("Ready!");
	          System.out.println("ready...");
	       } catch (Exception e) {
	            e.printStackTrace();
	       }
	}
}
   