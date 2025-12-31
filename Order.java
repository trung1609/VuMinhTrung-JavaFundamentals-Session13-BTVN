package Session13.gioi2;

import java.util.ArrayList;
import java.util.Scanner;

public class Order {
    private String orderId;
    private String customerName;

    public Order(String orderId, String customerName) {
        this.orderId = orderId;
        this.customerName = customerName;
    }

    public Order() {
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void inputData(Scanner sc, ArrayList<Order> orders) {
        this.orderId = getInvoiceId(orders);
        System.out.print("Nhap ten khach hang: ");
        this.customerName = sc.nextLine();
    }
    public static String getInvoiceId(ArrayList<Order> orders) {
        int result = orders.isEmpty() ? 1 : orders.size() + 1;
        return String.format("OD%04d", result);
    }
    @Override
    public String toString() {
        return "Ma don hang: " + orderId +
                ", Ten khach hang: " + customerName;
    }
}
