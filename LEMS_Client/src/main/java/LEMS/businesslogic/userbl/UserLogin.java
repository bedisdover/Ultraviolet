package LEMS.businesslogic.userbl;

import LEMS.po.userpo.UserRole;
import LEMS.vo.uservo.UserVO;

public class UserLogin {
	public UserVO login(String id,String password,UserRole role){
		User user=new User(id,password,role);
		UserVO uvo=user.getUser();
		return uvo;
	}
}
