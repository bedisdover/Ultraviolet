package LEMS.businesslogicservice.storeblservice;

import LEMS.po.storepo.InboundOrderPO;
import LEMS.po.storepo.OutboundOrderPO;
import LEMS.vo.storevo.InboundOrderVO;
import LEMS.vo.storevo.OutboundOrderVO;

public interface StoreGenerateOrderService {

	public InboundOrderVO generateInboundOrder(InboundOrderPO inboundOrderPO);	//生成入库单
	
	public OutboundOrderVO generateOutboundOrder(OutboundOrderPO outboundOrderPO);		//生成出库单
}
