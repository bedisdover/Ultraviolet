package LEMS.dataservice.userdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import LEMS.po.userpo.UserPO;
import LEMS.po.userpo.UserRole;

public interface UserDataService extends Remote{
	public void insert(UserPO po) throws RemoteException;
	public void delete(UserPO po) throws RemoteException;
	public void update(UserPO po) throws RemoteException;
	public  ArrayList<UserPO> find(UserRole r) throws RemoteException;
	public ArrayList<UserPO> findAll() throws RemoteException;
}
