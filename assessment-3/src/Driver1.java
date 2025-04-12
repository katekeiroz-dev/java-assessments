import java.util.Scanner;

/**
 * Driver Class
 *
 * @author Kate Keiroz
 * @version 1.1 (12 Apr 2025)
 */

public class Driver {

    private Scanner input = new Scanner(System.in);
    private Course course;  // A Course object that will hold course details and students
    private Student newStudent;  // A Student object to represent the student being added


    // main entry of the run program
    public static void main(String[] args) {

        new Driver();  // Creates a new instance of the Driver class
    }


    // Constructor to run the menu system when an instance of Driver is created
    public Driver() {

        runMenu();  // Starts the menu system
    }

    // Displays the main menu and takes the user’s choice
    private int mainMenu() {
        System.out.println("\n\tSTUDENT SYSTEM - MENU OPTION (choose the number for your action): ");
        System.out.println("--------------------------------------------------");
        System.out.println("1) Add a student");
        System.out.println("2) Find student by ID");
        System.out.println("3) List all students");
        System.out.println("4) List the students currently enrolled in the course");
        System.out.println("5) Display average student mark");
        System.out.println("6) Display student information");
        System.out.println("0) Exit");
        System.out.print("==>> ");
        int option = input.nextInt(); // Takes the user's choice
        return option; // retuns the option the user chosen
    }

    // Runs the menu, continuously asking for actions until the user chooses to exit
    private void runMenu() {

        System.out.print("Enter course name: ");
        String cName = input.nextLine();
        System.out.print("How many students are in the course? ");
        int numberStudents = input.nextInt();
        input.nextLine();  // Clear the buffer (important when switching between nextInt() and nextLine())

        course = new Course(cName, numberStudents);
        //switch statement that loops until the user chooses to exit

        int option = mainMenu();
        while (option != 0) {
            switch (option) {
                case 1 -> addStudent();
                case 2 -> findStudentById(); // added method - Search student by ID
                case 3 -> listStudents();
                case 4 -> listRegisteredStudents();
                case 5 -> calculateCourseAverage();
                case 6 -> printStudent();  // added method - Print the information of the  student
                default -> System.out.println("Invalid option entered: " + option);
            }
            option = mainMenu();
        }
        System.out.println("Exiting...bye");
        System.exit(0);
    }

    private void calculateCourseAverage() {
        System.out.println(course.calculateCourseAverage());
    }

    private void listStudents() {
        System.out.println(course.listStudents());
    }

    private void listRegisteredStudents() {
        System.out.println(course.listRegisteredStudents());
    }

    // Adds a new student to the course
    private void addStudent() {
        input.nextLine(); // Clear the buffer (important when switching between nextInt() and nextLine())
        System.out.print("Enter the Student's Name: ");
        String studentName = this.input.nextLine(); // Takes the student's name
        String studentId = "";
        boolean validId = false;

        // Keeps asking for a valid 8-digit student ID until the user enters a valid one
        while (!validId) {
            System.out.print("Enter the Student's ID (must contain 8-digit number ): ");
            studentId = this.input.nextLine();
            if (studentId.length() == 8) {
                validId = true;
            } else {
                System.out.println("Invalid ID. Please enter an ID that is exactly 8-digit number.");
            }
        }
        // Ask if the student is registered
        System.out.print("Is the student registered? (Your answer should be: true or false): ");
        boolean isRegistered = this.input.nextBoolean();

        // Create the Student object
        this.newStudent = new Student(studentId, studentName, isRegistered);

        // Create the array for marks
        int[] marks = new int[6];
        System.out.println("Enter 6 marks (0-100): ");

        // Loop to get marks from the user
        for (int i = 0; i < 6; ++i) {
            System.out.print("Mark " + (i + 1) + ": ");
            int mark = this.input.nextInt();
            if (mark >= 0 && mark <= 100) {
                marks[i] = mark;
            } else {
                System.out.println("Invalid mark. Please enter a number between 0 and 100.");
                --i;  // Decrement to repeat this input
            }
        }

        // Set marks for the student
        this.newStudent.setMarks(marks);

        // Add the student to the course
        boolean success = course.addStudent(this.newStudent);

        // Print whether the addition was successful or not
        if (success) {
            System.out.println("Student added successfully.");
        } else {
            System.out.println("The course is full. Could not add the student.");
        }
    }

    private void printStudent() {
        input.nextLine();  // Clear the buffer (important when switching between nextInt() and nextLine())

        // Ask the user for the student ID
        System.out.print("Enter the Student ID to view information: ");
        String studentId = input.nextLine();

        // Search for the student by ID
        String student = course.findStudentById(studentId);

        // Check if the student was found and print their information
        if (student != null) { //null for invalid or 0 value
            System.out.println(Utilities.printStars(100));
            System.out.println("Student Information:");
            System.out.println(student);  // This will call the toString() method of the Student class
            System.out.println(Utilities.printStars(100));
        } else {
            System.out.println("Student with ID " + studentId + " not found.");
        }
    }


    private void findStudentById() {
        input.nextLine();  // Clear buffer ..
        System.out.print("Enter the student ID (must contain 8 digits) : ");
        String id = input.nextLine();
        System.out.println(course.findStudentById(id));
    }
}