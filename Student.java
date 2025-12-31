package Session13.xuatsac1;

import java.util.Scanner;

public class Student {
    private int id;
    public static int AUTO_ID = 1;
    private String name;
    private double gpa;

    public Student(int id, String name, double gpa) {
        this.id = id;
        this.name = name;
        this.gpa = gpa;
    }

    public Student() {
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

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    @Override
    public String toString() {
        return String.format("Ma sinh vien: " + id + " - Ho va ten: " + name + " - Diem trung binh: " + gpa);
    }

    public void inputData(Scanner sc) {
        this.id = AUTO_ID++;
        System.out.print("Nhap ten sinh vien: ");
        this.name = sc.nextLine();

        System.out.print("Nhap gpa: ");
        this.gpa = Double.parseDouble(sc.nextLine());
    }
}
