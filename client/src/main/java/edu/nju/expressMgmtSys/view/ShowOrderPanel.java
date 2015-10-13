package edu.nju.expressMgmtSys.view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import edu.nju.expressMgmtSys.client.RMIHelper;
import edu.nju.expressMgmtSys.model.ExpressOrder;
import edu.nju.expressMgmtSys.service.OrderService;

public class ShowOrderPanel extends JPanel{
    private static final String[] TABLE_HEADER = new String[] {
            "Order ID", "Sender", "Receiver", "Commodity", "Type", "Pakcaging Fee", "Price"};

    private JTable orderListTable;
    private DefaultTableModel defaultTableModel;
    private JButton addButton;

    private OrderService orderService;

    public ShowOrderPanel() {
        orderService = RMIHelper.getOrderService();

        Object[][] orders = getOrders();
        defaultTableModel = new DefaultTableModel(orders, TABLE_HEADER);
        orderListTable = new JTable(defaultTableModel);
        addButton = new JButton("add");

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddOrderDialog(ShowOrderPanel.this).setVisible(true);
            }
        });
        
        this.setLayout(new BorderLayout());
        this.add(new JScrollPane(orderListTable), BorderLayout.CENTER);
        this.add(addButton, BorderLayout.SOUTH);
    }
    
    public void refresh() {
		Object[][] orders = getOrders();
		defaultTableModel.setDataVector(orders, TABLE_HEADER);
//		this.validate();
	}

    private Object[][] getOrders() {
        List<ExpressOrder> expressOrders = orderService.getExpressOrders();

        Object[][] orders = new Object[expressOrders.size()][];
        for (int i = 0; i < expressOrders.size(); i++) {
            Object[] order = changeToAnObject(expressOrders.get(i));
            orders[i] = order;
        }
        return orders;
    }

    private Object[] changeToAnObject(ExpressOrder expressOrder) {
        Object[] order = new Object[TABLE_HEADER.length];
        order[0] = expressOrder.getBarcode();
        order[1] = expressOrder.getSender().getName();
        order[2] = expressOrder.getReceiver().getName();
        order[3] = expressOrder.getCommodity().getName();
        order[4] = expressOrder.getType();
        order[5] = expressOrder.getPackagingFee();
        order[6] = expressOrder.getTotalPrice();
        return order;
    }
}
