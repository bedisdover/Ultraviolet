package LEMS.data.inquiredata;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import LEMS.dataservice.inquiredataservice.CostBenefitListDataService;
import LEMS.po.inquirepo.CostBenefitListPO;

/**
 * @author 章承尧
 * CostBenefitListDataService的实现
 */
@SuppressWarnings("serial")
public class CostBenefitListData extends UnicastRemoteObject implements CostBenefitListDataService {
	public CostBenefitListData() throws RemoteException{
		
	}
	public CostBenefitListPO findCostBenefitList(String startTime, String endTime) throws RemoteException {
		return null;
	}

}
