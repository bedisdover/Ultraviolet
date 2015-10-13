package edu.nju.expressMgmtSys.server;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

import edu.nju.expressMgmtSys.service.OrderService;
import edu.nju.expressMgmtSys.service.impl.OrderServiceImpl;

public class RMIHelper {

    public static void init() {
        try {
            LocateRegistry.createRegistry(1099);

            OrderService orderService = new OrderServiceImpl();

            Naming.rebind("order-service", orderService);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        }


    }
}
