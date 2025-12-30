package Session13.kha1;

import java.util.ArrayList;
import java.util.Scanner;

public class PersonManagement {
    static ArrayList<Person> arrPerson = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("***************** MENU QUAN LY NGUOI DUNG ****************");
            System.out.println("1. Them nguoi dung");
            System.out.println("2. Xoa nguoi dung");
            System.out.println("3. Hien thi danh sach nguoi dung");
            System.out.println("4. Thoat");
            System.out.print("Lua chon cua ban: ");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    addPerson(sc);
                    break;
                case 2:
                    removePerson(sc);
                    break;
                case 3:
                    displayPerson();
                    break;
                case 4:
                    System.exit(0);
                default:
                    System.err.println("Vui long nhap lai lua chon phu hop.");
            }
        } while (true);
    }

    public static void addPerson(Scanner sc) {
        Person person = new Person();
        person.inputData(sc);
        arrPerson.add(person);
        System.out.println("Nguoi dung da duoc them thanh cong.");
    }

    public static void displayPerson() {
        if (arrPerson.isEmpty()) {
            System.out.println("Chua co nguoi dung");
        } else {
            for (int i = 0; i < arrPerson.size(); i++) {
                System.out.println(arrPerson.get(i));
            }
        }
    }

    public static int checkEmail(String email) {
        for (int i = 0; i < arrPerson.size(); i++) {
            if (arrPerson.get(i).getEmail().equals(email)) {
                return i;
            }
        }
        return -1;
    }

    public static void removePerson(Scanner sc) {
        if (arrPerson.isEmpty()) {
            System.out.println("Chua co nguoi dung");
        } else {
            System.out.print("Nhap email nguoi dung de xoa: ");
            String email = sc.nextLine();
            int indexRemove = checkEmail(email);
            if (indexRemove == -1) {
                System.err.println("Email khong ton tai");
            } else {
                for (int i = 0; i < arrPerson.size(); i++) {
                    arrPerson.remove(indexRemove);
                }
            }
            System.out.println("Nguoi dung da duoc xoa thanh cong.");
        }
    }
}
