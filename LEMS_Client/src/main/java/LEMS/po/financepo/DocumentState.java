package LEMS.po.financepo;

import java.io.Serializable;
import java.util.HashMap;

/**
 * @author 宋益明
 * 
 * 单据状态：待审批、审批通过、不通过
 */
public enum DocumentState implements Serializable {
	waiting,//待审批
	accepted,//通过
	unaccepted//不通过
	;
	
	private static HashMap<DocumentState, String> stateList;
	
	static {
		stateList = new HashMap<>();
		
		stateList.put(DocumentState.waiting, "待审批");
		stateList.put(DocumentState.accepted, "通过");
		stateList.put(DocumentState.unaccepted, "不通过");
	}
	
	public static String transfer(DocumentState state) {
		return stateList.get(state);
	}
}
