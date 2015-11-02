package LEMS.businesslogic.userbl.stub;

import LEMS.businesslogicservice.userblservice.UserLoginService;
import LEMS.po.userpo.UserRole;
import LEMS.vo.uservo.UserVO;


public class UserLoginService_Stub implements UserLoginService{

	public UserVO login(long id, String name, String password, UserRole role) {
		System.out.println("登录成功");
		UserVO vo = new UserVO("123456","用户1","susu",null);
		return vo; 
	}

	
}
