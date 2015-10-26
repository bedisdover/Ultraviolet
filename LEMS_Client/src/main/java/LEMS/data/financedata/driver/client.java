package LEMS.data.financedata.driver;

import LEMS.data.financedata.stub.FinanceDataService_Stub;

/**
 * @author 宋益明
 *
 * 运行FinanceDataService驱动程序
 */
public class client {
	
	public static void main(String[] args) {
		FinanceDataService_Driver driver = new FinanceDataService_Driver();
		driver.drive(new FinanceDataService_Stub());
	}
}
