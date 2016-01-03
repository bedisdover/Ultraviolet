package LEMS.businesslogic.financebl;

import LEMS.businesslogic.utility.Approvalable;

/**
 * @author 宋益明
 * 
 * 工厂类
 * 用于生成审批单据时所需的具体实现类
 */
public class Factory {
	
	public static Factory factory;
	
	static {
		factory = new Factory();
	}
	
	private Factory() {}
	
	public Approvalable create(int index) {
		Approvalable approvalable = null;
		
		switch (index) {
		case 0:
			
		}
		
		return approvalable;
	}
}
