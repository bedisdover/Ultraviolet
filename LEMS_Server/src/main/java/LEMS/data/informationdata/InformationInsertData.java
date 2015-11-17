package LEMS.data.informationdata;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.rmi.RemoteException;

import LEMS.po.informationpo.AccountPO;
import LEMS.po.informationpo.DriverPO;
import LEMS.po.informationpo.InstitutionPO;
import LEMS.po.informationpo.Position;
import LEMS.po.informationpo.StaffPO;
import LEMS.po.informationpo.VehiclePO;

/**
 * @author 苏琰梓
 * InformationInsert包数据
 * 2015年10月26日
 */
public class InformationInsertData {
	public void insert(DriverPO po) throws RemoteException{
		
	}
	public void insert(VehiclePO po) throws RemoteException{
		
	}
	public void insert(InstitutionPO po) throws RemoteException{
		
	}
	public void insert(StaffPO po) throws RemoteException{
		try {
			FileOutputStream fileStream=new FileOutputStream("GeneralManager.ser",true);
			ObjectOutputStream os=new ObjectOutputStream(fileStream);
			os.writeObject(po);
			os.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void insert(AccountPO po) throws RemoteException{
		
	}
	public static void main(String[] args){
		InstitutionPO ip=new InstitutionPO("","");
		StaffPO sp=new StaffPO("gm00000","123456",Position.GeneralManager,ip);
		InformationInsertData i=new InformationInsertData();
		try {
			i.insert(sp);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
