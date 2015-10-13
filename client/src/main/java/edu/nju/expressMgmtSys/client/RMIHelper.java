package edu.nju.expressMgmtSys.client;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import edu.nju.expressMgmtSys.service.OrderService;

public class RMIHelper {
    private static final String IP = "localhost";//Can be read from config file
    private static OrderService orderService;

    public static void init() {
        try {
            orderService =  (OrderService) Naming.lookup("rmi://" + IP + "/order-service");

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (NotBoundException e) {
            e.printStackTrace();
        }
    }

    public static OrderService getOrderService() {
        return orderService;
    }
}
