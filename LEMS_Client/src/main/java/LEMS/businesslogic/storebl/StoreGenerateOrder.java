package LEMS.businesslogic.storebl;
/**
 * @author 周梦佳
 *生成仓库出库入库单
 */
import LEMS.businesslogicservice.storeblservice.StoreGenerateOrderService;
import LEMS.po.storepo.Area;
import LEMS.po.storepo.Destination;
import LEMS.po.storepo.InboundOrderPO;
import LEMS.po.storepo.LoadFormat;
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
		InboundOrderVO inboundOrderVO=new InboundOrderVO(id,inDate,destination,area,row,stand,position,inboundOrder.getOperation());
		return inboundOrderVO;
	
}
	
	public OutboundOrderVO generateOutboundOrder(OutboundOrderPO oOPO){
		String id=oOPO.getId();
		String outDate=oOPO.getOutDate();
		Destination destination=oOPO.getDestination();
		LoadFormat loadFormat=oOPO.getLoadFormat();
		long transferNum=oOPO.getTransferNum();
			
		StoreOutboundOrder outboundOrder=new MockStoreOutboundOrder(id,outDate,destination,loadFormat,transferNum);
		
		OutboundOrderVO outboundOrderVO=new OutboundOrderVO(id,outDate,destination,loadFormat,transferNum,outboundOrder.getOperation());
		return outboundOrderVO;
	
		
	}
}
