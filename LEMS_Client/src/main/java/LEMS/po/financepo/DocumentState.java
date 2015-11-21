package LEMS.po.financepo;

/**
 * @author 宋益明
 * 
 * 单据状态：待审批、审批通过、不通过
 */
public enum DocumentState {
	waiting,//待审批
	accepted,//通过
	unaccepted//不通过
}