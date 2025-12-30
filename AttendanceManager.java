package Session13.kha2;

import java.util.ArrayList;
import java.util.Scanner;

public class AttendanceManager implements Manage<Student> {
    static ArrayList<Student> arrStudents = new ArrayList<>();

    public static void main(String[] args) {
        AttendanceManager attendanceManager = new AttendanceManager();
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("****************** MENU QUAN LY DIEM DANH ******************");
            System.out.println("1. Them sinh vien");
            System.out.println("2. Sua sinh vien");
            System.out.println("3. Xoa sinh vien");
            System.out.println("4. Hien thi danh sach sinh vien");
            System.out.println("5. Thoat");
            System.out.print("Lua chon cua ban: ");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    attendanceManager.add(new Student());
                    break;
                case 2:
                    attendanceManager.update(0, null);
                    break;
                case 3:
                    attendanceManager.delete(0);
                    break;
                case 4:
                    attendanceManager.display();
                    break;
                case 5:
                    System.exit(0);
                default:
                    System.err.println("Vui long nhap lua chon phu hop.");
            }
        } while (true);
    }

    @Override
    public void add(Student item) {
        Scanner sc = new Scanner(System.in);
        item.inputData(sc);
        arrStudents.add(item);
        System.out.println("Sinh vien da duoc them thanh cong");
    }

    public static int checkStudentId(int student_id) {
        for (int i = 0; i < arrStudents.size(); i++) {
            if (arrStudents.get(i).getStudentId() == student_id) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void update(int index, Student item) {
        if (arrStudents.isEmpty()) {
            System.out.println("Chua co sinh vien");
        } else {
            Scanner sc = new Scanner(System.in);
            display();
            System.out.print("Nhap id sinh vien can sua: ");
            int student_id = Integer.parseInt(sc.nextLine());
            index = checkStudentId(student_id);
            if (index == -1) {
                System.err.println("Ma sinh vien khong ton tai");
            } else {
                System.out.print("Nhap ten sinh vien moi: ");
                String newName = sc.nextLine();
                arrStudents.get(index).setStudentName(newName);
                System.out.println("Sinh vien da duoc sua thanh cong");
            }
        }
    }

    @Override
    public void delete(int index) {
        if (arrStudents.isEmpty()) {
            System.out.println("Chua co sinh vien.");
        } else {
            display();
            Scanner sc = new Scanner(System.in);
            System.out.print("Nhap id sinh vien can xoa: ");
            int student_id = Integer.parseInt(sc.nextLine());
            index = checkStudentId(student_id);
            if (index == -1) {
                System.err.println("Ma sinh vien khong ton tai");
            } else {
                arrStudents.remove(index);
                System.out.println("Da xoa thanh cong sinh vien.");
            }
        }
    }

    @Override
    public void display() {
        if (arrStudents.isEmpty()) {
            System.out.println("Chua co sinh vien.");
        }else {
            for (int i = 0; i < arrStudents.size(); i++) {
                System.out.println(arrStudents.get(i));
            }
        }
    }
}
