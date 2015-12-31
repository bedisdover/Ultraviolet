package LEMS.businesslogic.orderbl;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import LEMS.businesslogic.utility.RMIConnect;
import LEMS.dataservice.factory.DatabaseFactory;
import LEMS.dataservice.factory.OrderFactory;
import LEMS.dataservice.orderdataservice.DistanceDataService;
import LEMS.po.orderpo.DistancePO;

/**
 * @author 宋益明
 * 
 * 用于处理制定城市间距离
 */
public class Distance {
	
	private DistancePO distancePO;
	
	public Distance() {
		distancePO = new DistancePO();
		this.init();
	}
	
	public double getDistance(String former, String latter) {
		return distancePO.getDistance(former, latter);
	}
	
	public void setDistance(String former, String latter, double distance) {
		distancePO.setDistance(former, latter, distance);
		
		try {
			this.getDataService().setDistance(distancePO);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 初始化城市间距离持久化对象
	 */
	private void init() {
		try {
			distancePO = this.getDataService().getDistance();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}	
	
	private DistanceDataService getDataService() {
		DistanceDataService distanceDataService = null;
		
		try {
			//连接数据库
			DatabaseFactory databaseFactory = (DatabaseFactory) Naming.lookup(RMIConnect.RMI);
			OrderFactory orderFactory = databaseFactory.getOrderFactory();
			distanceDataService = orderFactory.getDistanceData();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
		
		return distanceDataService;
	}
}
