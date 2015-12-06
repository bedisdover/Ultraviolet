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
}
