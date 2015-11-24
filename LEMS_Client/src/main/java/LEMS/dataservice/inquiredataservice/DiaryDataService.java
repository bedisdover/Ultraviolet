package LEMS.dataservice.inquiredataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import LEMS.po.inquirepo.DiaryPO;

/**
 * @author 章承尧
 * 日志数据层接口
 */
public interface DiaryDataService extends Remote{
	public ArrayList<DiaryPO> findDiary(String date) throws RemoteException;
	public void recordDiary(DiaryPO dpo) throws RemoteException;
}
