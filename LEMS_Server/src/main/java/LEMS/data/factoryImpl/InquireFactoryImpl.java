package LEMS.data.factoryImpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import LEMS.data.inquiredata.BusinessListData;
import LEMS.data.inquiredata.DiaryData;
import LEMS.dataservice.factory.InquireFactory;
import LEMS.dataservice.inquiredataservice.BusinessListDataService;
import LEMS.dataservice.inquiredataservice.CostBenefitListDataService;
import LEMS.dataservice.inquiredataservice.DiaryDataService;
import LEMS.dataservice.inquiredataservice.LogisticsInfoDataService;

@SuppressWarnings("serial")
public class InquireFactoryImpl extends UnicastRemoteObject implements
		InquireFactory {

	public InquireFactoryImpl() throws RemoteException {
		super();
	}

	public BusinessListDataService getBusinessListData() throws RemoteException {
		BusinessListDataService bld = new BusinessListData();
		return bld;
	}

	public CostBenefitListDataService getCostBenefitList() throws RemoteException {
		return null;
	}

	public DiaryDataService getDiaryData() throws RemoteException {
		DiaryData diary=new DiaryData();
		return diary;
	}

	public LogisticsInfoDataService getLogisticsInfo() throws RemoteException {
		return null;
	}

}
