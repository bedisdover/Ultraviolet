package LEMS.dataservice.orderdataservice;

import java.rmi.Remote;
import java.util.ArrayList;

/**
 * @author 宋益明
 * 
 * 实现查找不同机构的单据ID任务
 * 根据机构编号查找到最新ID，并直接生成新ID
 * 可以查询所有单据（订单、收款单、装车单等）
 */
public interface IdDataService extends Remote {
	/**
	 * 查询指定表中指定机构的所有单据ID
	 * 
	 * @param table 表名称（存储各种单据）
	 * @param institution 机构编号（三位）
	 * @return 该机构所有的订单ID
	 */
	public ArrayList<String> findAll(String table, String institution);
	
	/**
	 * 根据机构编号查找到最新ID，并直接生成新ID
	 */
	public String createID(String table, int length, String institution);
}
