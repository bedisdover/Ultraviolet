package LEMS.businesslogic.orderbl;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import LEMS.businesslogicservice.orderblservice.OrderService;
import LEMS.dataservice.factory.DatabaseFactory;
import LEMS.dataservice.factory.OrderFactory;
import LEMS.dataservice.orderdataservice.OrderDataService;
import LEMS.po.financepo.PricePO;
import LEMS.po.orderpo.DistancePO;
import LEMS.po.orderpo.Express;
import LEMS.po.orderpo.Packing;
import LEMS.vo.ordervo.CustomerVO;
import LEMS.vo.ordervo.GoodsVO;
import LEMS.vo.ordervo.OrderVO;

/**
 * @author 宋益明
 * 
 * 新建订单任务
 */
public class Order implements OrderService {

	/**
	 * 订单值对象
	 */
	private OrderVO order;
	/**
	 * 寄件人
	 */
	private CustomerVO sender;
	/**
	 * 收件人
	 */
	private CustomerVO receiver;
	/**
	 * 快递类型
	 */
	private Express expressType;
	/**
	 * 包装类型
	 */
	private Packing packageType;
	/**
	 * 货物信息
	 */
	private GoodsVO goods;
	/**
	 * 邮寄距离
	 */
	private double distance;
	
	public Order() {
		//新建订单
		order = new OrderVO();
	}
	
	public void addSender(CustomerVO sender) {
		this.sender = sender;
		
		order.setSender(sender);
	}

	public void addReceiver(CustomerVO receiver) {
		this.receiver = receiver;
		
		order.setReceiver(receiver);
	}

	public void addGoodsInfo(GoodsVO goods) {
		this.goods = goods;
		
		order.setGoodsInfo(goods);
	}

	public void chooseExpress(Express type) {
		this.expressType = type;
		
		order.setExpressType(type);
	}

	public void choosePack(Packing type) {
		this.packageType = type;
		
		order.setPackingType(type);
	}
	
	public String createID() {
		// TODO Auto-generated method stub
		return null;
	}

	public double getMoney() {
		//获得距离
		distance = DistancePO.getDistance(sender.getAddress().substring(0, 2), receiver.getAddress().substring(0, 2));
		//获得单价
		double price = PricePO.getPrice(expressType);
		
		return distance / 1000 * price * goods.getWeight();
	}

	public double getTotal() {
		
		order.setAmount(PricePO.getPrice(packageType) + getMoney()) ;
		
		return order.getAmount();
	}

	public String getTime() {
		return Time.getTime(distance, expressType);
	}

	public void endOrder() {
		try {
			//获得数据库的引用
			DatabaseFactory databaseFactory = (DatabaseFactory) Naming.lookup("rmi://localhost:1099/data");
			OrderFactory orderFactory = databaseFactory.getOrderFactory();
			OrderDataService orderDataService = orderFactory.getOrderData();

			//写入数据
			orderDataService.insert(order.transferToPO());
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
	}
}
