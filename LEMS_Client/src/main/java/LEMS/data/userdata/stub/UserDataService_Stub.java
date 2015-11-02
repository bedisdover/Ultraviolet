package LEMS.data.userdata.stub;

import LEMS.po.userpo.UserPO;
import LEMS.po.userpo.UserRole;

public class UserDataService_Stub {
	public UserPO login(long id, String name, String password, UserRole role) {
		System.out.println("登录成功");
		UserPO po = new UserPO("123456","用户1","susu",null);
		return po; 
	}
}
