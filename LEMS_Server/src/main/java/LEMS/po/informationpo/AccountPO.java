package LEMS.po.informationpo;

/**
 * @author 苏琰梓
 * 账户信息持久化对象
 * 2015年10月25日
 */
public class AccountPO {
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
	
	public AccountPO(String name,String password,double balance){
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
