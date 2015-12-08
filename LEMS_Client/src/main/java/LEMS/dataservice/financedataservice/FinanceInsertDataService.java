package LEMS.dataservice.financedataservice;

import java.rmi.Remote;

import LEMS.po.financepo.PayBillPO;

/**
 * @author 苏琰梓
 * 新建付款单信息数据层接口
 * 2015年12月8日
 */
public interface FinanceInsertDataService extends Remote{
	public void Insert(PayBillPO payPO);
}
