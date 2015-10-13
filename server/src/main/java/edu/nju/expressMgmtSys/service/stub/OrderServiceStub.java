package edu.nju.expressMgmtSys.service.stub;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import edu.nju.expressMgmtSys.model.Commodity;
import edu.nju.expressMgmtSys.model.Customer;
import edu.nju.expressMgmtSys.model.ExpressOrder;
import edu.nju.expressMgmtSys.model.ExpressType;
import edu.nju.expressMgmtSys.service.OrderService;

public class OrderServiceStub extends UnicastRemoteObject implements OrderService {


    public OrderServiceStub() throws RemoteException {
        super();
    }

    @Override
    public void addExpressOrder(ExpressOrder order) throws RemoteException{
        System.out.println("An Order has been added.");
    }

    @Override
    public List<ExpressOrder> getExpressOrders() throws RemoteException {
        ExpressOrder expressOrder = new ExpressOrder("0000000000",
                new Customer("Jay", "Nanjing", "Nanjing University", "87654321", "123456789"),
                new Customer("Zhou", "Beijing", "Beijing University", "88888888", "111111111"),
                new Commodity(1, 1, 1, "bomb"),
                ExpressType.STANDARD,
                5, 10);

        List<ExpressOrder> expressOrders = new ArrayList<>();
        expressOrders.add(expressOrder);
        return expressOrders;
    }
}
