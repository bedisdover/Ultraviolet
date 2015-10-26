package LEMS.data.financedata.stub;

import java.rmi.RemoteException;

import LEMS.dataservice.financedataservice.FinanceDataService;
import LEMS.po.financepo.FinancePO;

/**
 * @author 宋益明
 * 
 * Finance包DataService桩程序
 */
public class FinanceDataService_Stub implements FinanceDataService {

	public FinancePO find(long id) throws RemoteException {
		System.out.println("查找成功！\n");
		return new FinancePO();
	}

	public void insert(FinancePO po) throws RemoteException {
		System.out.println("插入成功！\n");
	}

	public void delete(FinancePO po) throws RemoteException {
		System.out.println("删除成功！\n");
	}

	public void update(FinancePO po) throws RemoteException {
		System.out.println("更新成功！\n");
	}

	public void init() throws RemoteException {
		System.out.println("初始化数据库成功！\n");
	}

	public void finish() throws RemoteException {
		System.out.println("操作完成，关闭数据库\n");
	}

}
