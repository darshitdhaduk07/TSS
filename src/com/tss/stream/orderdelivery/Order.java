package com.tss.stream.orderdelivery;

public class Order {
    private int orderId;
    private String customerName;
    private String productCategory;
    private int quantity;
    private double pricePerUint;
    private Status status;
    private static int counter = 0;

    public Order(String customerName, String productCategory, Status status, double pricePerUint, int quantity) {
        this.customerName = customerName;
        this.productCategory = productCategory;
        this.status = status;
        this.pricePerUint = pricePerUint;
        this.quantity = quantity;
        this.orderId = ++counter;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPricePerUint() {
        return pricePerUint;
    }

    public void setPricePerUint(double pricePerUint) {
        this.pricePerUint = pricePerUint;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public static int getCounter() {
        return counter;
    }

    public static void setCounter(int counter) {
        Order.counter = counter;
    }
    public double getTotalValue()
    {
        return getQuantity()*getPricePerUint();
    }
    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", customerName='" + customerName + '\'' +
                ", productCategory='" + productCategory + '\'' +
                ", quantity=" + quantity +
                ", pricePerUnit=" + pricePerUint +
                ", status=" + status +
                '}';
    }

}
