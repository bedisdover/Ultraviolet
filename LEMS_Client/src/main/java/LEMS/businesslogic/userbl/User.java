package LEMS.businesslogic.userbl;

import java.rmi.Naming;
import java.util.ArrayList;

import LEMS.dataservice.factory.DatabaseFactory;
import LEMS.dataservice.factory.UserFactory;
import LEMS.dataservice.informationdataservice.InformationInsertDataService;
import LEMS.dataservice.userdataservice.UserDataService;
import LEMS.po.informationpo.StaffPO;
import LEMS.po.userpo.UserPO;
import LEMS.po.userpo.UserRole;
import LEMS.vo.uservo.UserVO;

public class User {
	String id;
	String password;
	UserRole role;
	ArrayList<UserPO> ap;
	UserVO uv=null;
	public User(String id,String password,UserRole r){
		this.id=id;
		this.password=password;
		this.role=r;
	}
	public UserVO getUser(){
		try {
			DatabaseFactory database=(DatabaseFactory)Naming.lookup("rmi://localhost:1099/data");
			UserFactory uf=database.getUserFactory();
			UserDataService u=uf.getUserData();
			ap=u.find(role);
			for(UserPO user:ap){
				if(user.getId().equals(id)&&user.getPassword().equals(password)){
					uv=new UserVO(user.getId(),user.getPassword(),user.getRole(),user.getName(),user.getInstitution());
					return uv;
				}
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
