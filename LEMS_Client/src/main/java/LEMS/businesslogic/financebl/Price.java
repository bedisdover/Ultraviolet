package LEMS.businesslogic.financebl;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import LEMS.businesslogicservice.financeblservice.PriceService;
import LEMS.dataservice.factory.DatabaseFactory;
import LEMS.dataservice.factory.FinanceFactory;
import LEMS.dataservice.financedataservice.PriceDataService;
import LEMS.po.financepo.PricePO;
import LEMS.po.orderpo.Express;
import LEMS.po.orderpo.Packing;

/**
 * @author 宋益明
 * 
 * 制定价格任务
 */
public class Price implements PriceService {

	public Price() {
		//初始化PricePO
		init();
	}

	
	public double getPrice(Express type) {
		return PricePO.getPrice(type);
	}

	public double getPrice(Packing type) {
		return PricePO.getPrice(type);
	}

	public void pricing(Express type, double price) {
		//更新快递价格
		PricePO.pricing(type, price);
	}
	
	public void pricing(Packing type, double price) {
		//更新包装价格
		PricePO.pricing(type, price);
	}
	
	/**
	 * 初始化价格持久化对象
	 */
	private void init() {
		try {
			
			//TODO 可能存在严重问题，违反信息隐藏
			PricePO.pricePO = getService().getPrice();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 存储修改后的价格
	 */
	public void record() {
		try {
			getService().pricing(PricePO.pricePO);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 获得价格数据服务
	 * 
	 * @return PriceDataService
	 */
	private PriceDataService getService() {
		
		PriceDataService priceDataService = null;
		
		try {
			//获得数据库的引用
			DatabaseFactory databaseFactory = (DatabaseFactory) Naming.lookup("rmi://localhost:1099/data");
			FinanceFactory financeFactory = databaseFactory.getFinanceFactory();
			priceDataService = financeFactory.getPriceDataService();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
		
		return priceDataService;
	}
	public static void main(String[] args){
		Price p=new Price();
		p.init();
	}
}
