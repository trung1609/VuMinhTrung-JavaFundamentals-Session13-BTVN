package Session13.kha1;

import java.util.Scanner;

public class Person {
    private String name;
    private String email;
    private String phone;

    public Person() {
    }

    public Person(String name, String email, String phone) {
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }

    public void inputData(Scanner sc) {
        do {
            System.out.print("Nhap ten nguoi dung: ");
            this.name = sc.nextLine();
            if (name.isEmpty()) {
                System.out.println("Vui long khong de trong !");
            }
        } while (name.isEmpty());
        do {
            System.out.print("Nhap email nguoi dung: ");
            this.email = sc.nextLine();
            if (email.isEmpty()) {
                System.out.println("Vui long khong de trong !");
            }
        } while (email.isEmpty());
        do {
            System.out.print("Nhap so dien thoai nguoi dung: ");
            this.phone = sc.nextLine();
            if (phone.isEmpty()) {
                System.out.println("Vui long khong de trong !");
            }
        } while (phone.isEmpty());
    }

}
