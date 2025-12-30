package Session13.kha2;

import java.util.Scanner;

public class Student {
    private int studentId;
    private String studentName;
    public Student(){}
    public Student(int studentId, String studentName) {
        this.studentId = studentId;
        this.studentName = studentName;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", studentName='" + studentName + '\'' +
                '}';
    }

    public void inputData(Scanner sc){
        do{
            System.out.print("Nhap ma sinh vien: ");
            this.studentId = Integer.parseInt(sc.nextLine());
            if(this.studentId < 0){
                System.err.println("Vui long nhap lai ma sinh vien.");
            }
        }while(this.studentId < 0);

        do{
            System.out.print("Nhap ten sinh vien: ");
            this.studentName = sc.nextLine();
            if (this.studentName.isEmpty()){
                System.out.println("Vui long nhap lai ten sinh vien.");
            }
        }while (this.studentName.isEmpty());
    }
}
