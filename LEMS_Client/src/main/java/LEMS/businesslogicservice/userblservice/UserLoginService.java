package LEMS.businesslogicservice.userblservice;

import LEMS.po.userpo.UserRole;
import LEMS.vo.uservo.UserVO;

public interface UserLoginService {
	public UserVO login(long id,String password,String name,UserRole role);
}
