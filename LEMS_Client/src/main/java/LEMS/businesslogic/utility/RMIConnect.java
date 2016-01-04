package LEMS.businesslogic.utility;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class RMIConnect {
	public static String RMI;
	public static String FILE;
	
	static {
		try {
			//创建XML读取器
			SAXReader reader = new SAXReader();
			//读取
			Document document = reader.read("config.xml");
			//获取根目录
			Element system = document.getRootElement();
			Element connect = system.element("Connect");
			Element file = system.element("File");

			RMI = connect.attributeValue("IP");
			FILE = file.attributeValue("name");
			
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}
}
