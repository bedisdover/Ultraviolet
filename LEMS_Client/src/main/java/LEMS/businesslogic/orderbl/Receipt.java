package LEMS.businesslogic.orderbl;

import java.util.ArrayList;
import java.util.Date;

import LEMS.businesslogic.utility.DateFormate;
import LEMS.businesslogicservice.orderblservice.ReceiptService;
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
	 * 到达单值对象
	 */
	private ArrivalVO arrivalVO;
	
	/**
	 * 营业厅业务员
	 */
	private UserVO user;
	
	/**
	 * 
	 */
	private String depature;
	
	public Receipt(UserVO user) {
		//新建订单列表
		orders = new ArrayList<OrderPO>();
		
		this.user = user;
	}
	
	public void addOrder(String id) {
		//获得物流信息
		LogisticsInfoVO logistics = getLogistics(id);
		//更新物流信息
		logistics.setTrace("到达" + user.getInstitution().getLocation() + "营业厅");
		updateLogistics(logistics);
		
		//添加订单到订单列表中
		orders.add(findOrder(id));
	}

	public void createArrivalNote(ArrivalVO arrivalInfo) {
		// TODO Auto-generated method stub
		//设置到达时间
		arrivalVO.setDate(DateFormate.DATE_FORMAT.format(new Date()));
		//设置出发地
		
		
	}
	
	public ArrayList<OrderPO> getOrders() {
		return orders;
	}
}
