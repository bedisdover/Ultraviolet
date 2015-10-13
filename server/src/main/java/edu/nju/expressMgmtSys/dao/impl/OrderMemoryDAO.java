package edu.nju.expressMgmtSys.dao.impl;

import java.util.ArrayList;
import java.util.List;

import edu.nju.expressMgmtSys.dao.OrderDAO;
import edu.nju.expressMgmtSys.model.ExpressOrder;

public class OrderMemoryDAO implements OrderDAO{
    private List<ExpressOrder> orders;

    public OrderMemoryDAO() {
        orders = new ArrayList<>();
    }

    @Override
    public void addOrder(ExpressOrder order) {
        orders.add(order);
    }

    @Override
    public List<ExpressOrder> getOrders() {
        return orders;
    }
}
