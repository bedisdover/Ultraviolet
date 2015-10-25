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
	
	AccountPO(String name,double balance){
		this.name =  name;
		this.balance = balance;
	}
	
	public String getName(){
		return name;
	}
	public double getBalance(){
		return balance;
	}
}
