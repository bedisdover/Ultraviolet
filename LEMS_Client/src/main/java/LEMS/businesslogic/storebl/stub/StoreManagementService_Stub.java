package LEMS.businesslogic.storebl.stub;

import java.util.ArrayList;

import LEMS.businesslogic.storebl.StoreManagement;
import LEMS.po.storepo.Area;
import LEMS.vo.storevo.GoodsVO;



public class StoreManagementService_Stub {

		public ArrayList<GoodsVO> inquire(String startTime,String endTime){
			ArrayList<GoodsVO> gvo=new ArrayList<GoodsVO>();
			GoodsVO gvo1=new GoodsVO("1",Area.航运区,1,1,1);
			GoodsVO gvo2=new GoodsVO("000111000",Area.航运区,2,2,1);
			GoodsVO gvo3=new GoodsVO("000111000",Area.航运区,1,7,5);
			GoodsVO gvo4=new GoodsVO("000111000",Area.航运区,5,1,1);
			GoodsVO gvo5=new GoodsVO("000111000",Area.航运区,9,1,7);
			gvo.add(gvo1);
			gvo.add(gvo2);
			gvo.add(gvo3);
			gvo.add(gvo4);
			gvo.add(gvo5);
			return gvo;
		
	}
		
		public ArrayList<GoodsVO> check(){
			ArrayList<GoodsVO> gvo=new ArrayList<GoodsVO>();
			GoodsVO gvo1=new GoodsVO("1",Area.航运区,1,1,1);
			GoodsVO gvo2=new GoodsVO("000111000",Area.航运区,2,2,1);
			GoodsVO gvo3=new GoodsVO("000111000",Area.航运区,1,7,5);
			GoodsVO gvo4=new GoodsVO("000111000",Area.航运区,5,1,1);
			GoodsVO gvo5=new GoodsVO("000111000",Area.航运区,9,1,7);
			gvo.add(gvo1);
			gvo.add(gvo2);
			gvo.add(gvo3);
			gvo.add(gvo4);
			gvo.add(gvo5);
			return gvo;
		
	}
		
		public void warning(){
			StoreManagement sm=new StoreManagement();
			sm.warning();
			
		}
}
