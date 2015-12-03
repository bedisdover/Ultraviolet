package LEMS.businesslogic.utility;

import java.text.SimpleDateFormat;

/**
 * @author 宋益明
 * 
 * 日期格式
 */
public class DateFormate {

	/**
	 * 日期格式（年月日小时）
	 * 调用者：
	 * 		orderbl.Receipt
	 * 		orderbl.Sending
	 * 		orderbl.Order
	 */
	public static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyyMMddhh");
}
