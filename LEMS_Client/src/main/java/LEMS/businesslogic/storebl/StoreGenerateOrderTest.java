
public class StoreGenerateOrderTest extends TestCase{
		public testStoreGenerateInboundOrder(){
			MockStoreInboundOrder inbound=new MockStoreInboundOrder("1111111111", "20151115", 
					Destination.Nanjing, Area.Airline, 1, 1, 1);
		StoreGenerateOrder sgo=new StoreGenerateOrder();
		InboundOrderVO iovo=sgo.generateInboundOrder(inbound.operation.get(0));
		assertEquals("generate an inbound order.",iovo.getOperation().get(1));
		}
		
		
		public testStoreGenerateOutboundOrder(){
			MockStoreOutboundOrder outbound=new MockStoreOutboundOrder("1111111111", "20151115", 
					Destination.Nanjing,LoadFormat.Airplane,"0250001201511150000001");
		StoreGenerateOrder sgo=new StoreGenerateOrder();
		OutboundOrderVO oovo=sgo.generateOutboundOrder(outbound.operation.get(0));
		assertEquals("generate an outbound order.",oovo.getOperation().get(1));
		}
}

