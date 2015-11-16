package LEMS.businesslogic.storebl;

import java.util.ArrayList;

import LEMS.po.storepo.GoodsPO;
import LEMS.vo.ordervo.GoodsVO;

public class StoreManagement {
	String startTime;
	String endTime;
	
	public StoreManagement(String sTime,String eTime){
		startTime=sTime;
		endTime=eTime;
		
	}
	
	public ArrayList<GoodsVO> inquire(String startTime,String endTime){
		ArrayList<GoodsVO> alvo=new  ArrayList<GoodsVO>();
		MockStoreInboundOrder msio1=new MockStoreInboundOrder("1000000011", "20151115", Destination.Nanjing, Area.Airline, 1, 1, 1);
		MockStoreInboundOrder msio2=new MockStoreInboundOrder("1000001111", "20151105", Destination.Nanjing, Area.Trainline, 8, 6, 12);

		GoodsVO gvo1=new GoodssVO(msio1.getID(),msio1.getArea(),msio1.getRow(),msio1.getStand(),msio1.getPosition());
		GoodsVO gvo2=new GoodssVO(msio2.getID(),msio2.getArea(),msio2.getRow(),msio2.getStand(),msio2.getPosition());
		alvo.add(gvo1);
		alvo.add(gvo2);
		
		return alvo;
	}
	
	public ArrayList<GoodsVO> check(){
		ArrayList<GoodsVO> alvo=new  ArrayList<GoodsVO>();
		MockStoreInboundOrder msio1=new MockStoreInboundOrder("1000000011", "20151115", Destination.Nanjing, Area.Airline, 1, 1, 1);
		MockStoreInboundOrder msio2=new MockStoreInboundOrder("1000001111", "20151105", Destination.Nanjing, Area.Trainline, 8, 6, 12);

		GoodsVO gvo1=new GoodssVO(msio1.getID(),msio1.getArea(),msio1.getRow(),msio1.getStand(),msio1.getPosition());
		GoodsVO gvo2=new GoodssVO(msio2.getID(),msio2.getArea(),msio2.getRow(),msio2.getStand(),msio2.getPosition());
		alvo.add(gvo1);
		alvo.add(gvo2);
		
		return alvo;
	}
	
	public void warning(){
		int standardNum=0;
		ArrayList al=new ArrayList();
		al=check();
		int presentNum=(Integer) al.get(5);
		if(presentNum>=standardNum)
			System.out.println("Warning!");
	}

}
