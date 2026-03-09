package Project;

public class Student {
    private int rollNo;
    private String name;
    private double marks1;
    private double marks2;
    private double marks3;

    public Student(int rollNo, String name, double marks1, double marks2, double marks3) {
        this.rollNo = rollNo;
        this.name   = name;
        this.marks1 = marks1;
        this.marks2 = marks2;
        this.marks3 = marks3;
    }

    public int    getRollNo() { return rollNo; }
    public String getName()   { return name;   }
    public double getMarks1() { return marks1; }
    public double getMarks2() { return marks2; }
    public double getMarks3() { return marks3; }

    public double getTotalMarks() {
        return marks1 + marks2 + marks3;
    }

    public double getPercentage() {
        return (getTotalMarks() / 300.0) * 100.0;
    }

    public String getGrade() {
        double pct = getPercentage();
        if      (pct >= 90) return "A+";
        else if (pct >= 80) return "A";
        else if (pct >= 70) return "B";
        else if (pct >= 60) return "C";
        else if (pct >= 50) return "D";
        else                return "F";
    }

    @Override
    public String toString() {
        return String.format(
            "%-6d %-20s %8.2f %8.2f %8.2f %10.2f %10.2f%%   %s",
            rollNo, name, marks1, marks2, marks3,
            getTotalMarks(), getPercentage(), getGrade()
        );
    }
}