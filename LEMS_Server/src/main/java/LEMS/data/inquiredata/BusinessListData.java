package LEMS.data.inquiredata;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import LEMS.dataservice.inquiredataservice.BusinessListDataService;
import LEMS.po.inquirepo.BusinessListPO;

/**
 * @author 章承尧
 * BusinessListDataService的实现
 */
@SuppressWarnings("serial")
public class BusinessListData extends UnicastRemoteObject implements BusinessListDataService {

	public BusinessListData() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	public BusinessListPO findBusinessList(String startTime, String endTime) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
