package LEMS.businesslogic.inquirebl.inquirebusinesslist;

import java.util.ArrayList;

import LEMS.businesslogic.inquirebl.inquirecostbenefitlist.CostBenefitList;
import LEMS.po.financepo.IncomeBillPO;
import LEMS.po.financepo.PayBillPO;
import LEMS.vo.financevo.IncomeBillVO;
import LEMS.vo.financevo.PayBillVO;

public class BusinessList {

	String startTime;
	String endTime;
	ArrayList<PayBillPO> pay;
	ArrayList<IncomeBillPO> income;

	public BusinessList(String startTime, String endTime) {
		this.startTime = startTime;
		this.endTime = endTime;
	}

	public ArrayList<PayBillVO> getPayBill() {
		CostBenefitList cfl = new CostBenefitList(startTime, endTime);
		pay = cfl.getPayBill(startTime, endTime);
		ArrayList<PayBillVO> pv = new ArrayList<PayBillVO>();
		for (int i = 0; i < pay.size(); i++) {
			PayBillVO pav = new PayBillVO(pay.get(i).getDate(), pay.get(i).getId(), pay.get(i).getInstitution(),
					pay.get(i).getAmount(), pay.get(i).getPayer(), pay.get(i).getAccount(), pay.get(i).getItem(),
					pay.get(i).getRemark());
			pv.add(pav);
		}
		return pv;
	}

	public ArrayList<IncomeBillVO> getIncomeBill() {
		CostBenefitList cfl = new CostBenefitList(startTime, endTime);
		
		income = cfl.getIncomeBill(startTime, endTime);
		ArrayList<IncomeBillVO> iv = new ArrayList<IncomeBillVO>();
		for (int i = 0; i < income.size(); i++) {
			IncomeBillVO ivo = new IncomeBillVO(income.get(i).getDate(), income.get(i).getInstitution(),
					income.get(i).getAmount(), income.get(i).getAccount());
			iv.add(ivo);
		}
		return iv;
	}
}
