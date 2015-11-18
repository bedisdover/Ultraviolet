package LEMS.data.informationdata;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.rmi.RemoteException;

import LEMS.po.informationpo.AccountPO;
import LEMS.po.informationpo.DriverPO;
import LEMS.po.informationpo.InstitutionPO;
import LEMS.po.informationpo.StaffPO;
import LEMS.po.informationpo.VehiclePO;
import LEMS.po.userpo.UserPO;
import LEMS.po.userpo.UserRole;

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
	public void insert(UserPO po) throws RemoteException{
		switch(po.getRole()){
		case Manager:try {
			FileOutputStream fileStream=new FileOutputStream("Manager.ser",true);
			ObjectOutputStream os=new ObjectOutputStream(fileStream);
			long pos=0;
			 pos=fileStream.getChannel().position()-4;
             fileStream.getChannel().truncate(pos);
			os.writeObject(po);
			os.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		break;
		default:break;
		}
		
	}
	public void insert(AccountPO po) throws RemoteException{
		
	}
	public static void main(String[] args){
		InstitutionPO ip=new InstitutionPO("","");
		UserPO sp=new UserPO("m00001","123456",UserRole.Manager,"章承尧",ip);
		InformationInsertData i=new InformationInsertData();
		try {
			i.insert(sp);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
