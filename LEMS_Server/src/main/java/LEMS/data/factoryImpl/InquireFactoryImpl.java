package LEMS.data.factoryImpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import LEMS.data.inquiredata.BusinessListData;
import LEMS.dataservice.factory.InquireFactory;
import LEMS.dataservice.inquiredataservice.BusinessListDataService;
import LEMS.dataservice.inquiredataservice.CostBenefitListDataService;
import LEMS.dataservice.inquiredataservice.DiaryDataService;
import LEMS.dataservice.inquiredataservice.LogisticsInfoDataService;

@SuppressWarnings("serial")
public class InquireFactoryImpl extends UnicastRemoteObject implements InquireFactory {

	public InquireFactoryImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	public BusinessListDataService getBusinessListData() throws RemoteException {
		// TODO Auto-generated method stub
		BusinessListDataService bld=new BusinessListData();
		return bld;
	}

	public CostBenefitListDataService getCostBenefitList()
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public DiaryDataService getDiaryData() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public LogisticsInfoDataService getLogisticsInfo() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
