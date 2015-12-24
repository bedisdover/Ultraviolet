package LEMS.init;

import java.rmi.registry.LocateRegistry;

import LEMS.data.factoryImpl.DatabaseFactoryImpl;
import LEMS.dataservice.factory.DatabaseFactory;

/**
 * @author 章承尧
 * 初始化服务器
 */
public class LaunchServer {
	public static final int PORT=1099;
	public static void main(String[] args){
		 try {
			  DatabaseFactory data=new DatabaseFactoryImpl();
			  LocateRegistry.createRegistry(PORT); 
			  java.rmi.Naming.rebind("rmi://114.212.42.237:1099/data",  data);
	          System.out.println("ready...");
	       } catch (Exception e) {
	            e.printStackTrace();
	       }
	}
}
