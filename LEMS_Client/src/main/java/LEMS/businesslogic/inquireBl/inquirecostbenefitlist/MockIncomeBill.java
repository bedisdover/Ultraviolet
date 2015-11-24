package LEMS.businesslogic.inquirebl.inquirecostbenefitlist;

/**
 * @author user
 * 收款单的mock对象
 */
public class MockIncomeBill {
	
	/**
	 * 日期
	 */
	String date;
	/**
	 * 收入
	 */
	double income;
	public MockIncomeBill(String d,double i){
		date=d;
		income=i;
	}
	public double getIncome(){
		return income;
	}
}
