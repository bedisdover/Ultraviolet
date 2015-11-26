package LEMS.data.financedata;

import java.rmi.RemoteException;

import LEMS.dataservice.financedataservice.PriceDataService;
import LEMS.po.financepo.PricePO;

public class PriceData implements PriceDataService {

	private PricePO pricePO;
	
	public PricePO getPrice() throws RemoteException {
		
		return pricePO;
	}
	
	public void pricing(PricePO price) throws RemoteException {
		
	}

}
