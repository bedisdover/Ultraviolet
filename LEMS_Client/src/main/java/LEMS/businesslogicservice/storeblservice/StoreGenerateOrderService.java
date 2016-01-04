package LEMS.businesslogicservice.storeblservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

import LEMS.vo.storevo.InboundOrderVO;
import LEMS.vo.storevo.OutboundOrderVO;

public interface StoreGenerateOrderService extends Remote{

	public int generateInboundOrderPO(InboundOrderVO inboundOrderVO)throws RemoteException;
	
	public int generateOutboundOrderPO(OutboundOrderVO outboundOrderVO)throws RemoteException;
	
	public InboundOrderVO inquireInboundOrderPO(String id)throws RemoteException;//查询
	
	public OutboundOrderVO inquireOutboundOrderPO(String id)throws RemoteException;//查询
	
	public int deleteInboundOrderPO(String id)throws RemoteException;//删除入库单
	
	public int deleteOutboundOrderPO(String id)throws RemoteException;//删除出库单
	
	public int updateInboundOrderPO(InboundOrderVO inboundOrderVO)throws RemoteException;//修改入库单
	
	public int updateOutboundOrderPO(OutboundOrderVO outboundOrderVO)throws RemoteException;//修改出库单
}
