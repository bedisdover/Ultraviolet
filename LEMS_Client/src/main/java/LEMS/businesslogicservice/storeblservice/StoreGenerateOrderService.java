package LEMS.businesslogicservice.storeblservice;

import LEMS.po.storepo.InboundOrderPO;
import LEMS.po.storepo.OutboundOrderPO;

public interface StoreGenerateOrderService {

	public void generateInboundOrder(InboundOrderPO inboundOrderPO);
	
	public void generateOutboundOrder(OutboundOrderPO outboundOrderPO);
}
