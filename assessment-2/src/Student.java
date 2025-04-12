import java.util.Arrays;

public class Student {
    private String studentId;
    private String name;
    private boolean registered;
    private int[] marks;

    public Student(String studentId, String name, boolean registered) {
        if (studentId.length() == 8) {
            this.studentId = studentId;
        } else {
            this.studentId = "00000000";
        }

        this.name = this.truncateString(name, 20);
        this.registered = registered;
        this.marks = new int[6];
    }

    private String truncateString(String stringToTruncate, int length) {
        return stringToTruncate.length() <= length ? stringToTruncate : stringToTruncate.substring(0, length);
    }

    public String getStudentId() {
        return this.studentId;
    }

    public void setStudentId(String studentId) {
        if (studentId.length() == 8) {
            this.studentId = studentId;
        }

    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        if (name.length() <= 20) {
            this.name = name;
        }

    }

    public boolean isRegistered() {
        return this.registered;
    }

    public void setRegistered(boolean registered) {
        this.registered = registered;
    }

    public int[] getMarks() {
        return this.marks;
    }

    public void setMarks(int[] marks) {
        if (marks.length == 6) {
            for(int i = 0; i < marks.length; ++i) {
                if (marks[i] >= 0 && marks[i] <= 100) {
                    this.marks[i] = marks[i];
                }
            }
        }

    }

    public int getAverageMark() {
        int total = 0;

        for(int mark : this.marks) {
            total += mark;
        }

        return total / this.marks.length;
    }

    public String toString() {
        String var10000 = this.studentId;
        return "Student ID: " + var10000 + "\nName: " + this.name + "\nRegistered: " + this.registered + "\nMarks: " + Arrays.toString(this.marks) + "\nAverage Mark: " + this.getAverageMark();
    }
}
