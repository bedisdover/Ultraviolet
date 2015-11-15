package LEMS.businesslogic.userbl;

import LEMS.po.userpo.UserRole;

public class MockUser {
	String id;
	String password;
	String name;
	UserRole role;
	
	public MockUser(String i,String p,String n,UserRole r){
		id=i;
		password=p;
		name=n;
		role=r;
	}
}
