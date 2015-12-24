package LEMS.dataservice.financedataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import LEMS.po.financepo.IncomeBillPO;

/**
 * @author 宋益明
 * 
 * 收款单数据服务接口
 * 提供服务：
 * 		获取所有收款信息
 * 		根据日期、营业厅获取收款信息
 * 		存储收款单
 */
public interface IncomeBillDataService extends Remote{
	
	/**
	 * 获取所有收款信息
	 * 
	 * @return 所有收款信息
	 */
	public ArrayList<IncomeBillPO> getIncomeBill() throws RemoteException;
	
	//TODO 似乎没用的方法
	/**
	 * 根据日期获取收款信息
	 * 
	 * @param date 日期
	 * @return 收款信息
	 */
	public ArrayList<IncomeBillPO> getIncomeByDate(String date) throws RemoteException;
	//TODO 似乎没用的方法	
	/**
	 * 根据营业厅获取收款信息
	 * 
	 * @param institution 营业厅编号
	 * @return 收款信息
	 */
	public ArrayList<IncomeBillPO> getIncomeByIns(String institution) throws RemoteException;
	
	/**
	 * 按天、按营业厅查看收款单记录
	 * 
	 * @param date 日期
	 * @param institution 营业厅编号
	 * @return 收款单记录
	 */
	public ArrayList<IncomeBillPO> getIncomeByDateAndIns(String date, String institution) throws RemoteException;
	
	/**
	 * 存储一条收款信息
	 * 
	 * @param incomeBillPO 收款信息
	 */
	public void addIncomeBill(IncomeBillPO incomeBillPO) throws RemoteException;
}
