package LEMS.data.orderdata;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import LEMS.po.orderpo.OrderPO;

/**
 * @author 宋益明
 * 
 * 用于实现OrderPO的序列化
 */
public class SerializeOrderPO {

	/**
	 * 将OrderPO转换为二进制数组
	 * 
	 * @param orderPO
	 * @return
	 */
	public byte[] write(OrderPO orderPO) {
		byte[] out = null;
		
		ObjectOutputStream oos;
		try {
			oos = new ObjectOutputStream(new ByteArrayOutputStream());
			oos.writeObject(orderPO);
			oos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return out;
	}
}
