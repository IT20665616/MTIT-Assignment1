package osgi_attendancepublisher;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AttendancePublishImpl implements AttendancePublish {

    private Map<String, Attendance> attMap;

    public AttendancePublishImpl() {
        
    }

    @Override
    public void addAttendance(String courseId, String studentId, String attendance) {
        Attendance att = new Attendance(courseId, studentId, attendance);
        attMap.put(studentId, att);
    }

    @Override
    public void updateAttendance(String id, String courseId, String studentId) {
        if (attMap.containsKey(id)) {
            Attendance att = attMap.get(id);
            att.setCourseID(courseId);
            att.setStudentId(studentId);
            attMap.put(id, att);
        }
    }

    @Override
    public void deleteAttendance(String id) {
        attMap.remove(id);
    }

    @Override
    public Attendance getAttendanceById(String id) {
        return attMap.get(id);
    }

	@Override
	public void selectOption() {
		// TODO Auto-generated method stub
		attMap = new HashMap<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nSelect an option:");
            System.out.println("1. Add Attendance");
            System.out.println("2. Update Attendance");
            System.out.println("3. Delete Attendance");
            System.out.println("4. View Attendance by Attendance ID");
            System.out.println("5. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.println("\nEnter Course ID:");
                    String name = scanner.nextLine();
                    System.out.println("Enter Student ID:");
                    String courseId = scanner.nextLine();
                    System.out.println("Enter Attendance ID:");
                    String attendanceId = scanner.nextLine();
                    addAttendance(name, courseId, attendanceId);
                    System.out.println("\nAttendance Successfully Added !");
                    break;
                case 2:
                    System.out.println("Enter student ID:");
                    String getId = scanner.nextLine();
                    Attendance att = getAttendanceById(getId);
                    if (att != null) {
                        System.out.println("Attendance Details:");
                        System.out.println("Course ID: " + att.getCourseID());
                        System.out.println("Student ID: " + att.getStudentId());
                        System.out.println("Attendance: " + att.getAttendance());

                        System.out.println("\nEnter updated Course ID:");
                        String updateCourseId = scanner.nextLine();
                        System.out.println("Enter updated student ID:");
                        String updateStudentId = scanner.nextLine();
                        updateAttendance(getId, updateCourseId, updateStudentId);
                        System.out.println("\nAttendance Successfully Updated !");
                    } else {
                        System.out.println("Attendance with ID " + getId + " not found.");
                    }
                    break;
                case 3:
                    System.out.println("Enter student ID to delete:");
                    String deleteId = scanner.nextLine();
                    deleteAttendance(deleteId);
                    System.out.println("\nAttendance Successfully Deleted !");
                    break;
                case 4:
                    System.out.println("Enter student ID:");
                    String studentId = scanner.nextLine();
                    Attendance attendance = getAttendanceById(studentId);
                    if (attendance != null) {
                        System.out.println("Attendance Details:");
                        System.out.println("Name: " + attendance.getCourseID());
                        System.out.println("ID: " + attendance.getStudentId());
                        System.out.println("Department: " + attendance.getAttendance());
                    } else {
                        System.out.println("Attendance with ID " + studentId + " not found.");
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
}
