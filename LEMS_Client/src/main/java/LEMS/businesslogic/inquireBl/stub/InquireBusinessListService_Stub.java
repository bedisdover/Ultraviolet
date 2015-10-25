package LEMS.businesslogic.inquirebl.stub;

import java.util.ArrayList;

import LEMS.businesslogicservice.inquireblservice.InquireBusinessListService;
import LEMS.vo.financevo.PayBillVO;
import LEMS.vo.inquirevo.BusinessListVO;
import LEMS.vo.ordervo.IncomeBillVO;

/**
 * @author 章承尧
 * InquireBusinessListService的桩程序
 */
public class InquireBusinessListService_Stub implements	InquireBusinessListService {

	public BusinessListVO getBusinessList(String startTime, String endTime) {
		// TODO Auto-generated method stub
		ArrayList<PayBillVO> pb=new ArrayList<PayBillVO>();
		ArrayList<IncomeBillVO> ib=new ArrayList<IncomeBillVO>();
		PayBillVO pbv=new PayBillVO();
		pb.add(pbv);
		ArrayList<Long> orderID=new ArrayList<Long>();
		orderID.add(213459382L);
		orderID.add(312324321L);
		IncomeBillVO iv=new IncomeBillVO(startTime, 123456, orderID, 3000);
		ib.add(iv);
		BusinessListVO blv=new BusinessListVO("2015/10/24","2015/10/25",pb,ib);
		return blv;
	}

}
