package LEMS.businesslogic.orderbl.load;

import java.util.ArrayList;

import LEMS.businesslogic.orderbl.AddOrder;
import LEMS.businesslogicservice.orderblservice.LoadService;
import LEMS.po.financepo.DocumentState;
import LEMS.po.orderpo.OrderPO;
import LEMS.po.orderpo.load.LoadNotePO;
import LEMS.po.userpo.UserPO;
import LEMS.vo.ordervo.LoadVO;

/**
 * @author 宋益明
 * 
 * 装运管理任务
 * TODO 自从我把transfer和load分离出来后，就发现这个类和车辆装车管理真的好像……
 * 	装车单（记录装车日期、本中转中心汽运编号（中转中心编号+日期+0000000七位数字）、到达地（营业厅）、
 * 	车辆代号、监装员、押运员、本次装箱所有订单条形码号）、运费（运费根据出发地和目的地自动生成）。
 * 	
 * 以下为车辆装车管理内容（营业厅）
 * 	装车单（记录装车日期、本营业厅编号（025城市编码+1营业厅+0000鼓楼营业厅）、
 * 	汽运编号 （营业厅编号+20150921日期+00000编码 、五位数字）、到达地（本地中转中心或者其它营业厅）、
 * 	车辆代号、监装员、押运员、本次装箱所有订单条形码号）、运费（运费根据出发地和目的地自动生成）
 */
public class Load extends AddOrder implements LoadService {
	/**
	 * 订单列表
	 */
	protected ArrayList<OrderPO> orders;
	
	private LoadVO loadVO;
	
	public Load(LoadVO loadVO) {
		this.loadVO = loadVO;
		//新建订单列表
		orders = new ArrayList<OrderPO>();
	}
	
	public void addOrder(String id) {
		orders.add(findOrder(id));
	}

	public void createLoadNote() {
		LoadNotePO loadNote = new LoadNotePO();
		loadNote.setDate(loadVO.getDate());
		loadNote.setState(DocumentState.waiting);
	}
	
	public void setDate() {
		
	}
	
	public void setNumber(String number) {
		
	}
	
	public void setDeparture(String departure) {
		
	}
	
	public void setDestination(String destination) {
		
	}
	
	public void setSuperVision(UserPO superVision) {
		
	}
	
	public ArrayList<OrderPO> getOrders() {
		return orders;
	}
}
