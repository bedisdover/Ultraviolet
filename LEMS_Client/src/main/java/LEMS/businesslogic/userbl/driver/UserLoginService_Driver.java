package LEMS.businesslogic.userbl.driver;

import LEMS.businesslogicservice.userblservice.UserLoginService;
import LEMS.vo.uservo.UserVO;

public class UserLoginService_Driver {
	public void drive(UserLoginService userLoginService){
		UserVO vo = userLoginService.login(123456,"用户1","susu",null); 
	}
}
