package LEMS.businesslogic.storebl;

import LEMS.businesslogicservice.storeblservice.StoreGenerateOrderService;
import LEMS.po.storepo.InboundOrderPO;
import LEMS.po.storepo.OutboundOrderPO;
import LEMS.vo.storevo.InboundOrderVO;
import LEMS.vo.storevo.OutboundOrderVO;

public class StoreGenerateOrder implements  StoreGenerateOrderService{

	public InboundOrderVO generateInboundOrder(InboundOrderPO iOPO){
		String id=iOPO.getId();
		String inDate=iOPO.getInDate();
		Destination destination=iOPO.getDestination();
		Area area=iOPO.getArea();
		int row=iOPO.getRow();		
		int stand=iOPO.getStand();		
		int position=iOPO.getPosition();	
		StoreInboundOrder inboundOrder=new MockStoreInboundOrder(id,inDate,destination,area,row,stand,position);
		
		InboundOrderVO inboundOrderVO=new InboundOrderVO(inboundOrder,inboundOrder.generateOperation());
		return inboundOrderVO;
	
}
	
	public OutboundOrderVO generateOutboundOrder(OutboundOrderPO oOPO){
		String id=oOPO.getId();
		String outDate=oOPO.getOutDate();
		Destination destination=oOPO.getDestination();
		LoadFormat loadFormat=oOPO.getLoadFormat();
		long transferNum=oOPO.getTransferNum();
			
		StoreOutboundOrder outboundOrder=new MockStoreOutboundOrder(id,outDate,destination,loadFormat,transferNum);
		
		OutboundOrderVO outboundOrderVO=new OutboundOrderVO(outboundOrder,outboundOrder.generateOperation());
		return outboundOrderVO;
	
		
	}
}
