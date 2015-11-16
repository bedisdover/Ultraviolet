
public class MockStoreOutboundOrder extends StoreOutboundOrder {

	ArrayList<String> operation=new ArrayList<String>();
	public StoreOutboundOrder(String id, String outDate, Destination destination, LoadFormat loadFormat, long transferNum){
		operation.add(id);
		operation.add("add an id.");
		operation.add(outDate);
		operation.add("add outDate.");
		operation.add(destination);
		operation.add("add destination.");
		operation.add(loadFormat);
		operation.add("add a loadFormat.");
		operation.add(transferNum);
		operation.add("add a transferNum.");


	}
	public ArrayList<String> generateOperation(){
		return operation;
	}
}
