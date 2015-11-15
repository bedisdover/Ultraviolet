package LEMS.businesslogic.inquirebl.inquirecostbenefitlist;

public class MockPayBill {
	String date;
	double expense;
	public MockPayBill(String d,double e){
		date=d;
		expense=e;
	}
	public double getExpense(){
		return expense;
	}
}
