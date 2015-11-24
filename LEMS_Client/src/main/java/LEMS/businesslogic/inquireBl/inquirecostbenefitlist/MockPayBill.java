package LEMS.businesslogic.inquirebl.inquirecostbenefitlist;

/**
 * @author user
 * 付款单mock对象
 */
public class MockPayBill {
	
	/**
	 * 付款单日期
	 */
	String date;
	/**
	 * 支出
	 */
	double expense;
	
	public MockPayBill(String d,double e){
		date=d;
		expense=e;
	}
	public double getExpense(){
		return expense;
	}
}
