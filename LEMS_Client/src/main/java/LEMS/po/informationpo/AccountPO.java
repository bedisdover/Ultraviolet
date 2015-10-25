package LEMS.po.informationpo;

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
