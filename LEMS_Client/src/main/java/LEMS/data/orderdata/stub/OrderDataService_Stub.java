package LEMS.data.orderdata.stub;

import java.rmi.RemoteException;

import LEMS.dataservice.orderdataservice.OrderDataService;
import LEMS.po.orderpo.OrderPO;

/**
 * @author 宋益明
 * 
 * Order包DataService桩程序
 */
public class OrderDataService_Stub implements OrderDataService {

	public OrderPO find(long id) throws RemoteException {
		System.out.println("查找成功！\n");
		return new OrderPO();
	}

	public void insert(OrderPO po) throws RemoteException {
		System.out.println("插入成功！\n");
	}

	public void delete(OrderPO po) throws RemoteException {
		System.out.println("删除成功！\n");
	}

	public void update(OrderPO po) throws RemoteException {
		System.out.println("更新成功！\n");
	}

	public void init() throws RemoteException {
		System.out.println("初始化数据库成功！\n");
	}

	public void finish() throws RemoteException {
		System.out.println("完成操作，关闭数据库\n");
	}
}
