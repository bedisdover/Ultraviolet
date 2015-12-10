package LEMS.data.informationdata;

import java.rmi.RemoteException;




import java.rmi.server.UnicastRemoteObject;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import LEMS.data.Connect;
import LEMS.dataservice.informationdataservice.InformationFindDataService;
import LEMS.po.financepo.SalaryPO;
import LEMS.po.informationpo.AccountPO;
import LEMS.po.informationpo.DriverPO;
import LEMS.po.informationpo.Gender;
import LEMS.po.informationpo.InstitutionPO;
import LEMS.po.informationpo.StaffPO;
import LEMS.po.informationpo.VehiclePO;
import LEMS.po.userpo.UserPO;
import LEMS.po.userpo.UserRole;

/**
 * @author 苏琰梓
 * InformationFind包数据
 * 2015年10月26日
 */
@SuppressWarnings("serial")
public class InformationFindData extends UnicastRemoteObject implements InformationFindDataService{
	public InformationFindData() throws RemoteException {
		super();
	}
	
	//查找某一机构所有司机信息
	public ArrayList<DriverPO> findDriver(String businessid) throws RemoteException{
		ArrayList<DriverPO> drivers=new ArrayList<DriverPO>();
		DriverPO d=null;
		Connect co=new Connect();
		String sql="SELECT * FROM driver";
		ResultSet result=co.getResultSet(sql);
		try {
			while(result.next()){
				if(result.getString(1).substring(3,6).equals(businessid)){
					d=new DriverPO(result.getString(1),result.getString(2),result.getString(3),result.getString(4),result.getString(5),result.getString(6),Gender.transfer(result.getString(7)));
					drivers.add(d);
				}				
			}
			co.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return drivers;
	}
	
	//查找指定编号的司机信息
	public DriverPO findTheDriver(String id) throws RemoteException{
		DriverPO driver=null;
		Connect co=new Connect();
		String sql="SELECT * FROM driver";
		ResultSet result=co.getResultSet(sql);
		try {
			while(result.next()){
				if(result.getString(1).equals(id)){
					driver=new DriverPO(result.getString(1),result.getString(2),result.getString(3),result.getString(4),result.getString(5),result.getString(6),Gender.transfer(result.getString(7)));
					break;
				}				
			}
			co.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return driver;
	}
	
	//查找某一机构所有车辆信息
	public ArrayList<VehiclePO> findVehicle(String businessid) throws RemoteException{
		ArrayList<VehiclePO> vehicles=new ArrayList<VehiclePO>();
		VehiclePO v=null;
		Connect co=new Connect();
		String sql="SELECT * FROM vehicle";
		ResultSet result=co.getResultSet(sql);
		try {
			while(result.next()){
				if(result.getString(1).substring(3,6).equals(businessid)){
					v=new VehiclePO(result.getString(1),result.getString(2),result.getString(3),result.getString(4));
					vehicles.add(v);
				}				
			}
			co.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return vehicles;
	}
	
	//查找指定编号的车辆信息
	public VehiclePO findTheVehicle(String id) throws RemoteException{
		VehiclePO vehicle=null;
		Connect co=new Connect();
		String sql="SELECT * FROM vehicle";
		ResultSet result=co.getResultSet(sql);
		try {
			while(result.next()){
				if(result.getString(1).equals(id)){
					vehicle=new VehiclePO(result.getString(1),result.getString(2),result.getString(3),result.getString(4));
					break;
				}				
			}
			co.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return vehicle;
	}
	//查找所有机构信息
	public ArrayList<InstitutionPO> findInstitution() throws RemoteException{
		ArrayList<InstitutionPO> institutions=new ArrayList<InstitutionPO>();
		InstitutionPO i=null;
		Connect co=new Connect();
		String sql="SELECT * FROM institution";
		ResultSet result=co.getResultSet(sql);
		try {
			while(result.next()){
				i=new InstitutionPO(result.getString(1),result.getString(2));
				institutions.add(i);
			}
			co.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return institutions;
	}
	//根据指定编号查找机构信息
	public InstitutionPO findTheInstitution(String id) throws RemoteException{
		InstitutionPO ipo=null;
		Connect co=new Connect();
		String sql="SELECT * FROM institution";
		ResultSet result=co.getResultSet(sql);
		try {
			while(result.next()){
				if(result.getString(1).equals(id)){
					ipo=new InstitutionPO(result.getString(1),result.getString(2));
					break;
				}				
			}
			co.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ipo;
	}
	//查找对应id的人员信息
	public UserPO findStaff(String id) throws RemoteException{
		UserRole role=null;
		UserPO spo=null;
		Connect co=new Connect();
		String sql="SELECT * FROM user";
		ResultSet result=co.getResultSet(sql);
		try {
			while(result.next()){
				if(result.getString(1).equals(id)){
					switch(result.getString(3)){
					case "Manager":
						role=UserRole.Manager;
						break;
					case "GeneralManager":
						role=UserRole.GeneralManager;
						break;
					case "StoreManager":
						role=UserRole.StoreManager;
						break;
					case "BusinessClerk":
						role=UserRole.BusinessClerk;
						break;
					case "TransferClerk":
						role=UserRole.TransferClerk;
						break;
					case "Courier":
						role=UserRole.Courier;
						break;
					case "FinanceClerk":
						role=UserRole.FinanceClerk;
						break;
					default:
						break;
					}
					InstitutionPO ipo=new InstitutionPO(result.getString(5),result.getString(6));
					spo=new UserPO(result.getString(1),result.getString(2),role,result.getString(4),ipo);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		co.closeConnection();
		return spo;
	}

	//查找所有账户信息
	public ArrayList<AccountPO> findAccount() throws RemoteException {
		ArrayList<AccountPO> accounts=new ArrayList<AccountPO>();
		AccountPO a=null;
		Connect co=new Connect();
		String sql="SELECT * FROM account";
		ResultSet result=co.getResultSet(sql);
		try {
			while(result.next()){
				a=new AccountPO(result.getString(1),result.getString(2),result.getDouble(3));
				accounts.add(a);
			}
			co.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return accounts;
	}

	//根据卡号查找账户信息
	public AccountPO findTheAccount(String id) throws RemoteException {
		AccountPO apo=null;
		Connect co=new Connect();
		String sql="SELECT * FROM account";
		ResultSet result=co.getResultSet(sql);
		try {
			while(result.next()){
				if(result.getString(1).equals(id)){
					apo=new AccountPO(result.getString(1),result.getString(2),result.getDouble(3));
					break;
				}				
			}
			co.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return apo;
	}

	//查找所有人员薪水信息
	public ArrayList<SalaryPO> findSalary() throws RemoteException {
		ArrayList<SalaryPO> salas=new ArrayList<SalaryPO>();
		SalaryPO s=null;
		Connect co=new Connect();
		String sql="SELECT * FROM salary";
		ResultSet result=co.getResultSet(sql);
		try {
			while(result.next()){
				s=new SalaryPO(result.getString(1),result.getString(2),result.getString(3),result.getDouble(4));
				salas.add(s);
			}
			co.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return salas;
	}

	//根据id查找某个人员薪水信息
	public SalaryPO findTheSalary(String id) throws RemoteException {
		SalaryPO spo=null;
		Connect co=new Connect();
		String sql="SELECT * FROM salary";
		ResultSet result=co.getResultSet(sql);
		try {
			while(result.next()){
				if(result.getString(1).equals(id)){
					spo=new SalaryPO(result.getString(1),result.getString(2),result.getString(3),result.getDouble(4));
					break;
				}				
			}
			co.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return spo;
	}
}
