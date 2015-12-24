package LEMS.businesslogic.utility;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class RMIConnect {
//	public static final String RMI="rmi://114.212.42.237:1099/data";
	public static String RMI;
	
	
	static {
		try {
			//创建XML读取器
			SAXReader reader = new SAXReader();
			//读取
			Document document = reader.read("config.xml");
			//获取根目录
			Element connect = document.getRootElement();
			
			RMI = connect.attributeValue("IP");
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}
}
