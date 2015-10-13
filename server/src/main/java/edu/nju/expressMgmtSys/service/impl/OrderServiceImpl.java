package edu.nju.expressMgmtSys.service.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import edu.nju.expressMgmtSys.dao.OrderDAO;
import edu.nju.expressMgmtSys.dao.impl.OrderFileDAO;
import edu.nju.expressMgmtSys.model.ExpressOrder;
import edu.nju.expressMgmtSys.service.OrderService;

public class OrderServiceImpl extends UnicastRemoteObject implements OrderService {

    private OrderDAO orderDAO;

    public OrderServiceImpl() throws RemoteException {
        super();
        orderDAO = new OrderFileDAO();
    }

    public void addExpressOrder(ExpressOrder order) throws RemoteException{
        orderDAO.addOrder(order);
    }

    @Override
    public List<ExpressOrder> getExpressOrders() throws RemoteException {
        return orderDAO.getOrders();
    }
}
