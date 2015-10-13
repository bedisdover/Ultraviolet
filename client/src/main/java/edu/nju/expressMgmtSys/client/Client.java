package edu.nju.expressMgmtSys.client;

import edu.nju.expressMgmtSys.view.ClientFrame;

public class Client {

    public static void main(String[] args) {
        RMIHelper.init();

        new ClientFrame();
    }
}
