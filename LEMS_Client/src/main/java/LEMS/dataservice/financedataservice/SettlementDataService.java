package LEMS.dataservice.financedataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import LEMS.po.orderpo.IncomePO;

public interface SettlementDataService extends Remote {
	/**
	 * 按天、按营业厅查看收款单记录
	 * 
	 * @param date 日期
	 * @param institution 营业厅编号
	 * @return 收款单记录
	 * @throws RemoteException
	 */
	public ArrayList<IncomePO> getIncomePO(String date, String institution) throws RemoteException;
}
