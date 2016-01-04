package LEMS.data.financedata;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import LEMS.data.Connect;
import LEMS.data.orderdata.ReceiptRecordData;
import LEMS.dataservice.financedataservice.SettlementDataService;
import LEMS.po.orderpo.IncomePO;

public class SettlementData extends UnicastRemoteObject implements SettlementDataService {
	private static final long serialVersionUID = 1L;

	private Connect connect;
	
	private ReceiptRecordData receiptRecord;
	
	public SettlementData() throws RemoteException {
		super();
		
		connect = new Connect();
		receiptRecord = new ReceiptRecordData();
	}

	@Override
	public ArrayList<IncomePO> getIncomePO(String date, String institution) throws RemoteException {
		ArrayList<IncomePO> incomes = new ArrayList<IncomePO>();
		
		String sql = "SELECT * FROM cash";
		
		ResultSet result = connect.getResultSet(sql);
		
		try {
			while (result.next()) {
				if (result.getString(3).equals(date) && result.getString(1).startsWith(institution)) {
					incomes.add(receiptRecord.find(result.getString(1)));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return incomes;
	}

}
