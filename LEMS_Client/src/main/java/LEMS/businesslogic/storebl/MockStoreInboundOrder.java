<<<<<<< HEAD
package LEMS.businesslogic.storebl;

import java.util.ArrayList;

import LEMS.po.storepo.Area;
import LEMS.po.storepo.Destination;
=======
import java.util.ArrayList;

>>>>>>> origin/master

public class MockStoreInboundOrder extends StoreInboundOrder {
	String id;
	String inDate;
	Destination destination;
	Area area;
	int row;		//排
	int stand;		//架
	int position;	//位
	ArrayList<String> operation1;
	
	public MockStoreInboundOrder(String identity,String d,Destination des,Area ar,int r,int s,int pos){
		id=identity;
		inDate=d;
		destination=des;
		area=ar;
		row=r;
		stand=s;
		position=pos;
		
	}

	public MockStoreInboundOrder(String identity,String d,Destination des,Area ar,int r,int s,int pos,ArrayList<String> o){
		id=identity;
		inDate=d;
		destination=des;
		area=ar;
		row=r;
		stand=s;
		position=pos;
		operation1=o;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getInDate() {
		return inDate;
	}
	public void setInDate(String inDate) {
		this.inDate = inDate;
	}
	
	public Destination getDestination() {
		return destination;
	}
	public void setDestination(Destination destination) {
		this.destination = destination;
	}
	public Area getArea() {
		return area;
	}
	public void setArea(Area area) {
		this.area = area;
	}
	public int getRow() {
		return row;
	}
	public void setRow(int row) {
		this.row = row;
	}
	public int getStand() {
		return stand;
	}
	public void setStand(int stand) {
		this.stand = stand;
	}
	public int getPosition() {
		return position;
	}
	public void setPosition(int position) {
		this.position = position;
	}
	public ArrayList<String> getOperation(){
		return operation;
	}
	
	ArrayList<String> operation=new ArrayList<String>();
	public void StoreInboundOrder(String id, String inDate, Destination destination, Area area, int row, int stand, int position){
		operation.add(id);
		operation.add("add an id.");
		operation.add(inDate);
		operation.add("add inDate.");
		operation.add(destination.name());		//change enum to string : enumType.name();
		operation.add("add destination.");
		operation.add(area.name());
		operation.add("add area.");
		operation.add(String.valueOf(row));
		operation.add("add a row.");
		operation.add(String.valueOf(stand));
		operation.add("add a stand.");
		operation.add(String.valueOf(position));
		operation.add("add a position.");

	}
	public ArrayList<String> generateOperation(){
		return operation;
	}
}
