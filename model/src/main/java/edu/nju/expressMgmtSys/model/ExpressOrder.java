package edu.nju.expressMgmtSys.model;

import java.io.Serializable;

public class ExpressOrder implements Serializable{
    private static final long serialVersionUID = 8808667699386481286L;

    private String barcode;

    private Customer sender;
    private Customer receiver;
    private Commodity commodity;

    private ExpressType type;

    private double packagingFee;
    private double totalPrice;

    public ExpressOrder(String barcode, Customer sender,
                        Customer receiver, Commodity commodity,
                        ExpressType type, double packagingFee, double totalPrice) {
        this.barcode = barcode;
        this.sender = sender;
        this.receiver = receiver;
        this.commodity = commodity;
        this.type = type;
        this.packagingFee = packagingFee;
        this.totalPrice = totalPrice;
    }

    public String getBarcode() {
        return barcode;
    }

    public Customer getSender() {
        return sender;
    }

    public Customer getReceiver() {
        return receiver;
    }

    public Commodity getCommodity() {
        return commodity;
    }

    public ExpressType getType() {
        return type;
    }

    public double getPackagingFee() {
        return packagingFee;
    }

    public double getTotalPrice() {
        return totalPrice;
    }
}
