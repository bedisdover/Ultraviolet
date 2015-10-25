package LEMS.data.inquiredata.stub;

import java.util.ArrayList;

import LEMS.dataservice.inquiredataservice.BusinessListDataService;
import LEMS.po.financepo.IncomeBillPO;
import LEMS.po.financepo.PayBillPO;
import LEMS.po.inquirepo.BusinessListPO;

public class BusinessListDataService_Stub implements BusinessListDataService {

	public BusinessListPO findBusinessList(String startTime, String endTime) {
		// TODO Auto-generated method stub
		ArrayList<PayBillPO> arrp=new ArrayList<PayBillPO>();
		ArrayList<IncomeBillPO> arri=new ArrayList<IncomeBillPO>();
		IncomeBillPO pbp=new IncomeBillPO(startTime, endTime, 3000);
		arri.add(pbp);
		BusinessListPO bpo=new BusinessListPO(startTime,endTime,arrp,arri);
		return bpo;		
	}

}
