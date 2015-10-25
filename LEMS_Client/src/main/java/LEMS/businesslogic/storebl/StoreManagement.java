package LEMS.businesslogic.storebl;

import java.util.ArrayList;

import LEMS.po.storepo.GoodsPO;
import LEMS.vo.ordervo.GoodsVO;

public class StoreManagement {
	public ArrayList<GoodsVO> inquire(String startTime,String endTime){
		return new  ArrayList<GoodsVO>();
	}
	
	public ArrayList<GoodsVO> check(){
		return new ArrayList<GoodsVO>();
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
