package LEMS.businesslogic.financebl;

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
}
