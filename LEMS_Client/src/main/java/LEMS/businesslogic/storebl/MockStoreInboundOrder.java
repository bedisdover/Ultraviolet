import java.util.ArrayList;


public class MockStoreInboundOrder extends StoreInboundOrder {
	ArrayList<String> operation=new ArrayList<String>();
	public void StoreInboundOrder(String id, String inDate, Destination destination, Area area, int row, int stand, int position){
		operation.add(id);
		operation.add("add an id.");
		operation.add(inDate);
		operation.add("add inDate.");
		operation.add(destination);
		operation.add("add destination.");
		operation.add(area);
		operation.add("add area.");
		operation.add(row);
		operation.add("add a row.");
		operation.add(stand);
		operation.add("add a stand.");
		operation.add(position);
		operation.add("add a position.");

	}
	public ArrayList<String> generateOperation(){
		return operation;
	}
}
