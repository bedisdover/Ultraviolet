package LEMS.dataservice.userdataservice;

import java.rmi.RemoteException;

import LEMS.po.userpo.UserPO;

public interface UserDataService {
	public void insert(UserPO po) throws RemoteException;
	public void delete(long id) throws RemoteException;
	public void update(long id) throws RemoteException;
	public UserPO find(long id) throws RemoteException;
}
