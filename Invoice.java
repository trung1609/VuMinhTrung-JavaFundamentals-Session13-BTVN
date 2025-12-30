package Session13.gioi1;

import java.util.Scanner;

public class Invoice {
    private int id;
    public static int AUTO_ID = 1;
    private String invoiceId;
    private double amount;

    public Invoice() {
    }


    public Invoice(int id, String invoiceId, double amount) {
        this.id = id;
        this.invoiceId = invoiceId;
        this.amount = amount;
    }

    public String getInvoiceId() {
        return invoiceId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setInvoiceId(String invoiceId) {
        this.invoiceId = invoiceId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "ID : " + id +
                ", Ma hoa don: " + invoiceId +
                ", So tien: " + amount;
    }

    public void inputData(Scanner sc) {
        this.id = AUTO_ID++;
        System.out.print("Nhap ma hoa don: ");
        invoiceId = sc.nextLine();
        do {
            System.out.print("Nhap so tien: ");
            amount = Double.parseDouble(sc.nextLine());
            if (amount < 0) {
                System.out.println("Vui long nhap so tien >= 0.");
            }
        } while (amount < 0);
    }
}
