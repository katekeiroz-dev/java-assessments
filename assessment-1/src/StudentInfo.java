import java.util.Scanner;



public class StudentInfo {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        StudentInfo myStudentObject = new StudentInfo();
        System.out.println(myStudentObject.printStars(10) + "Student Information" + myStudentObject.printStars(10));
        System.out.println("You will be prompted to enter some details about a student.");

        System.out.print("Enter Student Name: ");
        String studentName = input.nextLine();

        String studentId;
        while (true) {
            System.out.print("Enter Student ID: ");
            studentId = input.nextLine();

            if (studentId.length() == 5) {
                break;  // If ID length is 5 digits  then it will exit the loop
            } else {
                System.out.println("Student ID mut have 5 digits. Please enter again.");
            }
        }
        System.out.print("Enter Student Age: ");
        int studentAge = input.nextInt();

        System.out.print("Enter Student average grade: ");
        double studentGrade = input.nextDouble();
        input.nextLine();

        System.out.print("Enter Student's Course: ");
        String studentCourse = input.nextLine();

        System.out.print("Did the student enjoy the Course (yes/no) : ");
        String enjoyCourse = input.nextLine();


        System.out.println(myStudentObject.printStars(40));

        System.out.println(
                "STUDENT DETAILS " + '\n' +
                        "Name: " + studentName + '\n' +
                        "ID: " + studentId + '\n' +
                        "Age: " + studentAge + '\n' +
                        "Average: " + studentGrade + '\n' +
                        "Course: " + studentCourse + '\n' +
                        myStudentObject.printStars(40));

        System.out.println("Vowel Count in Name: " + myStudentObject.numVowels(studentName));
        System.out.println("Word Count in Course Name: " + myStudentObject.numWords(studentName));
        System.out.println("Reversed Name: " + myStudentObject.reverseString(studentName));
        System.out.println(myStudentObject.finalAverageGrade(studentGrade));
        System.out.println("About the course: " + myStudentObject.enjoyQuestion(enjoyCourse));


    }

// methods //


    public String printStars(int num) {
        String theStars = "";
        for (int i = 0; i < num; i++)
            theStars += "*";
        return theStars;
    }


    public String enjoyQuestion(String questionAnswer) {
        questionAnswer = questionAnswer.toLowerCase();
        return questionAnswer.equals("no") || questionAnswer.equals("n") ? "Course isn't that enjoyable" : "Great Course";
    }
/*
    public String isAboveThreshold(double value, double threshold) {
        return value > threshold ? "Yes" : "No";
    }
    PS: I did not understand what was required to do at this lines of code.
*/

    private int numVowels(String str) {
        int countVowels = 0;
        str = str.toLowerCase();
        for (int i = 0; i < str.length(); i++) {
            char vowel = str.charAt(i);
            if ((vowel == 'a') || (vowel == 'e') || (vowel == 'i') || (vowel == 'o') || (vowel == 'u')) {
                countVowels++;
            }

        }
        return countVowels;

    }

    private int numWords(String str){
        String[] words = str.trim().split("\\s");
        return words.length;
    }


    private String reverseString(String str){
        String reversed = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            reversed += str.charAt(i);
        }

        return reversed;

    }

    private String finalAverageGrade(double grade) {
        if (grade < 50) {
            System.out.print("Final Grade: Student has a low grade.");
        } else if (grade >= 50 && grade <= 70) {
            System.out.print("Final Grade: Student has good average grade.");
        } else if (grade > 70 && grade <= 100) {
            System.out.print("Final Grade: Student has a great average grade. ");
        }
        return ""; //return null to compile the code

    }



}

