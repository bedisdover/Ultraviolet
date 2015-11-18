package LEMS.dataservice.userdataservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import LEMS.po.userpo.UserPO;
import LEMS.po.userpo.UserRole;

public interface UserDataService {
	public void insert(UserPO po) throws RemoteException;
	public void delete(long id) throws RemoteException;
	public void update(long id) throws RemoteException;
	public  ArrayList<UserPO> find(UserRole r) throws RemoteException;
}
