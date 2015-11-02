package LEMS.data.storedata.driver;

import LEMS.dataservice.storedataservice.GoodsDataService;
import LEMS.po.storepo.Area;
import LEMS.po.storepo.GoodsPO;

public class GoodsDataService_Driver {
	public void driver(GoodsDataService goodsDataService){
		GoodsPO gpo=goodsDataService.find("0001111111");
		System.out.println("find the goods");
		goodsDataService.insert(new GoodsPO("00011111111",Area.航运区,1,1,1));
		System.out.println("Insert succeed!");
		goodsDataService.delete(new GoodsPO("00011111111",Area.航运区,1,1,1));
		System.out.println("Delete succeed!");
		goodsDataService.update(new GoodsPO("00011111111",Area.航运区,1,1,1));
		System.out.println("update succeed!");
		goodsDataService.init();
		System.out.println("Initialization succeed!");
		goodsDataService.finish();;
		System.out.println("Finish succeed!");
	}
}
