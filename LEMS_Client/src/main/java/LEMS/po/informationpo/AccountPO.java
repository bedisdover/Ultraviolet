package LEMS.po.informationpo;

import java.io.Serializable;

/**
 * @author 苏琰梓
 * 账户信息持久化对象
 * 2015年10月25日
 */
@SuppressWarnings("serial")
public class AccountPO implements Serializable{
	/*
	 * 账户名称
	 */
	private String id;
	/*
	 * 账户余额
	 */
	private double balance;
	/*
	 * 账户密码
	 */
	private String password;
	
	public AccountPO(String id,String password,double balance){
		this.id =  id;
		this.balance = balance;
		this.password = password;
	}
	
	public String getId(){
		return id;
	}
	public double getBalance(){
		return balance;
	}
	public String getPassword(){
		return password;
	}
}
