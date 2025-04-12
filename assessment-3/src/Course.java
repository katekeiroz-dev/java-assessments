import java.util.ArrayList;

public class Course {
    private String courseName;
    private ArrayList<Student> students; // Use of ArrayList instead of primituve array
    private int maxStudents; // value is set dynamically based on what is passed to the constructor, whne asked to user and create curse obj

    // Constructor
    public Course(String courseName, int maxStudents) {
        this.courseName = courseName;
        this.maxStudents = maxStudents;  // value is set dynamically based on what is passed to the constructor
        this.students = new ArrayList<>(maxStudents); // Initialize ArrayList with the max capacity
    }

    // Method to check if the course is full
    private boolean isFull() {
        return students.size() >= maxStudents;  // Check if the course is full
    }

    // Method to add a student to the course
    public boolean addStudent(Student student) {
        if (isFull()) {
            return false; // Return false if course is full
        } else {
            students.add(student); // Add the student to the ArrayList
            return true;
        }
    }

    // Method to calculate the average mark of all students in the course
    public double calculateCourseAverage() {
        double total = 0;
        int numberOfMarks = 0;
        for (Student student : students) {
            for (int mark : student.getMarks()) {
                total += mark;
                numberOfMarks++;
            }
        }
        return numberOfMarks > 0 ? total / numberOfMarks : 0; // Avoid division by zero
    }
    // Method to list all students in the course
    public String listStudents() {
        if (students.isEmpty()) {
            return "Sorry. No students are added to the course yet. Choose option 1 to add a new student.";
        } //UX :Providing clear guidance to the user what steps she should take ..

        // Start with the course name
        String strListStudents = "Course: " + courseName + "\n";

        // Loop through all students and concatenate each student's details
        for (int i = 0; i < students.size(); i++) {
            strListStudents += (i + 1) + " : " + students.get(i) + "\n";
        }

        return strListStudents;
    }


    // Method to list all registered students in the course (those with registered value = true)
    public String listRegisteredStudents() {
        // Start with a message indicating registered students
        String registeredList = "Registered Students in the Course:";

        // Check if there are any registered students
        boolean hasRegisteredStudents = false;

        // Loop through students and append only those who are registered
        for (Student student : students) {
            if (student.isRegistered()) {
                registeredList += student + "\n";  // Append the student info
                hasRegisteredStudents = true;
            }
        }

        // If no students are registered, return a relevant message
        if (!hasRegisteredStudents) {
            return "No students are currently registered in the course." ;
        }

        return registeredList;
    }

    // Method to find a student by their ID
    public String findStudentById(String studentId) {
        for (Student student : students) {
            if (student.getStudentId().equals(studentId)) {
                return "Student found:\n" + student;
            }
        }
        return "Student with ID " + studentId + " not found.";
    }
}
