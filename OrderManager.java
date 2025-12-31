package Session13.gioi2;

import java.util.ArrayList;
import java.util.Scanner;

public class OrderManager implements Manage<Order> {
    static ArrayList<Order> orders = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        OrderManager orderManager = new OrderManager();
        do {
            System.out.println("************ MENU QUAN LY DON HANG ************");
            System.out.println("1. Them don hang");
            System.out.println("2. Sua don hang");
            System.out.println("3. Xoa don hang");
            System.out.println("4. Hien thi danh sach don hang");
            System.out.println("5. Thoat");
            System.out.print("Lua chon cua ban: ");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    orderManager.add(new Order());
                    break;
                case 2:
                    orderManager.update(0, null);
                    break;
                case 3:
                    orderManager.delete(0);
                    break;
                case 4:
                    orderManager.display();
                    break;
                case 5:
                    System.exit(0);
                default:
                    System.err.println("Vui long nhap lai lua chon phu hop.");
            }
        } while (true);
    }

    @Override
    public void add(Order item) {
        Scanner sc = new Scanner(System.in);
        item.inputData(sc, orders);
        orders.add(item);
        System.out.println("Don hang da duoc them thanh cong");
    }

    public static int checkOrderId(String order_id) {
        for (int i = 0; i < orders.size(); i++) {
            if (orders.get(i).getOrderId().equals(order_id)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void update(int index, Order item) {
        if (orders.isEmpty()) {
            System.out.println("Chua co don hang nao.");
        } else {
            display();
            Scanner sc = new Scanner(System.in);
            System.out.print("Nhap ma don hang can sua: ");
            String order_id = sc.nextLine();
            int indexUpdate = checkOrderId(order_id);
            if (indexUpdate == -1) {
                System.err.println("Ma don hang khong ton tai");
            } else {
                System.out.print("Nhap ten khach hang moi: ");
                String newCustomerName = sc.nextLine();
                orders.get(indexUpdate).setCustomerName(newCustomerName);
                System.out.println("Don hang da duoc sua thanh cong.");
            }
        }
    }

    @Override
    public void delete(int index) {
        if (orders.isEmpty()) {
            System.out.println("Chua co don hang nao.");
        } else {
            display();
            Scanner sc = new Scanner(System.in);
            System.out.print("Nhap ma don hang can xoa: ");
            String order_id = sc.nextLine();
            int indexDelete = checkOrderId(order_id);
            if (indexDelete == -1) {
                System.err.println("Ma don hang khong ton tai");
            } else {
                orders.remove(indexDelete);
                System.out.println("Don hang da duoc xoa thanh cong.");
            }
        }
    }

    @Override
    public void display() {
        for (int i = 0; i < orders.size(); i++) {
            System.out.println((i + 1) + ". " + orders.get(i));
        }
    }
}
