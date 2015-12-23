package LEMS.businesslogicservice.orderblservice;

import java.rmi.RemoteException;

import LEMS.po.storepo.TransportType;

/**
 * @author 宋益明
 * 
 * 中转任务接口
 */
public interface TransferService extends AddOrderService {
	/**
	 * 根据运输方式不同，生成中转单
	 * 
	 * @param type 运输方式
	 */
	public void createTransferNote(TransportType type) throws RemoteException;
}
