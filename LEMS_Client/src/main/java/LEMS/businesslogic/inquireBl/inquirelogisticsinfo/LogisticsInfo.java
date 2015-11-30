package LEMS.businesslogic.inquirebl.inquirelogisticsinfo;

import java.rmi.Naming;
import java.util.ArrayList;

import LEMS.dataservice.factory.DatabaseFactory;
import LEMS.dataservice.factory.InquireFactory;
import LEMS.dataservice.inquiredataservice.LogisticsInfoDataService;
import LEMS.po.inquirepo.LogisticsInfoPO;

public class LogisticsInfo {

	String id;
	ArrayList<String> trace;

	public LogisticsInfo(String id) {
		this.id = id;
	}

	public ArrayList<String> getLogisticsInfo() {
		try {
			DatabaseFactory database = (DatabaseFactory) Naming
					.lookup("rmi://localhost:1099/data");
			InquireFactory inquire = database.getInquireFactory();
			LogisticsInfoDataService lo = inquire.getLogisticsInfo();
			LogisticsInfoPO logisPO = lo.findLogisticsInfo(id);
			if (logisPO != null) {
				trace = logisPO.getTrace();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return trace;
	}
}
