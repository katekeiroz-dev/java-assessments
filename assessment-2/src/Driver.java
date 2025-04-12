
import java.util.Scanner;

public class Driver {
    private Scanner input;
    private Student newStudent;

    public static void main(String[] args) {
        new Driver();
    }

    public Driver() {
        this.input = new Scanner(System.in);
        this.addStudent();
        this.printStudent();
    }

    private void addStudent() {
        System.out.print("Enter the Student's Name: ");
        String studentName = this.input.nextLine();
        String studentId = "";
        boolean validId = false;

        while(!validId) {
            System.out.print("Enter the Student's ID (must contain 8-digit number ): ");
            studentId = this.input.nextLine();
            if (studentId.length() == 8) {
                validId = true;
            } else {
                System.out.println("Invalid ID. Please enter an ID that is exactly 8-digit number.");
            }
        }

        System.out.print("Is the student registered? (Your answer should be ; true or false): ");
        boolean isRegistered = this.input.nextBoolean();
        this.newStudent = new Student(studentId, studentName, isRegistered);
        int[] marks = new int[6];
        System.out.println("Enter 6 marks (0-100): ");

        for(int i = 0; i < 6; ++i) {
            System.out.print("Mark " + (i + 1) + ": ");
            int mark = this.input.nextInt();
            if (mark >= 0 && mark <= 100) {
                marks[i] = mark;
            } else {
                System.out.println("Invalid mark. Please enter a number between 0 and 100.");
                --i;
            }
        }

        this.newStudent.setMarks(marks);
    }

    private void printStudent() {
        System.out.println(Utilities.printStars(100));
        System.out.println("Student Information:");
        System.out.print(this.newStudent.toString());
        System.out.println(Utilities.printStars(100));
    }
}
