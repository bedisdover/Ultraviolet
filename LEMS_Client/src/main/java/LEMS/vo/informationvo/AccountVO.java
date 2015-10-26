package LEMS.vo.informationvo;

/**
 * @author 苏琰梓
 * 账户信息值对象
 * 2015年10月26日
 */
public class AccountVO {
	/*
	 * 账户名称
	 */
	private String name;
	/*
	 * 账户余额
	 */
	private double balance;
	/*
	 * 账户密码
	 */
	private String password;
	
	public AccountVO(String name,double balance,String password){
		this.name =  name;
		this.balance = balance;
		this.password = password;
	}
	
	public String getName(){
		return name;
	}
	public double getBalance(){
		return balance;
	}
	public String getPassword(){
		return password;
	}
}
