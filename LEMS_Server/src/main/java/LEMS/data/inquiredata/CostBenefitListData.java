package LEMS.data.inquiredata;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import LEMS.dataservice.inquiredataservice.CostBenefitListDataService;
import LEMS.po.inquirepo.CostBenefitListPO;

public class CostBenefitListData extends UnicastRemoteObject implements CostBenefitListDataService {
	public CostBenefitListData() throws RemoteException{
		
	}
	public CostBenefitListPO findCostBenefitList(String startTime, String endTime) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
