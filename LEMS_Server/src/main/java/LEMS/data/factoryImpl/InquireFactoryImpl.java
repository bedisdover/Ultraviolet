package LEMS.data.factoryImpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import LEMS.data.inquiredata.BusinessListData;
import LEMS.data.inquiredata.CostBenefitListData;
import LEMS.data.inquiredata.DiaryData;
import LEMS.data.inquiredata.LogisticsInfoData;
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
		CostBenefitListDataService cbfd=new CostBenefitListData();
		return cbfd;
	}

	public DiaryDataService getDiaryData() throws RemoteException {
		DiaryData diary=new DiaryData();
		return diary;
	}

	public LogisticsInfoDataService getLogisticsInfo() throws RemoteException {
		LogisticsInfoDataService lid=new LogisticsInfoData();
		return lid;
	}

}
