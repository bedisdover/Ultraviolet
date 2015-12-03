package LEMS.businesslogic.orderbl;

import java.util.ArrayList;

import LEMS.businesslogicservice.orderblservice.VehicleLoadService;
import LEMS.po.orderpo.OrderPO;
import LEMS.vo.ordervo.VehicleLoadVO;

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
	
	private VehicleLoadVO vehicleLoadVO;
	
	public VehicleLoad() {
		//新建订单列表
		orders = new ArrayList<OrderPO>();
		// TODO Auto-generated constructor stub
	}
	
	public void addOrder(String id) {
		// TODO Auto-generated method stub
		
	}

	public void createVehicleLoadNote(VehicleLoadVO vehicleLoadVO) {
		// TODO Auto-generated method stub
		
	}
	
	public ArrayList<OrderPO> getOrders() {
		return orders;
	}
	
	/**
	 * 计算并返回运费
	 */
	private double calculatePassage() {
		double weight = sumWeight(orders);
		//TODO 营业厅与中转中心间距离未知，默认30
		return 2 * 30 * weight / 1000;
	}
}
