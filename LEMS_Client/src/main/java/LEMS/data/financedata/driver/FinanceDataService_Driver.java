package LEMS.data.financedata.driver;

import java.rmi.RemoteException;

import LEMS.data.financedata.stub.FinanceDataService_Stub;
import LEMS.po.financepo.FinancePO;

/**
 * @author 宋益明
 * 
 * Finance包DataService驱动程序
 */
public class FinanceDataService_Driver {
	
	public void drive(FinanceDataService_Stub financeDataService_Stub) {
		try {
			financeDataService_Stub.init();
			FinancePO po = financeDataService_Stub.find(123456);
			financeDataService_Stub.insert(po);
			financeDataService_Stub.delete(po);
			financeDataService_Stub.update(po);
			financeDataService_Stub.finish();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
}
