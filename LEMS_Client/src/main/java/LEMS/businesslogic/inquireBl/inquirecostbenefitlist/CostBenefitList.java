package LEMS.businesslogic.inquirebl.inquirecostbenefitlist;

public class CostBenefitList {
	String startTime;
	String endTime;
	double totalIncome=0;
	double totalExpense=0;
	double totalProfit=0;
	public CostBenefitList(String startTime,String endTime){
		this.startTime=startTime;
		this.endTime=endTime;
	}
	
	public double calculateIncome(){
		MockIncomeBill b1=new MockIncomeBill(startTime,20.1);
		MockIncomeBill b2=new MockIncomeBill(startTime,29.8);
		totalIncome=b1.getIncome()+b2.getIncome();
		return (double)Math.round(totalIncome*100)/100;
	}
	public double calculateExpense(){
		MockPayBill b1=new MockPayBill(startTime,10.1);
		MockPayBill b2=new MockPayBill(startTime,19.8);
		totalExpense=b1.getExpense()+b2.getExpense();
		return (double)Math.round(totalExpense*100)/100;
	}
	public double calculateProfit(){
		return (double)Math.round((totalIncome-totalExpense)*100)/100;
	}
	
}
