package LEMS.data.storedata;

import LEMS.dataservice.storedataservice.GoodsDataService;
import LEMS.po.storepo.Area;
import LEMS.po.storepo.GoodsPO;


public class GoodsData implements GoodsDataService {

	public GoodsPO find(String id){
		return new GoodsPO(id,Area.航运区,1,1,1);
	}
	
	public void insert(GoodsPO goodsPO){
		System.out.println("Insert succeed!");
	}
	
	public void delete(GoodsPO goodsPO){
		System.out.println("Delete succeed!");
	}
	
	public void update(GoodsPO goodsPO){
		System.out.println("Update succeed!");
	}
	
	public void init(){
		System.out.println("Initialization succeed!");
	}
	
	public void finish(){
		System.out.println("end!");
	}

	public GoodsPO find(long id) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
