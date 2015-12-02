package LEMS.dataservice.storedataservice;

import java.util.ArrayList;

import LEMS.po.storepo.GoodsPO;

public interface GoodsDataService {

	public ArrayList<String> find(String id);
	
	public int insert(GoodsPO goodsPO);
	
	public int delete(GoodsPO goodsPO);
	
	public int update(GoodsPO goodsPO);
	
	public void init();
	
	public void finish();
	
}
