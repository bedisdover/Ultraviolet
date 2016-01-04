package LEMS.businesslogicservice.storeblservice;

import java.util.ArrayList;

import LEMS.vo.ordervo.GoodsVO;

public interface StoreManagementService {
	public ArrayList<GoodsVO> inquire(String startTime,String endTime);
	
	public ArrayList<GoodsVO> check();
	
	public int warning();

}
