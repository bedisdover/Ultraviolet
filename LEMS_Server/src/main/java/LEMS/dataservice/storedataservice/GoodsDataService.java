package LEMS.dataservice.storedataservice;

import LEMS.po.storepo.GoodsPO;

public interface GoodsDataService {

	public GoodsPO find(String id);
	
	public void insert(GoodsPO goodsPO);
	
	public void delete(GoodsPO goodsPO);
	
	public void update(GoodsPO goodsPO);
	
	public void init();
	
	public void finish();
	
}
