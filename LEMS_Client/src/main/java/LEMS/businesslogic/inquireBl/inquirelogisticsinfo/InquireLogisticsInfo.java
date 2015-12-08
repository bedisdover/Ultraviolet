package LEMS.businesslogic.inquirebl.inquirelogisticsinfo;

import java.rmi.Naming;
import java.rmi.RemoteException;

import LEMS.businesslogic.utility.RMIConnect;
import LEMS.businesslogicservice.inquireblservice.InquireLogisticsInfoService;
import LEMS.dataservice.factory.DatabaseFactory;
import LEMS.dataservice.factory.InquireFactory;
import LEMS.dataservice.inquiredataservice.LogisticsInfoDataService;
import LEMS.po.inquirepo.LogisticsInfoPO;
import LEMS.vo.inquirevo.LogisticsInfoVO;

/**
 * @author 章承尧 inquireLogisticsInfoService接口的实现
 */
public class InquireLogisticsInfo implements InquireLogisticsInfoService {

	public LogisticsInfoVO getLogisticsInfo(String id) {
		LogisticsInfoVO lvo=null;
		try {
			LogisticsInfoPO lpo=getLogisticsInfoData().findLogisticsInfo(id);
			if(lpo!=null){
				lvo=new LogisticsInfoVO(lpo.getId(),lpo.getTrace());				
			}						
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return lvo;
		
	}
	
	public void updateLogisticsInfo(LogisticsInfoVO lvo){
		LogisticsInfoDataService logicsdata=getLogisticsInfoData();
		LogisticsInfoPO lpo=new LogisticsInfoPO(lvo.getId(),lvo.getTrace());
		try {
			logicsdata.update(lpo);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	
	public void createLogistics(LogisticsInfoVO logisticsInfoVO) {
		LogisticsInfoDataService logicsdata=getLogisticsInfoData();
		LogisticsInfoPO lpo=new LogisticsInfoPO(logisticsInfoVO.getId(),logisticsInfoVO.getTrace());
		lpo.setInstitution(logisticsInfoVO.getInstitution());
		try {
			logicsdata.insertLogisticsInfo(lpo);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	
	private static LogisticsInfoDataService getLogisticsInfoData() {
		LogisticsInfoDataService lo = null;
		try {
			DatabaseFactory database = (DatabaseFactory) Naming
					.lookup(RMIConnect.RMI);
			InquireFactory inquire = database.getInquireFactory();
			lo = inquire.getLogisticsInfo();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return lo;
	}
	
}
