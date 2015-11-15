package LEMS.businesslogic.userbl;

import LEMS.po.userpo.UserRole;
import LEMS.vo.uservo.UserVO;

public class UserLogin {
	public UserVO login(String id,String password,UserRole role){
		MockUser mu=new MockUser("141250198","123456","zcy",UserRole.Manager);
		UserVO uvo=new UserVO(mu.id,mu.name,mu.password,mu.role);
		return uvo;
	}
}
