package LEMS.businesslogic.storebl;
import java.util.ArrayList;

/**
 * @author 周梦佳
 *生成仓库出库入库单
 */
import LEMS.businesslogicservice.storeblservice.StoreGenerateOrderService;
import LEMS.po.orderpo.TransportType;
import LEMS.po.storepo.Area;
import LEMS.po.storepo.Destination;
import LEMS.po.storepo.InboundOrderPO;

import LEMS.po.storepo.OutboundOrderPO;
import LEMS.vo.storevo.InboundOrderVO;
import LEMS.vo.storevo.OutboundOrderVO;


public class StoreGenerateOrder implements StoreGenerateOrderService{

	ArrayList<InboundOrderVO> addInboundOrder=new ArrayList<InboundOrderVO>();
	ArrayList<OutboundOrderVO> addOutboundOrder=new ArrayList<OutboundOrderVO>();
	
	public InboundOrderVO generateInboundOrder(InboundOrderPO iOPO){
		StoreManagement storeManagement=new StoreManagement();
		String id=iOPO.getId();
		String inDate=iOPO.getInDate();
		Destination destination=iOPO.getDestination();
		Area area=iOPO.getArea();
		int row=iOPO.getRow();		
		int stand=iOPO.getStand();		
		int position=iOPO.getPosition();		
		InboundOrderVO inboundOrderVO=new InboundOrderVO(id,inDate,destination,area,row,stand,position);
		addInboundOrder.add(inboundOrderVO);
		return inboundOrderVO;
	
}
	public OutboundOrderVO generateOutboundOrder(OutboundOrderPO oOPO){
		String id=oOPO.getId();
		String outDate=oOPO.getOutDate();
		Destination destination=oOPO.getDestination();
		TransportType transportType=oOPO.getTransportType();
		long transferNum=oOPO.getTransferNum();			
		OutboundOrderVO outboundOrderVO=new OutboundOrderVO(id,outDate,destination,transportType,transferNum);
		addOutboundOrder.add(outboundOrderVO);
		return outboundOrderVO;
	
		
	}
	
	public ArrayList<InboundOrderVO> totalInboundOrder(){		
		return addInboundOrder;
		
	}
	
	public ArrayList<OutboundOrderVO> totalOutboundOrder(){
		return addOutboundOrder;
		
	}
}
