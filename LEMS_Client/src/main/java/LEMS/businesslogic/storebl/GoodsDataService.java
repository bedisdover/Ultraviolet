package LEMS.businesslogic.storebl;

import java.util.ArrayList;

import LEMS.po.storepo.GoodsPO;

public interface GoodsDataService {

	public GoodsPO find(String id);
	
	public ArrayList<GoodsPO> find(String sTime,String eTime);
	
	public int insert(GoodsPO goodsPO);
	
	public int delete(String id);
	
	public int update(GoodsPO goodsPO);
	
	public void init();
	
	public void finish();
	

}
