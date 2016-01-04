package LEMS.businesslogic.utility;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;

/**
 * @author 宋益明
 * 
 * 格式， 包括日期格式，浮点数格式
 */
public class Formate {

	/**
	 * 日期格式（年月日小时）
	 * 调用者：
	 * 		orderbl.Receipt
	 * 		orderbl.Sending
	 * 		orderbl.Order
	 * 		orderbl.VehicleLoadController
	 */
	public static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyyMMddhh");
	
	public static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("#.00");
}
