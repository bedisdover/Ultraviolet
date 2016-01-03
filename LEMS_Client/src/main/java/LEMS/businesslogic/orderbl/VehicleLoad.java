package LEMS.businesslogic.orderbl;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import LEMS.businesslogic.utility.Approvalable;
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
public class VehicleLoad extends AddOrder implements VehicleLoadService, Approvalable {

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
	
	public VehicleLoad() {}
	
	public VehicleLoad(UserVO user, VehicleLoadVO vehicleLoadVO) {
		this.user = user;
		this.vehicleLoadVO = vehicleLoadVO;
		
		orders = new ArrayList<OrderPO>();
		vehicleLoadVO = new VehicleLoadVO();
	}
	
	public void addOrder(String id) throws RemoteException {
		orders.add(findOrder(id));
	}
	
	public String getName(String id) throws RemoteException {
		return findOrder(id).getName();
	}
	
	public double getWeight(String id) throws RemoteException {
		return findOrder(id).getWeight();
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
		vehicleLoadPO.setVehicle(vehicleLoadVO.getVehicle());
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
		String id = "";
		try {
			id = this.getDataService().createID(user.getInstitution().getLocation(), vehicleLoadVO.getDate());
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		return id;
	}
	
	/**
	 * 计算并返回运费
	 */
	private double calculatePassage() {
		double weight = sumWeight(orders);
		double distance = new Distance().getDistance(user.getInstitution().getLocation(), vehicleLoadVO.getDestination());
		return PRICE * distance * weight / 1000;
	}
	
	@Override
	public void approval(String id, DocumentState state) {
		try {
			this.getDataService().find(id).setState(state);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
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
