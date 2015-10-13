package edu.nju.expressMgmtSys.dao.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import edu.nju.expressMgmtSys.dao.OrderDAO;
import edu.nju.expressMgmtSys.model.ExpressOrder;

public class OrderFileDAO implements OrderDAO {
	private List<ExpressOrder> orders;

	public OrderFileDAO() {
		orders = new ArrayList<>();
	}

	@Override
	public void addOrder(ExpressOrder order) {
		orders.add(order);
		try {
			ObjectOutputStream os;
			File file = new File("order.txt");
			FileOutputStream fos = new FileOutputStream(file, true);
			if (file.length() < 1) {
				os = new ObjectOutputStream(fos);
			} else {
				os = new MyObjectOutputStream(fos);
			}
			os.writeObject(order);
			os.flush();
			os.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return;
	}

	@Override
	public List<ExpressOrder> getOrders() {
		orders.clear();
		ObjectInputStream is = null;

		File file = new File("order.txt");
		if (!file.exists()) {
			try {
				file.createNewFile();
				return orders;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		try {
			is = new ObjectInputStream(new FileInputStream(file));
			while (true) {
				ExpressOrder temp = (ExpressOrder) is.readObject();
				orders.add(temp);
			}
		} catch (Exception ex) {
			try {
				is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return orders;
	}

}

class MyObjectOutputStream extends ObjectOutputStream {
	public MyObjectOutputStream() throws IOException {
		super();
	}

	public MyObjectOutputStream(OutputStream out) throws IOException {
		super(out);
	}

	protected void writeStreamHeader() throws IOException {
		return;
	}
}