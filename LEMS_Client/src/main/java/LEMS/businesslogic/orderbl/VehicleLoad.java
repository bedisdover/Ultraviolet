package LEMS.businesslogic.orderbl;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import LEMS.businesslogic.utility.RMIConnect;
import LEMS.businesslogicservice.orderblservice.VehicleLoadService;
import LEMS.dataservice.factory.DatabaseFactory;
import LEMS.dataservice.factory.OrderFactory;
import LEMS.dataservice.orderdataservice.VehicleLoadDataService;
import LEMS.po.orderpo.OrderPO;
import LEMS.po.orderpo.VehicleLoadPO;

/**
 * @author 宋益明
 * 
 * 车辆装车管理任务
 */
public class VehicleLoad extends AddOrder implements VehicleLoadService {

	/**
	 * 订单列表
	 */
	private ArrayList<OrderPO> orders;
	/**
	 * 运费（单价）
	 */
	private static final double PRICE = 2;
	
	public VehicleLoad() {
		//新建订单列表
		orders = new ArrayList<OrderPO>();
		// TODO Auto-generated constructor stub
	}
	
	public void addOrder(String id) {
		orders.add(findOrder(id));
	}

	public ArrayList<OrderPO> getOrders() {
		return orders;
	}
	
	/**
	 * 计算并返回运费
	 */
	public double calculatePassage() {
		double weight = sumWeight(orders);
		//TODO 营业厅与中转中心间距离未知，默认30
		return PRICE * 30 * weight / 1000;
	}

	@Override
	public void createVehicleLoadNote(VehicleLoadPO vehicleLoadNotePO) {
		try {
			DatabaseFactory databaseFactory = (DatabaseFactory) Naming.lookup(RMIConnect.RMI);
			OrderFactory orderFactory = databaseFactory.getOrderFactory();
			VehicleLoadDataService vehicleLoadDataService = orderFactory.getVehicleLoadData();
			
			vehicleLoadDataService.insert(vehicleLoadNotePO);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
	}
}
