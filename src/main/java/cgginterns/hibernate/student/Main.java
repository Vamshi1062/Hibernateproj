package cgginterns.hibernate.student;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StudentManagement studentmang = new StudentManagement();
        Scanner scanner = new Scanner(System.in);

        int choice;
        do {
            System.out.println("===== Student Management Menu =====");
            System.out.println("1. Create a new student");
            System.out.println("2. Retrieve a student by ID");
            System.out.println("3. Update a student's Details");
            System.out.println("4. Delete a student");
            System.out.println("5.Display all");
            System.out.println("0. Exit");
            System.out.println("===================================");
            System.out.println("Enter your choice:");

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Enter student name:");
                    String name = scanner.nextLine();

                    System.out.println("Enter student city:");
                    String city = scanner.nextLine();

                    System.out.println("Enter student phone number:");
                    String phoneNo = scanner.nextLine();

                    StudentManage student = new StudentManage();
                    student.setSname(name);
                    student.setScity(city);
                    student.setSphoneno(phoneNo);

                    StudentManagement.saveStudent(student);
                    System.out.println("New student created with ID: " + student.getStudentid());
                    break;

                case 2:
                    System.out.println("Enter student ID to retrieve:");
                    int studentId = scanner.nextInt();
                    scanner.nextLine();

                    StudentManage retrievedStudent = StudentManagement.getStudentById(studentId);
                    if (retrievedStudent != null) {
                        System.out.println("Retrieved student details:");
                        System.out.println("ID: " + retrievedStudent.getStudentid());
                        System.out.println("Name: " + retrievedStudent.getSname());
                        System.out.println("City: " + retrievedStudent.getScity());
                        System.out.println("Phone Number: " + retrievedStudent.getSphoneno());
                    } else {
                        System.out.println("Student not found with ID: " + studentId);
                    }
                    break;

                case 3:
                	System.out.println("Enter student ID to update details:");
                    int studentToUpdateId = scanner.nextInt();
                    scanner.nextLine();

                    StudentManage studentToUpdate = StudentManagement.getStudentById(studentToUpdateId);
                    if (studentToUpdate != null) {
                        int updateChoice;
                        do {
                            System.out.println("===== Update Student Details =====");
                            System.out.println("1. Update name");
                            System.out.println("2. Update city");
                            System.out.println("3. Update phone number");
                            System.out.println("0. Exit");
                            System.out.println("=================================");
                            System.out.println("Enter your choice:");

                            updateChoice = scanner.nextInt();
                            scanner.nextLine();

                            switch (updateChoice) {
                                case 1:
                                    System.out.println("Enter new name:");
                                    String newName = scanner.nextLine();
                                    studentToUpdate.setSname(newName);
                                    break;

                                case 2:
                                    System.out.println("Enter new city:");
                                    String newCity = scanner.nextLine();
                                    studentToUpdate.setScity(newCity);
                                    break;

                                case 3:
                                    System.out.println("Enter new phone number:");
                                    String newPhoneNo = scanner.nextLine();
                                    studentToUpdate.setSphoneno(newPhoneNo);
                                    break;

                                case 0:
                                    System.out.println("Exiting the update menu...");
                                    break;

                                default:
                                    System.out.println("Invalid choice. Please try again.");
                                    break;
                            }
                        } while (updateChoice != 0);

                        StudentManagement.updateStudent(studentToUpdate);
                        System.out.println("Student details updated successfully!");
                    } else {
                        System.out.println("Student not found with ID: " + studentToUpdateId);
                    }

                case 4:
                    System.out.println("Enter student ID to delete:");
                    int studentToDeleteId = scanner.nextInt();
                    scanner.nextLine();

                    StudentManage studentToDelete = StudentManagement.getStudentById(studentToDeleteId);
                    if (studentToDelete != null) {
                        StudentManagement.deleteStudent(studentToDelete);
                        System.out.println("Student deleted successfully!");
                    } else {
                        System.out.println("Student not found with ID: " + studentToDeleteId);
                    }
                    break;

                case 0:
                    System.out.println("Exiting the program...");
                    break;
                case 5:
                	System.out.println("Displaying Student Details...");
                	StudentManagement.displayAll();
                	break;

                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }

            System.out.println();
        } while (choice != 0);

        // Close the scanner and session factory
        scanner.close();
        StudentManagement.closeSessionFactory();
    }
}
