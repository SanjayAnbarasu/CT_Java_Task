package Project;

import java.util.ArrayList;

public class StudentManager {

    private ArrayList<Student> students = new ArrayList<>();

    private void printHeader() {
        System.out.println("******************************************");
        System.out.printf("%-6s %-20s %8s %8s %8s %10s %12s  %s%n",
                "Roll", "Name", "Marks1", "Marks2", "Marks3",
                "Total", "Percentage", "Grade");
        System.out.println("******************************************");
    }

    public void addStudent(int rollNo, String name,
                           double marks1, double marks2, double marks3) {

        for (Student s : students) {
            if (s.getRollNo() == rollNo) {
                System.out.println("[ERROR] Roll No " + rollNo + " already exists!");
                return;
            }
        }

        if (marks1 < 0 || marks1 > 100 ||
            marks2 < 0 || marks2 > 100 ||
            marks3 < 0 || marks3 > 100) {
            System.out.println("[ERROR] Marks must be between 0 and 100.");
            return;
        }

        students.add(new Student(rollNo, name, marks1, marks2, marks3));
        System.out.println("[SUCCESS] Student \"" + name + "\" added successfully.");
    }

    public void displayAll() {
        if (students.isEmpty()) {
            System.out.println("[INFO] No student records found.");
            return;
        }
        printHeader();
        for (Student s : students) {
            System.out.println(s);
        }
        System.out.println("=".repeat(85));
        System.out.println("Total students: " + students.size());
    }

    public void searchByRollNo(int rollNo) {
        for (Student s : students) {
            if (s.getRollNo() == rollNo) {
                printHeader();
                System.out.println(s);
                System.out.println("=".repeat(85));
                return;
            }
        }
        System.out.println("[INFO] No student found with Roll No: " + rollNo);
    }

    public void displayTopper() {
        if (students.isEmpty()) {
            System.out.println("[INFO] No student records found.");
            return;
        }

        Student topper = students.get(0);
        for (Student s : students) {
            if (s.getTotalMarks() > topper.getTotalMarks()) {
                topper = s;
            }
        }

        System.out.println(" \n TOPPER  ");
        printHeader();
        System.out.println(topper);
        System.out.println("=".repeat(85));
    }

    public void deleteStudent(int rollNo) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getRollNo() == rollNo) {
                String deletedName = students.get(i).getName();
                students.remove(i);
                System.out.println("[SUCCESS] Student \"" + deletedName +
                                   "\" (Roll No: " + rollNo + ") deleted successfully.");
                return;
            }
        }
        System.out.println("[INFO] No student found with Roll No: " + rollNo);
    }

    public int getCount() {
        return students.size();
    }
}


