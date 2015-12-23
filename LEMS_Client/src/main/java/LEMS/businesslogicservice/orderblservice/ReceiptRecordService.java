package LEMS.businesslogicservice.orderblservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * @author 宋益明
 * 
 * 记录收款单任务接口
 */
public interface ReceiptRecordService extends AddOrderService {
	/**
	 * 生成收款单
	 * 
	 * @param income 收款信息
	 */
	public void createIncomeBill();
	
	/**
	 * 根据揽件员及日期获得所有订单
	 * 
	 * @param collector 揽件员ID
	 * @param date 日期
	 * @return 所有订单编号（String）
	 * @throws RemoteException 连接异常，发现异常后，在界面提示错误信息
	 */
	public ArrayList<String> getOrders(String collector, String date) throws RemoteException;
}
