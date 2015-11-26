package LEMS.businesslogic.informationbl;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import LEMS.dataservice.factory.DatabaseFactory;
import LEMS.dataservice.factory.InformationFactory;
import LEMS.dataservice.informationdataservice.InformationDeleteDataService;

public class InformationDelete {
	/**
	 * 删除司机信息
	 */
	public void deleteDriverVO(long id){
		
	}
	/**
	 * 删除车辆信息
	 */
	public void deleteVehicleVO(long id){
		
	}
	/**
	 * 删除机构信息
	 */
	public void deleteInstitutionVO(String id){
		
	}
	/**
	 * 删除人员信息
	 */
	public void deleteStaff(String id){
		try {
			DatabaseFactory database=(DatabaseFactory)Naming.lookup("rmi://localhost:1099/data");
			InformationFactory infof=database.getInformationFactory();
			InformationDeleteDataService infod=infof.getInformationDeleteData();
			infod.deleteStaff(id);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 删除账户信息
	 */
	public void deleteAccoutVO(String name){
		
	}
}
