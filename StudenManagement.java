package Session13.xuatsac1;

import java.util.ArrayList;
import java.util.Scanner;

public class StudenManagement {
    static ArrayList<Student> studentsList = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("================= MENU ==================");
            System.out.println("1. Nhap danh sach sinh vien");
            System.out.println("2. Hien thi danh sach sinh vien");
            System.out.println("3. Tim kiem sinh vien theo ten");
            System.out.println("4. Phan loai sinh vien GPA");
            System.out.println("0. Thoat chuong trinh");
            System.out.println("=========================================");
            System.out.print("Lua chon cua ban: ");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 0:
                    System.exit(0);
                case 1:
                    addStudent(sc);
                    break;
                case 2:
                    displayStudent();
                    break;
                case 3:
                    searchStudent(sc);
                    break;
                case 4:
                    classifyStudentByGPA();
                    break;
                default:
                    System.err.println("Vui long nhap lua chon phu hop.");
            }
        } while (true);
    }

    public static void addStudent(Scanner sc) {
        System.out.print("Nhap so luong sinh vien muon them: ");
        int count = Integer.parseInt(sc.nextLine());
        if (count < 5) {
            System.out.println("Vui long nhap it nhat 5 sinh vien.");
        } else {
            for (int i = 0; i < count; i++) {
                Student student = new Student();
                student.inputData(sc);
                studentsList.add(student);
            }
        }
    }

    public static void displayStudent() {
        if (studentsList.isEmpty()) {
            System.out.println("Chua co sinh vien.");
        } else {
            for (int i = 0; i < studentsList.size(); i++) {
                System.out.println(studentsList.get(i));
            }
        }
    }

    public static void searchStudent(Scanner sc) {
        if (studentsList.isEmpty()) {
            System.out.println("Chua co sinh vien.");
        } else {
            System.out.print("Nhap ten sinh vien can tim: ");
            String studentName = sc.nextLine();
            boolean isFound = false;
            for (int i = 0; i < studentsList.size(); i++) {
                if (studentsList.get(i).getName().equalsIgnoreCase(studentName)) {
                    System.out.println(studentsList.get(i));
                    isFound = true;
                }
            }
            if (!isFound) {
                System.out.println("Khong tim thay sinh vien co ten la " + studentName + ".");
            }
        }
    }

    public static void classifyStudentByGPA() {
        if (studentsList.isEmpty()) {
            System.out.println("Chua co sinh vien.");
        } else {
            ArrayList<String> rank = new ArrayList<>();
            for (int i = 0; i < studentsList.size(); i++) {
                if (studentsList.get(i).getGpa() >= 8.5) {
                    rank.add("Xuat sac");
                } else if (studentsList.get(i).getGpa() >= 7) {
                    rank.add("Gioi");
                } else if (studentsList.get(i).getGpa() >= 5.5) {
                    rank.add("Kha");
                } else {
                    rank.add("Trung binh / Yeu");
                }
            }

            for (int i = 0; i < studentsList.size(); i++) {
                System.out.println(studentsList.get(i));
                System.out.println("Xep loai: " + rank.get(i));
            }
        }
    }
}
