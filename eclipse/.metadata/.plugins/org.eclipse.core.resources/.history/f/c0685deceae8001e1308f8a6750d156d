package osgi_studentinformationconsumer;

import java.util.Scanner;

import org.osgi.framework.BundleContext;
import org.osgi.util.tracker.ServiceTracker;
import osgi_studentinformationpublisher.Student;
import osgi_studentinformationpublisher.StudentInfoPublish;

public class StudentInterfaceImpl implements StudentInterface{
	
	private BundleContext bundleContext;
    private ServiceTracker<StudentInfoPublish, StudentInfoPublish> studentInformationTracker;
    
    private Scanner scanner;

    public StudentInterfaceImpl(BundleContext bundleContext) {
        this.bundleContext = bundleContext;
        this.scanner = new Scanner(System.in);
    }

    public void start() {
    	studentInformationTracker = new ServiceTracker<>(bundleContext, StudentInfoPublish.class, null);
    	studentInformationTracker.open();
    }
    
    public void startConsoleInterface() {
        System.out.println("Welcome to the Student Information System!");

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nSelect an option:");
            System.out.println("1. Add a student");
            System.out.println("2. Display student information");
            System.out.println("3. Update student information");
            System.out.println("4. Delete a student");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addStudentFromConsole();
                    break;
                case 2:
                    System.out.print("Enter student ID: ");
                    String studentId = scanner.nextLine();
                    displayStudentInfo(studentId);
                    break;
                case 3:
                    System.out.print("Enter student ID: ");
                    String updateId = scanner.nextLine();
                    System.out.print("Enter updated name: ");
                    String updatedName = scanner.nextLine();
                    System.out.print("Enter updated department: ");
                    String updatedDepartment = scanner.nextLine();
                    updateStudent(updateId, updatedName, updatedDepartment);
                    break;
                case 4:
                    System.out.print("Enter student ID: ");
                    String deleteId = scanner.nextLine();
                    deleteStudent(deleteId);
                    break;
                case 5:
                    stop();
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }


    

    private StudentInfoPublish getStudentService() {
        return studentInformationTracker.getService();
    }
    
    public void addStudentFromConsole() {
        System.out.println("Enter student name:");
        String name = scanner.nextLine();

        System.out.println("Enter student ID:");
        String id = scanner.nextLine();

        System.out.println("Enter student department:");
        String department = scanner.nextLine();

        // Add the student using the provided information
        addStudent(name, id, department);
    }

    @Override
    public void displayStudentInfo(String id) {
    	StudentInfoPublish studentInfo = getStudentService();
        if (studentInfo != null) {
            Student student = studentInfo.getStudentById(id);
            if (student != null) {
                System.out.println("Student Info:");
                System.out.println("Name: " + student.getName());
                System.out.println("ID: " + student.getId());
                System.out.println("Department: " + student.getDepartment());
            } else {
                System.out.println("Student not found.");
            }
        } else {
            System.out.println("Student service is not available.");
        }
    }
    
    

    @Override
    public void addStudent(String name, String id, String department) {
    	StudentInfoPublish studentInfo = getStudentService();
        if (studentInfo != null) {
            studentInfo.addStudent(name, id, department);
            System.out.println("Student added successfully.");
        } else {
            System.out.println("Student service is not available.");
        }
    }

    @Override
    public void updateStudent(String id, String name, String department) {
    	StudentInfoPublish studentInfo = getStudentService();
        if (studentInfo != null) {
            studentInfo.updateStudent(id, name, department);
            System.out.println("Student updated successfully.");
        } else {
            System.out.println("Student service is not available.");
        }
    }

    @Override
    public void deleteStudent(String id) {
    	StudentInfoPublish studentService = getStudentService();
        if (studentService != null) {
            studentService.deleteStudent(id);
            System.out.println("Student deleted successfully.");
        } else {
            System.out.println("Student service is not available.");
        }
    }
    
    public void stop() {
    	studentInformationTracker.close();
    }

}
