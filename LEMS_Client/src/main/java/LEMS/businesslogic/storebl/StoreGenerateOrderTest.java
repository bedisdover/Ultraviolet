package LEMS.businesslogic.storebl;

import LEMS.po.storepo.Area;
import LEMS.po.storepo.Destination;
import LEMS.po.storepo.InboundOrderPO;
import LEMS.po.storepo.LoadFormat;
import LEMS.po.storepo.OutboundOrderPO;
import LEMS.vo.storevo.InboundOrderVO;
import LEMS.vo.storevo.OutboundOrderVO;
import junit.framework.TestCase;

public class StoreGenerateOrderTest extends TestCase{
		public void testStoreGenerateInboundOrder(){
			MockStoreInboundOrder inbound=new MockStoreInboundOrder("1111111111", "20151115", 
					Destination.Nanjing, Area.Airline, 1, 1, 1);
		StoreGenerateOrder sgo=new StoreGenerateOrder();
		InboundOrderPO ipo=new InboundOrderPO("1111111111", "20151115", Destination.Nanjing, Area.Airline, 1, 1, 1);
		InboundOrderVO iovo=sgo.generateInboundOrder(ipo);
		assertEquals("generate an inbound order.",iovo.getOperation().get(1));
		}
		
		
		public void testStoreGenerateOutboundOrder(){
			MockStoreOutboundOrder outbound=new MockStoreOutboundOrder("1111111111", "20151115", 
					Destination.Nanjing,LoadFormat.Airplane,11150001);
			OutboundOrderPO opo=new OutboundOrderPO("1111111111", "20151115",Destination.Nanjing,LoadFormat.Airplane,11150001);
		StoreGenerateOrder sgo=new StoreGenerateOrder();
		OutboundOrderVO oovo=sgo.generateOutboundOrder(opo);
		assertEquals("generate an outbound order.",oovo.getOperation().get(1));
		}
}

