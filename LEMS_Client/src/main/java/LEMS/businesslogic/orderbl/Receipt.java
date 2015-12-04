package LEMS.businesslogic.orderbl;

import java.util.ArrayList;
import java.util.Date;

import LEMS.businesslogic.utility.DateFormate;
import LEMS.businesslogicservice.orderblservice.ReceiptService;
import LEMS.dataservice.orderdataservice.ReceiptDataService;
import LEMS.po.orderpo.ArrivalNotePO;
import LEMS.po.orderpo.OrderPO;
import LEMS.vo.inquirevo.LogisticsInfoVO;
import LEMS.vo.ordervo.ArrivalVO;
import LEMS.vo.uservo.UserVO;

/**
 * @author 宋益明
 * 
 * 接收任务
 */
public class Receipt extends AddOrder implements ReceiptService {

	/**
	 * 订单列表
	 */
	private ArrayList<OrderPO> orders;
	
	/**
	 * 营业厅业务员
	 */
	private UserVO user;
	
	/**
	 * 到达单值对象
	 */
	private ArrivalVO arrivalVO;
	
	/**
	 * 出发地
	 */
	private String depature;
	
	public Receipt(UserVO user, ArrivalVO arrivalVO) {
		//新建订单列表
		orders = new ArrayList<OrderPO>();
		
		this.user = user;
		this.arrivalVO = arrivalVO;
	}
	
	public void addOrder(String id) {
		//获得物流信息
		LogisticsInfoVO logistics = getLogistics(id);
		depature = logistics.getInstitution();
		
		//更新物流信息
		logistics.setTrace("到达" + user.getInstitution().getLocation() + "营业厅");
		logistics.setInstitution(user.getInstitution().getLocation());
		updateLogistics(logistics);
		
		//添加订单到订单列表中
		orders.add(findOrder(id));
	}

	public void createArrivalNote() {
		// TODO 添加货物状态
		ArrivalNotePO arrivalNotePO = new ArrivalNotePO();
		
		arrivalNotePO.setDate(arrivalVO.getDate());
		arrivalNotePO.setDeparture(arrivalVO.getDepature());
		arrivalNotePO.setOrders(orders);
		arrivalNotePO.setId(createId());
		
		
	}
	
	/**
	 * 生成到达单ID
	 */
	private String createId() {
		//TODO 
		return null;
	}
	
	private ReceiptDataService 
}
