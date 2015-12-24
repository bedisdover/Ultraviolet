package LEMS.businesslogic.userbl;

import LEMS.vo.uservo.UserVO;

public class UserLogin {
	public UserVO login(String id, String password) throws Exception {
		User user = new User(id, password);
		UserVO uvo = null;
		try {
			uvo = user.getUser();
		} catch (Exception e) {
			// TODO 提示异常
			throw e;
		}
		return uvo;
	}
}
