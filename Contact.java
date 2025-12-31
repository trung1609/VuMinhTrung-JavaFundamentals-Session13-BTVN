package Session13.xuatsac2;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Contact {
    private int id;
    public static int AUTO_ID = 1;
    private String name;
    private String phoneNumber;

    public Contact() {
    }

    public Contact(int id, String name, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return String.format("ID: " + id + " - Name: " + name + " - Phone Number: " + phoneNumber);
    }

    public void inputData(Scanner sc, ArrayList<Contact> contacts) {
        this.id = AUTO_ID++;
        System.out.print("Nhap ten nguoi lien lac: ");
        this.name = sc.nextLine();
        this.phoneNumber = inputPhoneNumber(sc, contacts);

    }

    public String inputPhoneNumber(Scanner sc, ArrayList<Contact> contacts) {
        String phone_number;
        String regex = "0[3|5|7|8|9][0-9]{8}";
        do{
            System.out.print("Nhap so dien thoai: ");
            phone_number = sc.nextLine();
            if(Pattern.matches(regex, phone_number)){
                boolean isExist = false;
                for (int i = 0; i < contacts.size(); i++) {
                    if(contacts.get(i).getPhoneNumber().equals(phone_number)){
                        System.out.println("So dien thoai da ton tai.");
                        isExist = true;
                        break;
                    }
                }
                if(!isExist){
                    return phone_number;
                }
            }
        }while (true);
    }
}
