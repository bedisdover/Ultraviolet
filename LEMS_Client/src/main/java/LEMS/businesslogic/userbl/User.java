package LEMS.businesslogic.userbl;

import java.rmi.Naming;
import java.util.ArrayList;

import LEMS.businesslogic.utility.RMIConnect;
import LEMS.dataservice.factory.DatabaseFactory;
import LEMS.dataservice.factory.UserFactory;
import LEMS.dataservice.userdataservice.UserDataService;
import LEMS.po.userpo.UserPO;
import LEMS.po.userpo.UserRole;
import LEMS.vo.uservo.UserVO;

public class User {
	String id;
	String password;
	UserRole role;
	ArrayList<UserPO> ap;
	UserVO uv = null;

	public User(String id, String password) {
		this.id = id;
		this.password = password;
	}

	public UserVO getUser() throws Exception {
		try {
			DatabaseFactory database = (DatabaseFactory) Naming.lookup(RMIConnect.RMI);
			UserFactory uf = database.getUserFactory();
			UserDataService u = uf.getUserData();
			ap = u.findAll();
			for (UserPO user : ap) {
				if (user.getId().equals(id) && user.getPassword().equals(password)) {
					uv = new UserVO(user.getId(), user.getPassword(), user.getRole(), user.getName(),
							user.getInstitution());
					return uv;
				}
			}

		} catch (Exception e) {
			// TODO 无需catch
			throw e;
		}
		return null;
	}
}
