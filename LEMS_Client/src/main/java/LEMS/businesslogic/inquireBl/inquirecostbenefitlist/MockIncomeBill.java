package LEMS.businesslogic.inquirebl.inquirecostbenefitlist;

public class MockIncomeBill {
	String date;
	double income;
	public MockIncomeBill(String d,double i){
		date=d;
		income=i;
	}
	public double getIncome(){
		return income;
	}
}
