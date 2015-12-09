package LEMS.businesslogic.informationbl;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import LEMS.businesslogic.utility.RMIConnect;
import LEMS.businesslogicservice.informationblservice.InformationDeleteService;
import LEMS.dataservice.factory.DatabaseFactory;
import LEMS.dataservice.factory.InformationFactory;
import LEMS.dataservice.informationdataservice.InformationDeleteDataService;

public class InformationDelete implements InformationDeleteService{
	/**
	 * 删除司机信息
	 */
	public void deleteDriver(String id){
		try {
			DatabaseFactory database=(DatabaseFactory)Naming.lookup(RMIConnect.RMI);
			InformationFactory infof=database.getInformationFactory();
			InformationDeleteDataService infod=infof.getInformationDeleteData();
			infod.deleteDriver(id);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 删除车辆信息
	 */
	public void deleteVehicle(String id){
		try {
			DatabaseFactory database=(DatabaseFactory)Naming.lookup(RMIConnect.RMI);
			InformationFactory infof=database.getInformationFactory();
			InformationDeleteDataService infod=infof.getInformationDeleteData();
			infod.deleteVehicle(id);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 删除机构信息
	 */
	public void deleteInstitution(String id){
		try {
			DatabaseFactory database=(DatabaseFactory)Naming.lookup(RMIConnect.RMI);
			InformationFactory infof=database.getInformationFactory();
			InformationDeleteDataService infod=infof.getInformationDeleteData();
			infod.deleteInstitution(id);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 删除人员信息
	 */
	public void deleteStaff(String id){
		try {
			DatabaseFactory database=(DatabaseFactory)Naming.lookup(RMIConnect.RMI);
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
	public void deleteAccount(String id){
		try {
			DatabaseFactory database=(DatabaseFactory)Naming.lookup(RMIConnect.RMI);
			InformationFactory infof=database.getInformationFactory();
			InformationDeleteDataService infod=infof.getInformationDeleteData();
			infod.deleteAccount(id);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
	}
	public void deleteSalary(String id){
		try {
			DatabaseFactory database=(DatabaseFactory)Naming.lookup(RMIConnect.RMI);
			InformationFactory infof=database.getInformationFactory();
			InformationDeleteDataService infod=infof.getInformationDeleteData();
			infod.deleteSalary(id);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
	}
}
