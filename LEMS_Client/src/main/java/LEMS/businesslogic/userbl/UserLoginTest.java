package LEMS.businesslogic.userbl;

import static org.junit.Assert.*;

import org.junit.Test;

import LEMS.po.userpo.UserRole;
import LEMS.vo.uservo.UserVO;

public class UserLoginTest {

	@Test
	public void testLogin() {
		UserLogin ul=new UserLogin();
		UserVO uvo=ul.login("141250198","123456",UserRole.Manager);
		assertEquals("zcy",uvo.getName());
	}

}
