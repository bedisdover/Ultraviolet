package LEMS.dataservice.orderdataservice;

import java.rmi.Remote;

/**
 * @author 宋益明
 * 
 * 实现查找不同机构的单据ID任务
 * 根据机构编号查找到最新ID，并直接生成新ID
 * 可以查询所有单据（订单、收款单、装车单等）
 */
public interface IdDataService extends Remote {

	/**
	 * 根据机构编号查找到最新ID，并直接生成新ID
	 */
	public String createID(String table, int length, String pre);
}
