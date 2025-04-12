import java.util.Arrays;

/**
 * Student Class
 *
 * @author Kate Keiroz
 * @version 1.1 (12 Apr 2025)
 */

public class Student {
    // 4 Fields
    private String studentId;
    private String name;
    private boolean registered;
    private int[] marks;

    // Constructor
    public Student(String studentId, String name, boolean registered) {
        // Ensure studentId is 8 characters long and has by default "00000000" if it will not be valid
        if (studentId.length() == 8) {
            this.studentId = studentId;
        } else {
            this.studentId = "00000000";
        }

        // Truncate the name to 20 chars or use the original name if it's 20 characters or less
        this.name = truncateString(name);

        this.registered = registered;

        // Initialize marks array with 6 grades, all initialized to 0 (from 0 to 100)
        this.marks = new int[6];
    }

    // Method to truncate a string to a specific length
    private String truncateString(String stringToTruncate) {
        if (stringToTruncate.length() <= 20) {
            return stringToTruncate;
        } else {
            return stringToTruncate.substring(0, 20);
        }
    }

    // GETTERS AND SETTERS:

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        if (studentId.length() == 8) {
            this.studentId = studentId;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.length() <= 20) {
            this.name = name;
        }
    }

    public boolean isRegistered() {
        return registered;
    }

    public void setRegistered(boolean registered) {
        this.registered = registered;
    }

    public int[] getMarks() {
        return marks;
    }

    public void setMarks(int[] marks) {
        if (marks.length == 6) {
            for (int i = 0; i < marks.length; i++) {
                if (marks[i] >= 0 && marks[i] <= 100) {
                    this.marks[i] = marks[i];
                }
            }
        }
    }

    public int getAverageMark() {
        int total = 0;
        for (int mark : marks) {
            total += mark;
        }
        return total / marks.length;
    }

    public String toString() {
        return "Student ID: " + studentId + "\n" +
                "Name: " + name + "\n" +
                "Registered: " + registered + "\n" +
                "Marks: " + Arrays.toString(marks) + "\n" +
                "Average Mark: " + getAverageMark();
    }
}
