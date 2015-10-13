package edu.nju.expressMgmtSys.service;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import edu.nju.expressMgmtSys.model.ExpressOrder;

public interface OrderService extends Remote{

    void addExpressOrder(ExpressOrder order) throws RemoteException;

    List<ExpressOrder> getExpressOrders() throws RemoteException;

}
