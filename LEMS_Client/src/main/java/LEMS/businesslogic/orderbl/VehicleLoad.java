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
public class VehicleLoad implements VehicleLoadService {

	/**
	 * 订单列表
	 */
	private ArrayList<OrderPO> orders;
	
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
}
