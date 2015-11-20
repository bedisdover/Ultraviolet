package LEMS.businesslogicservice.storeblservice;

import java.util.ArrayList;

import LEMS.po.storepo.InboundOrderPO;
import LEMS.po.storepo.OutboundOrderPO;
import LEMS.vo.storevo.InboundOrderVO;
import LEMS.vo.storevo.OutboundOrderVO;

public interface StoreGenerateOrderService {

	public InboundOrderVO generateInboundOrder(InboundOrderPO inboundOrderPO);	//生成单个入库单
	
	public OutboundOrderVO generateOutboundOrder(OutboundOrderPO outboundOrderPO);//生成单个出库单
	
	public ArrayList<InboundOrderVO> totalInboundOrder();//所有入库单
	
	public ArrayList<OutboundOrderVO> totalOutboundOrder();//所有出库单

}
