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
import LEMS.po.financepo.DocumentState;
import LEMS.po.orderpo.OrderPO;
import LEMS.po.orderpo.VehicleLoadNotePO;
import LEMS.vo.ordervo.VehicleLoadVO;
import LEMS.vo.uservo.UserVO;

/**
 * @author 宋益明
 * 
 * 车辆装车管理任务
 */
public class VehicleLoad extends AddOrder implements VehicleLoadService {

	/**
	 * 运费（单价）
	 */
	private static final double PRICE = 2;
	/**
	 * 订单列表
	 */
	private ArrayList<OrderPO> orders;
	
	private UserVO user;
	
	private VehicleLoadVO vehicleLoadVO;
	
	public VehicleLoad(UserVO user, VehicleLoadVO vehicleLoadVO) {
		this.user = user;
		this.vehicleLoadVO = vehicleLoadVO;
		
		orders = new ArrayList<OrderPO>();
		vehicleLoadVO = new VehicleLoadVO();
	}
	
	public void addOrder(String id) {
		orders.add(findOrder(id));
	}
	
	@Override
	public void createVehicleLoadNote() {
		
		VehicleLoadNotePO vehicleLoadPO = new VehicleLoadNotePO();
		
		vehicleLoadPO.setId(this.createID());
		vehicleLoadPO.setState(DocumentState.waiting);
		vehicleLoadPO.setDate(vehicleLoadVO.getDate());
		vehicleLoadPO.setOrders(orders);
		vehicleLoadPO.setDeparture(user.getInstitution().getLocation());
		vehicleLoadPO.setDestination(vehicleLoadVO.getDestination());
		//TODO 获得车辆信息
		vehicleLoadPO.setVehicle(null);
		vehicleLoadPO.setSuperCargo(vehicleLoadVO.getSuperCargo());
		vehicleLoadPO.setSuperVision(vehicleLoadVO.getSuperVision());
		vehicleLoadPO.setPassage(this.calculatePassage());
		
		try {
			this.getDataService().insert(vehicleLoadPO);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	
	private String createID() {
		//TODO 创建车辆装车单ID
		return null;
	}
	
	/**
	 * 计算并返回运费
	 */
	private double calculatePassage() {
		double weight = sumWeight(orders);
		double distance = new Distance().getDistance(user.getInstitution().getLocation(), vehicleLoadVO.getDestination());
		return PRICE * distance * weight / 1000;
	}
	
	private VehicleLoadDataService getDataService() {
		
		VehicleLoadDataService vehicleLoadDataService = null;
		
		try {
			DatabaseFactory databaseFactory = (DatabaseFactory) Naming.lookup(RMIConnect.RMI);
			OrderFactory orderFactory = databaseFactory.getOrderFactory();
			vehicleLoadDataService = orderFactory.getVehicleLoadData();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
		
		return vehicleLoadDataService;
	}
}
