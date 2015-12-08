package LEMS.dataservice.orderdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

import LEMS.po.orderpo.ArrivalNotePO;

/**
 * @author 宋益明
 *
 * 接收任务数据服务，实现对到达单的增删改查操作
 * 到达单存储内容及顺序：
 * 		ID、单据状态、日期、出发地
 * 		所有托运单据ID（字符串，以空格隔开）
 * 		机构编号、中转单编号
 */
public interface ReceiptDataService extends Remote {

	public ArrivalNotePO find(String id) throws RemoteException;
	
	public void insert(ArrivalNotePO arrivalNotePO) throws RemoteException;
	
	public void update(ArrivalNotePO arrivalNotePO) throws RemoteException;
	
	public void delete(String id) throws RemoteException;
	
	/**
	 * 在数据库中查找指定机构最新的记录，并直接生成ID
	 * @param date 日期
	 * @param institution 机构
	 * 
	 * @return 记录ID
	 */
	public String createID(String institution, String date) throws RemoteException;
}
