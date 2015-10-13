package edu.nju.expressMgmtSys.dao;

import java.util.List;

import edu.nju.expressMgmtSys.model.ExpressOrder;

public interface OrderDAO {

    void addOrder(ExpressOrder order);

    List<ExpressOrder> getOrders();
}
