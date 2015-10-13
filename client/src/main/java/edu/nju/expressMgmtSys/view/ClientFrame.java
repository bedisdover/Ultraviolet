package edu.nju.expressMgmtSys.view;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class ClientFrame extends JFrame{

    public ClientFrame() {
        this.setSize(800, 300);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setTitle("Express Management System - Prototype");

        this.add(new ShowOrderPanel());

        this.setVisible(true);

    }
}
