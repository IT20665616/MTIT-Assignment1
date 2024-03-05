package osgi_studentinformationpublisher;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class StudentInfoPublishImpl implements StudentInfoPublish {

    private Map<String, Student> studentMap;

    public StudentInfoPublishImpl() {
        studentMap = new HashMap<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nSelect an option:");
            System.out.println("1. Add Student");
            System.out.println("2. Update Student");
            System.out.println("3. Delete Student");
            System.out.println("4. View Student by ID");
            System.out.println("5. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.println("\nEnter student name:");
                    String name = scanner.nextLine();
                    System.out.println("Enter student ID:");
                    String id = scanner.nextLine();
                    System.out.println("Enter student department:");
                    String department = scanner.nextLine();
                    addStudent(name, id, department);
                    System.out.println("\nStudent Successfully Added !");
                    break;
                case 2:
                    System.out.println("Enter student ID:");
                    String getId = scanner.nextLine();
                    Student student = getStudentById(getId);
                    if (student != null) {
                        System.out.println("Student Details:");
                        System.out.println("Name: " + student.getName());
                        System.out.println("ID: " + student.getId());
                        System.out.println("Department: " + student.getDepartment());
                        
                        System.out.println("\nEnter updated student name:");
                        String updateName = scanner.nextLine();
                        System.out.println("Enter updated student department:");
                        String updateDept = scanner.nextLine();
                        updateStudent(getId, updateName, updateDept);
                        System.out.println("\nStudent Successfully Updated !");
                    } else {
                        System.out.println("Student with ID " + getId + " not found.");
                    }
                    break;
                case 3:
                    System.out.println("Enter student ID to delete:");
                    String deleteId = scanner.nextLine();
                    deleteStudent(deleteId);
                    System.out.println("\nStudent Successfully Deleted !");
                    break;
                case 4:
                    System.out.println("Enter student ID:");
                    String studentId = scanner.nextLine();
                    Student std = getStudentById(studentId);
                    if (std != null) {
                        System.out.println("Student Details:");
                        System.out.println("Name: " + std.getName());
                        System.out.println("ID: " + std.getId());
                        System.out.println("Department: " + std.getDepartment());
                    } else {
                        System.out.println("Student with ID " + studentId + " not found.");
                    }
                    break;
                case 5:
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    @Override
    public void addStudent(String name, String id, String department) {
        Student student = new Student(name, id, department);
        studentMap.put(id, student);
    }

    @Override
    public void updateStudent(String id, String name, String department) {
        if (studentMap.containsKey(id)) {
            Student student = studentMap.get(id);
            student.setName(name);
            student.setDepartment(department);
            studentMap.put(id, student);
        }
    }

    @Override
    public void deleteStudent(String id) {
        studentMap.remove(id);
    }

    @Override
    public Student getStudentById(String id) {
        return studentMap.get(id);
    }
}
