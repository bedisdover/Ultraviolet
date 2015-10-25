package LEMS.vo.informationvo;

public class AccountVO {
	/*
	 * 账户名称
	 */
	private String name;
	/*
	 * 账户余额
	 */
	private double balance;
	
	public AccountVO(String name,double balance){
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
