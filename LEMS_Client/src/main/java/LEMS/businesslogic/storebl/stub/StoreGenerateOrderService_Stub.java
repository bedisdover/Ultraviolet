package LEMS.businesslogic.storebl.stub;

import LEMS.po.storepo.Area;
import LEMS.po.storepo.Destination;
import LEMS.po.storepo.LoadFormat;

import LEMS.vo.storevo.InboundOrderVO;
import LEMS.vo.storevo.OutboundOrderVO;

public class StoreGenerateOrderService_Stub {
	
	public InboundOrderVO generateInboundOrder(){
		String id="000111000";
		String inDate="2015.10.25";
		int row=1;		
		int stand=1;		
		int position=1;	
		InboundOrderVO iovo=new InboundOrderVO(id,inDate,Destination.上海,Area.航运区,row,stand,position);
			return iovo;
	}
	

	public OutboundOrderVO generateOutboundOrder(){
		String id="000111000";
		String outDate="2015.10.25";
		int tnum=00000011111;
		OutboundOrderVO oovo=new OutboundOrderVO(id,outDate,Destination.上海,LoadFormat.飞机,tnum);
			return oovo;
	}
	

}