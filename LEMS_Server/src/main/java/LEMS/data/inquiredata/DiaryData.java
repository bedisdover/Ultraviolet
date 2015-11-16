package LEMS.data.inquiredata;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import LEMS.dataservice.inquiredataservice.DiaryDataService;
import LEMS.po.inquirepo.DiaryPO;
/**
 * @author 章承尧
 * DiaryDataService接口的实现
 */
@SuppressWarnings("serial")
public class DiaryData extends UnicastRemoteObject implements DiaryDataService {

	public DiaryData() throws RemoteException {
		super();
	}

	public DiaryPO findDiary(String date) throws RemoteException{
		DiaryPO dpo=new DiaryPO(date, "add a payBill");
		return dpo;
	}
	
	
}
