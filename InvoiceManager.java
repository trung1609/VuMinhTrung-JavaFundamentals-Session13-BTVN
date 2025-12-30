package Session13.gioi1;

import java.util.ArrayList;
import java.util.Scanner;

public class InvoiceManager implements Manage<Invoice> {
    static ArrayList<Invoice> invoiceList = new ArrayList<>();

    public static void main(String[] args) {
        InvoiceManager invoiceManager = new InvoiceManager();
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("*************** MENU QUAN LY HOA DON ***************");
            System.out.println("1. Them hoa don");
            System.out.println("2. Sua hoa don");
            System.out.println("3. Xoa hoa don");
            System.out.println("4. Hien thi danh sach hoa don");
            System.out.println("5. Thoat");
            System.out.print("Lua chon cua ban: ");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    invoiceManager.add(new Invoice());
                    break;
                case 2:
                    invoiceManager.update(0, null);
                    break;
                case 3:
                    invoiceManager.delete(0);
                    break;
                case 4:
                    invoiceManager.display();
                    break;
                case 5:
                    System.exit(0);
                default:
                    System.err.println("Vui long nhap lua chon phu hop.");
            }
        } while (true);
    }

    @Override
    public void add(Invoice item) {
        Scanner sc = new Scanner(System.in);
        item.inputData(sc);
        invoiceList.add(item);
        System.out.println("Hoa don da duoc them thanh cong");
    }

    public static int checkInvoiceId(int invoice_id) {
        for (int i = 0; i < invoiceList.size(); i++) {
            if (invoiceList.get(i).getId() == invoice_id) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void update(int index, Invoice item) {
        if (invoiceList.isEmpty()) {
            System.out.println("Chua co hoa don.");
        } else {
            display();
            Scanner sc = new Scanner(System.in);
            System.out.print("Nhap ma hoa don can sua: ");
            int invoice_id = Integer.parseInt(sc.nextLine());
            int indexUpdate = checkInvoiceId(invoice_id);
            if (indexUpdate == -1) {
                System.err.println("Ma hoa don khong ton tai");
            } else {
                System.out.print("Nhap ma hoa don moi: ");
                String new_invoice_id = sc.nextLine();
                invoiceList.get(indexUpdate).setInvoiceId(new_invoice_id);
                double new_amount;
                do {
                    System.out.print("Nhap so tien moi: ");
                    new_amount = Double.parseDouble(sc.nextLine());
                    if (new_amount < 0) {
                        System.err.println("Vui long nhap so tien >= 0");
                    }
                } while (new_amount < 0);
                invoiceList.get(indexUpdate).setAmount(new_amount);
                System.out.println("Hoa don da duoc sua thanh cong.");
            }
        }
    }

    @Override
    public void delete(int index) {
        if (invoiceList.isEmpty()) {
            System.out.println("Chua co hoa don.");
        } else {
            display();
            Scanner sc = new Scanner(System.in);
            System.out.print("Nhap ma hoa don can xoa: ");
            int invoice_id = Integer.parseInt(sc.nextLine());
            int indexDelete = checkInvoiceId(invoice_id);
            if (indexDelete == -1) {
                System.err.println("Ma hoa don khong ton tai");
            } else {
                invoiceList.remove(indexDelete);
                System.out.println("Hoa don da duoc xoa thanh cong.");
            }
        }
    }

    @Override
    public void display() {
        if (invoiceList.isEmpty()) {
            System.out.println("Chua co hoa don.");
        } else {
            for (int i = 0; i < invoiceList.size(); i++) {
                System.out.println((i + 1) + ". " + invoiceList.get(i));
            }
        }
    }
}
