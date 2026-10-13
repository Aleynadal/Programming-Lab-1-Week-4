/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package courseregistrationsystem;

import java.util.ArrayList;
import java.util.Scanner;


public class CourseRegistrationSystem {
static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
       
  
          ArrayList<Course> courses = setupCourses();

        boolean running = true;
        while (running) {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Register a student");
            System.out.println("2. View all courses");
            System.out.println("3. Exit");
            System.out.print("Your choice: ");
            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    registerStudent(courses);
                    break;
                case "2":
                    viewAllCourses(courses);
                    break;
                case "3":
                    System.out.println("Goodbye!");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
        scanner.close();
    }

    
    static int readInt(String prompt, int minimum) {
        while (true) {
            System.out.print(prompt);
            try {
                int value = Integer.parseInt(scanner.nextLine().trim());
                if (value >= minimum) {
                    return value;
                }
                System.out.println("Please enter a number >= " + minimum + ".");
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid integer.");
            }
        }
    }

    
    static ArrayList<Course> setupCourses() {
        ArrayList<Course> courses = new ArrayList<>();
        int count = readInt("How many courses do you want to create (at least 3)? ", 3);

        for (int i = 1; i <= count; i++) {
            System.out.println("\nCourse " + i + ":");
            System.out.print("  Course name: ");
            String name = scanner.nextLine().trim();
            int capacity = readInt("  Classroom capacity: ", 1);
            courses.add(new Course(name, capacity));
        }

        System.out.println("\nAvailable courses:");
        for (Course c : courses) {
            System.out.println("  - " + c.getCourseName());
        }
        return courses;
    }

    static Course findCourse(ArrayList<Course> courses, String name) {
        for (Course c : courses) {
            if (c.getCourseName().equals(name)) {
                return c;
            }
        }
        return null;
    }

   
    static void registerStudent(ArrayList<Course> courses) {
        System.out.print("Student ID: ");
        String studentID = scanner.nextLine().trim();
        System.out.print("Student name: ");
        String studentName = scanner.nextLine().trim();
        System.out.print("Course name to register for: ");
        String courseName = scanner.nextLine().trim();

        Course course = findCourse(courses, courseName);

        if (course == null) {
            System.out.println("No course found with that name.");
            return;
        }

        if (course.isFull()) {
            System.out.println("This course is full. Registration failed.");
            return;
        }

        if (course.isStudentRegistered(studentID)) {
            System.out.println("This student is already registered for this course.");
            return;
        }

        course.addStudent(new Student(studentID, studentName));
        System.out.println("Registration successful.");
    }

    static void viewAllCourses(ArrayList<Course> courses) {
        System.out.println("\n===== ALL COURSES =====");
        for (Course c : courses) {
            c.displayInfo();
        }
    }
    
}
