package LEMS.businesslogic.financebl.driver;

import LEMS.businesslogic.financebl.stub.NumericalStatementService_Stub;

/**
 * @author 宋益明
 * 
 * 统计报表任务驱动程序
 */
public class NumericalStatementService_Driver {
	
	public void drive(NumericalStatementService_Stub stub) {
		stub.export("13413531");
	}
}
