/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package courseregistrationsystem;

import java.util.ArrayList;


public class Course {
       
    private String courseName;
    private int capacity;
    private ArrayList<Student> enrolledStudents;

    public Course(String courseName, int capacity) {
        this.courseName = courseName;
        this.capacity = capacity;
        this.enrolledStudents = new ArrayList<>();
    }

    public String getCourseName() {
        return courseName;
    }

    public int getCapacity() {
        return capacity;
    }

    public ArrayList<Student> getEnrolledStudents() {
        return enrolledStudents;
    }

    public boolean isFull() {
        return enrolledStudents.size() >= capacity;
    }

    public boolean isStudentRegistered(String studentID) {
        for (Student s : enrolledStudents) {
            if (s.getStudentID().equals(studentID)) {
                return true;
            }
        }
        return false;
    }

    public void addStudent(Student student) {
        enrolledStudents.add(student);
    }

    public void displayInfo() {
        System.out.println("Course: " + courseName);
        System.out.println("Capacity: " + capacity);
        System.out.println("Enrolled students: " + enrolledStudents.size());
        if (enrolledStudents.isEmpty()) {
            System.out.println("  (no students enrolled)");
        } else {
            for (Student s : enrolledStudents) {
                System.out.println("  - " + s.getName() + " (ID: " + s.getStudentID() + ")");
            }
        }
        System.out.println("------------------------------");
    }
}
    

