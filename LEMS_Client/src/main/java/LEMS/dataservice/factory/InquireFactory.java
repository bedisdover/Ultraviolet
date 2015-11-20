package LEMS.dataservice.factory;

import java.rmi.Remote;
import java.rmi.RemoteException;

import LEMS.dataservice.inquiredataservice.BusinessListDataService;
import LEMS.dataservice.inquiredataservice.CostBenefitListDataService;
import LEMS.dataservice.inquiredataservice.DiaryDataService;
import LEMS.dataservice.inquiredataservice.LogisticsInfoDataService;

public interface InquireFactory extends Remote{
	public BusinessListDataService getBusinessListData() throws RemoteException;
	public CostBenefitListDataService getCostBenefitList() throws RemoteException;
	public DiaryDataService getDiaryData() throws RemoteException;
	public LogisticsInfoDataService getLogisticsInfo() throws RemoteException;
}
