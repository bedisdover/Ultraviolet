package LEMS.data.storedata.stub;

import LEMS.po.storepo.Area;
import LEMS.po.storepo.GoodsPO;

public class GoodsDataService_Stub {
	public GoodsPO find(String id){

	Area area=Area.航运区;
	int	row=1;
	int	stand=1;
	int	position=1;
	GoodsPO gpo=new GoodsPO(id,area,row,stand,position);
	return gpo;
	}
	
}